package com.management.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * JDBC获取数据库连接工具类
 */
public class JDBCUtil {
	
	private static Connection con;
	
	/**
	 * 获取Mysql数据库连接
	 * @return java.sql.Connection对象
	 */
	public static Connection getConnection() 
			throws ClassNotFoundException, SQLException {
		//数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//数据库连接地址
		String url = "jdbc:mysql://localhost:3306/manager"
				+ "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		//数据库用户名
		String user = "root";
		//数据库密码
		String password = "";
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
}
