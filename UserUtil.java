package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserUtil {
	public static Connection creatConnection()
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_mwf_8","root","");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return conn;
	}

}
