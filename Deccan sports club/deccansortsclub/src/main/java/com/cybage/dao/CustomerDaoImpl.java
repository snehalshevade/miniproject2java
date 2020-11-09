package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybage.dbutil.DbUtil;
import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void adduser(String username, String password, String address, String phone, String email)throws SQLException,Exception
	{
		String sql="insert into users(userName,password,role,address,phone,email)values(?,?,?,?,?,?)";
		Connection con=DbUtil.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, "member");
		ps.setString(4, address);
		ps.setString(5, phone);
		ps.setString(6, email);
		if(ps.executeUpdate()==1){
			System.out.println("record added");
		}
		else
		{
			System.out.println("not adde");
		}
		
	}
	@Override
	public Users authenticate(String username, String password) throws SQLException, Exception {
		String sql = "select * from users where username = ? and password= ?";
		Connection con = DbUtil.getConnection(); // new object
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		   Users user=new Users(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), 
				   rs.getString(5), rs.getString(6), rs.getString(7));
			rs.close();
			ps.close();
			System.out.println("user found");
			System.out.println(user);
			return user;
			
		} else {
			rs.close();
			ps.close();
			con.close();
			System.out.println("user not found");
		}
	return null;
			
	}
	@Override
	public List<Sports> getsports() throws Exception {
		String sql = "select * from sports";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Sports> sportlist = new ArrayList<Sports>();
		while(rs.next()) {
			sportlist.add(new Sports(rs.getInt(1), rs.getString(2)));
		}
		return sportlist;
	}


}
