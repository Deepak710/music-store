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
					<h4>Genre Management</h4>
					<br/><br/>
				</div>
				<div class = "panel-body">
					<sf:form class = "form-horizontal" 
						modelAttribute = "genre"
						action = "${contextRoot}/manage/genres"
						method = "POST"
						enctype = "multipart/form-data"
					>
  						<fieldset>
  							<div class="form-group has-danger">							
								<sf:input path="name" type="text" class="form-control" id="genrename" placeholder="Enter Genre Name"/>
								<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
							<div class="form-group">
								<sf:textarea path="description" class="form-control" id="genredesc" rows="3" placeholder="Enter Genre Description"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em"/>
							</div>
							<div class="form-group has-danger">
								<label for="genrepic">Genre Pic</label>
								<sf:input path="file" type="file" class="form-control-file" id="genrepic" aria-describedby="fileHelp"/>
								<small id="fileHelp" class="form-text text-muted">Select a JPEG image of aspect-ratio 1:1</small>
								<sf:errors path="file" cssClass="help-block" element="em"/>
							</div>
							<br/>
							<div class = "form-group offset-md-4">
								<button type="submit" id="submit" class="btn btn-outline-success btn-lg">Submit</button>
							</div>
							<div class = "form-group">
								<sf:hidden path="active"/>
								<sf:hidden path="pic"/>
								<sf:hidden path="view"/>
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
			<h5>Available Genres</h5>
			<br/><br/>
		</div>
		<div class = "col-md-12">
			<div style = "overflow: auto">
				<table id="manageGenres" class = "table">
					<thead>
						<tr>
							<th>Genre Pic</th>
							<th>Genre Name</th>
							<th>Genre Description</th>			
							<th>Genre Activate</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Genre Pic</th>
							<th>Genre Name</th>
							<th>Genre Description</th>			
							<th>Genre Activate</th>
							<th>Edit</th>
						</tr>
					</tfoot>	
				</table>
			</div>
		</div>
	</div>
</div>