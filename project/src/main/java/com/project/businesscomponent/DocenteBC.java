package com.project.businesscomponent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.project.architecture.dao.DAOConstants;
import com.project.architecture.dao.DocentiDAO;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.model.Docente;

public class DocenteBC implements DAOConstants{
	private static DocentiDAO dDAO;
	
	public DocenteBC() {
		dDAO = DocentiDAO.getFactory();
	}
	
	public static ArrayList<Docente> getDocenti() throws SQLException, NamingException, ClassNotFoundException, IOException {
		try {
			return dDAO.getDocenti(DBAccess.getConnection());
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public static ArrayList<Docente> moreThanOne() throws SQLException, NamingException, ClassNotFoundException, IOException {
		try {
			return dDAO.moreThanOne(DBAccess.getConnection());
		} finally {
			DBAccess.closeConnection();
		}
	}
	
	public static Docente getDocenteByPK(byte codDocente) throws SQLException, NamingException, ClassNotFoundException, IOException {
		try {
			return dDAO.findByPk(DBAccess.getConnection(), codDocente);
		} finally {
			DBAccess.closeConnection();
		}
	}
}
