package com.ts.urbanspoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.urbanspoon.dto.Restaurant;
import com.ts.urbanspoon.dto.User;
import com.ts.urbanspoon.exception.UrbanspoonException;
import com.ts.urbanspoon.service.UrbanSpoonService;

@WebServlet("/UrbanSpoonController")
 public class UrbanSpoonController extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UrbanSpoonController() {
		
		System.out.println("***UrbanSpoonController object is created..");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Restaurant> rest=UrbanSpoonService.getRestaurants(3);
		request.setAttribute("restaurantsList",rest);
		System.out.println("rest:"+rest);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String s = request.getParameter("action");
		
		if(s.equalsIgnoreCase("user_registration")){
		
			try {
				User u = UrbanSpoonService.insertUser(request,response);
				System.out.println(u.getId());
				
			} catch (UrbanspoonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

}
