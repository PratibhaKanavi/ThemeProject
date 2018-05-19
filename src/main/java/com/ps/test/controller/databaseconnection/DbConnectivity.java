package com.ps.test.controller.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;


@Component
public class DbConnectivity {

	public Connection dbConnect(){
		Connection conn=null;
		try {
			
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//conn = DriverManager.getConnection("jdbc:sqlserver://192.168.100.21;databaseName=ORCL_DBO12;integrated Security=true", "sa", "tvd123");
			
			 conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-5MTQQ8H;databaseName=ORCL_DBO12","sa","tvd123");
			System.out.println("connected with the Db");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
		}
	
}
