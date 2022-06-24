<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>

<body>


	<div class="container col-md-4 col-md-offset-4">
		
		<form method="POST" action="/add-todo.do">
			<p style="padding-top:100px;">New Name :</p> 
			<input name="todo" type="text" class="form-control"/>
			<p style="padding-top:20px;">New Category :</p> 
			<input name="category" type="text" class="form-control"/>
			<p style="padding-top:20px;">New Description: </p>
			<input name="description" rows="4" cols="50" type="text" class="form-control">
			
			<button  type="submit" class="btn btn-primary btn-lg" style="margin-top:15px;">
				<i class="fa-solid fa-user-plus"></i>
			</button>
		</form>
		
		<div>
  		<h3>
  		<span class="label label-danger">${errorMessage}</span>
  		</h3>
		</div>
	</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>