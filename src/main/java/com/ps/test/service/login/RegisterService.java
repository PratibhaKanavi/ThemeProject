package com.ps.test.service.login;

import java.util.List;

import com.ps.test.dto.RegisterDTO;

public interface RegisterService {
	
	void saveRegistration(RegisterDTO dto);

	int checklogin(String email, String password);

	void updatedetails(String email, String pwd, String repwd);

	String checkEmail(String email);

	List<RegisterDTO> getAllData();

	
}
