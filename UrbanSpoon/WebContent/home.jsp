<%@ page import="java.util.*" %>
<%@ page import="com.ts.urbanspoon.dto.*" %>

<%

List<Restaurant> list=(List<Restaurant>)request.getAttribute("restaurantsList");
out.println(list);

%>


