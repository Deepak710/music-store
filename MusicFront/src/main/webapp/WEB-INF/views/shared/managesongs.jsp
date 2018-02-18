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
					<h4>Song Management</h4>
					<br/><br/>
				</div>
				<div class = "panel-body">
					<sf:form class = "form-horizontal" 
						modelAttribute="song"
						action="${contextRoot}/manage/${artist}/${album}/songs"
						method="POST"
						enctype = "multipart/form-data"
					>
  						<fieldset>
  							<div class="form-group has-danger">							
								<sf:input path="name" type="text" class="form-control" id="songname" placeholder="Enter Song Name"/>
								<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
							<div class="form-group">
								<label class="control-label">Song Rate</label>
								<div class="form-group">
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text"> &#8377; </span>
										</div>
										<sf:input path="rate" type="number" class="form-control has-danger"/>
										<div class="input-group-append">
											<span class="input-group-text">.00 /-</span>
										</div>
										<sf:errors path="rate" cssClass="help-block" element="em"/>
									</div>
								</div>
							</div>
							<div class="form-group has-danger">
								<label for="albumart">Song Preview</label>
								<sf:input path="file" type="file" class="form-control-file" id="songpreview" aria-describedby="fileHelp"/>
								<small id="fileHelp" class="form-text text-muted">Select a MP3 MPEG file</small>
								<sf:errors path="file" cssClass="help-block" element="em"/>
							</div>
							<br/>
							<div class = "form-group offset-md-4">
								<button type="submit" id="submit" class="btn btn-outline-success btn-lg">Submit</button>
							</div>
							<div class = "form-group">
								<sf:hidden path="rating"/>
								<sf:hidden path="bought"/>
								<sf:hidden path="preview"/>
								<sf:hidden path="track_no"/>
							</div>				
  						</fieldset>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<div class =  "row">
		<script>
			window.manageSongAlbum = '${album}';
			window.manageSongArtist = '${artist}';
			window.role = '${role}';
			window.logged = '${logged}';
		</script>
		<div class = "col-md-12">
			<br/><br/><br/><br/>
			<h5>Available Songs</h5>
			<br/><br/>
		</div>
		<div class = "col-md-12">
			<div style = "overflow: auto">
				<table id="manageSongs" class = "table">
				<thead>
					<tr>
						<th>Track Number</th>
						<th>Song Name</th>
						<th>Song Rate</th>
						<th>Preview</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Track Number</th>
						<th>Song Name</th>
						<th>Song Rate</th>
						<th>Preview</th>
						<th>Edit</th>
					</tr>
				</tfoot>	
			</table>
			</div>
		</div>
	</div>
</div>