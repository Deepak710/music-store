<div class = "container">
	<div class = "row">
		<script>
			window.album = '${album.name}';
			window.albartist = '${album.artist}';
			window.role = '${role}';
			window.logged = '${logged}';
		</script>
		<div class = "col-md-3">
			<br/>
			<div class = "thumbnail">
				<img src = "${images}/${album.pic}" class = "img img-responsive albViewIMG"/>
			</div>
		</div>
		<div class = "col-md-9">
			<br/><br/><br/><br/>
			<h1>${album.name}</h1>
			<c:choose>
				<c:when test = "${rate < 1}">
					<h3><span style = "color:red">No Songs!!!</span></h3>
				</c:when>
				<c:otherwise>
					<h3>&#8377; ${rate}/-</h3>
				</c:otherwise>
			</c:choose>
			<br/>
			<h5>${album.artist}</h5>
			<h5>${album.genre}</h5>
			<h5>${album.lang}</h5>
			<br/>
			<hr/>
			<table id="SingleAlbum" class = "table">
				<thead>
					<tr>
						<th>Track Number</th>
						<th>Song Name</th>
						<th>Rate</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Track Number</th>
						<th>Song Name</th>
						<th>Rate</th>
						<th></th>
						<th></th>
					</tr>
				</tfoot>	
			</table>
			<hr/>
			<br/>
			<c:choose>
				<c:when test = "${rate < 1}">
					<a href="javascript:void(0)"><button style = "font-size:24px" class = "btn btn-outline-warning disabled"> <strike>No Songs in Album...</strike></button></a>
				</c:when>
				<c:when test = "${role == 'null'}">
					<a href="${contextRoot}/manage/login"><button style = "font-size:24px" class = "btn btn-outline-warning"> Log In to Buy Album!!!</button></a>
				</c:when>
				<c:when test = "${role == 'ADMIN'}">
					<a href="javascript:void(0)"><button style = "font-size:24px" class = "btn btn-outline-warning disabled">Admins Can't Buy Albums</button></a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/add/${album.artist}/${album.name}"><button style = "font-size:24px" class = "btn btn-outline-success">Add Album to Cart</button></a>
				</c:otherwise>
			</c:choose>
			&#160;&#160;<a href="${contextRoot}/all/album"><button style = "font-size:24px" class = "btn btn-outline-warning">Back</button></a>
		</div>
	</div>
</div>