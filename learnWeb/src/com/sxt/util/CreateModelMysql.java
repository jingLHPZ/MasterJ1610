package com.sxt.util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sxt.base.BaseDao;


/**
 * 给mybatis新model初始化
 */
public class CreateModelMysql extends BaseDao {
	
	// 输入的数据
    private String projectName = "sxtWeb"; // 项目名称
    private String javaSourceFolder = "/src"; // Java Source路径
    private String resourceSourceFolder = "/src/com/sxt"; // Resource Source路径
    private String packageOutPath = "com.sxt"; // 指定实体生成所在包的路径
    private String authorName = ""; // 作者名字
    private String databaseName = "sxt"; // 库名
    private String tableName = "ld_sale_proxy_merchant"; // 表名


    // 输出的数据
    private String workspacePath; // 工作空间路径
    private String tablePrimaryKey; // 表主键
    private String className; // 类名
    private String classAliasName; // 类别名
    private String classComment; // 类注释
    private List<String> colNames; // 列名数组
    private List<String> colTypes; // 列名类型数组
    private List<String> colComments; // 列名注释数组
    private List<String> propertys; // 列名注释数组
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*
    private boolean f_decimal = false; // 是否需要导入包java.sql.*

    /*
     * 构造函数
     */
    public CreateModelMysql() {
        // 查要生成实体类的表
        String tableSql = "SELECT * FROM information_schema.tables WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?;";
        String columnSql = "SELECT * FROM information_schema.columns WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?;";

        try {
            Result result = executeQuery(tableSql, databaseName, tableName);
            SortedMap[] rows = result.getRows();
            classComment = rows[0].get("TABLE_COMMENT").toString().trim();

            result = null;
            rows = null;
            result = executeQuery(columnSql, databaseName, tableName);
            rows = result.getRows();
            colNames = new ArrayList<String>();
            colTypes = new ArrayList<String>();
            colComments = new ArrayList<String>();
            propertys = new ArrayList<String>();
            for (int i = 0; i < rows.length; i++) {
            	String COLUMN_KEY = rows[i].get("COLUMN_KEY").toString();
                if ("PRI".equals(COLUMN_KEY)) {
                    tablePrimaryKey = rows[i].get("COLUMN_NAME").toString();
                }
                colNames.add(rows[i].get("COLUMN_NAME").toString());
                propertys.add(deleteUnderlineToStr(rows[i].get("COLUMN_NAME").toString()));
                String DATA_TYPE = rows[i].get("DATA_TYPE").toString();
                colTypes.add(DATA_TYPE);
                colComments.add(rows[i].get("COLUMN_COMMENT").toString().trim());

                if(DATA_TYPE.toString().equalsIgnoreCase("datetime") 
                		|| DATA_TYPE.toString().equalsIgnoreCase("date")){
                    f_util = true;
                }
                if(DATA_TYPE.equalsIgnoreCase("decimal")) {
                    f_decimal = true;
                }
                if(DATA_TYPE.equalsIgnoreCase("image")) {
                    f_sql = true;
                }
            }

            // No.1 实体类
            classAliasName = initcapEntityName(tableName);
            className = classAliasName;

            String content = parse();

            Scanner input = new Scanner(System.in);
            workspacePath = System.getProperty("user.dir");
            if (!workspacePath.endsWith("\\" + projectName)) {
                workspacePath += "\\" + projectName;
            }
            String outPutPath = workspacePath + javaSourceFolder + File.separator + (this.packageOutPath+".models").replace(".", "\\") + File.separator + className + ".java";
            if (new File(outPutPath).exists()) {
                System.out.print(className + "类已存在，是否覆盖原文件(y/n)：");
                String next = input.next();
                if ("y".equals(next.toLowerCase())) {
                    fileWriter(outPutPath, content);
                }
            } else {
                fileWriter(outPutPath, content);
            }
            System.out.println("正在生成 已完成 25%");

            // No.2 Dao类
            content = parseDao();
            outPutPath = workspacePath + javaSourceFolder + File.separator + (this.packageOutPath + ".inter").replace(".", "/") + File.separator + "I" + classAliasName + ".java";
            if (new File(outPutPath).exists()) {
                System.out.print("I" + classAliasName + "类已存在，是否覆盖原文件(y/n)：");
                String next = input.next();
                if ("y".equals(next.toLowerCase())) {
                    fileWriter(outPutPath, content);
                }
            } else {
                fileWriter(outPutPath, content);
            }
            System.out.println("正在生成 已完成 50%");
            

            // No.3 Dao对应的Mybatis配置文件
            content = parseMybatisDao();
            outPutPath = workspacePath + resourceSourceFolder + "/mapper" + File.separator + classAliasName + "Mapper.xml";
            if (new File(outPutPath).exists()) {
                System.out.print(classAliasName + "Mapper.xml写配置文件已存在，是否覆盖原文件(y/n)：");
                String next = input.next();
                if ("y".equals(next.toLowerCase())) {
                    fileWriter(outPutPath, content);
                }
            } else {
                fileWriter(outPutPath, content);
                //settingMybatisConfig();
            }
            System.out.println("正在生成 已完成 75%");

            // No.4 Service类
            /*content = parseServiceImpl();
            outPutPath = workspacePath + javaSourceFolder + File.separator + (this.packageOutPath + ".service.impl").replace(".", "/") + File.separator + classAliasName + "ServiceImpl.java";
            if (new File(outPutPath).exists()) {
                System.out.print(classAliasName + "ServiceImpl类已存在，是否覆盖原文件(y/n)：");
                String next = input.next();
                if ("y".equals(next.toLowerCase())) {
                    fileWriter(outPutPath, content);
                }
            } else {
                fileWriter(outPutPath, content);
            }*/
            input.close();
            System.out.println("正在生成 已完成 100%");
            System.out.print("Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件写入
     * @param outPutPath
     * @param content
     * @throws Exception
     */
    public void fileWriter(String outPutPath, String content) throws Exception {
        FileWriter fw = new FileWriter(outPutPath);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        pw.close();
        fw.close();
    }

    /**
     * 设置Mybatis Configuration
     * @param pkg
     */
    public void settingMybatisConfig() throws Exception {
        Document doc = XmlUtil.read("/config/MyBatis-Configuration.xml");
        Element root = doc.getRootElement();
        Iterator it = root.elementIterator();
        it.next();
        Element ele = (Element) it.next();
        Element ele2 = DocumentHelper.createElement("mapper");
        ele2.addAttribute("resource", "mybatis/" + classAliasName + "DaoMapper.xml");
        ele.add(ele2);
        XmlUtil.write(doc, workspacePath + resourceSourceFolder + "/mybatis/MyBatis-Configuration.xml");
    }

    /**
     * 功能：生成实体类主体代码
     * @return
     */
    private String parse() {
        StringBuffer sb = new StringBuffer();

        sb.append("package " + this.packageOutPath + ".models;\r\n");
        sb.append("\r\n");
        
        // 判断是否导入工具包
        if(f_util) {
            sb.append("import java.util.Date;\r\n");
        }
        if(f_sql) {
            sb.append("import java.sql.*;\r\n");
        }
        if(f_decimal) {
        	sb.append("import java.math.BigDecimal;\r\n");
        }
        if(f_util || f_sql) {
            sb.append("\r\n");
        }
        sb.append("import java.io.Serializable;\r\n");
        sb.append("\r\n");
        
        // 注释部分
        sb.append("/**\r\n");
        sb.append(" * " + classComment + "类 " + tableName + "\r\n");
        sb.append(" * @author " + this.authorName + "\r\n");
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        sb.append(" * @date " + sp.format(new Date()) + "\r\n");
        sb.append(" */\r\n");
        
        // 实体部分
        sb.append("public class " + className + "  implements Serializable {\r\n");
        sb.append("\r\n");
        sb.append("\tprivate static final long serialVersionUID = 1L;\r\n");
        sb.append("\r\n");
        processAllAttrs(sb); // 属性
        processAllMethod(sb); // get set方法
        sb.append("}");

        return sb.toString();
    }

    /**
     * 功能：生成所有属性
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {
        for (int i = 0; i < propertys.size(); i++) {
            sb.append("\t/**\r\n");
            sb.append("\t * " + colComments.get(i) + "\r\n");
            sb.append("\t */\r\n");
            sb.append("\tprivate " + sqlType2JavaType(colTypes.get(i)) + " " + propertys.get(i) + ";\r\n");
            sb.append("\r\n");
        }
    }

    /**
     * 功能：生成所有方法
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {
        for (int i = 0; i < propertys.size(); i++) {
            sb.append("\tpublic " + sqlType2JavaType(colTypes.get(i)) + ("boolean".equals(sqlType2JavaType(colTypes.get(i)))?" is":" get") + initcap(propertys.get(i)) + "() {\r\n");
            sb.append("\t\treturn " + propertys.get(i) + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\r\n");
            sb.append("\tpublic void set" + initcap(propertys.get(i)) + "(" + sqlType2JavaType(colTypes.get(i)) + " " + propertys.get(i) + ") {\r\n");
            sb.append("\t\tthis." + propertys.get(i) + " = " + propertys.get(i) + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\r\n");
        }
    }
    
    /**
     * 将字符串带有下划线的去掉，并将首字母大写
     * @param param
     * @return
     */
    private String deleteUnderlineToStr(String param) {
    	
    	StringBuffer str = new StringBuffer();
    	
    	String colum[] = param.split("_");
    	
    	if (colum.length > 0) {
    		str.append(colum[0]);
    		for (int i = 1; i < colum.length; i++) {
    			str.append(initcap(colum[i]));
			}
    	}
    	return str.toString();
    }

    /**
     * 功能：将输入字符串的首字母改成大写
     * @param str
     * @return
     */
    private String initcapEntityName(String str) {
        char[] ch = str.toCharArray();
        if(ch[0] >= 'a' && ch[0] <= 'z'){
            ch[0] = (char)(ch[0] - 32);
        }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '_') {
                ch[i + 1] = (char) (ch[i + 1] - 32);
            }
        }
        return new String(ch).replace("_", "");
    }

    /**
     * 功能：将输入字符串的首字母改成大写
     * @param str
     * @return
     */
    private String initcap(String str) {
        char[] ch = str.toCharArray();
        if(ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char)(ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * 功能：获得列的数据类型
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType) {
        if(sqlType.equalsIgnoreCase("bit")){
            return "Boolean";
        }else if(sqlType.equalsIgnoreCase("tinyint")){
            return "Byte";
        }else if(sqlType.equalsIgnoreCase("smallint")){
            return "Short";
        }else if(sqlType.equalsIgnoreCase("int")){
            return "Integer";
        }else if(sqlType.equalsIgnoreCase("bigint")){
            return "Long";
        }else if(sqlType.equalsIgnoreCase("float")){
            return "Float";
        } else if (sqlType.equalsIgnoreCase("decimal")) {
        	return "BigDecimal";
        } else if(sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("double") || sqlType.equalsIgnoreCase("smallmoney")){
            return "Double";
        }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")|| sqlType.equalsIgnoreCase("longtext")
                || sqlType.equalsIgnoreCase("longblob")){
            return "String";
        }else if(sqlType.equalsIgnoreCase("datetime") || sqlType.equalsIgnoreCase("date")){
            return "Date";
        }else if(sqlType.equalsIgnoreCase("image")){
            return "Blob";
        }

        return null;
    }

    /**
     * 功能：生成Dao写类主体代码
     * @return
     */
    private String parseDao() {
        String lowerName = classAliasName.substring(0, 1).toLowerCase() + classAliasName.substring(1);
        StringBuffer sb = new StringBuffer();

        sb.append("package " + (this.packageOutPath + ".inter") + ";\r\n");
        sb.append("\r\n");
        // 导包
        sb.append("import java.util.List;\r\n");
        sb.append("\r\n");
        sb.append("import " + (this.packageOutPath + ".models.") + className + ";\r\n");
        sb.append("\r\n");
        sb.append("import java.util.Map;\r\n");
        sb.append("\r\n");
        // 实体部分
        sb.append("public interface I" + classAliasName + " {\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 添加一个" + classComment + "，并且给它分配ID\r\n");
        sb.append("\t * @param " + lowerName + "\r\n");
        sb.append("\t * @return 影响行数\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic int insert(" + className + " " + lowerName + ");\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 编辑" + classComment + "\r\n");
        sb.append("\t * @param " + lowerName + "\r\n");
        sb.append("\t * @return 影响行数\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic int update(" + className + " " + lowerName + ");\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 根据ID删除" + classComment + "\r\n");
        sb.append("\t * @param id\r\n");
        sb.append("\t * @return 影响行数\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic int delete(Long id);\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 根据条件查询List" + classComment + "\r\n");
        sb.append("\t * @param maps\r\n");
        sb.append("\t * @return \r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic List<" + className + "> query"+ className +"List(Map<String, Object> params);\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 根据条件查询" + classComment + "\r\n");
        sb.append("\t * @param " + lowerName + "\r\n");
        sb.append("\t * @return \r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic " + className + " query"+ className +"ByCondition(" + className + " " + lowerName + ");\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 根据条件查询" + classComment + "总个数\r\n");
        sb.append("\t * @param " + lowerName + "\r\n");
        sb.append("\t * @return \r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic int query"+ className +"Count(" + className + " " + lowerName + ");\r\n");
        sb.append("\r\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * 功能：生成Mybatis写配置文件
     * @return
     */
    private String parseMybatisDao() {
        StringBuffer sb = new StringBuffer();
        String lowerName = classAliasName.substring(0, 1).toLowerCase() + classAliasName.substring(1);
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n");
        sb.append("<mapper namespace=\"" + (this.packageOutPath + ".inter.I") + classAliasName + "\">\r\n");
        sb.append("\r\n");
        sb.append("\t<resultMap type=\""+ className +"\" id=\""+ lowerName +"Map\">");
        sb.append("\r\n");
        sb.append("\t\t<id property=\""+ deleteUnderlineToStr(tablePrimaryKey) +"\" column=\""+ tablePrimaryKey +"\" />");
        sb.append("\r\n");
        for (int i = 0; i < colNames.size(); i++) {
        	if (colNames.get(i) != tablePrimaryKey) {
        		sb.append("\t\t<result property=\"" + propertys.get(i) + "\" column=\"" + colNames.get(i) + "\"/>");
        		sb.append("\r\n");
        	}
        }
        sb.append("\t</resultMap>");
        sb.append("\r\n");
        sb.append("\t<insert id=\"insert\" parameterType=\"" + className + "\" keyProperty=\"" + tablePrimaryKey + "\" useGeneratedKeys=\"true\">\r\n");
        sb.append("\t\tINSERT INTO " + tableName + " (\r\n");
        sb.append("\t\t\t<trim suffixOverrides=\",\">\r\n");
        for (int i = 0; i < colNames.size(); i++) {
        	sb.append("\t\t\t<if test=\"" + propertys.get(i) + " != null\">" + colNames.get(i) + ", </if>\r\n");
        }
        sb.append("\t\t\t</trim>");
        sb.append("\r\n");
        sb.append("\t\t) VALUES (\r\n");
        sb.append("\t\t\t<trim suffixOverrides=\",\">\r\n");
        for (int i = 0; i < colNames.size(); i++) {
        	sb.append("\t\t\t<if test=\"" + propertys.get(i) + " != null\">#{" + propertys.get(i) + "}, </if>\r\n");
        }
        sb.append("\t\t\t</trim>");
        sb.append("\r\n");
        sb.append("\t\t)\r\n");
        sb.append("\t</insert>\r\n");
        sb.append("\r\n");
        sb.append("\t<update id=\"update\" parameterType=\"" + className + "\">\r\n");
        sb.append("\t\tUPDATE " + tableName + " \r\n");
        sb.append("\t\t<set>\r\n");
        for (int i = 0; i < colNames.size(); i++) {
            sb.append("\t\t<if test=\"" + propertys.get(i) + " != null\">" + colNames.get(i) + " = #{" + propertys.get(i) + "}, </if>\r\n");
        }
        sb.append("\t\t</set>\r\n");
        sb.append("\t\tWHERE " + tablePrimaryKey + " = #{" + tablePrimaryKey + "} \r\n");
        sb.append("\t</update>\r\n");
        sb.append("\r\n");
        sb.append("\t<delete id=\"delete\" parameterType=\"Long\">\r\n");
        sb.append("\t\tDELETE FROM " + tableName + " \r\n");
        sb.append("\t\tWHERE " + tablePrimaryKey + " = #{" + tablePrimaryKey + "} \r\n");
        sb.append("\t</delete>\r\n");
        sb.append("\r\n");
        sb.append("\t<select id=\"query" + className + "List\"  parameterType=\"java.util.Map\" resultMap=\""+ lowerName +"Map\">\r\n");
        sb.append("\t\tSELECT * FROM " + tableName + " \r\n");
        sb.append("\t\tWHERE 1=1 \r\n");
        sb.append("\t\t<if test=\"startRow != null and pageSize != null\">limit #{startRow},#{pageSize}</if> \r\n");
        sb.append("\t</select>\r\n");
        sb.append("\r\n");
        sb.append("\t<select id=\"query" + className + "Count\"  parameterType=\"java.util.Map\" resultType=\"Integer\">\r\n");
        sb.append("\t\tSELECT count(id) FROM " + tableName + " \r\n");
        sb.append("\t\tWHERE 1=1 \r\n");
        sb.append("\t</select>\r\n");
        sb.append("\r\n");
        sb.append("\t<select id=\"query" + className + "ByCondition\"  parameterType=\""+ className +"\" resultMap=\""+ lowerName +"Map\">\r\n");
        sb.append("\t\tSELECT * FROM " + tableName + " \r\n");
        sb.append("\t\tWHERE " + tablePrimaryKey + " = #{" + tablePrimaryKey + "} \r\n");
        sb.append("\t</select>\r\n");
        sb.append("\r\n");
        sb.append("</mapper>");
        return sb.toString();
    }

    /**
     * 功能：生成Service类主体代码
     * @return
     */
    private String parseServiceImpl() {
        String lowerName = classAliasName.substring(0, 1).toLowerCase() + classAliasName.substring(1);
        StringBuffer sb = new StringBuffer();

        sb.append("package " + (this.packageOutPath + ".service.impl") + ";\r\n");
        sb.append("\r\n");
        // 导包
        sb.append("import java.util.List;\r\n");
        sb.append("import java.util.Map;\r\n");
        sb.append("\r\n");
        sb.append("import org.apache.commons.logging.Log;\r\n");
        sb.append("import org.apache.commons.logging.LogFactory;\r\n");
        sb.append("import org.springframework.beans.factory.annotation.Autowired;\r\n");
        sb.append("import org.springframework.stereotype.Service;\r\n");
        sb.append("\r\n");
        sb.append("import " + this.packageOutPath + ".common.util.PageUtils;\r\n");
        sb.append("import " + (this.packageOutPath + ".daor.") + classAliasName + "DaoR;\r\n");
        sb.append("import " + (this.packageOutPath + ".daow.") + classAliasName + "DaoW;\r\n");
        sb.append("import " + (this.packageOutPath + ".entity.") + className + ";\r\n");
        sb.append("import " + (this.packageOutPath + ".entity.page.") + "Page;\r\n");
        sb.append("\r\n");
        // 实体部分
        sb.append("@Service\r\n");
        sb.append("public class " + classAliasName + "ServiceImpl {\r\n");
        sb.append("\r\n");
        sb.append("\tprivate final Log log = LogFactory.getLog(this.getClass());\r\n");
        sb.append("\r\n");
        sb.append("\t@Autowired\r\n");
        sb.append("\tprivate " + classAliasName + "DaoR " + lowerName + "DaoR;\r\n");
        sb.append("\r\n");
        sb.append("\t@Autowired\r\n");
        sb.append("\tprivate " + classAliasName + "DaoW " + lowerName + "DaoW;\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 根据条件获取" + classComment + "，带分页\r\n");
        sb.append("\t * @param " + lowerName + "\r\n");
        sb.append("\t * @param page\r\n");
        sb.append("\t * @return\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic List<" + className + "> find" + classAliasName + "ByPage(" + className + " " + lowerName + ",\r\n");
        sb.append("\t\t\tPage page) {\r\n");
        sb.append("\t\ttry {\r\n");
        sb.append("\t\t\tcondition(" + lowerName + ");\r\n");
        sb.append("\t\t\tString myColumn = " + lowerName + ".getMyColumn();\r\n");
        sb.append("\t\t\tpage.setEntityCount(count" + classAliasName + "By(" + lowerName + ", true));\r\n");
        sb.append("\t\t\t" + lowerName + ".setMyColumn(myColumn);\r\n");
        sb.append("\t\t\tPageUtils.setPage(" + lowerName + ", page);\r\n");
        sb.append("\t\t\treturn " + lowerName + "DaoR.findByPage(" + lowerName + ");\r\n");
        sb.append("\t\t} catch (Exception e) {\r\n");
        sb.append("\t\t\tlog.error(\"function find" + classAliasName + "ByPage fail ================== \" + e.getMessage());\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t\treturn null;\r\n");
        sb.append("\t}\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 根据条件获取" + classComment + "\r\n");
        sb.append("\t * @param " + lowerName + "\r\n");
        sb.append("\t * @return\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic List<" + className + "> find" + classAliasName + "By(" + className + " " + lowerName + ") {\r\n");
        sb.append("\t\ttry {\r\n");
        sb.append("\t\t\tcondition(" + lowerName + ");\r\n");
        sb.append("\t\t\treturn " + lowerName + "DaoR.findBy(" + lowerName + ");\r\n");
        sb.append("\t\t} catch (Exception e) {\r\n");
        sb.append("\t\t\tlog.error(\"function find" + classAliasName + "By fail ================== \" + e.getMessage());\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t\treturn null;\r\n");
        sb.append("\t}\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 根据条件获取" + classComment + "记录总条数\r\n");
        sb.append("\t * @param " + lowerName + "\r\n");
        sb.append("\t * @return\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic int count" + classAliasName + "By(" + className + " " + lowerName + ", boolean...isPage) {\r\n");
        sb.append("\t\ttry {\r\n");
        sb.append("\t\t\tif (isPage.length == 0 || !isPage[0]) condition(" + lowerName + ");\r\n");
        sb.append("\t\t\t" + lowerName + ".setMyColumn(\"count(*) count\");\r\n");
        sb.append("\t\t\tMap<String, Object> arrayMap = " + lowerName + "DaoR.arrayBy(" + lowerName + ");\r\n");
        sb.append("\t\t\tif (arrayMap != null) {\r\n");
        sb.append("\t\t\t\treturn Integer.parseInt(arrayMap.get(\"count\").toString());\r\n");
        sb.append("\t\t\t}\r\n");
        sb.append("\t\t} catch (Exception e) {\r\n");
        sb.append("\t\t\tlog.error(\"function count" + classAliasName + "By fail ================== \" + e.getMessage());\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t\treturn 0;\r\n");
        sb.append("\t}\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 根据ID获取" + classComment + "\r\n");
        sb.append("\t * @param id\r\n");
        sb.append("\t * @return\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic " + className + " find" + classAliasName + "ById(Long id) {\r\n");
        sb.append("\t\treturn find" + classAliasName + "ById(id, \"*\");\r\n");
        sb.append("\t}\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 根据ID获取" + classComment + "，且获取指定字段\r\n");
        sb.append("\t * @param id\r\n");
        sb.append("\t * @param myColumn\r\n");
        sb.append("\t * @return\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic " + className + " find" + classAliasName + "ById(Long id, String myColumn) {\r\n");
        sb.append("\t\ttry {\r\n");
        sb.append("\t\t\t" + className + " " + lowerName + " = new " + className + "();\r\n");
        sb.append("\t\t\t" + lowerName + ".setMyWhere(\" AND " + tablePrimaryKey + " = \" + id);\r\n");
        sb.append("\t\t\t" + lowerName + ".setMyColumn(myColumn);\r\n");
        sb.append("\t\t\tList<" + className + "> list = " + lowerName + "DaoR.findBy(" + lowerName + ");\r\n");
        sb.append("\t\t\tif (list != null && list.size() > 0) return list.get(0);\r\n");
        sb.append("\t\t} catch (Exception e) {\r\n");
        sb.append("\t\t\tlog.error(\"function find" + classAliasName + "ById fail ================== \" + e.getMessage());\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t\treturn null;\r\n");
        sb.append("\t}\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 添加" + classComment + "\r\n");
        sb.append("\t * @param " + lowerName + "\r\n");
        sb.append("\t * @return\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic " + className + " add" + classAliasName + "(" + className + " " + lowerName + ") {\r\n");
        sb.append("\t\ttry {\r\n");
        sb.append("\t\t\t" + lowerName + "DaoW.add(" + lowerName + ");\r\n");
        sb.append("\t\t\treturn " + lowerName + ";\r\n");
        sb.append("\t\t} catch (Exception e) {\r\n");
        sb.append("\t\t\tlog.error(\"function add" + classAliasName + " fail ================== \" + e.getMessage());\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t\treturn null;\r\n");
        sb.append("\t}\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 编辑" + classComment + "\r\n");
        sb.append("\t * @param " + lowerName + "\r\n");
        sb.append("\t * @return\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic boolean update" + classAliasName + "(" + className + " " + lowerName + ") {\r\n");
        sb.append("\t\ttry {\r\n");
        sb.append("\t\t\tint resultNum = " + lowerName + "DaoW.upd(" + lowerName + ");\r\n");
        sb.append("\t\t\treturn resultNum != 0;\r\n");
        sb.append("\t\t} catch (Exception e) {\r\n");
        sb.append("\t\t\tlog.error(\"function update" + classAliasName + " fail ================== \" + e.getMessage());\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t\treturn false;\r\n");
        sb.append("\t}\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 根据ID删除" + classComment + "\r\n");
        sb.append("\t * @param id\r\n");
        sb.append("\t * @return\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic boolean delete" + classAliasName + "(Long id) {\r\n");
        sb.append("\t\ttry {\r\n");
        sb.append("\t\t\tint resultNum = " + lowerName + "DaoW.del(id);\r\n");
        sb.append("\t\t\treturn resultNum != 0;\r\n");
        sb.append("\t\t} catch (Exception e) {\r\n");
        sb.append("\t\t\tlog.error(\"function delete" + classAliasName + " fail ================== \" + e.getMessage());\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t\treturn false;\r\n");
        sb.append("\t}\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 批量删除" + classComment + "\r\n");
        sb.append("\t * @param idList\r\n");
        sb.append("\t * @return\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic boolean deleteBatch" + classAliasName + "(List<Long> idList) {\r\n");
        sb.append("\t\ttry {\r\n");
        sb.append("\t\t\tint resultNum = " + lowerName + "DaoW.delBatch(idList);\r\n");
        sb.append("\t\t\treturn resultNum != 0;\r\n");
        sb.append("\t\t} catch (Exception e) {\r\n");
        sb.append("\t\t\tlog.error(\"function deleteBatch" + classAliasName + " fail ================== \" + e.getMessage());\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t\treturn false;\r\n");
        sb.append("\t}\r\n");
        sb.append("\r\n");
        sb.append("\t/**\r\n");
        sb.append("\t * 条件拼装\r\n");
        sb.append("\t * @param " + lowerName + "\r\n");
        sb.append("\t * @return\r\n");
        sb.append("\t */\r\n");
        sb.append("\tpublic void condition(" + className + " " + lowerName + ") {\r\n");
        sb.append("\t\tif(" + lowerName + " == null) \r\n");
        sb.append("\t\t\treturn;\r\n");
        sb.append("\t\tStringBuffer sqlFilter = new StringBuffer(\"\");\r\n");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\t\t" + lowerName + ".setMyWhere(sqlFilter.toString());\r\n");
        sb.append("\t}\r\n");
        sb.append("\r\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * 出口
     * TODO
     * @param args
     */
    public static void main(String[] args) {

        new CreateModelMysql();

    }

}
