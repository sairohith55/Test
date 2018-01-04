package com.ts.urbanspoon.dao;

import java.sql.*;
import java.util.*;

import com.ts.urbanspoon.dto.*;
import com.ts.urbanspoon.util.DAOUtility;

public class RestaurantDAO {

	public List<Restaurant> getRestaurants(final int TOP) {
		// w.r.t query to get Top 10 Restaurants.
		Restaurant res = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Restaurant> list = null;

		try {
			con = DAOUtility.getConncetion();
			String query = "select * from restaurant limit" + TOP;
			System.out.println("------>query is:" + query);
			stmt=con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("rs:" + rs);
			list = new ArrayList();
			
			if (rs.next()) {
				System.out.println("yes we have a record");

				do {
					
					  Restaurant r=new Restaurant();
					  r.setId(rs.getInt("restaurant_id"));
					  r.setGovtRegistrationId(rs.getString("govt_registration_id"));
					  r.setName(rs.getString("name"));
					  r.setLogoName(rs.getString("logo_name")); //branch
					  
					  list.add(r);
					 
				} while (rs.next());
			} else {
				System.out.println("--->no record is available");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--------->list:" + list);

		return list;
	}

}
