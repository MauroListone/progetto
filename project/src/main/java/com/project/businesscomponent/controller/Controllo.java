package com.project.businesscomponent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.project.businesscomponent.utility.LoginUtility;
import com.project.architecture.dao.DAOException;


/**
 * Servlet implementation class Controllo
 */
@WebServlet("/controllo")
public class Controllo extends HttpServlet {
	private static final long serialVersionUID = 4826142772589320119L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeadmin = request.getParameter("nomeadmin");
		String cognomeadmin = request.getParameter("cognomeadmin");
		String codadmin = request.getParameter("codadmin");

		HttpSession session = request.getSession();
		String adminname, adminlastname, admincod;
		
		if (nomeadmin != null && cognomeadmin != null && codadmin != null) {
			try {
				LoginUtility lU = new LoginUtility();
				adminname= lU.getNomeAdmin(nomeadmin);
				adminlastname= lU.getCognomeAdmin(cognomeadmin);
				admincod = lU.getAdminCod(codadmin);
				
				if (admincod != null) {
					if (admincod.equals(codadmin)) {
						session.setAttribute("nomeadmin", nomeadmin);
						session.setAttribute("cognomeadmin", cognomeadmin);
						response.sendRedirect("home.jsp");
					} else {
						response.sendRedirect("accessonegato.jsp");
					}
				} else {
					response.sendRedirect("accessonegato.jsp");
				}
			} catch (DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			} 
		}
	}
}
