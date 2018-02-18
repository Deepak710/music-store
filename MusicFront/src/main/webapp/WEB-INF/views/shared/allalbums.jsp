<div class = "container">
	<div class = "row">
		<div class = "col-md-3">
			<%@include file="sidebar.jsp" %>
		</div>
		<div class = "col-md-9">
			<div class = "row">
				<div class = "col-md-12">
					<c:if test="${userClickGenre==true}">
						<ol class = "breadcrumb">
							<li class = "breadcrumb-item">
								<a href = "${contextRoot}/home">Home</a>
							</li>
							<li class = "breadcrumb-item">
								<a href="${contextRoot}/all/album">Albums</a>
							</li>
							<li class = "breadcrumb-item">Genres</li>
							<li class = "breadcrumb-item">
								<a href = "${contextRoot}/genre/${genre.name}/album">${genre.name}</a>
							</li>
						</ol>
					</c:if>
					<c:if test="${userClickArtist==true}">
						<ol class = "breadcrumb">
							<li class = "breadcrumb-item">
								<a href = "${contextRoot}/home">Home</a>
							</li>
							<li class = "breadcrumb-item">
								<a href="${contextRoot}/all/album">Albums</a>
							</li>
							<li class = "breadcrumb-item">Artists</li>
							<li class = "breadcrumb-item">
								<a href = "${contextRoot}/artist/${artist.name}/album">${artist.name}</a>
							</li>
						</ol>
					</c:if>
					<c:if test="${userClickLanguage==true}">
						<ol class = "breadcrumb">
							<li class = "breadcrumb-item">
								<a href = "${contextRoot}/home">Home</a>
							</li>
							<li class = "breadcrumb-item">
								<a href="${contextRoot}/all/album">Albums</a>
							</li>
							<li class = "breadcrumb-item">Language</li>
							<li class = "breadcrumb-item">
								<a href = "${contextRoot}/language/${lang}/album">${lang}</a>
							</li>
						</ol>
					</c:if>
				</div>
			</div>
			<div class = "row">
				<script>
					window.role = '${role}';
					window.logged = '${logged}';
				</script>
				<div class = "col-md-12">
					<c:if test="${userClickBrowse==true}">
						<script>
							window.artist = '';
							window.genre = '';
						</script>
						<table id="AllAlbums" class = "table">
							<thead>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>
									<th>Album Artist</th>
									<th>Album Genre</th>
									<th>Album Language</th>
									<th></th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>
									<th>Album Artist</th>
									<th>Album Genre</th>
									<th>Album Language</th>
									<th></th>
								</tr>
							</tfoot>	
						</table>
					</c:if>
					<c:if test="${userClickLanguage==true}">
						<script>
							window.lang = '${lang}';
						</script>
						<table id="LanguageAlbums" class = "table">
							<thead>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>
									<th>Album Artist</th>
									<th>Album Genre</th>
									<th></th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>
									<th>Album Artist</th>
									<th>Album Genre</th>
									<th></th>
								</tr>
							</tfoot>	
						</table>
					</c:if>
					<c:if test="${userClickGenre==true}">
						<script>
							window.artist = '';
							window.genre = '${genre.name}';
						</script>
						<table id="GenreAlbums" class = "table">
							<thead>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>
									<th>Album Artist</th>
									<th>Album Language</th>
									<th></th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>
									<th>Album Artist</th>
									<th>Album Language</th>
									<th></th>
								</tr>
							</tfoot>
						</table>
					</c:if>
					<c:if test="${userClickArtist==true}">
						<script>
							window.artist = '${artist.name}';
							window.genre = '';
						</script>
						<table id="ArtistAlbums" class = "table">
							<thead>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>									
									<th>Album Genre</th>
									<th>Album Language</th>
									<th></th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>									
									<th>Album Genre</th>
									<th>Album Language</th>
									<th></th>
								</tr>
							</tfoot>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>