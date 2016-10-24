package com.sxt.page.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import com.masapay.biz.common.util.PageList;
import com.masapay.common.lang.Paginator;

/**
 * 
 * PageUtils
 * pillar liu
 * 2015-10-09 下午5:46:16
 * @version 1.0.0
 */
public class PageUtils {

	private final static transient Log log = LogFactory.getLog(PageUtils.class);

	public static <T> Page<T> getPage(HttpServletRequest request) {
		Page<T> page = new Page<T>();
		Integer pageSize = 5;
		log.debug("pageSize=============" + pageSize);
		page.setPageSize(pageSize);
		page.setPageNo(request.getParameter("pageNo"));
		page.setTotalCount(request.getParameter("totalCount"));
		return page;
	}
	
	public static void setServicePage(Page<?> pageService , Page<?> page) {
		pageService.setPageSize(page.getPageSize());
		pageService.setTotalCount(page.getTotalCount());
		pageService.setPageNo(page.getPageNo());
	}
	
	/**
	 * 通过反射把Page对象的model对象拷贝到DTO对象,目前只能支持基本的操作
	 * @param <T>
	 * @param page	查询数据库返回的page对象
	 * @param targetClass 目标DTO
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<?> changePageList(final List<T> resultList, Object targetClass)
	{
		if(resultList == null || resultList.size()==0 || targetClass== null ) return resultList;
		try{
			List<T> t_list = new ArrayList<T>();
			List<T> s_list = resultList;
			T t_clazz = s_list.get(0);
			Field[] filedsSource = t_clazz.getClass().getDeclaredFields();
			Object targetObj = ObjectUtils.instanceByClass(targetClass.getClass().getName());
			Field[] filedsTarget = targetObj.getClass().getDeclaredFields();
			Class<?>[] classArray = null;
			for (T source : s_list) {
				for (Field fSource : filedsSource) {
					for (Field fTarget : filedsTarget)
						if (fSource.getName().equals(fTarget.getName())) {
							if (!Modifier.isStatic(fSource.getModifiers())
									&& !Modifier.isFinal(fSource.getModifiers())) {
								String fieldName = fSource.getName();
								String methodNameSource = "get"
										+ Character
												.toUpperCase(fieldName.charAt(0))
										+ fieldName.substring(1);
								String methodNameTarget = "set"
										+ Character
												.toUpperCase(fieldName.charAt(0))
										+ fieldName.substring(1);
								Method method = t_clazz.getClass().getDeclaredMethod(
										methodNameSource, classArray);
								if (!Modifier.isPublic(method.getModifiers())) {
									method.setAccessible(true);
								}
	
								Class<?> clz = null;
								Object sourceValue = method.invoke(source);
								if (sourceValue != null) {
									if (sourceValue instanceof String) {
										clz = String.class;
									} else if (sourceValue instanceof Date) {
										clz = Date.class;
									} else if (sourceValue instanceof Long) {
										clz = Long.class;
									} else if (sourceValue instanceof Integer) {
										clz = Integer.class;
									} else if (sourceValue instanceof BigDecimal) {
										clz = BigDecimal.class;
									}
	
									Class<?>[] l_class = { clz };
									Method methodTarget = targetObj.getClass()
											.getDeclaredMethod(methodNameTarget,
													l_class);
									if (!Modifier.isPublic(method.getModifiers())) {
										methodTarget.setAccessible(true);
									}
									methodTarget.invoke(targetObj, sourceValue);
	
								}
							}
						}
				
				}
				t_list.add( (T)targetObj);
				targetObj = ObjectUtils.instanceByClass(targetClass.getClass().getName());
			}
			return t_list;
		}catch (Exception e) {
			log.error("from model to dto error : " + e.getMessage() , e);
			return resultList;
		}
		
	}
	
	public static  <T> List<?> changePageList(final List<T> resultList, Object targetClass,String[] ignoreProperties )
	{
		List<Object> t_list = new ArrayList<Object>();
		if(targetClass == null) return null;
		try{
			List<T> s_list = resultList;
			for (T source : s_list) {
				Object targetObject =  ObjectUtils.instanceByClass(targetClass.getClass().getName());
				BeanUtils.copyProperties(source, targetObject,ignoreProperties);
				t_list.add( targetObject);
			}
			return t_list;
		}catch (Exception e) {
			log.error("from model to dto error : " + e.getMessage() , e);
			return t_list;
		}
		
	}
	
	public static PageList getCheckPage(List resultList, int pageSize, int pageNum) {

		Paginator paginator = new Paginator();
		paginator.setItemsPerPage(pageSize);
		paginator.setPage(pageNum);

		paginator.setItems(resultList.size());

		List tempList = new ArrayList();

		PageList pageList = new PageList();
		pageList.setPaginator(paginator);

		if (paginator.getBeginIndex() <= paginator.getItems()) {
			if ((pageNum * pageSize + pageSize) > resultList.size()) {
				tempList = resultList.subList((pageNum - 1) * pageSize,
						resultList.size()); // 最后一页数据
			} else {
				tempList = resultList.subList((pageNum - 1) * pageSize, pageNum
						* pageSize);
			}

			pageList.addAll(tempList);
		}

		return pageList;
	}
	
	public static void main(String[] args) {
//		
//		List<ParamsFileParser> list = new ArrayList<ParamsFileParser>();
//		ParamsFileParser fileParser = new ParamsFileParser();
//		ParamsFileParserDTO dto = new ParamsFileParserDTO();
//		fileParser.setBankCode("001");
//		list.add(fileParser);
//		fileParser = new ParamsFileParser();
//		fileParser.setBankCode("002");
//		list.add(fileParser);
//		fileParser = new ParamsFileParser();
//		fileParser.setBankCode("003");
//		list.add(fileParser);
//		fileParser = new ParamsFileParser();
//		fileParser.setBankCode("004");
//		list.add(fileParser);
//		List<Object> list1 = changePageList(list,dto,null );
//		for(Object obj : list1){
//			System.out.println(obj);
//		}
	}
	
}
