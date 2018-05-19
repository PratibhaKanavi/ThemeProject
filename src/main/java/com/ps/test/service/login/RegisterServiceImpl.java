package com.ps.test.service.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.test.dao.login.RegisterDao;
import com.ps.test.dto.RegisterDTO;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private RegisterDao dao;

	@Override
	public void saveRegistration(RegisterDTO dto) {
		// TODO Auto-generated method stub
		dao.saveRegistration(dto);
	}

	@Override
	public int checklogin(String email, String password) {
		// TODO Auto-generated method stub
		return dao.checklogin(email,password);
	}

	@Override
	public void updatedetails(String email, String pwd, String repwd) {
		// TODO Auto-generated method stub
		dao.updatedetails(email,pwd,repwd);
	}

	@Override
	public String checkEmail(String email) {
		// TODO Auto-generated method stub
		return dao.checkEmail(email);
	}

	@Override
	public List<RegisterDTO> getAllData() {
		// TODO Auto-generated method stub
		
		return dao.getAllData();
	}

	
}
