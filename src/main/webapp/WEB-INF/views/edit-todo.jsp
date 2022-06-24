<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Todo</title>
</head>
<body>
	
	<div class="container">
		
		<form method="POST" action="/edit-todo.do?ID=${ID}&name=${name}&category=${category}&description=${description}">
			Edit Name : <input name="edit-name" type="text" class="form-control" value="${name}"/>
			Edit Category : <input name="edit-category" type="text" class="form-control" value="${category}"/>
			Edit Description: <input name="edit-description" type="text" class="form-control" value="${description}"/>  
			<button type="submit" class="btn btn-primary btn-lg" style="margin-top:5px;">
				<i class="fa-solid fa-pen-to-square"></i>
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