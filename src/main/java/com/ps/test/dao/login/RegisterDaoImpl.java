package com.ps.test.dao.login;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.test.dto.RegisterDTO;

@Repository
public class RegisterDaoImpl implements RegisterDao{
	
	@Autowired
	private SessionFactory factory;

	@Override
	public void saveRegistration(RegisterDTO dto) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(dto);
		tx.commit();
		session.close();
	}

	@Override
	@Transactional
	public int checklogin(String email, String password) {
		// TODO Auto-generated method stub
		int i= (int) factory.getCurrentSession().createQuery("select slno from RegisterDTO where email='"+email+"' and password='"+password+"'").uniqueResult();
		return i;
	}

	@Override
	@Transactional
	public void updatedetails(String email, String pwd, String repwd) {
		// TODO Auto-generated method stub
		
		System.out.println("in dao");
		RegisterDTO register=null;
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		int id = (int) factory.getCurrentSession().createQuery("SELECT slno FROM RegisterDTO WHERE email='"+email+"'").uniqueResult();
		register = session.get(RegisterDTO.class, id);
		register.setPassword(pwd);
		register.setConfirmpwd(repwd);
		session.update(register);
		tx.commit();
		session.close();
		
	/*	Session session = factory.getCurrentSession();
		//String sql="UPDATE register_user SET PASSWORD='"+email+"',CONFIRMPWD='"+pwd+"' WHERE EMAIL='"+repwd+"'";
		session.createSQLQuery("UPDATE register_user SET PASSWORD='"+email+"',CONFIRMPWD='"+pwd+"' WHERE EMAIL='"+repwd+"'");
		session.close();*/
	}

	@Override
	@Transactional
	public String checkEmail(String email) {
		// TODO Auto-generated method stub
		return (String) factory.getCurrentSession().createQuery("SELECT email FROM RegisterDTO WHERE email='"+email+"'").uniqueResult();
	}

	@Override
	public List<RegisterDTO> getAllData() {
		// TODO Auto-generated method stub
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<RegisterDTO> l1 = session.createQuery("from RegisterDTO").list();
		tx.commit();
		session.close();
		return l1;
	}
 

}
