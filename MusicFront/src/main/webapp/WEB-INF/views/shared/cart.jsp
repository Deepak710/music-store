<div class = "container">
	<div class = "row">
		<h1>${name}'s History</h1>
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
	<div class =  "row">
		<script>
			window.email = '${email}';
		</script>
		<div class = "col-md-12">
			<br/><br/><br/><br/>
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
	</div>
</div>