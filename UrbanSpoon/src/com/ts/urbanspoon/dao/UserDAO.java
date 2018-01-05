package com.ts.urbanspoon.dao;

import java.sql.*;
import com.ts.urbanspoon.dto.User;
import com.ts.urbanspoon.exception.UrbanspoonException;
import com.ts.urbanspoon.util.DAOUtility;
 
 

public class UserDAO {

	public static User insertUser(User u) throws UrbanspoonException{
		Connection con = null;
		java.sql.PreparedStatement stmt = null;

		try {
			con = DAOUtility.getConncetion();
			String query = "insert into user values(?,?,?,?,?)";
			System.out.println("------>query is:" + query);
			stmt=con.prepareStatement(query);
			
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getGender());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.setLong(5, u.getMobileNo());
			if (stmt.executeUpdate() > 0) {
				u.setId(DAOUtility.getLatestId("user"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return u;

	}
}