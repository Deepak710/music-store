<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="theme" value="/resources/theme" />
<spring:url var="audios" value="/resources/audios" />
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

<!-- Custom styles for this template -->
<link href="${theme}/solar.css" rel="stylesheet">
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">
<link href="${css}/one-page-wonder.min.css" rel="stylesheet">

</head>

<body oncontextmenu="return false;">
	<div class="wrapper">
		<%@include file="./shared/navbar.jsp"%>
		<div class="context">
			<c:choose>
				<c:when test="${userClickHome == true}">
					<%@include file="./shared/home.jsp"%>
				</c:when>
				<c:when test="${userClickCart == true}">
					<%@include file="./shared/cart.jsp"%>
				</c:when>
				<c:when test="${userClickCheckout == true}">
					<%@include file="./shared/checkout.jsp"%>
				</c:when>
				<c:when test="${userClickLogin == true}">
					<%@include file="./shared/login.jsp"%>
				</c:when>
				<c:when test="${userClickSignup == true}">
					<%@include file="./shared/signup.jsp"%>
				</c:when>
				<c:when test="${userClickBrowse == true or userClickGenre == true or userClickArtist == true or userClickLanguage == true}">
					<%@include file="./shared/allalbums.jsp"%>
				</c:when>
				<c:when test="${userClickAlbum == true}">
					<%@include file="./shared/singlealbum.jsp" %>
				</c:when>
				<c:when test="${userClickManageAlbums == true}">
					<%@include file="./shared/managealbums.jsp" %>
				</c:when>
				<c:when test="${userClickManageArtists == true}">
					<%@include file="./shared/manageartists.jsp" %>
				</c:when>
				<c:when test="${userClickManageGenres == true}">
					<%@include file="./shared/managegenres.jsp" %>
				</c:when>
				<c:when test="${userClickManageSongs == true}">
					<%@include file="./shared/managesongs.jsp" %>
				</c:when>
			</c:choose>
		</div>
		<br/><br/>
		<%@include file="./shared/footer.jsp"%>
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap4.js"></script>
		<script src="${js}/bootbox.min.js"></script>
		<script src="${js}/myapp.js"></script>
	</div>
</body>
</html>