package com.login.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class MyConnectionProvider implements MyProvider {
	static Connection con=null;
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
