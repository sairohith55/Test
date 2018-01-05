package com.ts.urbanspoon.dao;

import com.ts.urbanspoon.dto.User;
import com.ts.urbanspoon.exception.UrbanspoonException;
import com.ts.urbanspoon.service.UrbanSpoonService;

public class Test {

	public static void main(String[] args) throws UrbanspoonException {
		
		User u = new User();
		u.setName("sai");
		u.setEmail("saaa");
		u.setGender("male");
		u.setPassword("sadad");
		u.setMobileNo((long) 7095388597.0);
		
		User u1 = UserDAO.insertUser(u);
		
		System.out.println(u1.getId());
	}

}
