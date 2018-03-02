<div class="container">
	<c:choose>
		<c:when test="${checkoutalbum == true}">
			<div class="row">
				<script>
					window.artist = '${artist}';
					window.album = '${album}';
					window.email = '${email}';
				</script>
				<div class="col-md-12 text-center">
					<h1>Buy Album</h1>
				</div>
				<div class="col-md-12">
					<div style="overflow: auto">
						<table id="checkoutAlbum" class="table">
							<thead>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>
									<th>Album Artist</th>
									<th>Album Genre</th>
									<th>Album Language</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>
									<th>Album Artist</th>
									<th>Album Genre</th>
									<th>Album Language</th>
								</tr>
							</tfoot>
						</table>
					</div>
					<h4>Album Rate: ${rate}</h4>
					<h4>Estimated Delivery Date: ${date}</h4>
					<a href="${contextRoot}/buy/${artist}/${album}"
						class="btn btn-outline-success btn-lg">Buy Album</a> <a
						href="${contextRoot}/cart" class="btn btn-outline-warning btn-lg">Back</a>
				</div>
			</div>
		</c:when>
		<c:when test="${checkoutalbums == true}">
			<div class="row">
				<script>
					window.email = '${email}';
				</script>
				<div class="col-md-12 text-center">
					<h1>Buy All Albums</h1>
				</div>
				<div class="col-md-12">
					<div style="overflow: auto">
						<table id="checkoutAlbums" class="table">
							<thead>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>
									<th>Album Artist</th>
									<th>Album Genre</th>
									<th>Album Language</th>
									<th>Rate</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Album Art</th>
									<th>Album Name</th>
									<th>Album Artist</th>
									<th>Album Genre</th>
									<th>Album Language</th>
									<th>Rate</th>
								</tr>
							</tfoot>
						</table>
					</div>
					<h4>Albums Rate: ${rate}</h4>
					<h4>Estimated Delivery Date: ${date}</h4>
					<a href="${contextRoot}/buy/all/albums"
						class="btn btn-outline-success btn-lg">Buy All Albums</a> <a
						href="${contextRoot}/cart" class="btn btn-outline-warning btn-lg">Back</a>
				</div>
			</div>
		</c:when>
		<c:when test="${checkoutsong == true}">
			<div class="row">
				<script>
					window.artist = '${artist}';
					window.album = '${album}';
					window.track = '${track}';
					window.email = '${email}';
				</script>
				<div class="col-md-12 text-center">
					<h1>Buy Song</h1>
				</div>
				<div class="col-md-12">
					<div style="overflow: auto">
						<table id="checkoutSong" class="table">
							<thead>
								<tr>
									<th>Artist</th>
									<th>Album</th>
									<th>Track Number</th>
									<th>Song Name</th>
									<th>Preview</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Artist</th>
									<th>Album</th>
									<th>Track Number</th>
									<th>Song Name</th>
									<th>Preview</th>
								</tr>
							</tfoot>
						</table>
					</div>
					<h4>Song Rate: ${rate}</h4>
					<h4>Estimated Delivery Date: ${date}</h4>
					<a href="${contextRoot}/buy/${artist}/${album}/${track}"
						class="btn btn-outline-success btn-lg">Buy Song</a> <a
						href="${contextRoot}/cart" class="btn btn-outline-warning btn-lg">Back</a>
				</div>
			</div>
		</c:when>
		<c:when test="${checkoutsongs == true}">
			<div class="row">
				<script>
					window.email = '${email}';
				</script>
				<div class="col-md-12 text-center">
					<h1>Buy All Songs</h1>
				</div>
				<div class="col-md-12">
					<div style="overflow: auto">
						<table id="checkoutSongs" class="table">
							<thead>
								<tr>
									<th>Artist</th>
									<th>Album</th>
									<th>Track Number</th>
									<th>Song Name</th>
									<th>Song Rate</th>
									<th>Preview</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Artist</th>
									<th>Album</th>
									<th>Track Number</th>
									<th>Song Name</th>
									<th>Song Rate</th>
									<th>Preview</th>
								</tr>
							</tfoot>
						</table>
					</div>
					<h4>Songs Rate: ${rate}</h4>
					<h4>Estimated Delivery Date: ${date}</h4>
					<a href="${contextRoot}/buy/all/songs"
						class="btn btn-outline-success btn-lg">Buy All Songs</a> <a
						href="${contextRoot}/cart" class="btn btn-outline-warning btn-lg">Back</a>
				</div>
			</div>
		</c:when>
	</c:choose>
</div>