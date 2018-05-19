package com.ps.test.controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SQLLiteDemo {
	
	@RequestMapping("/xmltolitedb")
	public void sqllitemethod()
	{
		Connection conn=null;
		try {
			
			System.out.println("inside the ");
			Class.forName("org.sqlite.JDBC");
			//String url="jdbc:sqlite:E:/sqlite/mydb.db";	
			String url="jdbc:sqlite:D:/sweet~/5L01_352514082276415_54003702_01032018.db";
			 conn =DriverManager.getConnection(url);
			 
			 
			 
			if(conn!=null){
				System.out.println("Connected to the database");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                conn.close();
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
