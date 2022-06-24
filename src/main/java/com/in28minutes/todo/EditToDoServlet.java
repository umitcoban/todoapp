package com.in28minutes.todo;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditToDoServlet
 */
@WebServlet(urlPatterns="/edit-todo.do")
public class EditToDoServlet extends HttpServlet {

	TodoService todoService = new TodoService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UUID id = UUID.fromString(request.getParameter("ID"));
		String editname = request.getParameter("name");
		String editcategory = request.getParameter("category");
		String editDescription = request.getParameter("description");
		request.setAttribute("ID", id);
		request.setAttribute("name", editname);
		request.setAttribute("category", editcategory);
		request.setAttribute("description", editDescription);
		request.getRequestDispatcher("/WEB-INF/views/edit-todo.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String editTodoName = request.getParameter("edit-name");
		String editTodoCategory = request.getParameter("edit-category");
		String editTodoDescription = request.getParameter("edit-description");
		UUID newTodoID = UUID.fromString(request.getParameter("ID"));
		System.out.println(editTodoName+"/"+editTodoCategory+"/"+editTodoDescription);
		if(todoService.isValidTodo(editTodoName) && todoService.isValidTodo(editTodoCategory)&& todoService.isValidTodo(editTodoDescription)) {
			Todo todo = new Todo();
			todo.name= editTodoName;
			todo.Category = editTodoCategory;
			todo.description = editTodoDescription;
			todo.ID = newTodoID;
			System.out.println(todo.name+"/"+todo.Category+"/"+todo.description);
			todoService.Edit(todo);
			request.setAttribute("todos", todoService.getAllTodo());
			//request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request,response);
			response.sendRedirect("/list-todos.do");
		}else {
			request.setAttribute("errorMessage", "Invalid Todo Name!");
			request.setAttribute("todos", todoService.getAllTodo());
			request.getRequestDispatcher("/WEB-INF/views/edit-todo.jsp").forward(request,response);
		}
	}

}
