package com.ts.urbanspoon.dto;

import java.util.List;

public class Cuisine {
	private int id;
	private String name;
	private String country;
	private List<Recipe> recipesList;
	
	
	public Cuisine() {
		 
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public List<Recipe> getRecipesList() {
		return recipesList;
	}


	public void setRecipesList(List<Recipe> recipesList) {
		this.recipesList = recipesList;
	}


	@Override
	public String toString() {
		return "Cuisine [id=" + id + ", name=" + name + ", country=" + country + ", recipesList=" + recipesList + "]";
	}

 
	
	
	
}
