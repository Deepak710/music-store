<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class = "container">
	<div class = "row">
	<c:if test="${not empty message}">
			<div class = "col-md-12">
				<div class = "alert alert-success alert-dismissible">
					${message}
					<button type = "button" class = "close" data-dismiss = "alert">&times;</button>
				</div>
			</div>
		</c:if>
		<div class = "offset-md-2 col-md-8">
			<div class = "panel panel-primary">
				<div class = "panel-heading">
					<br/><br/><br/>
					<h4>Album Management</h4>
					<br/><br/>
				</div>
				<div class = "panel-body">
					<sf:form class = "form-horizontal" 
						modelAttribute="album"
						action="${contextRoot}/manage/albums"
						method="POST"
						enctype = "multipart/form-data"
					>
  						<fieldset>
  							<div class="form-group has-danger">							
								<sf:input type="text" path="name" class="form-control" id="albumname" placeholder="Enter Album Name"/>
								<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
							<div class="form-group">
								<label class="control-label" for="selectartist">Select Artist: </label>
								<sf:select path="artist" class="custom-select" id="selectartist" 
									items="${artists}" 
									itemLabel="name"
									itemValue="name"
								/>
							</div>
							<div class="form-group">
								<label class="control-label" for="selectartist">Select Genre: </label>
								<sf:select path="genre" class="custom-select" id="selectgenre" 
									items="${genres}" 
									itemLabel="name"
									itemValue="name"
								/>
							</div>
							<div class="form-group">
								<label class="control-label" for="selectlang">Select Language: </label>
								<sf:select path="lang" class="custom-select" id="selectlang">
									<sf:option itemLabel="lang" itemValue="lang" value="English">English</sf:option>
									<sf:option itemLabel="lang" itemValue="lang" value="Hindi">Hindi</sf:option>
									<sf:option itemLabel="lang" itemValue="lang" value="Tamil">Tamil</sf:option>
								</sf:select>
							</div>
							<div class="form-group has-danger">
								<label for="albumart">Album Art</label>
								<sf:input type="file" path="file" class="form-control-file" id="albumart" aria-describedby="fileHelp"/>
								<small id="fileHelp" class="form-text text-muted">Select a JPEG image of aspect-ratio 1:1</small>
								<sf:errors path="file" cssClass="help-block" element="em"/>
							</div>
							<br/>
							<div class = "form-group offset-md-4">
								<button type="submit" id="submit" class="btn btn-outline-success btn-lg">Submit</button>
							</div>
							<div class = "form-group">
								<sf:hidden path="active"/>
								<sf:hidden path="view"/>
								<sf:hidden path="pic"/>
								<sf:hidden path="songs"/>
							</div>				
  						</fieldset>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<div class =  "row">
		<script>
			window.role = '${role}';
			window.logged = '${logged}';
		</script>
		<div class = "col-md-12">
			<br/><br/><br/><br/>
			<h5>Available Albums</h5>
			<br/><br/>
		</div>
		<div class = "col-md-12">
			<div style = "overflow: auto">
				<table id="manageAlbums" class = "table">
					<thead>
						<tr>
							<th>Album Art</th>
							<th>Album Name</th>
							<th>Album Artist</th>
							<th>Album Genre</th>
							<th>Album Language</th>
							<th>Album Activate</th>
							<th>Edit</th>
							<th>Add Songs</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Album Art</th>
							<th>Album Name</th>
							<th>Album Artist</th>
							<th>Album Genre</th>
							<th>Album Language</th>
							<th>Album Activate</th>
							<th>Edit</th>
							<th>Add Songs</th>
						</tr>
					</tfoot>	
				</table>
			</div>
		</div>
	</div>
</div>