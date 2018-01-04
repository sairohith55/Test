package com.ts.urbanspoon.service;

import java.util.List;

import com.ts.urbanspoon.dao.BranchDAO;
import com.ts.urbanspoon.dao.RecipeDAO;
import com.ts.urbanspoon.dao.RestaurantDAO;
import com.ts.urbanspoon.dto.Branch;
import com.ts.urbanspoon.dto.Recipe;
import com.ts.urbanspoon.dto.Restaurant;

public class UrbanSpoonService {

	public UrbanSpoonService() {
		// TODO Auto-generated constructor stub
	}

	public static List<Restaurant> getRestaurants(final int TOP) {
		// w.r.t query to get Top 10 Restaurants.

		List<Restaurant> restaurantsList = new RestaurantDAO().getRestaurants(TOP);
		for (Restaurant restaurant : restaurantsList) {
			List<Branch> branchesList = new BranchDAO().getBranches(restaurant.getId());
			restaurant.setBranchesList(branchesList);
		}

		return restaurantsList;
	}
	
	public static  List<Recipe> getRecipes(final int TOP){
		 //wrt query to get top 10 recipes.
		
		return new RecipeDAO().getRecipes(TOP);
	}


}
