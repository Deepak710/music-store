$(function() {
	switch (menu) {
	case 'Log In':
		$('#login').addClass('active');
		break;
	case 'Sign Up!!!':
		$('#signup').addClass('active');
		break;
	case 'Manage Albums':
		$('#managealbums').addClass('active');
		break;
	case 'Manage Artists':
		$('#manageartists').addClass('active');
		break;
	case 'Manage Genres':
		$('#managegenres').addClass('active');
		break;
	}
	var jsonURL = '';
	if (window.lang) {
		jsonURL = window.contextRoot + '/json/data/language/' + window.lang
				+ '/album';
		var $table = $('#LanguageAlbums');
		if ($table.length) {
			$table
					.DataTable({
						lengthMenu : [
								[ 3, 5, 10, -1 ],
								[ '3 Albums', '5 Albums', '10 Albums',
										'All Albums' ] ],
						pageLength : 5,
						ajax : {
							url : jsonURL,
							dataSrc : ''
						},
						columns : [
								{
									bSortable : false,
									data : 'pic',
									mRender : function(data, type, row) {
										return '<img src="'
												+ window.contextRoot
												+ '/resources/images/' + data
												+ '" class = "dataTableIMG"/>';
									}
								},
								{
									data : 'name'
								},
								{
									data : 'artist'
								},
								{
									data : 'genre'
								},
								{
									data : 'name',
									bSortable : false,
									mRender : function(data, type, row, meta) {
										var str = '';
										str += '<a href = "'
												+ window.contextRoot
												+ '/view/'
												+ row.artist
												+ '/'
												+ row.name
												+ '" class="btn btn-outline-info btn-sm">View</a> &#160;';
										if (row.songs < 1 || window.role != 'USER')
											str += '<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-sm disabled">Cart</a>';
										else
											str += '<a href = "'
													+ window.contextRoot
													+ '/add/'
													+ row.artist
													+ '/'
													+ row.name
													+ '" class="btn btn-outline-success btn-sm">Cart</a>';
										return str;
									}
								} ]
					});
		}
	}
	if (window.artist == '' && window.genre == '') {
		jsonURL = window.contextRoot + '/json/data/all/album';
		var $table = $('#AllAlbums');
		if ($table.length) {
			$table
					.DataTable({
						lengthMenu : [
								[ 3, 5, 10, -1 ],
								[ '3 Albums', '5 Albums', '10 Albums',
										'All Albums' ] ],
						pageLength : 5,
						ajax : {
							url : jsonURL,
							dataSrc : ''
						},
						columns : [
								{
									bSortable : false,
									data : 'pic',
									mRender : function(data, type, row) {
										return '<img src="'
												+ window.contextRoot
												+ '/resources/images/' + data
												+ '" class = "dataTableIMG"/>';
									}
								},
								{
									data : 'name'
								},
								{
									data : 'artist'
								},
								{
									data : 'genre'
								},
								{
									data : 'lang'
								},
								{
									data : 'name',
									data : 'artist',
									bSortable : false,
									mRender : function(data, type, row, meta) {
										var str = '';
										str += '<a href = "'
												+ window.contextRoot
												+ '/view/'
												+ row.artist
												+ '/'
												+ row.name
												+ '" class="btn btn-outline-info btn-sm">View</a> &#160;';
										if (row.songs < 1 || window.role != 'USER')
											str += '<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-sm disabled">Cart</a>';
										else
											str += '<a href = "'
													+ window.contextRoot
													+ '/add/'
													+ row.artist
													+ '/'
													+ row.name
													+ '" class="btn btn-outline-success btn-sm">Cart</a>';
										return str;
									}
								} ]
					});
		}
	} else if (window.artist) {
		jsonURL = window.contextRoot + '/json/data/artist/' + window.artist
				+ '/album';
		var $table = $('#ArtistAlbums');
		if ($table.length) {
			$table
					.DataTable({
						lengthMenu : [
								[ 3, 5, 10, -1 ],
								[ '3 Albums', '5 Albums', '10 Albums',
										'All Albums' ] ],
						pageLength : 5,
						ajax : {
							url : jsonURL,
							dataSrc : ''
						},
						columns : [
								{
									bSortable : false,
									data : 'pic',
									mRender : function(data, type, row) {
										return '<img src="'
												+ window.contextRoot
												+ '/resources/images/' + data
												+ '" class = "dataTableIMG"/>';
									}
								},
								{
									data : 'name'
								},
								{
									data : 'genre'
								},
								{
									data : 'lang'
								},
								{
									data : 'name',
									data : 'artist',
									data : 'songs',
									bSortable : false,
									mRender : function(data, type, row, meta) {
										var str = '';
										str += '<a href = "'
												+ window.contextRoot
												+ '/view/'
												+ row.artist
												+ '/'
												+ row.name
												+ '" class="btn btn-outline-info btn-sm">View</a> &#160;';
										if (row.songs < 1 || window.role != 'USER')
											str += '<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-sm disabled">Cart</a>';
										else
											str += '<a href = "'
													+ window.contextRoot
													+ '/add/'
													+ row.artist
													+ '/'
													+ row.name
													+ '" class="btn btn-outline-success btn-sm">Cart</a>';
										return str;
									}
								} ]
					});
		}
	} else if (window.genre) {
		jsonURL = window.contextRoot + '/json/data/genre/' + window.genre
				+ '/album';
		var $table = $('#GenreAlbums');
		if ($table.length) {
			$table
					.DataTable({
						lengthMenu : [
								[ 3, 5, 10, -1 ],
								[ '3 Albums', '5 Albums', '10 Albums',
										'All Albums' ] ],
						pageLength : 5,
						ajax : {
							url : jsonURL,
							dataSrc : ''
						},
						columns : [
								{
									bSortable : false,
									data : 'pic',
									mRender : function(data, type, row) {
										return '<img src="'
												+ window.contextRoot
												+ '/resources/images/' + data
												+ '" class = "dataTableIMG"/>';
									}
								},
								{
									data : 'name'
								},
								{
									data : 'artist'
								},
								{
									data : 'lang'
								},
								{
									data : 'name',
									data : 'artist',
									bSortable : false,
									mRender : function(data, type, row, meta) {
										var str = '';
										str += '<a href = "'
												+ window.contextRoot
												+ '/view/'
												+ row.artist
												+ '/'
												+ row.name
												+ '" class="btn btn-outline-info btn-sm">View</a> &#160;';
										if (row.songs < 1 || window.role != 'USER')
											str += '<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-sm disabled">Cart</a>';
										else
											str += '<a href = "'
													+ window.contextRoot
													+ '/add/'
													+ row.artist
													+ '/'
													+ row.name
													+ '" class="btn btn-outline-success btn-sm">Cart</a>';
										return str;
									}
								} ]
					});
		}
	}
	if (window.album && window.albartist) {
		jsonURL = window.contextRoot + '/json/data/view/' + window.albartist
				+ '/' + window.album;
		var $table = $('#SingleAlbum');
		if ($table.length) {
			$table
					.DataTable({
						lengthMenu : false,
						ajax : {
							url : jsonURL,
							dataSrc : ''
						},
						columns : [
								{
									data : 'track_no',
									mRender : function(data, type, row) {
										if (data < 10)
											return '0' + data;
										else
											return data;
									}
								},
								{
									data : 'name'
								},
								{
									data : 'rate',
									mRender : function(data, type, row) {
										return '&#8377; ' + data + '/-';
									}
								},
								{
									data : 'preview',
									bSortable : false,
									mRender : function(data, type, row) {
										return '<audio class="playback" controls=\'controls\' style="width: 350px;" controlsList="nodownload"><source src="'
												+ window.contextRoot
												+ '/resources/audios/'
												+ data
												+ '" type="audio/mpeg"></audio>';
									}
								},
								{
									data : 'album',
									data : 'artist',
									data : 'track_no',
									bSortable : false,
									mRender : function(data, type, row, meta) {
										if (window.role != 'USER')
											return '<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-sm disabled">Cart</a>';
										else
											return '<a href = "'
													+ window.contextRoot
													+ '/add/'
													+ row.artist
													+ '/'
													+ row.album
													+ '/'
													+ row.track_no
													+ '" class="btn btn-outline-success btn-sm">Cart</a>';
									}
								} ]
					});
		}
	}
	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 5000)
	}
	var $manageAlbumTable = $('#manageAlbums');
	if ($manageAlbumTable.length) {
		jsonURL = window.contextRoot + '/json/data/admin/all/album';
		$manageAlbumTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Albums', '5 Albums', '10 Albums',
							'All Albums' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						bSortable : false,
						data : 'pic',
						mRender : function(data, type, row) {
							return '<img src="'
									+ window.contextRoot
									+ '/resources/images/' + data
									+ '" class = "dataTableIMG"/>';
						}
					},
					{
						data : 'name'
					},
					{
						data : 'artist'
					},
					{
						data : 'genre'
					},
					{
						data : 'lang'
					},
					{
						data : 'active',
						bSortable : false,
						mRender : function(data, type, row) {
							str = '<label class = "switch">';
							if (data) str +=	'<input type = "checkbox" id = "toggle" checked = "checked" value = "'+row.name+','+row.artist+'"/>';
							else str +=	'<input type = "checkbox" id = "toggle" value = "'+row.name+','+row.artist+'"/>';
							str +=	'<div class = "slider"></div>';
							str +=	'</label>';
							return str;
						}
					},
					{
						data : 'name',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<a href = "'+window.contextRoot+'/manage/'+row.artist+'/'+row.name+'" class = "btn btn-outline-success btn-sm">Edit</a>';
						}
					},
					{
						data : 'name',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<a href = "'+window.contextRoot+'/manage/'+row.artist+'/'+row.name+'/songs" class = "btn btn-outline-info btn-sm">Add Songs</a>';
						}
					}],
					initComplete : function() {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change', function() {
							var checkbox = $(this);
							var checked = checkbox.prop('checked');
							var dia = (checked) ? 'Activate the Album?' : 'De-Activate the Album?';
							var value = checkbox.prop('value');
							value = value.split(',');
							bootbox.confirm({
								size : 'medium',
								title : 'Album Activation/De-Activation',
								message : dia,
								callback : function(confirmed) {
										if (confirmed) {
											var active = window.contextRoot + '/manage/' + value[1] + '/' + value[0] + '/activation';
											$.post(active, function(data) {
												bootbox.alert({
													size : 'medium',
													title : 'Info',
													message : data
												});
											});
									} else {
										checkbox.prop('checked', !checked);
									}
								}
							});
						});
					}
		});
	}
	var $manageArtistTable = $('#manageArtists');
	if ($manageArtistTable.length) {
		jsonURL = window.contextRoot + '/json/data/admin/all/artist';
		$manageArtistTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Artists', '5 Artists', '10 Artists',
							'All Artists' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						bSortable : false,
						data : 'pic',
						mRender : function(data, type, row) {
							return '<img src="'
									+ window.contextRoot
									+ '/resources/images/' + data
									+ '" class = "dataTableIMG"/>';
						}
					},
					{
						data : 'name'
					},
					{
						data : 'bio'
					},
					{
						data : 'active',
						bSortable : false,
						mRender : function(data, type, row) {
							str = '<label class = "switch">';
							if (data) str +=	'<input type = "checkbox" checked = "checked" value = "'+row.name+'"/>';
							else str +=	'<input type = "checkbox" value = "'+row.name+'"/>';
							str +=	'<div class = "slider"></div>';
							str +=	'</label>';
							return str;
						}
					},
					{
						data : 'name',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<a href = "'+window.contextRoot+'/manage/artist/'+row.name+'" class = "btn btn-outline-success btn-sm">Edit</a>';
						}
					}
					],
					initComplete : function() {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change', function() {
							var checkbox = $(this);
							var checked = checkbox.prop('checked');
							var dia = (checked) ? 'Activate the Artist?' : 'De-Activate the Artist?';
							var value = checkbox.prop('value');
							bootbox.confirm({
								size : 'medium',
								title : 'Artist Activation/De-Activation',
								message : dia,
								callback : function(confirmed) {
									if (confirmed) {
										var activate = window.contextRoot + '/manage/artist/' + value + '/activation';
										$.post(activate, function(data) {
											bootbox.alert({
												size : 'medium',
												title : 'Info',
												message : data
											});
										});
									} else {
										checkbox.prop('checked', !checked);
									}
								}
							});
						});
					}
		});
	}
	var $manageGenreTable = $('#manageGenres');
	if ($manageGenreTable.length) {
		jsonURL = window.contextRoot + '/json/data/admin/all/genre';
		$manageGenreTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Genres', '5 Genres', '10 Genres',
							'All Genres' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						data : 'pic',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<img src="'
									+ window.contextRoot
									+ '/resources/images/' + data
									+ '" class = "dataTableIMG"/>';
						}
					},
					{
						data : 'name'
					},
					{
						data : 'description'
					},
					{
						data : 'active',
						bSortable : false,
						mRender : function(data, type, row) {
							str = '<label class = "switch">';
							if (data) str +=	'<input type = "checkbox" checked = "checked" value = "'+row.name+'"/>';
							else str +=	'<input type = "checkbox" value = "'+row.name+'"/>';
							str +=	'<div class = "slider"></div>';
							str +=	'</label>';
							return str;
						}
					},
					{
						data : 'name',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<a href = "'+window.contextRoot+'/manage/genre/'+row.name+'" class = "btn btn-outline-success btn-sm">Edit</a>';
						}
					}
					],
					initComplete : function() {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change', function() {
							var checkbox = $(this);
							var checked = checkbox.prop('checked');
							var dia = (checked) ? 'Activate the Genre?' : 'De-Activate the Genre?';
							var value = checkbox.prop('value');
							bootbox.confirm({
								size : 'medium',
								title : 'Genre Activation/De-Activation',
								message : dia,
								callback : function(confirmed) {
									if (confirmed) {
										var activate = window.contextRoot + '/manage/genre/' + value +'/activation';
										$.post(activate, function (data) {
											bootbox.alert({
												size : 'medium',
												title : 'Info',
												message : data
											});
										})
									} else {
										checkbox.prop('checked', !checked);
									}
								}
							});
						});
					}
		});
	}
	var $manageSongTable = $('#manageSongs');
	if ($manageSongTable.length) {
		jsonURL = window.contextRoot + '/json/data/admin/'+window.manageSongArtist+'/'+window.manageSongAlbum;
		$manageSongTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Songs', '5 Songs', '10 Songs',
							'All Songs' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						data : 'track_no'
					},
					{
						data : 'name'
					},
					{
						data : 'rate',
						mRender : function(data, type, row) {
							return '&#8377; ' + data + '/-';
						}
					},
					{
						data : 'preview',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<audio class="playback" controls=\'controls\' style="width: 400px;" controlsList="nodownload"><source src="'
									+ window.contextRoot
									+ '/resources/audios/'
									+ data
									+ '" type="audio/mpeg"></audio>';
						}
					},
					{
						data : 'name',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<a href = "'+window.contextRoot+'/manage/'+row.artist+'/'+row.album+'/'+row.track_no+'" class = "btn btn-outline-success btn-sm">Edit</a>';
						}
					}]
		});
	}
	var $cartAlbumsTable = $('#cartAlbums');
	if ($cartAlbumsTable.length) {
		jsonURL = window.contextRoot + '/json/data/' + window.email + '/cart/albums';
		console.log(jsonURL);
		$cartAlbumsTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Albums', '5 Albums', '10 Albums',
							'All Albums' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						bSortable : false,
						data : 'pic',
						mRender : function(data, type, row) {
							return '<img src="'
									+ window.contextRoot
									+ '/resources/images/' + data
									+ '" class = "dataTableIMG"/>';
						}
					},
					{
						data : 'name',
						mRender : function(data, type, row) {
							return '<a href = "' + window.contextRoot + '/view/' + row.artist + '/' + row.name + '"> ' + data + '</a>';
						}
					},
					{
						data : 'artist'
					},
					{
						data : 'genre'
					},
					{
						data : 'lang'
					},
					{
						data : 'rate',
						mRender : function(data, type, row) {
							return '&#8377; ' + data + '/-';
						}
					},
					{
						data : 'name',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<a href = "'+window.contextRoot+'/checkout/'+row.artist+'/'+row.name+'" class = "btn btn-outline-success btn-sm"> Buy </a>';
						}
					},
					{
						data : 'name',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<a href = "'+window.contextRoot+'/remove/'+row.artist+'/'+row.name+'" class = "btn btn-outline-info btn-sm"> Remove </a>';
						}
					}]
		});
	}
	var $cartSongTable = $('#cartSongs');
	if ($cartSongTable.length) {
		jsonURL = window.contextRoot + '/json/data/' + window.email + '/cart/songs';
		$cartSongTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Songs', '5 Songs', '10 Songs',
							'All Songs' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						data : 'artist'
					},
					{
						data : 'album',
						mRender : function(data, type, row) {
							return '<a href = "' + window.contextRoot + '/view/' + row.artist + '/' + row.album + '"> ' + data + '</a>';
						}
					},
					{
						data : 'track_no'
					},
					{
						data : 'name'
					},
					{
						data : 'rate',
						mRender : function(data, type, row) {
							return '&#8377; ' + data + '/-';
						}
					},
					{
						data : 'preview',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<audio class="playback" controls=\'controls\' style="width: 300px;" controlsList="nodownload"><source src="'
									+ window.contextRoot
									+ '/resources/audios/'
									+ data
									+ '" type="audio/mpeg"></audio>';
						}
					},
					{
						data : 'name',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<a href = "'+window.contextRoot+'/checkout/'+row.artist+'/'+row.album+'/'+row.track_no+'" class = "btn btn-outline-success btn-sm"> Buy </a>';
						}
					},
					{
						data : 'name',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<a href = "'+window.contextRoot+'/remove/'+row.artist+'/'+row.album+'/'+row.track_no+'" class = "btn btn-outline-info btn-sm"> Remove </a>';
						}
					}]
		});
	}
	var $boughtAlbumsTable = $('#boughtAlbums');
	if ($boughtAlbumsTable.length) {
		jsonURL = window.contextRoot + '/json/data/' + window.email + '/cart/bought/albums';
		console.log(jsonURL);
		$boughtAlbumsTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Albums', '5 Albums', '10 Albums',
							'All Albums' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						bSortable : false,
						data : 'pic',
						mRender : function(data, type, row) {
							return '<img src="'
									+ window.contextRoot
									+ '/resources/images/' + data
									+ '" class = "dataTableIMG"/>';
						}
					},
					{
						data : 'name',
						mRender : function(data, type, row) {
							return '<a href = "' + window.contextRoot + '/view/' + row.artist + '/' + row.name + '"> ' + data + '</a>';
						}
					},
					{
						data : 'artist'
					},
					{
						data : 'genre'
					},
					{
						data : 'lang'
					},
					{
						data : 'rate',
						mRender : function(data, type, row) {
							return '&#8377; ' + data + '/-';
						}
					},
					{
						data : 'date'
					},
					{
						data : 'date',
						mRender : function(data, type, row) {
							var d = new Date(row.date);
							d.setDate(d.getDate() + 7);
							if (new Date() >= d)
								return 'Album was delivered on <br/>' + d;
							else
								return 'Album will be delivered on <br/>' + d;
						}
					}]
		});
	}
	var $boughtSongTable = $('#boughtSongs');
	if ($boughtSongTable.length) {
		jsonURL = window.contextRoot + '/json/data/' + window.email + '/cart/bought/songs';
		$boughtSongTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Songs', '5 Songs', '10 Songs',
							'All Songs' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						data : 'artist'
					},
					{
						data : 'album',
						mRender : function(data, type, row) {
							return '<a href = "' + window.contextRoot + '/view/' + row.artist + '/' + row.album + '"> ' + data + '</a>';
						}
					},
					{
						data : 'track_no'
					},
					{
						data : 'name'
					},
					{
						data : 'rate',
						mRender : function(data, type, row) {
							return '&#8377; ' + data + '/-';
						}
					},
					{
						data : 'preview',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<audio class="playback" controls=\'controls\' style="width: 200px;" controlsList="nodownload"><source src="'
									+ window.contextRoot
									+ '/resources/audios/'
									+ data
									+ '" type="audio/mpeg"></audio>';
						}
					},
					{
						data : 'date'
					},
					{
						data : 'date',
						mRender : function(data, type, row) {
							var d = new Date(row.date);
							d.setDate(d.getDate() + 7);
							if (new Date() >= d)
								return 'Song was delivered on <br/>' + d;
							else
								return 'Song will be delivered on <br/>' + d;
						}
					}]
		});
	}
	var $checkoutAlbumTable = $('#checkoutAlbum');
	if ($checkoutAlbumTable.length) {
		jsonURL = window.contextRoot + '/json/data/' + window.email + '/cart/' + window.artist + '/' + window.album;
		console.log(jsonURL);
		$checkoutAlbumTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Albums', '5 Albums', '10 Albums',
							'All Albums' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						bSortable : false,
						data : 'pic',
						mRender : function(data, type, row) {
							return '<img src="'
									+ window.contextRoot
									+ '/resources/images/' + data
									+ '" class = "dataTableIMG"/>';
						}
					},
					{
						data : 'name',
					},
					{
						data : 'artist'
					},
					{
						data : 'genre'
					},
					{
						data : 'lang'
					}
					]
		});
	}
	var $checkoutAlbumsTable = $('#checkoutAlbums');
	if ($checkoutAlbumsTable.length) {
		jsonURL = window.contextRoot + '/json/data/' + window.email + '/cart/albums';
		console.log(jsonURL);
		$checkoutAlbumsTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Albums', '5 Albums', '10 Albums',
							'All Albums' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						bSortable : false,
						data : 'pic',
						mRender : function(data, type, row) {
							return '<img src="'
									+ window.contextRoot
									+ '/resources/images/' + data
									+ '" class = "dataTableIMG"/>';
						}
					},
					{
						data : 'name',
					},
					{
						data : 'artist'
					},
					{
						data : 'genre'
					},
					{
						data : 'lang'
					},
					{
						data : 'rate',
						mRender : function(data, type, row) {
							return '&#8377; ' + data + '/-';
						}
					}
					]
		});
	}
	var $checkoutSongTable = $('#checkoutSong');
	if ($checkoutSongTable.length) {
		jsonURL = window.contextRoot + '/json/data/' + window.email + '/cart/' + window.artist + '/' + window.album + '/' + window.track;
		$checkoutSongTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Songs', '5 Songs', '10 Songs',
							'All Songs' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						data : 'artist'
					},
					{
						data : 'album',
					},
					{
						data : 'track_no'
					},
					{
						data : 'name'
					},
					{
						data : 'preview',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<audio class="playback" controls=\'controls\' style="width: 200px;" controlsList="nodownload"><source src="'
									+ window.contextRoot
									+ '/resources/audios/'
									+ data
									+ '" type="audio/mpeg"></audio>';
						}
					}
					]
		});
	}
	var $checkoutSongsTable = $('#checkoutSongs');
	if ($checkoutSongsTable.length) {
		jsonURL = window.contextRoot + '/json/data/' + window.email + '/cart/songs';
		$checkoutSongsTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Songs', '5 Songs', '10 Songs',
							'All Songs' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
					{
						data : 'artist'
					},
					{
						data : 'album',
					},
					{
						data : 'track_no'
					},
					{
						data : 'name'
					},
					{
						data : 'rate',
						mRender : function(data, type, row) {
							return '&#8377; ' + data + '/-';
						}
					},
					{
						data : 'preview',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<audio class="playback" controls=\'controls\' style="width: 200px;" controlsList="nodownload"><source src="'
									+ window.contextRoot
									+ '/resources/audios/'
									+ data
									+ '" type="audio/mpeg"></audio>';
						}
					}
					]
		});
	}
	var $reportAlbumTable = $('#reportAlbum');
	if ($reportAlbumTable.length) {
		jsonURL = window.contextRoot + '/json/data/report/albums';
		$reportAlbumTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Albums', '5 Albums', '10 Albums',
							'All Albums' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
				{
					bSortable : false,
					data : 'pic',
					mRender : function(data, type, row) {
						return '<img src="'
								+ window.contextRoot
								+ '/resources/images/' + data
								+ '" class = "dataTableIMG"/>';
					}
				},
				{
					data : 'path'
				},
				{
					data : 'monthSale',
					mRender : function(data, type, row) {
						return data + ' Units Sold for &#8377; ' + row.monthRate;
					}
				},
				{
					data : 'allSale',
					mRender : function(data, type, row) {
						return data + ' Units Sold for &#8377; ' + row.allRate;
					}
				}
			]
		});
	}
	var $reportSongTable = $('#reportSong');
	if ($reportSongTable.length) {
		jsonURL = window.contextRoot + '/json/data/report/songs';
		$reportSongTable
		.DataTable({
			lengthMenu : [
					[ 3, 5, 10, -1 ],
					[ '3 Songs', '5 Songs', '10 Songs',
							'All Songs' ] ],
			pageLength : 5,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns : [
				{
					bSortable : false,
					data : 'preview',
					mRender : function(data, type, row) {
						return '<audio class="playback" controls=\'controls\' style="width: 200px;" controlsList="nodownload"><source src="'
							+ window.contextRoot
							+ '/resources/audios/'
							+ data
							+ '" type="audio/mpeg"></audio>';
					}
				},
				{
					data : 'path'
				},
				{
					data : 'monthSale',
					mRender : function(data, type, row) {
						return data + ' Units Sold for &#8377; ' + row.monthRate;
					}
				},
				{
					data : 'allSale',
					mRender : function(data, type, row) {
						return data + ' Units Sold for &#8377; ' + row.allRate;
					}
				}
			]
		});
	}
});