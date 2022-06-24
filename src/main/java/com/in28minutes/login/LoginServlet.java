package com.in28minutes.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.in28minutes.todo.TodoService;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	
	private LoginService loginService = new LoginService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//request.setAttribute("name", request.getParameter("name"));
		//request.setAttribute("password", request.getParameter("password"));
		if(request.getSession().getAttribute("name")!=null)
			request.getRequestDispatcher("/list-todos.do").forward(request, response);
			//response.sendRedirect("/list-todo.do");
			else
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setAttribute("name", request.getParameter("name"));
		//request.setAttribute("password", request.getParameter("password"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean isUserValid = loginService.isValidUser(name, password);
		
		
		if(isUserValid)
		{
			// session ve request arasýndaki farký her seferinde 
			request.getSession().setAttribute("name", name);
			//request.setAttribute("password", password);
			//request.setAttribute("todos", todoService.getAllTodo());
			//request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			response.sendRedirect("/list-todos.do");
		}
		else
		{
			request.setAttribute("errorMessage", "Invalid User Credential !");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			//response.sendRedirect("/login.do");
		}
	}
}
