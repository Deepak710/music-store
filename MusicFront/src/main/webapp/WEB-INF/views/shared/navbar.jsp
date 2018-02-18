<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home">Music Store</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<c:choose>
				<c:when test="${logged == 'null' or role == 'ADMIN'}">
					<ul class="navbar-nav ml-auto">
						<c:if test="${role == 'ADMIN'}">
							<li class="nav-item"><a class="nav-link"
								href="${contextRoot}/manage/albums" id="managealbums">Manage
									Albums</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${contextRoot}/manage/artists" id="manageartists">Manage
									Artists</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${contextRoot}/manage/genres" id="managegenres">Manage
									Genres</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${contextRoot}/manage/signup" id="signup">Sign Up</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${contextRoot}/signout" id="signout">Sign Out</a></li>
						</c:if>
						<c:if test="${role == 'null'}">
							<li class="nav-item"><a class="nav-link"
								href="${contextRoot}/manage/login" id="login">Log In</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${contextRoot}/manage/signup" id="signup">Sign Up</a></li>
						</c:if>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav ml-auto">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" data-toggle="dropdown">Hey ${logged}!</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="${contextRoot}/cart">View Cart</a>
								<a class="dropdown-item" href="${contextRoot}/signout">Sign Out</a>
							</div>
						</li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>
<br />
<br />
<br />