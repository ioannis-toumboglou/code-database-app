<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Code Management Application</title>
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
		
		<form:form action="updateCode" modelAttribute="code" method="POST" enctype="multipart/form-data">
			<!-- Need to associate the data with code id -->
			<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr id="table">
						<td><label><b>Title:</b></label></td>
						<td><form:input path="title" required="required" /></td>
					</tr>
					<tr id="table">
						<td><label><b>Category:</b></label></td>
						<td><form:input path="category" required="required" /></td>
					</tr>
					<tr id="table">
						<td><label><b>Date:</b></label></td>
						<td><form:input type="date" path="date" required="required" /></td>
					</tr>
					<tr id="table">
						<td><label><b>Description:</b></label></td>
						<td>
							<form:textarea path="description" placeholder="Please type a description" rows="5" required="required"/>
						</td>
					</tr>
					<tr id="table">
						<td><label><b>Document:</b></label></td>
						<td><a href="file:///C:/Users/toumb-laptop/Desktop/Files/${code.fileName}" target="_blank" title="Open file">${code.fileName}</a></td>
					</tr>
					<tr style="margin-left:150px; background-color: aliceblue;">
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