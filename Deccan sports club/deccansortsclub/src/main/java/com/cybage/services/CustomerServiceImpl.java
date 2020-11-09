package com.cybage.services;

import java.sql.SQLException;
import java.util.List;

import com.cybage.dao.CustomerDao;
import com.cybage.dao.CustomerDaoImpl;
import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public class CustomerServiceImpl implements CustomerServiceI{
	CustomerDao dao=new CustomerDaoImpl();
	public void adduser(String username,String password,String address,
			   String phone,String email) throws SQLException, Exception 
	{
	   dao.adduser(username, password, address, phone, email);
	}
	public Users authenticate(String username, String password) throws SQLException,Exception{
		return dao.authenticate(username, password);
}
	@Override
	public List<Sports> getSports() throws Exception {
		return dao.getsports();
	}
}
