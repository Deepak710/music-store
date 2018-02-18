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
						<h4>Login</h4>
						<br /> <br />
					</div>
					<div class="panel-body">
						<sf:form class="form-horizontal" 
							modelAttribute="user"
							action="${contextRoot}/manage/login"
							method="POST"
							enctype = "multipart/form-data"
						>
							<fieldset>
								<div class="form-group">
									<sf:input path="email" type="email" class="form-control"
										id="email" placeholder="Enter your E-Mail ID" />
									<sf:errors path="email" cssClass="help-block" element="em"/>
								</div>
								<div class="form-group">
									<sf:input path="password" type="password" class="form-control"
										id="p1" placeholder="Enter Password" />
									<sf:errors path="password" cssClass="help-block" element="em"/>
								</div>
								<div class = "form-group offset-md-4">
									<button type="submit" id="submit" class="btn btn-outline-success btn-lg">Submit</button>
								</div>
							</fieldset>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>