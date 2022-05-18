<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<!-- Bootstrap Core CSS -->
<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.10.2.js"></script>
<link
		href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
		rel="stylesheet">
<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	  rel="stylesheet">



<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/business-casual.css"
	  rel="stylesheet">

<!-- Fonts -->
<link
		href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
		rel="stylesheet" type="text/css">
<link
		href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
		rel="stylesheet" type="text/css">


<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

<body>

		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2 class="brand">
				Hello User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>


	<c:forEach var="movie" items="${movieDetails}">

		<div class="row">
			<tr>
			</tr>
			<tr>
				<td ><h4 class="address-bar">Movie Name: ${movie.moviename}</h4>
					<h5 class="address-bar"> rate: ${movie.rate}</h5>
					<h5 class="address-bar"> ListMovie</h5>
				</td>
			</tr>
			<tr class="glyphicon-align-center">
				<c:forEach var="video" items="${movie.videoresult}">
					<td><iframe title="YouTube video player"
							class="youtube-player" type="text/html"
							src="http://www.youtube.com/embed/${video.videoId}"
							frameborder="0" allowFullScreen></iframe></td>
				</c:forEach>
			</tr>

		</div>
	</c:forEach>
</body>
</html>