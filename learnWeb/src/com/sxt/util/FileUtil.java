package com.sxt.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	//	上传图片支持格式
	public static String[] imgSuffix = {"gif", "jpg", "jpeg", "png","bmp"};
	public static String[] imgHead = {"bmp", "jpg", "gif", "png"};
	public static String[] imgCard = {"jpg", "bmp", "png"};
	//	上传图片支持大小，单位KB
	public static long imgSize = 2048;
//	上传图片支持大小，单位KB
	public static long imgHeadSize = 1024;
	//	充值图片路径
	public static String IMG_RECHARGE_URL = "image.recharge.url";
	
	public static String BANNER_URL = "";//服务于首页banner
	
	public static String saveFile(MultipartFile file, HttpServletRequest request) throws UnsupportedEncodingException {  
        String path=PropertiesRead.use_classLoador().getProperty("image.url");
        String fileNames =file.getOriginalFilename();  
        String fileName =System.currentTimeMillis()+fileNames.substring(fileNames.lastIndexOf("."));  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        } 
  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return fileName;  
	}
	
	/**
	 * 根据上传路径上传图片文件
	 * @param file
	 * @param uploadUrl
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String saveFile2(MultipartFile file, String uploadUrl, 
			HttpServletRequest request) throws UnsupportedEncodingException {
		
        String path = PropertiesRead.use_classLoador().getProperty(uploadUrl);
        String fileNames = file.getOriginalFilename();
        String fileName =System.currentTimeMillis() + fileNames.substring(fileNames.lastIndexOf("."));  
        File targetFile = new File(path, fileName);
        
        if(!targetFile.exists()) {
            targetFile.mkdirs();
        }
  
        try {  
            file.transferTo(targetFile);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return path + fileName;  
	}
	
	public static List<String> filesUpload(MultipartFile[] files, HttpServletRequest request) throws UnsupportedEncodingException {  
	    List<String> list=new ArrayList<String>();
		//判断file数组不能为空并且长度大于0  
	    if(files!=null&&files.length>0){  
	        //循环获取file数组中得文件  
	        for(int i = 0;i<files.length;i++){  
	            MultipartFile file = files[i];  
	            //保存文件  
	            list.add(saveFile(file,request));
	            try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	        }  
	    }  
	    return list;
	}  
	public static List<String> filesUpload3(MultipartFile[] files,String uploadUrl, HttpServletRequest request) throws UnsupportedEncodingException {  
	    List<String> list=new ArrayList<String>();
		//判断file数组不能为空并且长度大于0  
	    if(files!=null&&files.length>0){  
	        //循环获取file数组中得文件  
	        for(int i = 0;i<files.length;i++){  
	            MultipartFile file = files[i];  
	            //保存文件  
	            list.add(saveFile3(file,uploadUrl,request));
	            try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	        }  
	    }  
	    return list;
	}  
	/**
	 * 根据上传路径上传图片文件
	 * @param file
	 * @param uploadUrl
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String saveFile3(MultipartFile file, String uploadUrl, 
			HttpServletRequest request) throws UnsupportedEncodingException {
		
        String path = PropertiesRead.use_classLoador().getProperty(uploadUrl);
        String fileNames = file.getOriginalFilename();
        String fileName =System.currentTimeMillis() + fileNames.substring(fileNames.lastIndexOf("."));  
        File targetFile = new File(path, fileName);
        
        if(!targetFile.exists()) {
            targetFile.mkdirs();
        }
  
        try {  
            file.transferTo(targetFile);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return fileName;  
	}
	/**
	 * 是否支持该文件上传
	 * @param patternArray 支持的格式
	 * @param suffix 后缀
	 * @return
	 */
	public static boolean isCorrectFormat(String[] patternArray, String suffix) {
		
		if (suffix.indexOf(".") > -1) suffix = suffix.replace(".", "");
		
		if (patternArray != null && patternArray.length > 0) {
			for (String pattern : patternArray) {
				if(pattern.equalsIgnoreCase(suffix)) {
					return true;
				}
			}
		} else {
			return false;
		}
		return false;
	}
	

	
	/**
	 * 图片大小是否支持
	 * @param imgSize 支持大小，单位kb
	 * @param uploadImgSize 图片大小，单位KB
	 * @return
	 */
	public static boolean isCorrectSize(long imgSize, long uploadImgSize) {
		
		if(imgSize * 1024 < uploadImgSize) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 读取BANNER路径
	 * @return
	 */
	public static String getBanner(){
		if(StringUtil.isEmpty(BANNER_URL)) {
			BANNER_URL = PropertiesRead.use_classLoador().getProperty("image.banner.path");
		}
		return BANNER_URL;
	}
	
	public static void main(String[] args) {
		System.out.println(Math.random()*10000);
		
	}
}
