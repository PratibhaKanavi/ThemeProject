package com.ps.test.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ps.test.controller.databaseconnection.DbConnectivity;
import com.ps.test.dto.RegisterDTO;
import com.ps.test.service.login.RegisterService;


@Controller
public class ThemeContoller {
	
	@Autowired
	private RegisterService service;
	
	@Autowired
	HttpSession session= null;
	
	@Autowired
	DbConnectivity connectivity;
	
/*	@Autowired
	JasperPdfGeneration pdf;*/
	
	
	
////////////////////Dashboard code////////////////////////////////
@RequestMapping(value="/test")
public ModelAndView dash(){
	Connection conn=null;
System.out.println("inside dash");

 //Connection conn = connectivity.dbConnect();

Statement stmt=null;
ResultSet rs=null;
Map<String, Object> map  = new HashMap<String,Object>();
double s1=0,s2=0,s3=0,s4=0,s5=0,s6=0,s7=0,s8=0,s9=0,s10=0,s11=0,s12=0,s13=0,s14=0,s15=0;
try {

	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	conn=DriverManager.getConnection("jdbc:microsoft:sqlserver://DESKTOP-5MTQQ8H;databaseName=ORCL_DBO12","sa","tvd123");

String sql1 = "select sum(PAYABLE),READDATE from MAST_OUT where PAYABLE between 0 and 500 group by READDATE";
stmt = conn.createStatement();
rs=stmt.executeQuery(sql1);
while (rs.next()) {
System.out.println("cmg--->"+rs.getString(1));
if(rs.getString(2).equals("2018-02-01"))
{
	s1=rs.getDouble(1);
	System.out.println("s1--->"+s1);
}
if(rs.getString(2).equals("2018-02-02"))
{
	s2=rs.getDouble(1);
	System.out.println("s2---->"+s2);
}
if(rs.getString(2).equals("2018-02-03"))
{
	s3=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-04"))
{
	s4=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-05"))
{
	s5=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-06"))
{
	s6=rs.getDouble(1);
}

map.put("data1", s1);
map.put("data2", s2);
map.put("data3", s3);
map.put("data4", s4);
map.put("data5", s5);
map.put("data6", s6);

}
/*while (rs.next()) {
if(rs.getString(2).equals("2018-02-01"))
{
	s1=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-02"))
{
	s2=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-03"))
{
	s3=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-04"))
{
	s4=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-05"))
{
	s5=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-06"))
{
	s6=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-07"))
{
	s7=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-08"))
{
	s8=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-09"))
{
	s9=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-10"))
{
	s10=rs.getDouble(1);
}

if(rs.getString(2).equals("2018-02-11"))
{
	s11=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-12"))
{
	s12=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-13"))
{
	s13=rs.getDouble(1);
}
if(rs.getString(2).equals("2018-02-14"))
{
	s14=rs.getDouble(1);
	System.out.println("s14---->"+s14);
}
if(rs.getString(2).equals("2018-02-15"))
{
	s15=rs.getDouble(1);
}

map.put("data1", s1);
map.put("data2", s2);
map.put("data3", s3);
map.put("data4", s4);
map.put("data5", s5);
map.put("data6", s6);
map.put("data7", s7);
map.put("data8", s8);
map.put("data9", s9);
map.put("data10", s10);
map.put("data11", s11);
map.put("data12", s12);
map.put("data13", s13);
map.put("data14", s14);
map.put("data15", s15);

} */


} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

return new ModelAndView("home",map);

}
	
	
	
	
	
	/*@RequestMapping(value="/test")
	public ModelAndView homePage(){
		System.out.println("inside the controller");
		return new ModelAndView("home");
	}*/
	

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request){
		return new ModelAndView("login");
		
	}
	
	@RequestMapping("/register")
	public ModelAndView registerUser(){
		return new ModelAndView("register");
	}

	
	@RequestMapping(value="/saveregister")
	public String saveUser(@ModelAttribute RegisterDTO dto){
		System.out.println("inside save register");
		System.out.println("name-->"+dto.getFname());
		System.out.println("--->"+(dto.getPassword().equals(dto.getConfirmpwd())));
		if(!(dto.getPassword().equals(dto.getConfirmpwd())))
		{
			
			return "redirect:/register.html";
		}
		
		else{
			service.saveRegistration(dto);	
		}
		
		return "redirect:/login.html"; 
		 
		
	}
	
	@RequestMapping("/loginapp")
	public String logon(@RequestParam(value="email1") String email,@RequestParam(value="pwd") String password){
		System.out.println("inside loginapp");
		System.out.println("val of-->"+email);
		int i=0;
		try{
			
	 i = service.checklogin(email,password);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	if(i>0){
		return "redirect:/test.html";
	}
	else{
		return "login";
	}
}
	
	
	@RequestMapping("/forgotpassword")
	public ModelAndView forgotpass(){
		System.out.println("inside the forgot password");
		return new ModelAndView("forgotpassword");
	}
	
	
	@RequestMapping(value="/resetpwd", method=RequestMethod.POST)
	public String resetpwd(@RequestParam(name="email1") String email,@RequestParam(name="pwd") String pwd,@RequestParam(name="pwd2") String repwd){
		
		System.out.println("inside the reset");
		
		String emailcheck=service.checkEmail(email);
		
		System.out.println("val--->"+( !(pwd.equals(repwd)) ||  emailcheck != null ));
		
		if(!( !(pwd.equals(repwd)) ||  emailcheck != null ))
		{
			return "redirect:/forgotpassword.html";
		}
		else{
			
		service.updatedetails(email,pwd,repwd);
		}
		return  "redirect:/login.html";
		
	}
	
	/*@RequestMapping("/pdfgen")
	public void downloadpdf(HttpServletResponse resp) throws JRException, IOException,BeansException{
		
		List<RegisterDTO> list =service.getAllData();
		for (RegisterDTO registerDTO : list) {
			System.out.println("value-->"+registerDTO.getFname());
		}
		
		pdf.DownloadPdfReportSingle("jasperReport", list, resp, "jasperReport");
		
	}*/
	

	/* @RequestMapping(method = RequestMethod.GET , value = "pdfgen")
	    public ModelAndView generatePdfReport(ModelAndView modelAndView){
	 
	 
	        Map<String,Object> parameterMap = new HashMap<String,Object>();
	 
	        List<RegisterDTO> list =service.getAllData();
	 
	        JRDataSource JRdataSource = new JRBeanCollectionDataSource(list);
	 
	        parameterMap.put("datasource", JRdataSource);
	 
	        //pdfReport bean has ben declared in the jasper-views.xml file
	        modelAndView = new ModelAndView("home", parameterMap);
	 
	        return modelAndView;
	 
	    }//generatePdfReport
	 
	*/
	
	
	
	@RequestMapping("datatabledisplay")
	public ModelAndView datatable(){
		return new ModelAndView("datatabledisp");
		
	}
	
}
