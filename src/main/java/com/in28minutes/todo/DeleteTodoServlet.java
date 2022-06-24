package com.in28minutes.todo;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteTodo
 */
@WebServlet(urlPatterns="/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {
	 private TodoService todoService = new TodoService();

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			UUID requestID = UUID.fromString(request.getParameter("todo")) ;
			todoService.Delete(requestID);
			//request.setAttribute("todos", todoService.getAllTodo());
			response.sendRedirect("/list-todos.do");
		}


}
