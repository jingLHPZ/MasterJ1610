package com.sxt.util;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * 目录管理器
 * @author pillar liu
 * @version $Id: DirectoryUtil.java, v 0.1 2013-3-23 下午3:36:21 pillar liu Exp $
 */
public class DirectoryUtil {
    private Logger             logger        = Logger.getLogger(this.getClass());

    /** 文件存放目录 */
    public static final String DIRECTORY_DIR = "instfile";

    /** 提现处理文件存放目录 */
    public static final String DIRECTORY_ALL = "withdraw";

    /**
     * 文件基本路径
     */
    private String             baseDirectory;

    public static boolean isDirectory(String path) {
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        return true;
    }

    public String getAbsolutPath(String dir) {
        String absolutPath = baseDirectory + File.separator + DIRECTORY_DIR + File.separator + dir;

        File fileDir = new File(absolutPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        if (!fileDir.exists() || !fileDir.isDirectory() || !fileDir.canWrite()) {
            logger.error("absolute path error: " + fileDir.getAbsolutePath());
            return absolutPath;
        }
        return absolutPath;
    }

    public String getAbsolutPath() {
        String absolutPath = baseDirectory;

        File fileDir = new File(absolutPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        if (!fileDir.exists() || !fileDir.isDirectory() || !fileDir.canWrite()) {
            logger.error("absolute path error: " + fileDir.getAbsolutePath());
            return absolutPath;
        }
        return absolutPath;
    }

    public void setBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

}
