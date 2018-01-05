package com.ts.urbanspoon.dao;

import java.sql.*;
import com.ts.urbanspoon.dto.User;
import com.ts.urbanspoon.exception.UrbanspoonException;
import com.ts.urbanspoon.util.DAOUtility;
 
 

public class UserDAO {

	public static User insert(User user) throws UrbanspoonException {
		Connection connection = DAOUtility.getConncetion();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into user(name,gender,email,password,date_of_birth,mobile_number) values(?,?,?,?,?,?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getGender());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setDate(5,user.getDate());;
			preparedStatement.setLong(6, user.getMobileNo());
			if (preparedStatement.executeUpdate() > 0) {
				user.setId(DAOUtility.getLatestId("user"));
			}
		} catch (SQLException e) {
			throw new UrbanspoonException(e.toString());
		} finally {
			DAOUtility.close(preparedStatement, connection);
			
		}
		return user;
	}
}