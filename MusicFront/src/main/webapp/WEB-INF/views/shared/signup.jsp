<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="context">
	<div class="container">
		<div class="row">
			<c:if test="${not empty message}">
				<div class = "col-md-12">
					<div class = "alert alert-success alert-dismissible">
						${message}
						<button type = "button" class = "close" data-dismiss = "alert">&times;</button>
					</div>
				</div>
			</c:if>
			<div class="offset-md-2 col-md-8">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<br /> <br /> <br />
						<h4>Sign-Up!!!!</h4>
						<br /> <br />
					</div>
					<div class="panel-body">
						<sf:form class="form-horizontal" 
							modelAttribute="user"
							action="${contextRoot}/manage/signup"
							method="POST"
							enctype = "multipart/form-data"
						>
							<fieldset>
								<div class="form-group">
									<sf:input path="name" type="text" class="form-control"
										placeholder="Enter your Name" id="name" />
									<sf:errors path="name" cssClass="help-block" element="em"/>
								</div>
								<div class="form-group">
									<sf:input path="email" type="email" class="form-control"
										id="email" placeholder="Enter your E-Mail ID" />
									<small id="emailHelp" class="form-text text-muted">We'll
										never share your email with anyone else.</small>
									<sf:errors path="email" cssClass="help-block" element="em"/>
								</div>
								<div class="form-group">
									<sf:input path="password" type="password" class="form-control"
										id="p1" placeholder="Enter 8-character Password" />
									<sf:errors path="password" cssClass="help-block" element="em"/>
								</div>
								<div class="form-group">
									<small id="phoneHelp" class="form-text text-muted">Phone Number</small>
									<sf:input path="phone" type="text" class="form-control"
										placeholder="XXXXXXXXXX" id="phone" />
									<sf:errors path="phone" cssClass="help-block" element="em"/>
								</div>
								<div class="form-group">
									<sf:textarea path="address" class="form-control" id="address"
										placeholder="Enter your Address" rows="5"></sf:textarea>
									<sf:errors path="address" cssClass="help-block" element="em"/>
								</div>
								<br />
								<c:if test = "${role == 'ADMIN'}">
									<div class="form-group">
										<label class="control-label col-md-4">Select Role</label>
										<div class="custom-control custom-radio">
											<label class="radio-inline"> 
												<sf:radiobutton path="role" value="USER" checked="checked" /> User
											</label> 
											<label class="radio-inline"> 
												<sf:radiobutton path="role" value="ADMIN" /> Admin
											</label>
										</div>
									</div>
								</c:if>
								<div class = "form-group offset-md-4">
									<button type="submit" id="submit" class="btn btn-outline-success btn-lg">Submit</button>
								</div>
								<c:if test = "${role != 'ADMIN'}">
									<div class = "form-group">
										<sf:hidden path="role"/>
									</div>				
								</c:if>								
							</fieldset>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>