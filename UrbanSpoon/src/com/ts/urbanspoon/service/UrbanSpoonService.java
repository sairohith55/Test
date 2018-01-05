package com.ts.urbanspoon.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.urbanspoon.dao.BranchDAO;
import com.ts.urbanspoon.dao.RecipeDAO;
import com.ts.urbanspoon.dao.RestaurantDAO;
import com.ts.urbanspoon.dao.UserDAO;
import com.ts.urbanspoon.dto.Branch;
import com.ts.urbanspoon.dto.Recipe;
import com.ts.urbanspoon.dto.Restaurant;
import com.ts.urbanspoon.dto.User;
import com.ts.urbanspoon.exception.UrbanspoonException;

public class UrbanSpoonService {

	public UrbanSpoonService() {
		
	}

	public static List<Restaurant> getRestaurants(final int TOP) {
		
		List<Restaurant> restaurantsList = new RestaurantDAO().getRestaurants(TOP);
		for (Restaurant restaurant : restaurantsList) {
			List<Branch> branchesList = new BranchDAO().getBranches(restaurant.getId());
			restaurant.setBranchesList(branchesList);
		}

		return restaurantsList;
	}
	
	public static  List<Recipe> getRecipes(final int TOP){
		
		return new RecipeDAO().getRecipes(TOP);
	}

   public static User insertUser(HttpServletRequest request, HttpServletResponse response) throws UrbanspoonException{
		
		String name = request.getParameter("firstName")+request.getParameter("lastName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String pswd = request.getParameter("password");
		
		long number = Long.parseLong(request.getParameter("mobileNumber"));
		
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setGender(gender);
		u.setPassword(pswd);
		u.setMobileNo(number);
		
		User u1= UserDAO.insertUser(u);
		return u1;
}

}
