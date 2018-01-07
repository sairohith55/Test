package com.ts.urbanspoon.service;

import java.sql.Date;
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
		
		List<Restaurant> restaurantsList = RestaurantDAO.getRestaurants(TOP);
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
		
		String name = request.getParameter("firstName") +" "+ request.getParameter("lastName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		if(gender.equalsIgnoreCase("male")){
			gender="M";
		}else
			gender="F";
		
		String pswd = request.getParameter("password");
		Date date = Date.valueOf(request.getParameter("date"));
		long number = Long.parseLong(request.getParameter("mobileNumber"));
		
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setGender(gender);
		u.setPassword(pswd);
		u.setDate(date);
		u.setMobileNo(number);
		
		User u1= UserDAO.insert(u);
		return u1;

   }

   public static User getUser(HttpServletRequest request, HttpServletResponse response) throws UrbanspoonException {
	   
	   User u = UserDAO.getUser(Integer.parseInt(request.getParameter("user_id")));
	   if(u.getPassword().equals(request.getParameter("password"))){
	
		   return u;
	   }
	   else
		   return null;

   }
   
   public static Restaurant insertRestaurant(HttpServletRequest request, HttpServletResponse response) throws UrbanspoonException{
		
		String name = request.getParameter("Name");
		String pswd = request.getParameter("rest_password");
		String logo_name = request.getParameter("logo_name");
		String govt_reg_id = request.getParameter("govt_reg_id");
		
		Restaurant r = new Restaurant();
		r.setGovtRegistrationId(govt_reg_id);
		r.setName(name);
		r.setPassword(pswd);
		r.setLogoName(logo_name);
		
		Restaurant r1 = RestaurantDAO.insert(r);
		return r1;
  }
   
 public static Restaurant getRestaurant(HttpServletRequest request, HttpServletResponse response) throws UrbanspoonException {
	   
	   Restaurant r = RestaurantDAO.getRestaurant(Integer.parseInt(request.getParameter("user_id")));
	   if(r.getPassword().equals(request.getParameter("password")))
	   return r;
	   else
	   return null;

   }

}
