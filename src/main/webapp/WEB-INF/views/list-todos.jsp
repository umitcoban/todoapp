<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>
<body>

	<div class="container">
		
			<h1> 
				<span>Welcome ${name}</span>
			</h1>
		
		<h2 style="padding-bottom:50px;padding-top:20px;"> &nbsp &nbsp Your Todos are</h2>
		
		<div style="margin-right:25px; padding-bottom:5px;">
		<button title="Add New Todo" class="btn btn-primary" onclick="location.href='/add-todo.do'">
			<i class="fa-solid fa-plus"></i>
		</button>
		</div>
	<div clas="container-xl">
		<table class="table table-stripped">
			<thead class="thead-light">
				<th>Category</th>
				<th>Name</th>
				<th>#</th>
			</thead>
		<tbody class="table table-striped">
			<c:forEach items="${todos}" var="todo">
				<tr>
				
					<td>${todo.category}</td>
					
						<c:choose>
						<c:when test="${todo.isDone==true}">
						 <td>
						 ${todo.name}
						 <span class="label label-success">DONE!</span>
						 </td>
						</c:when>
						<c:when test="${todo.isDone==false}">
						 <td>
						 ${todo.name}
						 <span class="label label-warning">In Progress</span>
						 </td>
						</c:when>
					</c:choose>
			
					<td>
					
					<c:choose>
						<c:when test="${todo.isDone==false}">
							<button style="margin-right:7px;" title="Check Done" class="btn btn-success" onclick="location.href='/done-todo.do?ID=${todo.ID}'">
								<i class="fa-solid fa-check"></i>
							</button>
						</c:when>
						<c:when test="${todo.isDone==true}">
							<button style="margin-right:7px;" title="Check is not Done" class="btn btn-warning" id="location.href='/done-todo.do?ID=${todo.ID}" onclick="location.href='/done-todo.do?ID=${todo.ID}'">
							<i class="fa-solid fa-xmark"></i>
							</button>
						</c:when>
						</c:choose>
						
						<button style="margin-right:7px;" class="btn btn-primary" onclick="location.href='/edit-todo.do?ID=${todo.ID}&name=${todo.name}&category=${todo.category}&description=${todo.description}'">
							<i class="fa-solid fa-pen-to-square"></i>
						</button>
						
						<button style="margin-right:7px;" class="btn btn-danger" id="location.href='/delete-todo.do?todo=${todo.ID}" onclick="location.href='/delete-todo.do?todo=${todo.ID}'">
							<i class="fa-solid fa-trash"></i>
						</button>
						
					</td>
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>	
	</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</body>

</html>