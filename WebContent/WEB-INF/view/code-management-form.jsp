<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Code</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-code-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Code Management Application</h2>		
		</div>
	</div>
	
	<div id="container">
		<h3>Save Code</h3>
		
		<form:form action="saveCode" modelAttribute="code" method="POST">
			<!-- Need to associate the data with code id -->
			<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="title" /></td>
					</tr>
					<tr>
						<td><label>Category:</label></td>
						<td><form:input path="category" /></td>
					</tr>
					<tr>
						<td><label>Date:</label></td>
						<td><form:input path="date" /></td>
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/code/list">Back to List</a>
		</p>
		
	</div>

</body>

</html>