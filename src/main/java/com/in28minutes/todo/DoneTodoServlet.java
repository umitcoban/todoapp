package com.in28minutes.todo;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoneTodoServlet
 */
@WebServlet(urlPatterns="/done-todo.do")
public class DoneTodoServlet extends HttpServlet {

	TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UUID newTodoID = UUID.fromString(request.getParameter("ID"));
		todoService.DoneTodo(newTodoID);
		response.sendRedirect("/list-todos.do");
	}

}
