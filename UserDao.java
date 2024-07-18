package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.User;
import com.util.UserUtil;

public class UserDao {
	public static void signupUser(User u) {
		try {
			Connection conn=UserUtil.creatConnection();
					String sql="insert into job(fname,lname,birthdate,email,phon,gender,password) value(?,?,?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1,u.getFname());
					pst.setString(2,u.getLname());
					pst.setString(3,u.getBirthday());
					pst.setString(4,u.getEmail());
					pst.setLong(5,u.getPhon());
					pst.setString(6,u.getGander());
					pst.setString(7, u.getPassword());
					pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkEmail(String email)
	{
		boolean flag=false;
		try {
			Connection conn=UserUtil.creatConnection();
			String sql="select * from job where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static User loginUser(String email)
	{
		User u=null;
		try {
			Connection conn=UserUtil.creatConnection();
			String sql="select * from job where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setEmail(rs.getString("email"));
				u.setGander(rs.getString("gender"));
				u.setBirthday(rs.getString("birthdate"));
				u.setPassword(rs.getString("password"));
				u.setPhon(rs.getLong("phon"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	public static void changePassword(String email,String password)
	{
		try {
			Connection conn=UserUtil.creatConnection();
			String sql="update job set password? where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, email);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void upadateUser(User u) {
		try {
			Connection conn=UserUtil.creatConnection();
					String sql="update job set fname=?,lname=?,email=?,birthdate=?,email=?,phon=?,gender=? where uid=?";
					PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1,u.getFname());
					pst.setString(2,u.getLname());
					pst.setString(3,u.getBirthday());
					pst.setString(4,u.getEmail());
					pst.setLong(5,u.getPhon());
					pst.setString(6,u.getGander());
					pst.setInt(7, u.getUid());
					pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
