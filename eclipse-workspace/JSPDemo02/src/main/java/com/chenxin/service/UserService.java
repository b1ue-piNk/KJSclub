package com.chenxin.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chenxin.dao.DB;

public class UserService {
//	public UserService(String name,String password) {
//		// TODO Auto-generated constructor stub
//		
//	}
	
	public ResultSet getRs (String name,String password) throws SQLException {
		DB db = new DB();
		Connection con = db.getCon();
		Statement stmt = con.createStatement();
		String sql = "select * from account where useName='" + name + "'" + " and usePassword='" + password + "'";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
	}
	
	public ResultSet registerService(String new_name,String new_password) throws SQLException {
		DB db = new DB();
		Connection con = db.getCon();
		Statement stmt = con.createStatement();
		String id_sql = "SELECT MAX(useId) FROM account;";
		ResultSet rs = stmt.executeQuery(id_sql);
		if(rs.next()) {
			String value = rs.getString("MAX(useId)");
			int i = Integer.parseInt(value);
			i++;
			String sql = "insert into account values(" + i + ",'" + new_name + "','" + new_password + "')";
			stmt.execute(sql);
		}
		db.closed();
		return rs;
	}
	
	public ResultSet if_repete (String new_name) throws SQLException {
		DB db = new DB();
		Connection con = db.getCon();
		Statement stmt = con.createStatement();
		String if_re = "SELECT * FROM account WHERE useName = '" + new_name + "';";
		ResultSet rs = stmt.executeQuery(if_re);
		return rs;
	}
}
