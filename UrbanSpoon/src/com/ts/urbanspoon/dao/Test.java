package com.ts.urbanspoon.dao;

import java.sql.Date;

import com.ts.urbanspoon.dto.User;
import com.ts.urbanspoon.exception.UrbanspoonException;

public class Test {

	public static void main(String[] args) throws UrbanspoonException {
		
		Date d= Date.valueOf("1996-07-24");
		User u = new User();
		u.setName("sairam");
		u.setEmail("saaagar@");
		u.setGender("male");
		u.setPassword("sadad");
		u.setDate(d);
		u.setMobileNo((long) 7093.0);
		
		User u1 = UserDAO.insert(u);
		System.out.println(u1.getId());
	}

}
