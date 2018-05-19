package com.ps.test.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.ps.test.controller.databaseconnection.DbConnectivity;
import com.ps.test.service.trmservice.TrmDatainsertionService;


@Controller
public class TrmController {
	
	@Autowired
	TrmDatainsertionService service;
	
	@Autowired
	DbConnectivity connectivity;
	
	
	@RequestMapping("/datainsert")
	public ModelAndView datainsert(){
		return new ModelAndView("datainsert");
		
	}
	
/////////////// method to generate the Xml file into .db file ////////////////////////////////////////////
	
	/*@RequestMapping("/xmltolitedb")
	public @ResponseBody String xmltoSQLLiteDB() throws SAXException, IOException, ParserConfigurationException{
		int i=0;
	 i = service.xmltoSQLLiteDB();
		if(i == 1)
			return "data inserted Sucessfully";
		
		else 
			return "fails while inserting data";
	}*/
	
	
	
////////////////////////Method to insert the data from the .db file to an SQLServer database/////////////////// 
	@RequestMapping(value="/litetosqlserver",method=RequestMethod.GET )
	public @ResponseBody void sqlliteDBtoSqlServer() throws SQLException, ParseException, IOException, ClassNotFoundException{
		int i=0;
		String msg="data inserted Sucessfully";
		String msg1 = "fails while inserting data";
		 i = service.sqlliteDBtoSqlServer();
		/*System.out.println("lite to sql server controller--> "+i);
		if(i == 1){
			System.out.println("inside the if....");
			return msg;
		}
		else 
			return msg1;*/
	}
	
	
////////////////////////MAst_IN table insertion method///////////////////////
	public void mastInInsert() throws SQLException, ParseException, IOException, ClassNotFoundException{
		service.mastInInsert();
	}

	
	



}
