<header class="masthead text-center text-white">
	<div class="masthead-content">
		<div class="container">
			<h1 class="masthead-heading mb-0">Music Store</h1>
			<h3 class="masthead-subheading mb-0">One Stop Shop for ALL your Vinyl Needs</h3>
			<a href="${contextRoot}/all/album" class="btn btn-primary btn-xl rounded-pill mt-5">Browse</a>
		</div>
	</div>
	<div class="bg-circle-1 bg-circle"></div>
	<div class="bg-circle-2 bg-circle"></div>
	<div class="bg-circle-3 bg-circle"></div>
	<div class="bg-circle-4 bg-circle"></div>
</header>

<section>
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 order-lg-2">
				<div class="p-5">
					<a href = "${contextRoot}/${latestalbumlink}"><img class="img-fluid rounded-circle" src="${images}/${latestalbumpic}" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6 order-lg-1">
				<div class="p-5">
					<h2 class="display-4">Latest Album</h2>
					<p>${latestalbum}</p>
				</div>
			</div>
		</div>
	</div>
</section>

<section>
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6">
				<div class="p-5">
					<a href = "${contextRoot}/${trendingalbumlink}"><img class="img-fluid rounded-circle" src="${images}/${trendingalbumpic}" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="p-5">
					<h2 class="display-4">Top Album</h2>
					<p>${trendingalbum}</p>
				</div>
			</div>
		</div>
	</div>
</section>

<section>
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 order-lg-2">
				<div class="p-5">
					<a href = "${contextRoot}/${latestsonglink}"><img class="img-fluid rounded-circle" src="${images}/${latestsongpic}" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6 order-lg-1">
				<div class="p-5">
					<h2 class="display-4">Latest Song</h2>
					<p>${latestsong}</p>
				</div>
			</div>
		</div>
	</div>
</section>

<section>
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6">
				<div class="p-5">
					<a href = "${contextRoot}/${trendingsonglink}"><img class="img-fluid rounded-circle" src="${images}/${trendingsongpic}" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="p-5">
					<h2 class="display-4">Top Song</h2>
					<p>${trendingsong}</p>
				</div>
			</div>
		</div>
	</div>
</section>

<section>
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 order-lg-2">
				<div class="p-5">
					<a href = "${contextRoot}/${topartistlink}"><img class="img-fluid rounded-circle" src="${images}/${topartistpic}" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6 order-lg-1">
				<div class="p-5">
					<h2 class="display-4">Top Artist</h2>
					<p>${topartist} <br/> ${topartistbio} </p>
				</div>
			</div>
		</div>
	</div>
</section>

<section>
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6">
				<div class="p-5">
					<a href = "${contextRoot}/${topgenrelink}"><img class="img-fluid rounded-circle" src="${images}/${topgenrepic}" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="p-5">
					<h2 class="display-4">Top Genre</h2>
					<p>${topgenre} <br/> ${topgenredescrition}</p>
				</div>
			</div>
		</div>
	</div>
</section>