package com.sxt.base;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
import java.sql.*;

public class BaseDao {

	private Connection conn = null;				//数据库连接对象
	private Statement st = null;
	private PreparedStatement pst = null;
	private CallableStatement cst = null;
	private ResultSet rs = null;
	protected Result res = null;				//将查询到的结果集转存到Result对象中

    // 数据库连接
									  
    private static final String URL ="jdbc:mysql://192.168.0.251:3306/sxt?characterEncoding=utf8";
    private static final String NAME = "root";
    private static final String PASS = "123456";
    private static final String DRIVER ="com.mysql.jdbc.Driver";

	/**
	 * 获取数据库连接
	 * @return 连接对象
	 */
	protected Connection getConnection() {
		try {
			// SQL Server加载驱动
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=UserManager", "sa", "sasa");

			// Oracle加载驱动
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","oracle");
			
			
			// MySql加载驱动
			Class.forName(DRIVER);						// 加载数据库驱动类
			conn = DriverManager.getConnection(URL,NAME,PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("BaseDao_getConnection_ClassNotFoundException:" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("BaseDao_getConnection_SQLException:" + e.getMessage());
		}
//		try {
//			// 连接池创建数据库连接对象
//			Context context = new InitialContext();
//			DataSource ds = (DataSource)context.lookup("java:comp/env/privs");
//			return ds.getConnection();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return conn;
	}

	/**
	 * 执行增删改的方法
	 * @param sql SQL语句
	 * @param objs 这个参数可以不填,可传入一个参数或参数数组
	 * @return 影响的行数
	 */
	protected int executeUpdate(String sql, Object... objs) {
		int num = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			if (objs != null && objs.length > 0) {
				for (int i = 0; i < objs.length; i++) {
					pst.setObject(i + 1, objs[i]);
				}
			}
			num = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BaseDao_executeUpdate_SQLException:" + e.getMessage());
		} finally {
			closeAll();
		}
		return num;
	}

	/**
	 * 执行查询的方法
	 * @param sql SQL语句
	 * @param objs 这个参数可以不填,可传入一个参数或参数数组
	 * @return 查询获得一个结果集
	 */
	protected Result executeQuery(String sql, Object... objs) {
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			if (objs != null && objs.length > 0) {
				for (int i = 0; i < objs.length; i++) {
					pst.setObject(i + 1, objs[i]);
				}
			}
			rs = pst.executeQuery();
			return ResultSupport.toResult(rs);
		} catch (SQLException e) {
			System.out.println("BaseDao_executeQuery_SQLException:" + e.getMessage());
		} finally {
			closeAll();
		}
		return null;
	}

	/**
	 * 关闭ResultSet、CallableStatement、Statement、PreparedStatement、Connection
	 */
	protected void closeAll() {
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			System.out.println("BaseDao_closeAll_ResultSet:" + e.getMessage());
		}

		try {
			if (cst != null) cst.close();
		} catch (SQLException e) {
			System.out.println("BaseDao_closeAll_CallableStatement:" + e.getMessage());
		}

		try {
			if (pst != null) pst.close();
		} catch (SQLException e) {
			System.out.println("BaseDao_closeAll_PreparedStatement:" + e.getMessage());
		}

		try {
			if (st != null) st.close();
		} catch (SQLException e) {
			System.out.println("BaseDao_closeAll_Statement:" + e.getMessage());
		}

		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			System.out.println("BaseDao_closeAll_Connection:" + e.getMessage());
		}
	}
	
}
