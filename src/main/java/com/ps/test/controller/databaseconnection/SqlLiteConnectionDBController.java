package com.ps.test.controller.databaseconnection;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;

@Controller
public class SqlLiteConnectionDBController {
	
	public Connection sqlLiteconnect(){
		Connection conn=null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			//String url="jdbc:sqlite:E:/sqlite/mydb.db";
			
			
				
			String url="jdbc:sqlite:C:/DBs/5L01_352514082475140_54003810_30112017.db";
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
		
		
		return conn;
		
	}

	/*public static void main(String[] args) {
		System.out.println("in main function");
		SqlLiteConnectionDBController controller = new SqlLiteConnectionDBController();
		Connection con = controller.sqlLiteconnect();
		
		
	}*/
	
}
