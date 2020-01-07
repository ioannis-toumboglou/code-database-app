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
						<td><label><b>Title:</b></label></td>
						<td><form:input path="title" required="required" /></td>
					</tr>
					<tr>
						<td><label><b>Category:</b></label></td>
						<td><form:input path="category" required="required" /></td>
					</tr>
					<tr>
						<td><label><b>Date:</b></label></td>
						<td><form:input path="date" required="required" /></td>
					</tr>
					<tr>
						<td><label><b>Description:</b></label></td>
						<td>
							<form:textarea path="description" placeholder="Please type a description" rows="5" required="required"/>
						</td>
					</tr>
					<tr>
						<td><label><b>File:</b></label></td>
						<td><input type="file" name="code_file" /></td>
					</tr>
					<tr style="margin-left:150px;">
						<td><label></label></td>
						<td>
							<input type="submit" value="Save" class="save" />
							<input type="button" value="Cancel" class="cancel" onclick="window.location.href='list'"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		
	</div>

</body>

</html>