package dao;

import java.sql.Connection;

import daoUtil.ConnectMySql;
import daoUtil.ExcuteQuery;

public class AccessDatabase {

	
	public  boolean search(String email,String password)
	{
		Connection conn=ConnectMySql.getConnection("Servlet_Example", "root", "mysql");
		if(ExcuteQuery.selectQuery("users", "email", conn, email))
		{
			if(ExcuteQuery.selectQuery("users", "password", conn, password))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
