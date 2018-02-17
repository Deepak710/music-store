<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="fonts" value="/resources/fonts" />
<spring:url var="theme" value="/resources/theme" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Music Store - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${theme}/solar.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="${fonts}/catamaran.css" rel="stylesheet">
<link href="${fonts}/lato.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/one-page-wonder.min.css" rel="stylesheet">

</head>

<body oncontextmenu="return false;">
	<div class="wrapper">
		<%@include file="./shared/navbar.jsp"%>
		<div class="context">
			<div class="row">
				<div class="col-md-12">
					<div class="jumbotron">
						<br/><br/><br/>
						<h1>${error}</h1>
						<br/><br/><br/>
						<hr/>
						<br/><br/><br/>
						<blockquote style="word-wrap:break-word">${description}</blockquote>
						<br/><br/><br/>
					</div>
				</div>
			</div> 
		</div>
		<%@include file="./shared/footer.jsp"%>
	</div>
</body>
</html>