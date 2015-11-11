<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data Input Form</title>
</head>
<body>
	<form method="post" action="UserServlet">
		<table>
			<tr>
				<td>*User Name :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>Sex :</td>
				<td>
					<select name="sex">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Active :</td>
				<td>
					<select name="active">
						<option value="Yes">Yes</option>
						<option value="No">No</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Tags :</td>
				<td><input type="text" name="tags"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="submit">Submit</button>
			</tr>
		</table>
	</form>
</body>
</html>