package com.ps.test.service.trmservice;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.ps.test.dao.trmdao.TrmDataInsertDao;

@Service
public class TrmDataInsertionServiceImpl implements TrmDatainsertionService{

	@Autowired
	TrmDataInsertDao dao;

	@Override
	public int xmltoSQLLiteDB() throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		return dao.xmltoSQLLiteDB();
	}

	@Override
	public int sqlliteDBtoSqlServer() throws SQLException, ParseException, IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		return dao.sqlliteDBtoSqlServer();
	}

	@Override
	public void mastInInsert() throws SQLException, ParseException, IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		dao.mastInInsert();
	}
}
