package com.project.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.architecture.dao.DAOException;
import com.project.architecture.dao.CorsoCorsistaDAO;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn;

	public CorsoCorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public void create(CorsoCorsista cc) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsoCorsistaDAO.getFactory().create(conn, cc);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
