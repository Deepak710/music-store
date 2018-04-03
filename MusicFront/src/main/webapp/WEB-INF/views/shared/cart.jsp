<div class = "container">
	<div class = "row">
		<div class = "col-md-12 text-center">
			<h1>${name}'s Cart</h1>
		</div>
	</div>
	<div class =  "row">
		<script>
			window.email = '${email}';
		</script>
		<div class = "col-md-12">
			<br/><br/><br/>
			<h3>Albums In Cart</h3>
			<br/><br/>
		</div>
		<div class = "col-md-12">
			<div style = "overflow: auto">
				<table id="cartAlbums" class = "table">
					<thead>
						<tr>
							<th>Album Art</th>
							<th>Album Name</th>
							<th>Album Artist</th>
							<th>Album Genre</th>
							<th>Album Language</th>
							<th>Rate</th>
							<th>Buy</th>
							<th>Remove</th>
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
							<th>Buy</th>
							<th>Remove</th>
						</tr>
					</tfoot>	
				</table>
			</div>
		</div>
		<div class = "col-md-12 text-right">
			<br/>
			<c:choose>
				<c:when test="${cartalbums > 0}">
					<a href="${contextRoot}/checkout/all/albums" class="btn btn-outline-success btn-lg">Buy ALL Albums</a>
				</c:when>
				<c:otherwise>
					<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-lg disabled">Buy ALL Albums</a>
				</c:otherwise>
			</c:choose>
			&emsp;<a href="${contextRoot}/remove/all/albums" class="btn btn-outline-warning btn-lg">Remove ALL Albums</a>
		</div>
	</div>
	<div class =  "row">
		<script>
			window.email = '${email}';
		</script>
		<div class = "col-md-12">
			<br/><br/><br/><br/>
			<h3>Songs in Cart</h3>
			<br/><br/>
		</div>
		<div class = "col-md-12">
			<div style = "overflow: auto">
				<table id="cartSongs" class = "table">
				<thead>
					<tr>
						<th>Artist</th>
						<th>Album</th>
						<th>Track Number</th>
						<th>Song Name</th>
						<th>Song Rate</th>
						<th>Preview</th>
						<th>Buy</th>
						<th>Remove</th>
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
						<th>Buy</th>
						<th>Remove</th>
					</tr>
				</tfoot>	
			</table>
			</div>
		</div>
		<div class = "col-md-12 text-right">
			<br/>
			<c:choose>
				<c:when test="${cartsongs > 0}">
					<a href="${contextRoot}/checkout/all/songs" class="btn btn-outline-success btn-lg">Buy ALL Songs</a>
				</c:when>
				<c:otherwise>
					<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-lg disabled">Buy ALL Songs</a>
				</c:otherwise>
			</c:choose>
			&emsp;<a href="${contextRoot}/remove/all/songs" class="btn btn-outline-warning btn-lg">Remove ALL Songs</a>
		</div>
	</div>
	<div class = "row">
		<div class = "col-md-12 text-center">
			<br/><br/><br/><br/>
			<br/><br/><br/><br/>
			<h1>${name}'s Purchase History</h1>
		</div>
	</div>
	<div class = "row">
		<script>
			window.email = '${email}';
		</script>
		<div class = "col-md-12">
			<br/><br/><br/><br/>
			<h3>Albums Bought</h3>
			<br/><br/>
		</div>
		<div class = "col-md-12">
			<div style = "overflow: auto">
				<table id="boughtAlbums" class = "table">
					<thead>
						<tr>
							<th>Album Art</th>
							<th>Album Name</th>
							<th>Album Artist</th>
							<th>Album Genre</th>
							<th>Album Language</th>
							<th>Rate</th>
							<th>Buy Date</th>
							<th>Receive Date</th>
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
							<th>Buy Date</th>
							<th>Receive Date</th>
						</tr>
					</tfoot>	
				</table>
			</div>
		</div>
	</div>
	<div class =  "row">
		<script>
			window.email = '${email}';
		</script>
		<div class = "col-md-12">
			<br/><br/><br/><br/>
			<h3>Songs Bought</h3>
			<br/><br/>
		</div>
		<div class = "col-md-12">
			<div style = "overflow: auto">
				<table id="boughtSongs" class = "table">
				<thead>
					<tr>
						<th>Artist</th>
						<th>Album</th>
						<th>Track Number</th>
						<th>Song Name</th>
						<th>Song Rate</th>
						<th>Preview</th>
						<th>Buy Date</th>
						<th>Receive Date</th>
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
						<th>Buy Date</th>
						<th>Receive Date</th>
					</tr>
				</tfoot>	
			</table>
			</div>
		</div>
	</div>
</div>