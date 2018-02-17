
<ul class="nav nav-pills flex-column">
	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		data-toggle="dropdown" role="button" aria-haspopup="true"
		aria-expanded="true">Genre</a>
		<div class="dropdown-menu">
			<c:forEach items="${genres}" var="g">
				<a class="dropdown-item"
					href="${contextRoot}/genre/${g.name}/album"
					class="list-group-item">${g.name}</a>
			</c:forEach>
		</div></li>
	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		data-toggle="dropdown" role="button" aria-haspopup="true"
		aria-expanded="true">Artist</a>
		<div class="dropdown-menu">
			<c:forEach items="${artists}" var="a">
				<a class="dropdown-item"
					href="${contextRoot}/artist/${a.name}/album"
					class="list-group-item">${a.name}</a>
			</c:forEach>
		</div></li>
	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		data-toggle="dropdown" role="button" aria-haspopup="true"
		aria-expanded="true">Language</a>
		<div class="dropdown-menu">
			<a class="dropdown-item"
				href="${contextRoot}/language/English/album"
				class="list-group-item">English</a>
			<a class="dropdown-item"
				href="${contextRoot}/language/Hindi/album"
				class="list-group-item">Hindi</a>
			<a class="dropdown-item"
				href="${contextRoot}/language/Tamil/album"
				class="list-group-item">Tamil</a>
		</div></li>
</ul>