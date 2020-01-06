<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>List Code</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Code Management Application</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">			
			<!-- Add search box -->
			<form:form action="search" method="GET">Search Code:<input type="text" name="searchKeyword" />
				<input type="submit" value="Search" class="add-button" />
				
				<!-- Add code button -->
				<input type="button" value="Add Code" 
					   onclick="window.location.href='showAddForm'; return false;" 
					   class="add-button"
					   style="float: right;"
				/>
			</form:form>
		
			<!-- Add HTML table -->
			<table>
				<tr>
					<th>Title</th>
					<th>Category</th>
					<th>Date</th>
					<th>Description</th>
					<th>Code</th>
				</tr>
				
				<c:forEach var="tempCode" items="${codeList}">
					<!-- Construct an "update" link for each code record-->
					<c:url var="updateLink" value="/code/showUpdateForm">
						<c:param name="codeId" value="${tempCode.id}" />
					</c:url>
					<!-- Construct a "delete" link for each code record-->
					<c:url var="deleteLink" value="/code/delete">
						<c:param name="codeId" value="${tempCode.id}" />
					</c:url>
					<tr>
						<td> ${tempCode.title} </td>
						<td> ${tempCode.category} </td>
						<td> ${tempCode.date} </td>
						<td> ${tempCode.description} </td>
						<td> 
							<a href="${tempCode.code}">Show</a> 
						</td>
						<td>
							<a href="${updateLink}">Update</a> 
							| 
							<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this code record?'))) return false">Delete</a>
						</td>
					</tr>					
				</c:forEach>
				
			</table>		
		</div>
	</div>

</body>

</html>