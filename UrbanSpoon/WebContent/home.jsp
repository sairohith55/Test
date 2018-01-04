<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ts.urbanspoon.dto.*"%>


<table border="1">


	<c:forEach var="restList" items="${restaurantsList}">
		<tr>
			<td><c:out value="${restList.id}" /></td>
			<td><c:out value="${restList.govtRegistrationId}" /></td>
			<td><c:out value="${restList.name}" /></td>
			<td><c:out value="${restList.logoName}" /></td>


			<c:forEach var="branchList" items="${restList.branchesList}">

				<td><c:out value="${branchList.id}" /></td>
				<td><c:out value="${branchList.location}" /></td>
				<td><c:out value="${branchList.city}" /></td>
				<td><c:out value="${branchList.state}" /></td>
				<td><c:out value="${branchList.country}" /></td>
				<td><c:out value="${branchList.postalCode}" /></td>
				<td><c:out value="${branchList.email}" /></td>
				<td><c:out value="${branchList.mobileNo}" /></td>

			</c:forEach>

		</tr>
	</c:forEach>



</table>