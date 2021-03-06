<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Code Management Application</title>
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
			<form:form action="search" method="GET"><b>Search Code:</b><input type="text" name="searchKeyword" id="searchBar"/>
				<input type="submit" value="Search" class="add-button" />
				
				<!-- Add code button -->
				<input type="button" value="Add Code" 
					   onclick="window.location.href='showAddForm'; return false;" 
					   class="add-button"
					   style="float: right;"
				/>
			</form:form>
			
			<br/>
		
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
						<td style="max-width:12em; text-overflow:ellipsis; white-space:nowrap; overflow:hidden;"> ${tempCode.description} </td>
						<td>
							<input type="button" value="Open" class="open-code-button" onclick="window.location.href='${updateLink}'"/>
							<input type="button" value="Delete" class="delete-button" onclick="if(confirm('Are you sure you want to delete this record?')) {window.location.href='${deleteLink}'} else {return false;}"/>
						</td>
					</tr>					
				</c:forEach>
				
			</table>		
		</div>
	</div>

</body>

</html>