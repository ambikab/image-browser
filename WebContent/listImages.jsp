<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Image Browser</title>
<link href="css/master.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link
	href="js/jquery-ui-1.8.21.custom/css/custom-theme/jquery-ui-1.9.2.custom.css"
	rel="stylesheet">
</head>
<body>
	<div class="rowfluid designClass" id="header"></div>

	<div class="offset1 designClass span3 well" id="topContent">
		<div id="resultPanel">
			<table class="offset2 span6 table table-hover" id="resultTable">
				<thead>
					<tr>
						<th>Image Name</th>
						<th>Image</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:length(images) eq 0}">
						<tr>
							<td colspan="2">Images Not Available in the Db</td>
						</tr>
					</c:if>
					<c:forEach items="${images}" var="images">

						<tr>
							<td><c:out value="${images.name}" /></td>
							<td><button onClick="showImage('${images.name}')">View</button></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="2"><input type="button" class="offset2"
							value="Add Image" onClick="showForm();" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!--  modal pop up of the page goes here -->
	<div id="displayImage" style="display: none;"></div>
	<div id="addNewImage" style="display: none;">
		<form method="POST" action='ImageController' name="frmAddImage"
			enctype="multipart/form-data">
			<table class="offset1">
				<tr>
					<td>Image Name</td>
					<td><input type="text" name="imageName" /></td>
				</tr>
				<tr>
					<td>Image</td>
					<td><input type="file" name="image" /></td>
				</tr>
				<tr>
					<td colspan="2"><input class="offset1" type="submit"
						value="Submit" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>

<!--  scripts to be included in the file -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.js"></script>
<script type="text/javascript" src="js/bootbox.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootbox.min.js"></script>
<script type="text/javascript" src="js/images.js"></script>
<script type="text/javascript"
	src="js/jquery-ui-1.8.21.custom/development-bundle/ui/jquery.effects.core.js"></script>
<script type="text/javascript"
	src="js/jquery-ui-1.8.21.custom/development-bundle/ui/jquery.effects.fade.js"></script>
<script type="text/javascript" src="js/moment-1.6.2.min.js"></script>

</html>