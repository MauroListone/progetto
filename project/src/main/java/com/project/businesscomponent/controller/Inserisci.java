package com.project.businesscomponent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inserisci
 */
@WebServlet("/redirect")
public class Inserisci extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inserisci() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	 String location = request.getParameter("page");
		 if(location != null) {
			 if(location.equals("newCorsista"))
				 response.sendRedirect("newCorsista.jsp");
			 else if(location.equals("eliminaCorsi"))
				 response.sendRedirect("corsi.jsp");
			 else
				 response.sendRedirect("404.jsp");
		 }
			 
		 }
		 
		 
	}

