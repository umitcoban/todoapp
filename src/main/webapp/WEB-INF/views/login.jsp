
<%@ include file="../common/header.jspf" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<body>
	<nav role="navigation" class="navbar navbar-default">

		<div class="">
			<a href="/" class="navbar-brand">TODO App</a>
		</div>

		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="/list-todos.do">Todos</a></li>
			</ul>
		</div>

	</nav>

<div class="container-fluid col-md-4 col-md-offset-4">

		
		<h3> Today date is a :
		  <jsp:useBean id="now" class="java.util.Date" />
			<fmt:formatDate type = "both" dateStyle = "medium" timeStyle = "short" value="${now}" /> 
	
		 </h3>
		
		
<form action="/login.do" method="post">
  <div class="form-group" >
    <label for="exampleInputEmail1">Username</label>
    <input type="text" name = "name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
	<div class="text-center">
	<h3>
	<span class="label label-danger">${errorMessage}</span>
	</h3>
	</div>
		<div class="text-center">
			<button  type="submit" class="btn btn-primary btn-lg">
  				<i class="fa-solid fa-arrow-right-to-arc">LOGIN</i>
  			</button>
		</div>
  
</form>

</div>



	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>