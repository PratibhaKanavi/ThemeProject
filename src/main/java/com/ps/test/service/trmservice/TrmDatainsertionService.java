package com.ps.test.service.trmservice;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface TrmDatainsertionService {

	int xmltoSQLLiteDB()throws SAXException, IOException, ParserConfigurationException;

	int sqlliteDBtoSqlServer() throws SQLException, ParseException, IOException, ClassNotFoundException;

	void mastInInsert() throws SQLException, ParseException, IOException, ClassNotFoundException;

}
