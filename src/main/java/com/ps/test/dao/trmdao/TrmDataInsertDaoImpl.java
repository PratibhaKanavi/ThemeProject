package com.ps.test.dao.trmdao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.ps.test.controller.databaseconnection.DbConnectivity;
import com.ps.test.controller.databaseconnection.SqlLiteConnectionDBController;

@Repository
public class TrmDataInsertDaoImpl implements TrmDataInsertDao{
	
	private static final Logger log = Logger.getLogger(TrmDataInsertDaoImpl.class);

	@Autowired
	DbConnectivity connectivity;
	
	@Autowired
    SqlLiteConnectionDBController connectlite;
	
	@Autowired
	SessionFactory factory;
	
	
	
	@Override
	public int xmltoSQLLiteDB() throws SAXException, IOException, ParserConfigurationException{
		int k = 0;
		// TODO Auto-generated method stub
		File file = new File("D:/TRMRELATEDDOCS/DBs");
        File[] files = file.listFiles();
        String sql1=null;
        String sql2=null;
        String sql3=null;
		String sql4=null;
		 String sql5=null;
	        String sql6=null;
	        String sql7=null;
			String sql8=null;
			 String sql9=null;
		        String sql10=null;
		        String sql11=null;
				String sql12=null;
				 String sql13=null;
			        String sql14=null;
			        String sql15=null;
					String sql16=null;
			       String query=null; 
			       String query1=null; 
			       String query2=null; 
        
        String  f1=null;
        Connection sqlliteconn = null;
        for (File file2 : files) {
		
        	System.out.println("name---->"+file2.getName());
        	f1= file2.getName();
        	String device_id= "123456789012341";
        	String mrcode = f1.substring(14	, 22);
        	 String Id = f1.substring(9, 13);
        	 
        	 String Date = f1.substring(23,31);
        	 
        	 String dest_db1 = "D:/TRMRELATEDDOCS/mydbTExt.db";
        	 File db_path = new File("D:/TRMRELATEDDOCS/mydbTExt.db");
        	
        	String filename = Id + "_" + device_id.substring(0, 15).toString() + "_" + mrcode.trim() +"-" + Date + ".db";
        	filename = filename.replace(" ", "");
        	File dest_db = new File("D:/TRMRELATEDDOCS/janxmlfilesmoved/sqllitedbfile/1-5data/csd1/04012018/"+filename) ;
        	
        	Files.copy(db_path.toPath(), dest_db.toPath());
        	
        	try {
        		
				Class.forName("org.sqlite.JDBC");
				String url="jdbc:sqlite:"+dest_db+"";
				sqlliteconn =DriverManager.getConnection(url);
				System.out.println("sqlite get connected");
				sqlliteconn.setAutoCommit(false);
				
				File fXmlFile = new File("C:/DBs/"+f1);
				System.out.println("fxmlFile---->"+fXmlFile);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				
				
				
				NodeList nodeList = doc.getElementsByTagName("ACCTINFO");
				for (int i = 0; i < nodeList.getLength(); i++) {
		            
					  Node node = nodeList.item(i);
					  
					  
					  if (node.getNodeType() == Node.ELEMENT_NODE)
				         {
				            Element eElement = (Element) node;
				            
				          //  String READDAT = filename.substring(2, 2).toString();
				         // System.out.println("pratibha READDT---->"+eElement.getElementsByTagName("MRCODE").item(0).getTextContent());
				          
				            String addr=eElement.getElementsByTagName("ADDR").item(0).getTextContent().toString().replaceAll("'", "");
				           // System.out.println("replaceAll--->"+addr);
				            
				            String name = eElement.getElementsByTagName("NAME").item(0).getTextContent().toString().replaceAll("'", "");
				            
				           sql1 = "INSERT INTO ACCTINFO(CUSTINFO_Id,MRCODE,ACCT,ORRNO,NRRNO,NAME,ADDR,TARIF,CUSTCL,NUMCONN,SLKW,SLHP,SD,TVMTRFLG,CONNLDHP,CONNLDKW,RATELDHP,RATELDKW,DBTFLG,TODFLG,TAXEXEMPT,VACANTFLG,SEASONFLG,LT1TOLT2,AVGPRVSEASON,DLBILL)"
				           		+ "VALUES('"+i+"','" +eElement.getElementsByTagName("MRCODE").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("ACCT").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("ORRNO").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("NRRNO").item(0).getTextContent().toString() + "','" +name + "',"
				          		+ "'" +addr + "','" +eElement.getElementsByTagName("TARIF").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("CUSTCL").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("NUMCONN").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("SLKW").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("SLHP").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("SD").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("TVMTRFLG").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("CONNLDHP").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("CONNLDKW").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("RATELDHP").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("RATELDKW").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("DBTFLG").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("TODFLG").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("TAXEXEMPT").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("VACANTFLG").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("SEASONFLG").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("LT1TOLT2").item(0).getTextContent().toString() + "',"
				          		+ "'" +eElement.getElementsByTagName("AVGPRVSEASON").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("DLBILL").item(0).getTextContent().toString() + "'); ";
				          
				          
				        
				Statement stmt = sqlliteconn.createStatement();
				stmt.executeUpdate(sql1);
				
				
				
				         }
					  }
				
				

				NodeList nodeList1 = doc.getElementsByTagName("AVERAGECONS");
				for (int i = 0; i < nodeList1.getLength(); i++) {
					Node node = nodeList1.item(i);
					  
					  
					  if (node.getNodeType() == Node.ELEMENT_NODE)
				         {
				            Element eElement = (Element) node;
				            
				            sql2="INSERT INTO AVERAGECONS VALUES('" +eElement.getElementsByTagName("AVGKWH").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("AVGTODOFF").item(0).getTextContent().toString() + "', " +
                                    "'" + eElement.getElementsByTagName("AVGTODON").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("AVGTODNM").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("AVGMD").item(0).getTextContent().toString()  + "', " +
                                    "'" + eElement.getElementsByTagName("AVGMDOFF").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("AVGMDON").item(0).getTextContent().toString() + "','" +eElement.getElementsByTagName("AVGMDNM").item(0).getTextContent().toString()  + "'," +
                                    "'" + eElement.getElementsByTagName("AVGKVAH").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("AVGPF").item(0).getTextContent().toString() + "','" + i+ "')";   
				         }
					
					  Statement stmt = sqlliteconn.createStatement();
						stmt.executeUpdate(sql2);
				}
				
				
				
				NodeList nodeList2 = doc.getElementsByTagName("BILLSEQ");
				for (int i = 0; i < nodeList2.getLength(); i++) {
					Node node = nodeList2.item(i);
					  
					  
					  if (node.getNodeType() == Node.ELEMENT_NODE)
				         {
				            Element eElement = (Element) node;
				            
				            sql3="INSERT INTO BILLSEQ VALUES('" + eElement.getElementsByTagName("MRCYC").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("ROUTE").item(0).getTextContent().toString()+ "', " +
	                                    "'" + eElement.getElementsByTagName("RTSEQ").item(0).getTextContent().toString() + "','" + i + "')";   
				         }
					
					  Statement stmt = sqlliteconn.createStatement();
						stmt.executeUpdate(sql3);
				}
				
				NodeList nodeList3 = doc.getElementsByTagName("CUSTINFO");
				for (int i = 0; i < nodeList3.getLength(); i++) {
					Node node = nodeList3.item(i);
					  
					  
					  if (node.getNodeType() == Node.ELEMENT_NODE)
				         {
				            Element eElement = (Element) node;
				            
				            sql4="INSERT INTO CUSTINFO VALUES('" +i+ "','" + eElement.getElementsByTagName("MTRXCHNGFLG").item(0).getTextContent().toString() + "', " +
		                                "'" + eElement.getElementsByTagName("BILLMSG").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("REBATEAMT").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("OTHER").item(0).getTextContent().toString() + "', " +
		                                "'" + eElement.getElementsByTagName("ARREARS").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("INTEREST").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("CREADJ").item(0).getTextContent().toString() + "')";   
				         }
					
					  Statement stmt = sqlliteconn.createStatement();
						stmt.executeUpdate(sql4);
				} 
				
				
				
				
				
				NodeList nodeList6 = doc.getElementsByTagName("MTRXCHANGE1");
				for (int i = 0; i < nodeList6.getLength(); i++) {
					Node node = nodeList6.item(i);
					  
					  
					  if (node.getNodeType() == Node.ELEMENT_NODE)
				         {
				            Element eElement = (Element) node;
				            
				            sql5="INSERT INTO MTRXCHANGE1 VALUES('" + eElement.getElementsByTagName("OLDMTR").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("RMDATE").item(0).getTextContent().toString() + "', " +
	                                    "'" + eElement.getElementsByTagName("RMREADSTS").item(0).getTextContent().toString()  + "','" + eElement.getElementsByTagName("RMMTRCON").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("RMREADKWH").item(0).getTextContent().toString()  + "', " +
	                                    "'" + eElement.getElementsByTagName("RMREADTODOFF").item(0).getTextContent().toString()  + "','" + eElement.getElementsByTagName("RMREADTODON").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("RMREADTODNM").item(0).getTextContent().toString() + "', " +
	                                    "'" + eElement.getElementsByTagName("RMREADMD").item(0).getTextContent().toString() + "', '" + eElement.getElementsByTagName("RMREADMDOFF").item(0).getTextContent().toString() + "', '" + eElement.getElementsByTagName("RMREADMDON").item(0).getTextContent().toString()+ "'," +
	                                    "'" + eElement.getElementsByTagName("RMREADMDNM").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("RMREADKVAH").item(0).getTextContent().toString()  + "','" + eElement.getElementsByTagName("RMREADPF").item(0).getTextContent().toString() + "'," +
	                                    "'" + eElement.getElementsByTagName("NEWMTR").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("INDATE").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("INREADSTS").item(0).getTextContent().toString()  + "','" + eElement.getElementsByTagName("INMTRCON").item(0).getTextContent().toString() + "'," +
	                                    "'" + eElement.getElementsByTagName("INREADKWH").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("INREADTODOFF").item(0).getTextContent().toString()+ "','" + eElement.getElementsByTagName("INREADTODON").item(0).getTextContent().toString()+ "'," +
	                                    "'" + eElement.getElementsByTagName("INREADTODNM").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("INREADMD").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("INREADMDOFF").item(0).getTextContent().toString() + "'," +
	                                    "'" + eElement.getElementsByTagName("INREADMDON").item(0).getTextContent().toString() + "','" + eElement.getElementsByTagName("INREADMDNM").item(0).getTextContent().toString()+ "','" + eElement.getElementsByTagName("INREADKVAH").item(0).getTextContent().toString()  + "'," +
	                                    "'" + eElement.getElementsByTagName("INREADPF").item(0).getTextContent().toString() + "','" +i + "')";   
				         }
					
					  Statement stmt = sqlliteconn.createStatement();
						stmt.executeUpdate(sql5);
				} 
				
				NodeList nodeList7 = doc.getElementsByTagName("PENALTY");
				for (int i = 0; i < nodeList7.getLength(); i++) {
					Node node = nodeList7.item(i);
					  
					  
					  
					  if (node.getNodeType() == Node.ELEMENT_NODE)
				         {
				            Element eElement = (Element) node;
				            
				            sql6="INSERT INTO PENALTY VALUES('" + eElement.getElementsByTagName("APP_PF").item(0).getTextContent().toString().trim() + "','" +eElement.getElementsByTagName("VALUE_PF").item(0).getTextContent().toString().trim() + "','" +i + "')";   
				         }
					
					  Statement stmt = sqlliteconn.createStatement();
						stmt.executeUpdate(sql6);
				}    
				
				
				
				
				
				NodeList nodeList8 = doc.getElementsByTagName("PRVMRREADS");
				String readdate=null;
				for (int i = 0; i < nodeList8.getLength(); i++) {
					Node node = nodeList8.item(i);
					  
					  
					  
					  if (node.getNodeType() == Node.ELEMENT_NODE)
				         {
				            Element eElement = (Element) node;
				           
				            NodeList nodeList01 = doc.getElementsByTagName("BILLSEQ");
				            for (int i1 = 0; i1 < nodeList01.getLength(); i1++) {
								Node node1 = nodeList01.item(i1);
								  
								  
								  
								  if (node1.getNodeType() == Node.ELEMENT_NODE)
							         {
									  Element eElement1 = (Element) node1;
				           
				            String ReadDt = eElement1.getElementsByTagName("MRCYC").item(0).getTextContent().toString().trim();
				            
				            readdate = ReadDt.substring(2, 4);
							         }
								  }
				            Calendar c = Calendar.getInstance();
				            int year = c.get(Calendar.YEAR);
				            String month = new SimpleDateFormat("MM").format(c.getTime());
				            System.out.println("month--->"+month);
				            System.out.println(new SimpleDateFormat("MM").format(c.getTime()));
				            String date = readdate + month + year;
				            
				            System.out.println("date--->"+date);
				            
				            sql7="INSERT INTO PRVMRREADS VALUES('" + eElement.getElementsByTagName("MTR").item(0).getTextContent().toString().trim() + "','" + date + "', " +
	                                    "'" +eElement.getElementsByTagName("MTRCON").item(0).getTextContent().toString().trim() + "','" +eElement.getElementsByTagName("FULLSCALE").item(0).getTextContent().toString().trim() + "','" +eElement.getElementsByTagName("READSTS").item(0).getTextContent().toString().trim() + "', " +
	                                    "'" +eElement.getElementsByTagName("READKWH").item(0).getTextContent().toString().trim() + "','" +eElement.getElementsByTagName("READTODOFF").item(0).getTextContent().toString().trim() + "','" +eElement.getElementsByTagName("READTODON").item(0).getTextContent().toString().trim() + "'," +
	                                    "'" +eElement.getElementsByTagName("READTODNM").item(0).getTextContent().toString().trim() + "','" +eElement.getElementsByTagName("READMD").item(0).getTextContent().toString().trim() + "','" +eElement.getElementsByTagName("READMDOFF").item(0).getTextContent().toString().trim() + "'," +
	                                    "'" +eElement.getElementsByTagName("READMDON").item(0).getTextContent().toString().trim() + "','" +eElement.getElementsByTagName("READMDNM").item(0).getTextContent().toString().trim() + "','" +eElement.getElementsByTagName("READKVAH").item(0).getTextContent().toString().trim() + "'," +
	                                    "'" +eElement.getElementsByTagName("READPF").item(0).getTextContent().toString().trim() + "','" + i + "')";   
				         }
					
					  Statement stmt = sqlliteconn.createStatement();
						stmt.executeUpdate(sql7);
				}  
				
				
				
				NodeList nodeList9 = doc.getElementsByTagName("REBATE");
				for (int i = 0; i < nodeList9.getLength(); i++) {
					Node node = nodeList9.item(i);
					  
					  
					  
					  if (node.getNodeType() == Node.ELEMENT_NODE)
				         {
				            Element eElement = (Element) node;
				           
				            
				            
				            sql8="INSERT INTO REBATE VALUES('" + i+ "','" + i + "')";   
				         }
					
					  Statement stmt = sqlliteconn.createStatement();
						stmt.executeUpdate(sql8);
				}   
				
				
				
				NodeList nodeList10 = doc.getElementsByTagName("REBATELIST");
				for (int i = 0; i < nodeList10.getLength(); i++) {
					Node node = nodeList10.item(i);
					  
					  
					  
					  if (node.getNodeType() == Node.ELEMENT_NODE)
				         {
				            Element eElement = (Element) node;
				           
				            
				            
				            sql9="INSERT INTO REBATELIST VALUES('" +i + "','" + i + "')";   
				        
				         }
					  Statement stmt = sqlliteconn.createStatement();
						stmt.executeUpdate(sql9);
				         }
						
				
				
				
						NodeList nodeList12 = doc.getElementsByTagName("PENALTYLIST");
					
						for (int i = 0; i < nodeList12.getLength(); i++) {
							Node node = nodeList12.item(i);
						  
						  
						  
						  if (node.getNodeType() == Node.ELEMENT_NODE)
					         {
					            Element eElement = (Element) node;
					            
					            
					             query="INSERT INTO PENALTYLIST VALUES('" +i + "','" +i + "')";   
					         }
						
						  Statement stmt = sqlliteconn.createStatement();
							stmt.executeUpdate(query);
					}
						
						
				
				
				
					NodeList nodeList11 = doc.getElementsByTagName("STARTDT");
					for (int i = 0; i < nodeList11.getLength(); i++) {
						Node node = nodeList11.item(i);
						  
						  Node currentItem = nodeList11.item(i);
						    String key = currentItem.getAttributes().getNamedItem("name").getNodeValue();
						  
					            sql10="INSERT INTO STARTDT(NAME,REBATE_Id) VALUES('" +key  + "','" +i+ "')";   
						
						  Statement stmt = sqlliteconn.createStatement();
							stmt.executeUpdate(sql10);
					}
					
				
					
					
					
					
					
					
					
					NodeList nodeList4 = doc.getElementsByTagName("ENDDT");
					for (int i = 0; i < nodeList4.getLength(); i++) {
						Node node = nodeList4.item(i);
						 
						
						Node currentItem = nodeList4.item(i);
					    String key = currentItem.getAttributes().getNamedItem("name").getNodeValue();
						
					             query1="INSERT INTO ENDDT VALUES('" + key + "','" + i + "')";   
						
						  Statement stmt = sqlliteconn.createStatement();
							stmt.executeUpdate(query1);
					}
					
					
					
					
					
					
					NodeList nodeList5 = doc.getElementsByTagName("ELFLG");
					for (int i = 0; i < nodeList5.getLength(); i++) {
						Node node = nodeList5.item(i);
						  
						 						  
							Node currentItem = nodeList5.item(i);
						    String key = currentItem.getAttributes().getNamedItem("name").getNodeValue();
					            Element eElement = (Element) node;

					             query2="INSERT INTO ELFLG VALUES('" + key+ "','N', " +
		                                    "'" + i+ "')";   
						
						  Statement stmt = sqlliteconn.createStatement();
							stmt.executeUpdate(query2);
					}
				
					
				
				
					
					sql11 = "insert into MAST_CUST(MONTH,READDATE,RRNO,NAME,ADD1,TARIFF,MF,PREVSTAT,AVGCON,LINEMIN,"
			                 +"  SANCHP,SANCKW,PRVRED,FR,IR,DLCOUNT,ARREARS,PF_FLAG,BILLFOR,MRCODE,"
			                 +"  LEGFOL,ODDEVEN,SSNO,CONSNO,REBATE_FLAG,RREBATE,EXTRA1,DATA1,EXTRA2,DATA2,"
			                 +"   PH_NO,DEPOSIT,MTRDIGIT,PFVAL,BMDVAL,ASDAMT,IODAMT,BILL_NO,INTEREST_AMT,CAP_FLAG,"
			                 +"   TOD_FLAG,TOD_PREVIOUS1,TOD_PREVIOUS3,INT_ON_DEP,SO_FEEDER_TC_POLE,TARIFF_NAME,PREV_READ_DATE,BILL_DAYS,MTR_SERIAL_NO,CHQ_DISSHONOUR_FLAG,"
			                 +"   CHQ_DISHONOUR_DATE,FDRNAME,TCCODE,MTR_FLAG,NEW_TARIFF_EFFECT_DATE,INVENTORY_LOAD,HP,CONNLDHP,CONNLDKW,CREADJ,READKVAH) "	

			                 +"   SELECT SUBSTR(PRVMRREADS.READDT,3,2) READDT,(substr('00'||PRVMRREADS.READDT, -8, 2) || '-' || substr('00'||PRVMRREADS.READDT, -6, 2) || '-' || substr('0000'||PRVMRREADS.READDT, -4, 4)) DATE,ACCTINFO.ORRNO,ACCTINFO.NAME,ACCTINFO.ADDR,TARIFF_CODE.TARIFF,PRVMRREADS.MTRCON,PRVMRREADS.READSTS,AVERAGECONS.AVGKWH,000,"
			                 +"   ACCTINFO.SLHP,ACCTINFO.SLKW,PRVMRREADS.READKWH,000,000,ACCTINFO.DLBILL,(CASE WHEN CUSTINFO.ARREARS>=0 THEN CUSTINFO.ARREARS ELSE 0.0 END) AS ARREARS,(CASE WHEN ACCTINFO.TVMTRFLG = 'Y' THEN '2' ELSE '0' END) as 'TVMTRFLG' ,1,ACCTINFO.MRCODE,"
			                 +"   ACCTINFO.NRRNO,000,BILLSEQ.RTSEQ,ACCTINFO.ACCT,(CASE WHEN ACCTINFO.DBTFLG = 'Y' THEN '4' when ACCTINFO.TAXEXEMPT='Y' then '3' ELSE '0' END) DBT_TAX,000,CUSTINFO.BILLMSG,CUSTINFO.OTHER,000,000,"
			                 +"   ACCTINFO.TODFLG,(CASE WHEN CUSTINFO.ARREARS < 0 THEN (replace(CUSTINFO.ARREARS,'-','')) ELSE (0.0) END) AS DEPOSIT,LENGTH(PRVMRREADS.FULLSCALE) FULLSCALE,AVERAGECONS.AVGPF,000,000,000,000,CUSTINFO.INTEREST,000,"
			                 +"   (CASE WHEN ACCTINFO.TODFLG = 'Y' THEN '1' ELSE '0' END) as 'TODFLG',000,000,000,000,TARIFF_CODE.TARIFFNAME,substr('00'||PRVMRREADS.READDT, -8, 2) || '-' || substr((substr('00'||PRVMRREADS.READDT, -6, 2)-1),1,2) || '-' || substr('0000'||PRVMRREADS.READDT, -4, 4) PRVREADDT,000,PRVMRREADS.MTR,000,"
			                +"    000,000,000,'M','25-04-2017',(case when ((RATELDHP+RATELDKW)-(SLKW+SLHP))>0 then ((RATELDHP+RATELDKW)-(SLKW+SLHP)) else 0 end) INVENTORY_LOAD,ACCTINFO.SLHP,ACCTINFO.CONNLDHP,ACCTINFO.CONNLDKW,CUSTINFO.CREADJ,PRVMRREADS.READKVAH"

			                +"    FROM ACCTINFO,AVERAGECONS,BILLSEQ,CUSTINFO,MTRXCHANGE1,PENALTYLIST,PRVMRREADS,REBATELIST,REBATE,STARTDT,ELFLG,ENDDT,TARIFF_CODE WHERE ACCTINFO.CUSTINFO_id = AVERAGECONS.CUSTINFO_id AND ACCTINFO.CUSTINFO_id = BILLSEQ.CUSTINFO_id AND ACCTINFO.CUSTINFO_id = CUSTINFO.CUSTINFO_id AND ACCTINFO.CUSTINFO_id = MTRXCHANGE1.CUSTINFO_id AND ACCTINFO.CUSTINFO_id = PENALTYLIST.CUSTINFO_id AND ACCTINFO.CUSTINFO_id = PRVMRREADS.CUSTINFO_id"
			                +"    AND ACCTINFO.CUSTINFO_id = REBATELIST.CUSTINFO_id AND PENALTYLIST.CUSTINFO_id = PENALTYLIST.PENALTYLIST_id AND REBATELIST.CUSTINFO_id = REBATE.REBATE_id AND REBATE.REBATELIST_id = STARTDT.REBATE_id AND STARTDT.REBATE_id = ELFLG.REBATE_id AND STARTDT.REBATE_id = ENDDT.REBATE_id"
			                +"    AND ACCTINFO.TARIF=TARIFF_CODE.TARIFFCODE";
					
					
					
				
					
				 Statement stmt = sqlliteconn.createStatement();
					stmt.executeUpdate(sql11);
				
					String update1="UPDATE MAST_CUST SET BMDKW=sanckw where tariff in(50,51,52,53,60) and sanckw>0";
					String update2 = "UPDATE MAST_CUST SET BMDKW=round((HP * 0.746),2) where tariff in(40,41,42,43,50,51,52,53,60)";
					String update3 = "UPDATE MAST_CUST SET BMDKW=sanckw where tariff not in(40,41,42,43,50,51,52,53,60)";
					
					String sql23[]={update1,update2,update3};
					
					for (String string : sql23) {
						stmt.executeUpdate(string);	
					}
					
					/*String q1="select BMDKW,_id from mast_cust";
					ResultSet rs = stmt.executeQuery(q1);
					if(rs!=null){
						String iNV = String.format("{0:0.00}", rs.getString(59).toString());
						
						
						System.out.println("col 59--->"+ rs.getString(59).toString());
						String q2 = "update mast_cust set BMDKW='" + iNV + "' where _id='" + rs.getString(59).toString() + "'";
						stmt.executeUpdate(q2);	
					}*/
					
					String a1 = "UPDATE MAST_CUST SET TARIFF_NAME=TARIFF_NAME || '-SR' WHERE REBATE_FLAG=1";
                    String a2 = "UPDATE MAST_CUST SET TARIFF_NAME=TARIFF_NAME || '-HR' WHERE REBATE_FLAG=2";
                    String a3 = "UPDATE MAST_CUST SET TARIFF_NAME=TARIFF_NAME || '-TE' WHERE REBATE_FLAG=3";
                    String a4 = "UPDATE MAST_CUST SET TARIFF_NAME=TARIFF_NAME || '-DBT' WHERE REBATE_FLAG=4";
                    String a5 = "UPDATE MAST_CUST SET TARIFF_NAME=TARIFF_NAME || '-PL' WHERE REBATE_FLAG=5";
                    String a6 = "UPDATE MAST_CUST SET TARIFF_NAME=TARIFF_NAME || '-FL' WHERE REBATE_FLAG=6";
                    String a7 ="UPDATE MAST_CUST SET TARIFF_NAME=TARIFF_NAME || '-CR' WHERE REBATE_FLAG=7";
                    String a8 = "UPDATE MAST_CUST SET TARIFF_NAME=TARIFF_NAME || '-IPR' WHERE REBATE_FLAG=8";
					
					String[] strings ={a1,a2,a3,a4,a5,a6,a7,a8};
					for (String string : strings) {
						stmt.executeUpdate(string);	
					}
					
					  String a9 = "UPDATE MAST_CUST SET DLCOUNT='0'";
					  stmt.executeUpdate(a9);			
				
        	/*catch (Exception e) {
					// TODO: handle exception
					 log.info(" sql11   mast_cust*********---->" + sql11);
					// Files.write(Paths.get("E:/myTExt.txt"), sql11.getBytes(), StandardOpenOption.APPEND);
					
				}*/
				
					sqlliteconn.commit();
				
					
				 
				 
				 sqlliteconn.close();
			} 
        	
        	catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 log.info(" sql1 ACCTINFO*********---->" + sql1);
				 log.info(" sql2 AVERAGECONS*********---->" + sql2);
				 log.info(" sql3 BILLSEQ*********---->" + sql3);
				 log.info(" sql4 CUSTINFO*********---->" + sql4);
				 log.info(" sql5 MTRXCHANGE1*********---->" + sql5);
				 log.info(" sql6 PENALTY*********---->" + sql6);
				 log.info(" sql7 PRVMRREADS*********---->" + sql7);
				 log.info(" sql8 REBATE*********---->" + sql8);
				 log.info(" sql9 REBATELIST*********---->" + sql9);
				 log.info(" query PENALTYLIST*********---->" + query);
				 log.info(" sql10 STARTDT*********---->" + sql10);
				 log.info(" query1 ENDDT*********---->" + query1); 
				 log.info(" query2 ELFLG*********---->" + query2);
				 
				 log.info(" sql11 mast_cust********---->" + sql11);
				
				 
				 
			}
        	
        	java.nio.file.Path temp =  Files.move
			        (Paths.get("D:/DBs/"+f1+""), 
			        Paths.get("D:/TRMRELATEDDOCS/janxmlfilesmoved/xmlfile/1-5data/csd1/04012018/"+f1));
			 if(temp != null)
		        {
		            System.out.println("File moved successfully");
		            k=1;
		        }
		        else
		        {
		            System.out.println("Failed to move the file");
		        }
        	
        	
		
        	
        }
		return k; 	
		
		
	}

	@Override
	public int sqlliteDBtoSqlServer() throws SQLException, ParseException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("inside controller");
		int k = 0;
		String DATE1 = null;
		String month1 = "";
		float GAIN_LOSS = 0;
		float GAIN = 0;
		float LOSS = 0;
		String sql1=null;
		String sql2=null;
		String sql3=null;
		String sql4=null;
		GAIN_LOSS = GAIN + LOSS;

		Connection sqlliteconn = null;

		File file = new File("D:/TRMRELATEDDOCS/DBs");
		File[] files = file.listFiles();
		for(File f: files){

		Class.forName("org.sqlite.JDBC");
		String url="jdbc:sqlite:D:/TRMRELATEDDOCS/DBs/"+f.getName()+"";
		sqlliteconn =DriverManager.getConnection(url);
		Connection conn=null;
		System.out.println("name---->"+f.getName());			
		Statement stmt1 = sqlliteconn.createStatement();
		String sql = "SELECT * FROM MAST_OUT";
		ResultSet rs1 = stmt1.executeQuery(sql);
		while (rs1.next()) {

		String V_ASD =rs1.getString(28) ;
		String V_ASD2 = "";
		V_ASD2 = (V_ASD.replace("ASD to be paid:Rs.", "").replace("(ignore if paid)", "")).trim();

		DATE1 = rs1.getString(2).substring(4,8)+"-"+rs1.getString(2).substring(2,4)+"-"+ rs1.getString(2).substring(0,2);

		LOSS=Float.parseFloat(rs1.getString(79));
		GAIN=Float.parseFloat(rs1.getString(78));

		GAIN_LOSS=LOSS+GAIN;

		// System.out.println("float value payable_loss---->"+LOSS);
		// System.out.println("float value payable_profit---->"+GAIN);

		//System.out.println("data cmg--->"+DATE1);
		conn = connectivity.dbConnect();
		// System.out.println("sqlserver connected");

		//DATE1="2017-12-01";
		String month=rs1.getString(2).substring(2,4);

		try
		{

		sql1 = "insert into MAST1 (BILLING_MONTH,DATE1,RRNO,PREVSTAT,AVGCON,PREVREAD,OLDFR,OLDIR,DLCOUNT, ARREARS,"
		+ "BILLDAYS,MRCODE,LEGFALIO,SSNO,CONSID,RBTAMT,REMARKS,DATA2,FAC,PF,"
		+ "BMD,PFPENALTY,BMDPENALTY,DT,DI,IMG,LON,LAT,NET_PAYABLE_AMOUNT,EC,"
		+ "FC,CON,CURSTAT,CURREAD,CONNSTAT,BILLUNBILLED,DR,GAIN_LOSS) "
		+ "VALUES('" + month + "','" + DATE1 + "','" + rs1.getString(3)+ "'," + rs1.getString(8)+ "," + rs1.getString(9)+ ","
		+ "" + rs1.getString(13)+ "," + rs1.getString(14)+ "," + rs1.getString(15)+ "," + rs1.getString(16)+ "," + rs1.getString(17)+ ","
		+ "" + rs1.getString(48)+ "," + rs1.getString(20)+ "," + rs1.getString(21)+ "," + rs1.getString(23)+ ",'" + rs1.getString(24)+ "',"
		+ "'" + rs1.getString(27)+ "','" + rs1.getString(28)+ "','" + rs1.getString(29)+ "','" + rs1.getString(31)+ "','" + rs1.getString(36)+ "',"
		+ ""  + rs1.getString(37)+ "," + rs1.getString(63)+ "," + rs1.getString(62)+ "," + rs1.getString(61)+ "," + rs1.getString(59)+ ","
		+ "" + rs1.getString(39)+ ",'" + rs1.getString(76)+ "','" + rs1.getString(73)+ "','" + rs1.getInt(71)+ "'," + rs1.getString(102)+ ","
		+ "" + rs1.getString(58)+ "," + rs1.getString(57)+ "," + rs1.getString(56)+ "," + rs1.getString(55)+ ","
		+ "'A',1," + rs1.getString(70)+ ","+GAIN_LOSS +") ";

//			System.out.println("LEGFALIO---->"+rs1.getString(21));
		//System.out.println("SSNO---->"+rs1.getString(23));

		// INSERT MAINDETAILS   HP
		sql2 = "insert into MAINDETAILS1 (RRNO,CONSID,TARIFFBILLING,TARIFFDCB,MF,KW,HP,SUBDIVCODE,SUBDIV_ID,CONSUMER_NAME,"
		+ "ADD1,LATITUDE,LONGITUDE,AVGCON,MTR_SLNO,RU_FLAG) VALUES('" + rs1.getString(3)+ "','" + rs1.getString(24)+ "'," + rs1.getString(6)+ "," + rs1.getString(8)+ "," + rs1.getString(7)+ ","
			+ "" + rs1.getString(12)+ "," + rs1.getString(11)+ "," + rs1.getString(20)+ "," + rs1.getString(20)+ ",'" + rs1.getString(4)+ "','" + rs1.getString(5)+ "','" + rs1.getInt(71)+ "','" + rs1.getInt(72)+ "'," + rs1.getString(9)+ ",'" + rs1.getString(49)+ "',1)";



		sql3 = "UPDATE MAST1 SET PREVSTAT =" + rs1.getString(8) + ", PREVREAD = " + rs1.getString(13) + ", ARREARS = " + rs1.getString(17) + ", AVGCON = " + rs1.getString(9) + "," +
		"RBTAMT = " + rs1.getString(27) + ", PFPENALTY =" + rs1.getString(63) + ", BMDPENALTY = " +rs1.getString(62)+ "," +
		"PF = " + rs1.getString(36)+ ", BMD =" + rs1.getString(37) + ", DI = " +rs1.getString(39) + ", CONNSTAT = 'A', BILLUNBILLED = 1," +
		"NET_PAYABLE_AMOUNT =" +rs1.getString(102) + ", CURREAD = " + rs1.getString(55) + ", CURSTAT = " + rs1.getString(56) + "," +
		"DT = " + rs1.getString(61) + ", FAC =" +rs1.getString(29)+ "," +
		"LON = '" + rs1.getString(73) + "', LAT ='" + rs1.getString(71) + "', CON =" + rs1.getString(57)+ "," +
		"IMG = '" +rs1.getString(76) + "', DR =" + rs1.getString(70) + ", GAIN_LOSS = " + GAIN_LOSS + "," +
		"FC = " + rs1.getString(58) + ", EC = " + rs1.getString(59) + ", SSNO = " + rs1.getString(23) + ", DLCOUNT = " + rs1.getString(16) + "," +
		"BILLDAYS = " + rs1.getString(48) + ", OLDFR = " + rs1.getString(14) + ", OLDIR = " +rs1.getString(15) + "," +
		"REMARKS = " + V_ASD2 + " , MRCODE = " +rs1.getString(20) + 
		" WHERE CONSID = '"+ rs1.getString(24).toString().toString()+"'" ;


		String READDAT = f.getName();
		String date = READDAT.substring(2, 4);
		System.out.println("READDAT-->"+READDAT);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM");
		LocalDate localDate = LocalDate.now();
		String Todt =dtf.format(localDate); 

		String ReadDt = Todt + "-" + date;


		sql4 = "insert into MAST_OUT (MONTH,READDATE,RRNO,NAME,ADD1,TARIFF,MF,PREVSTAT,AVGCON,LINEMIN,SAPCHP,SAPCKW,PRVRED,FR,IR,DLCOUNT,ARREARS,PF_FLAG,"
		+ "BILLFOR,MRCODE,LEGFOL,ODDEVEN,SSNO,CONSNO,PH_NO,REBATE_FLAG,RREBATE,EXTRA1,DATA1,EXTRA2,DATA2,DEPOSIT,MTRDIGIT,ASDAMT,IODAMT,PFVAL,BMDVAL,"
		+ "BILLNO,INTEREST_AMT,CAP_FLAG,TOD_FLAG,TOD_PREVIOUS1,TOD_PREVIOUS3,INT_ON_DEP,SO_FEEDER_TC_POLE,TARIFF_NAME,PREV_READ_DATE,"
		+ "BILL_DAYS,MTR_SERIAL_NO,CHQ_DISHONOUR_DATE,FDRNAME,TCCODE,MTR_FLAG,PRES_RDG,PRES_STS,UNITS,FIX,ENGCHG,REBATE_AMOUNT,TAX_AMOUNT,"
		+ "BMD_PENALTY,PF_PENALTY,PAYABLE,BILLDATE,BILLTIME,TOD_CURRENT1,TOD_CURRENT3,GOK_SUBSIDY,DEM_REVENUE,GPS_LAT,GPS_LONG,ONLINE_FLAG,"
		+ "BATTERY_CHARGE,SIGNAL_STRENGTH,IMGADD,PAYABLE_REAL,PAYABLE_PROFIT,PAYABLE_LOSS,BILL_PRINTED,FSLAB1,FSLAB2,FSLAB3,FSLAB4,FSLAB5,"
		+ "ESLAB1,ESLAB2,ESLAB3,ESLAB4,ESLAB5,CHARITABLE_RBT_AMT,SOLAR_RBT_AMT,FL_RBT_AMT,HANDICAP_RBT_AMT,PL_RBT_AMT,IPSET_RBT_AMT,"
		+ "REBATEFROMCCB_AMT,TOD_CHARGES,PF_PENALITY_AMT,EXLOAD_MDPENALITY,CURR_BILL_AMOUNT,ROUNDING_AMOUNT,DUE_DATE,DISCONN_DATE,CREADJ,"
		+ "ID,PREADKVAH)"
		+ "VALUES('" + rs1.getString(1).toString() + "','" + ReadDt + "','" + rs1.getString(3) + "','" + rs1.getString(4) + "','" + rs1.getString(5) + "','" + rs1.getString(6) + "',"
		+ "'" + rs1.getString(7) + "','" + rs1.getString(8) + "','" +rs1.getString(9) + "','" + rs1.getString(10) + "','" +  rs1.getString(11) + "',"
		+ "'" +  rs1.getString(12) + "','" +  rs1.getString(13) + "','" +  rs1.getString(14) + "','" + rs1.getString(15) + "','" +  rs1.getString(16)+ "',"
		+ "'" +  rs1.getString(17) + "','" +  rs1.getString(18) + "','" + rs1.getString(19) + "','" +  rs1.getString(20) + "','" +  rs1.getString(21) + "',"
		+ "'" +  rs1.getString(22) + "','" +  rs1.getString(23) + "','" +  rs1.getString(24) + "','" +  rs1.getString(25) + "','" + rs1.getString(26) + "',"
		+ "'" + rs1.getString(27) + "','" +  rs1.getString(28) + "','" + rs1.getString(29) + "','" +  rs1.getString(30)+ "','" +  rs1.getString(31) + "','" +  rs1.getString(32) + "',"
		+ "'" +  rs1.getString(33) + "','" +  rs1.getString(34) + "','" +  rs1.getString(35) + "','" + rs1.getString(36) + "','" +  rs1.getString(37) + "','" +  rs1.getString(38) + "',"
		+ "'" +  rs1.getString(39) + "','" +  rs1.getString(40) + "','" + rs1.getString(41) + "','" +  rs1.getString(42) + "','" +  rs1.getString(43)+ "',"
		+ "'" + rs1.getString(44) + "','" +  rs1.getString(45) + "','" +  rs1.getString(46) + "','" +  rs1.getString(47) + "','" +  rs1.getString(48) + "',"
		+ "'" +  rs1.getString(49) + "','" + rs1.getString(51) + "','" + rs1.getString(52) + "','" +  rs1.getString(53) + "','" + rs1.getString(54) + "',"
		+ "'" +  rs1.getString(55) + "','" +  rs1.getString(56) + "','" +  rs1.getString(57) + "','" +  rs1.getString(58) + "','" +  rs1.getString(59) + "',"
		+ "'" +  rs1.getString(60) + "','" +  rs1.getString(61) + "','" +  rs1.getString(62) + "','" +  rs1.getString(63) + "','" +  rs1.getString(64) + "',"
		+ "'" +  rs1.getString(65) + "','" +  rs1.getString(66) + "','" +  rs1.getString(67) + "','" +  rs1.getString(68) + "','" +  rs1.getString(69) + "',"
		+ "'" +  rs1.getString(70) + "',  '" +  rs1.getString(71) + "',"
		+ "'" + rs1.getString(72) + "','" + rs1.getString(73) + "',"
		+ "'" + rs1.getString(74) + "','" + rs1.getString(75) + "','" + rs1.getString(76) + "','" +rs1.getString(77) + "','" + rs1.getString(78) + "',"
		+ "	'" + rs1.getString(79) + "','" +rs1.getString(80) + "','" + rs1.getString(81) + "','" + rs1.getString(82) + "','" + rs1.getString(83) + "','" + rs1.getString(84) + "',"
		+ "'" + rs1.getString(85) + "','" + rs1.getString(86) + "','" + rs1.getString(87) + "','" + rs1.getString(88)+ "','" + rs1.getString(89) + "','" + rs1.getString(90) + "',"
		+ "'" + rs1.getString(92) + "','" + rs1.getString(93) + "','" + rs1.getString(94) + "','" + rs1.getString(95) + "','" + rs1.getString(96) + "','" + rs1.getString(97) + "','" +rs1.getString(98) + "',"
		+ "'" + rs1.getString(99) + "','" + rs1.getString(100) + "','" + rs1.getString(101) + "','" + rs1.getString(102) + "','" + rs1.getString(103) + "','" + rs1.getString(104)+ "',"
		+ "	'" + rs1.getString(105) + "','" + rs1.getString(106) + "','" + rs1.getString(107) + "','" + rs1.getString(108) + "')";

		String[] queries = {sql1,sql2,sql3,sql4};
		Statement stmt = conn.createStatement(); 
		for (String string : queries) {
		stmt.executeQuery(string);
		}
		stmt.close();
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info(" Logging values sql1" + sql1);
		log.info(" Logging values MAINDETAILS1" + sql2);
		log.info(" Logging values PREVSTAT" + sql3);
		log.info(" Logging values PREVSTAT" + sql4);
		}





		}
		rs1.close();
		Statement stmt=null;
		String sql12 = "SELECT * FROM MAST_CUST";
		String sqlin=null;
		Statement stmt12 = sqlliteconn.createStatement();
		ResultSet rs2 = stmt12.executeQuery(sql12);

		while (rs2.next()) {

		conn= connectivity.dbConnect();
		String month=rs2.getString(2).substring(3,5);

		String date = rs2.getString(2).substring(6,10)+"-"+rs2.getString(2).substring(3,5)+"-"+ rs2.getString(2).substring(0,2);
		System.out.println("month----->"+month);
		System.out.println("date--->"+date);

		sqlin = "insert into MAST_IN (MONTH,READDATE,RRNO,NAME,ADD1,TARIFF,MF,PREVSTAT,AVGCON,LINEMIN,SANCHP,"
			+ "SANCKW,PRVRED,FR,IR,DLCOUNT,ARREARS,PF_FLAG,BILLFOR,MRCODE,LEGFOL,ODDEVEN,SSNO,CONSNO,REBATE_FLAG,"
			+ "RREBATE,EXTRA1,DATA1,EXTRA2,DATA2,PH_NO,DEPOSIT,MTRDIGIT,PFVAL,BMDVAL,ASDAMT,IODAMT,BILL_NO,INTEREST_AMT,"
			+ "CAP_FLAG,TOD_FLAG,TOD_PREVIOUS1,TOD_PREVIOUS3,INT_ON_DEP,SO_FEEDER_TC_POLE,TARIFF_NAME,PREV_READ_DATE,BILL_DAYS,"
			+ "MTR_SERIAL_NO,CHQ_DISSHONOUR_FLAG,CHQ_DISHONOUR_DATE,FDRNAME,TCCODE,MTR_FLAG,NEW_TARIFF_EFFECT_DATE,INVENTORY_LOAD,HP,BMDKW,"
			+ "CONNLDHP,CONNLDKW,CREADJ,READKVAH)"
			+ "VALUES('" + month + "','" + date + "','" + rs2.getString(3) + "','" + rs2.getString(4) + "', " 
		+"'" + rs2.getString(5) + "','" + rs2.getString(6) + "','" + rs2.getString(7) + "','" + rs2.getString(8) + "', " 
		+"'" + rs2.getString(9) + "','" + rs2.getString(10) + "','" + rs2.getString(11) + "','" + rs2.getString(12) + "', " +
		"'" + rs2.getString(13) + "','" +rs2.getString(14) + "','" + rs2.getString(15) + "','" + rs2.getString(16) + "', " +
		"'" + rs2.getString(17)+ "','" + rs2.getString(18) + "','" + rs2.getString(19) + "','" + rs2.getString(20) + "', " +
		"'" + rs2.getString(21) + "','" + rs2.getString(22) + "','" + rs2.getString(23) + "','" + rs2.getString(24) + "'," +
		"'" + rs2.getString(25) + "','" + rs2.getString(26) + "','" + rs2.getString(27) + "','" + rs2.getString(28) + "'," +
		"'" + rs2.getString(29)+ "', '" + rs2.getString(30) + "', '" + rs2.getString(31) + "', '" +rs2.getString(32) + "', '" +rs2.getString(33) + "'," +
		"'" + rs2.getString(34) + "', '" + rs2.getString(35) + "', '" + rs2.getString(36) + "', '" +rs2.getString(37)+ "', '" + rs2.getString(38) + "'," +
		"'" + rs2.getString(39) + "', '" + rs2.getString(40) + "', '" + rs2.getString(41) + "', '" + rs2.getString(42) + "', '" + rs2.getString(43) + "'," +
		"'" + rs2.getString(44) + "', '" + rs2.getString(45) + "', '" + rs2.getString(46)+ "', '" + rs2.getString(47) + "', '" + rs2.getString(48) + "'," +
		"'" + rs2.getString(49) + "', '" + rs2.getString(50) + "', '" +rs2.getString(51) + "', '" + rs2.getString(52) + "', '" + rs2.getString(53)+ "'," +
		"'" + rs2.getString(54) + "', '" + rs2.getString(55) + "', '" + rs2.getString(57) + "', '" + rs2.getString(58) + "', '" + rs2.getString(59)+ "'," +
		"'" + rs2.getString(60) + "','" + rs2.getString(61) + "', '" + rs2.getString(62) + "', '" + rs2.getString(63) + "')";

		stmt = conn.createStatement(); 
		stmt.executeUpdate(sqlin);	
		System.out.println("query is executed");	
		}
		
		conn.close();
		sqlliteconn.close();


		java.nio.file.Path temp =  Files.move
		(Paths.get("D:/TRMRELATEDDOCS/DBs/"+f.getName()+""), 
		Paths.get("D:/TRMRELATEDDOCS/movedFilestoSqlServer/Feb_data/CSD1/01022018/"+f.getName()+""));
		if(temp != null)
		{
		System.out.println("File moved successfully");
		k=1;
		}
		else
		{
		System.out.println("Failed to move the file");
		}



		}
		return k;	
	
		
		
		
	}

	@Override
	public void mastInInsert() throws SQLException, ParseException, IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		
		Connection sqlliteconn = null;
		String sql1=null;
		File file = new File("D:/TRMRELATEDDOCS/DBs");
		Class.forName("org.sqlite.JDBC");


		Connection conn=null;

		String sqlin=null;
		File[] files = file.listFiles();
		for(File f: files){


		String url="jdbc:sqlite:D:/TRMRELATEDDOCS/DBs/"+f.getName()+"";

		sqlliteconn =DriverManager.getConnection(url);
		System.out.println("name---->"+f.getName());	
		/*	Statement stmt1 = sqlliteconn.createStatement();
		String sql = "SELECT * FROM MAST_OUT";
		ResultSet rs1 = stmt1.executeQuery(sql);
		while (rs1.next()) {

		try
		{
		String READDAT = f.getName();
		String date = READDAT.substring(2, 4);
		System.out.println("READDAT-->"+READDAT);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM");
		LocalDate localDate = LocalDate.now();
		String Todt =dtf.format(localDate); 

		String ReadDt = Todt + "-" + date;
		System.out.println("Todt-->"+Todt);
		System.out.println("date-->"+date);

		conn = connectivity.dbConnect();

		System.out.println("month-->"+rs1.getString(1));
		// String month=rs1.getString(2).substring(2,4);
		sql1 = "insert into MAST_OUT (MONTH,READDATE,RRNO,NAME,ADD1,TARIFF,MF,PREVSTAT,AVGCON,LINEMIN,SAPCHP,SAPCKW,PRVRED,FR,IR,DLCOUNT,ARREARS,PF_FLAG,"
		+ "BILLFOR,MRCODE,LEGFOL,ODDEVEN,SSNO,CONSNO,PH_NO,REBATE_FLAG,RREBATE,EXTRA1,DATA1,EXTRA2,DATA2,DEPOSIT,MTRDIGIT,ASDAMT,IODAMT,PFVAL,BMDVAL,"
		+ "BILLNO,INTEREST_AMT,CAP_FLAG,TOD_FLAG,TOD_PREVIOUS1,TOD_PREVIOUS3,INT_ON_DEP,SO_FEEDER_TC_POLE,TARIFF_NAME,PREV_READ_DATE,"
		+ "BILL_DAYS,MTR_SERIAL_NO,CHQ_DISHONOUR_DATE,FDRNAME,TCCODE,MTR_FLAG,PRES_RDG,PRES_STS,UNITS,FIX,ENGCHG,REBATE_AMOUNT,TAX_AMOUNT,"
		+ "BMD_PENALTY,PF_PENALTY,PAYABLE,BILLDATE,BILLTIME,TOD_CURRENT1,TOD_CURRENT3,GOK_SUBSIDY,DEM_REVENUE,GPS_LAT,GPS_LONG,ONLINE_FLAG,"
		+ "BATTERY_CHARGE,SIGNAL_STRENGTH,IMGADD,PAYABLE_REAL,PAYABLE_PROFIT,PAYABLE_LOSS,BILL_PRINTED,FSLAB1,FSLAB2,FSLAB3,FSLAB4,FSLAB5,"
		+ "ESLAB1,ESLAB2,ESLAB3,ESLAB4,ESLAB5,CHARITABLE_RBT_AMT,SOLAR_RBT_AMT,FL_RBT_AMT,HANDICAP_RBT_AMT,PL_RBT_AMT,IPSET_RBT_AMT,"
		+ "REBATEFROMCCB_AMT,TOD_CHARGES,PF_PENALITY_AMT,EXLOAD_MDPENALITY,CURR_BILL_AMOUNT,ROUNDING_AMOUNT,DUE_DATE,DISCONN_DATE,CREADJ,"
		+ "ID,PREADKVAH)"
		+ "VALUES('" + rs1.getString(1).toString() + "','" + ReadDt + "','" + rs1.getString(3) + "','" + rs1.getString(4) + "','" + rs1.getString(5) + "','" + rs1.getString(6) + "',"
		+ "'" + rs1.getString(7) + "','" + rs1.getString(8) + "','" +rs1.getString(9) + "','" + rs1.getString(10) + "','" +  rs1.getString(11) + "',"
		+ "'" +  rs1.getString(12) + "','" +  rs1.getString(13) + "','" +  rs1.getString(14) + "','" + rs1.getString(15) + "','" +  rs1.getString(16)+ "',"
		+ "'" +  rs1.getString(17) + "','" +  rs1.getString(18) + "','" + rs1.getString(19) + "','" +  rs1.getString(20) + "','" +  rs1.getString(21) + "',"
		+ "'" +  rs1.getString(22) + "','" +  rs1.getString(23) + "','" +  rs1.getString(24) + "','" +  rs1.getString(25) + "','" + rs1.getString(26) + "',"
		+ "'" + rs1.getString(27) + "','" +  rs1.getString(28) + "','" + rs1.getString(29) + "','" +  rs1.getString(30)+ "','" +  rs1.getString(31) + "','" +  rs1.getString(32) + "',"
		+ "'" +  rs1.getString(33) + "','" +  rs1.getString(34) + "','" +  rs1.getString(35) + "','" + rs1.getString(36) + "','" +  rs1.getString(37) + "','" +  rs1.getString(38) + "',"
		+ "'" +  rs1.getString(39) + "','" +  rs1.getString(40) + "','" + rs1.getString(41) + "','" +  rs1.getString(42) + "','" +  rs1.getString(43)+ "',"
		+ "'" + rs1.getString(44) + "','" +  rs1.getString(45) + "','" +  rs1.getString(46) + "','" +  rs1.getString(47) + "','" +  rs1.getString(48) + "',"
		+ "'" +  rs1.getString(49) + "','" + rs1.getString(51) + "','" + rs1.getString(52) + "','" +  rs1.getString(53) + "','" + rs1.getString(54) + "',"
		+ "'" +  rs1.getString(55) + "','" +  rs1.getString(56) + "','" +  rs1.getString(57) + "','" +  rs1.getString(58) + "','" +  rs1.getString(59) + "',"
		+ "'" +  rs1.getString(60) + "','" +  rs1.getString(61) + "','" +  rs1.getString(62) + "','" +  rs1.getString(63) + "','" +  rs1.getString(64) + "',"
		+ "'" +  rs1.getString(65) + "','" +  rs1.getString(66) + "','" +  rs1.getString(67) + "','" +  rs1.getString(68) + "','" +  rs1.getString(69) + "',"
		+ "'" +  rs1.getString(70) + "',  '" +  rs1.getString(71) + "',"
		+ "'" + rs1.getString(72) + "','" + rs1.getString(73) + "',"
		+ "'" + rs1.getString(74) + "','" + rs1.getString(75) + "','" + rs1.getString(76) + "','" +rs1.getString(77) + "','" + rs1.getString(78) + "',"
		+ "	'" + rs1.getString(79) + "','" +rs1.getString(80) + "','" + rs1.getString(81) + "','" + rs1.getString(82) + "','" + rs1.getString(83) + "','" + rs1.getString(84) + "',"
		+ "'" + rs1.getString(85) + "','" + rs1.getString(86) + "','" + rs1.getString(87) + "','" + rs1.getString(88)+ "','" + rs1.getString(89) + "','" + rs1.getString(90) + "',"
		+ "'" + rs1.getString(92) + "','" + rs1.getString(93) + "','" + rs1.getString(94) + "','" + rs1.getString(95) + "','" + rs1.getString(96) + "','" + rs1.getString(97) + "','" +rs1.getString(98) + "',"
		+ "'" + rs1.getString(99) + "','" + rs1.getString(100) + "','" + rs1.getString(101) + "','" + rs1.getString(102) + "','" + rs1.getString(103) + "','" + rs1.getString(104)+ "',"
		+ "	'" + rs1.getString(105) + "','" + rs1.getString(106) + "','" + rs1.getString(107) + "','" + rs1.getString(108) + "')";

		Statement stmt = conn.createStatement(); 
		stmt.executeQuery(sql1);
		stmt.close();	

		conn.close();
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info(" Logging values MAST_out" + sql1);

		}


		}
		*/









		try{

		Statement stmt=null;
		String sql12 = "SELECT * FROM MAST_CUST";

		Statement stmt12 = sqlliteconn.createStatement();
		ResultSet rs2 = stmt12.executeQuery(sql12);

		while (rs2.next()) {

		conn= connectivity.dbConnect();
		String month=rs2.getString(2).substring(3,5);

		String date = rs2.getString(2).substring(6,10)+"-"+rs2.getString(2).substring(3,5)+"-"+ rs2.getString(2).substring(0,2);
		System.out.println("month----->"+month);
		System.out.println("date--->"+date);

		sqlin = "insert into MAST_INMahesh (MONTH,READDATE,RRNO,NAME,ADD1,TARIFF,MF,PREVSTAT,AVGCON,LINEMIN,SANCHP,"
		+ "SANCKW,PRVRED,FR,IR,DLCOUNT,ARREARS,PF_FLAG,BILLFOR,MRCODE,LEGFOL,ODDEVEN,SSNO,CONSNO,REBATE_FLAG,"
		+ "RREBATE,EXTRA1,DATA1,EXTRA2,DATA2,PH_NO,DEPOSIT,MTRDIGIT,PFVAL,BMDVAL,ASDAMT,IODAMT,BILL_NO,INTEREST_AMT,"
		+ "CAP_FLAG,TOD_FLAG,TOD_PREVIOUS1,TOD_PREVIOUS3,INT_ON_DEP,SO_FEEDER_TC_POLE,TARIFF_NAME,PREV_READ_DATE,BILL_DAYS,"
		+ "MTR_SERIAL_NO,CHQ_DISSHONOUR_FLAG,CHQ_DISHONOUR_DATE,FDRNAME,TCCODE,MTR_FLAG,NEW_TARIFF_EFFECT_DATE,INVENTORY_LOAD,HP,BMDKW"
		+ "CONNLDHP,CONNLDKW,CREADJ,READKVAH)"
		+ "VALUES('" + month + "','" + date + "','" + rs2.getString(3) + "','" + rs2.getString(4) + "', " 
		+"'" + rs2.getString(5) + "','" + rs2.getString(6) + "','" + rs2.getString(7) + "','" + rs2.getString(8) + "', " 
		+"'" + rs2.getString(9) + "','" + rs2.getString(10) + "','" + rs2.getString(11) + "','" + rs2.getString(12) + "', " +
		"'" + rs2.getString(13) + "','" +rs2.getString(14) + "','" + rs2.getString(15) + "','" + rs2.getString(16) + "', " +
		"'" + rs2.getString(17)+ "','" + rs2.getString(18) + "','" + rs2.getString(19) + "','" + rs2.getString(20) + "', " +
		"'" + rs2.getString(21) + "','" + rs2.getString(22) + "','" + rs2.getString(23) + "','" + rs2.getString(24) + "'," +
		"'" + rs2.getString(25) + "','" + rs2.getString(26) + "','" + rs2.getString(27) + "','" + rs2.getString(28) + "'," +
		"'" + rs2.getString(29)+ "', '" + rs2.getString(30) + "', '" + rs2.getString(31) + "', '" +rs2.getString(32) + "', '" +rs2.getString(33) + "'," +
		"'" + rs2.getString(34) + "', '" + rs2.getString(35) + "', '" + rs2.getString(36) + "', '" +rs2.getString(37)+ "', '" + rs2.getString(38) + "'," +
		"'" + rs2.getString(39) + "', '" + rs2.getString(40) + "', '" + rs2.getString(41) + "', '" + rs2.getString(42) + "', '" + rs2.getString(43) + "'," +
		"'" + rs2.getString(44) + "', '" + rs2.getString(45) + "', '" + rs2.getString(46)+ "', '" + rs2.getString(47) + "', '" + rs2.getString(48) + "'," +
		"'" + rs2.getString(49) + "', '" + rs2.getString(50) + "', '" +rs2.getString(51) + "', '" + rs2.getString(52) + "', '" + rs2.getString(53)+ "'," +
		"'" + rs2.getString(54) + "', '" + rs2.getString(55) + "', '" + rs2.getString(57) + "', '" + rs2.getString(58) + "', '" + rs2.getString(59)+ "'," +
		"'" + rs2.getString(60) + "','" + rs2.getString(61) + "', '" + rs2.getString(62) + "', '" + rs2.getString(63) + "')";

		stmt = conn.createStatement(); 
		stmt.executeUpdate(sqlin);	
		System.out.println("query is executed");	
		}

		conn.close();
		sqlliteconn.close();



		}

		catch (Exception e) {
		// TODO: handle exception
		log.info(" Logging values sql1" + sqlin);
		}


		/*java.nio.file.Path temp =  Files.move
		(Paths.get("C:/DBs/"+f.getName()+""), 
		Paths.get("E:/TRMRELATEDDOCS/movedFilestoSqlServer/january _data/1-5data/csd2/01/"+f.getName()+""));
		if(temp != null)
		{
		System.out.println("File moved successfully");
		}
		else
		{
		System.out.println("Failed to move the file");
		}*/


		}


		}
		
		
	}


