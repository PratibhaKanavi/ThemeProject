package com.ps.test.dao.login;

import java.util.List;

import com.ps.test.dto.RegisterDTO;

public interface RegisterDao {

	void saveRegistration(RegisterDTO dto);

	int checklogin(String email, String password);

	void updatedetails(String email, String pwd, String repwd);

	String checkEmail(String email);

	List<RegisterDTO> getAllData();


}
