package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public interface CustomerDao {
   public void adduser(String username,String password,String address,
		   String phone,String email) throws SQLException, Exception;
	public Users authenticate(String username,String password)throws SQLException,Exception;
	public List<Sports> getsports() throws SQLException, Exception;
}
