package com.project.businesscomponent.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.architecture.dao.DAOException;
import com.project.businesscomponent.facade.CorsistaFacade;
import com.project.businesscomponent.model.Corsista;


/**
 * Servlet implementation class Registra
 */
@WebServlet("/aggiungi")
public class Registra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Corsista corsista = new Corsista();
		try {
			corsista.setNomecorsista(request.getParameter("nomecorsista"));
			corsista.setCognomecorsista(request.getParameter("cognomecorsista"));
			corsista.setPrecedentiformativi(request.getParameter("precedenti"));
			System.out.println("corsista registrato");
			CorsistaFacade cF = CorsistaFacade.getInstance();
			cF.createCorsista(corsista);
			System.out.println("corsista creato");
			response.sendRedirect("home.jsp");
		} catch (DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}

}
