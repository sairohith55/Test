package com.ts.urbanspoon.dao;


import java.util.List;

import com.ts.urbanspoon.dto.Restaurant;
import com.ts.urbanspoon.exception.UrbanspoonException;

public class Test {

	public static void main(String[] args) throws UrbanspoonException {
		
		
		List<Restaurant> r = RestaurantDAO.getRestaurants(3);
		System.out.println(r);
	}

	
}
