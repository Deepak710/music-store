$(function() {
	switch (menu) {
	case 'Log In':
		$('#login').addClass('active');
		break;
	case 'Sign Up':
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
												+ '" class="btn btn-outline-info btn-sm"> <span class = "fas fa-eye"></span> </a> &#160;';
										if (row.songs < 1)
											str += '<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-sm disabled"> <span class = "fas fa-cart-plus"></span> </a>';
										else
											str += '<a href = "'
													+ window.contextRoot
													+ '/add/'
													+ row.artist
													+ '/'
													+ row.name
													+ '" class="btn btn-outline-success btn-sm"> <span class = "fas fa-cart-plus"></span> </a>';
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
												+ '" class="btn btn-outline-info btn-sm"> <span class = "fas fa-eye"></span> </a> &#160;';
										if (row.songs < 1)
											str += '<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-sm disabled"> <span class = "fas fa-cart-plus"></span> </a>';
										else
											str += '<a href = "'
													+ window.contextRoot
													+ '/add/'
													+ row.artist
													+ '/'
													+ row.name
													+ '" class="btn btn-outline-success btn-sm"> <span class = "fas fa-cart-plus"></span> </a>';
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
												+ '" class="btn btn-outline-info btn-sm"> <span class = "fas fa-eye"></span> </a> &#160;';
										if (row.songs < 1)
											str += '<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-sm disabled"> <span class = "fas fa-cart-plus"></span> </a>';
										else
											str += '<a href = "'
													+ window.contextRoot
													+ '/add/'
													+ row.artist
													+ '/'
													+ row.name
													+ '" class="btn btn-outline-success btn-sm"> <span class = "fas fa-cart-plus"></span> </a>';
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
												+ '" class="btn btn-outline-info btn-sm"> <span class = "fa fa-eye"></span> </a> &#160;';
										if (row.songs < 1)
											str += '<a href = "javascript:void(0)" class="btn btn-outline-secondary btn-sm disabled"> <span class = "fas fa-cart-plus"></span> </a>';
										else
											str += '<a href = "'
													+ window.contextRoot
													+ '/add/'
													+ row.artist
													+ '/'
													+ row.name
													+ '" class="btn btn-outline-success btn-sm"> <span class = "fas fa-cart-plus"></span> </a>';
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
									data : 'rating'
								},
								{
									data : 'preview',
									bSortable : false,
									mRender : function(data, type, row) {
										return '<audio class="playback" controls=\'controls\' style="width: 150px;" controlsList="nodownload"><source src="'
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
										return '<a href = "'
												+ window.contextRoot
												+ '/add/'
												+ row.artist
												+ '/'
												+ row.album
												+ '/'
												+ row.track_no
												+ '" class="btn btn-outline-success btn-sm"> <span class = "fa fa-cart-plus"></span> </a>';
									}
								} ]
					});
		}
	}
	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 2500)
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
							return '<a href = "'+window.contextRoot+'/manage/'+row.artist+'/'+row.name+'" class = "btn btn-outline-success btn-sm"> <span class = "far fa-edit"></span> </a>';
						}
					},
					{
						data : 'name',
						bSortable : false,
						mRender : function(data, type, row) {
							return '<a href = "'+window.contextRoot+'/manage/'+row.artist+'/'+row.name+'/songs" class = "btn btn-outline-info btn-sm"> <span class = "fas fa-plus"></span> </a>';
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
							return '<a href = "'+window.contextRoot+'/manage/artist/'+row.name+'" class = "btn btn-outline-success btn-sm"> <span class = "far fa-edit"></span> </a>';
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
							return '<a href = "'+window.contextRoot+'/manage/genre/'+row.name+'" class = "btn btn-outline-success btn-sm"> <span class = "far fa-edit"></span> </a>';
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
							return '<a href = "'+window.contextRoot+'/manage/'+row.artist+'/'+row.album+'/'+row.track_no+'" class = "btn btn-outline-success btn-sm"> <span class = "far fa-edit"></span> </a>';
						}
					}]
		});
	}
});