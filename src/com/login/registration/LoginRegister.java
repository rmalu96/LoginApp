package com.login.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/loginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginRegister() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDAO cd=new CustomerDAOImpl();
		String userName=request.getParameter("username");
		String password =request.getParameter("password1");
		String submilType=request.getParameter("submit");
		Customer c=cd.getCustomer(userName, password);
		
		//System.out.println("hii login page"+submilType);
		//System.out.println(c.getUsername()+c.getPassword());
		if(submilType.equals("login") && userName.equals(c.getUsername()) && password.equals(c.getPassword())) {
		
			
			//cd.getCustomer(userName, password);
			request.setAttribute("message",c.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request,response);
			
			
		}else if(submilType.equals("Register")) {
			
			c.setName(request.getParameter("name"));
			c.setPassword(password);
			c.setUsername(userName);
			cd.insertCustomer(c);
			//request.getRequestDispatcher("welcome.jsp").forward(request,response);
			request.setAttribute("successMessage","Registation Done please login");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
			
		}else {
			request.setAttribute("message","Data Not Found ,click on Register");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	
	}

}
