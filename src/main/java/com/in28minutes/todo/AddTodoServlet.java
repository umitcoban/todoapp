package com.in28minutes.todo;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTodoServlet
 */
@WebServlet(urlPatterns="/add-todo.do")
public class AddTodoServlet extends HttpServlet {
	TodoService todoService = new TodoService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String newTodoName = request.getParameter("todo");
		String newTodoCategory = request.getParameter("category");
		String newTodoDescription = request.getParameter("description");
		
		if(todoService.isValidTodo(newTodoName) && todoService.isValidTodo(newTodoCategory)&&todoService.isValidTodo(newTodoDescription)) {
			todoService.Add(new Todo(newTodoName, newTodoCategory, newTodoDescription, false ));
			request.setAttribute("todos", todoService.getAllTodo());
			//request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request,response);
			response.sendRedirect("/list-todos.do");
		}else {
			request.setAttribute("errorMessage", "Invalid Todo Name!");
			request.setAttribute("todos", todoService.getAllTodo());
			request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(request,response);
		}
	}

}
