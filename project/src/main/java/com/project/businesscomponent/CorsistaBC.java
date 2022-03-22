package com.project.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.project.architecture.dao.CorsistaDAO;
import com.project.architecture.dao.DAOException;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.idgenerator.CorsistaIdGenerator;
import com.project.businesscomponent.model.Corsista;

public class CorsistaBC {
	private Connection conn;

	public CorsistaBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Corsista[] getCorsisti() throws DAOException {
		try {
			return CorsistaDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void create(Corsista corsista) 
			throws DAOException, ClassNotFoundException, IOException {
		try {
			corsista.setCodcorsista(CorsistaIdGenerator.getInstance().getNextId());
			CorsistaDAO.getFactory().create(conn, corsista);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void createOrUpdate(Corsista corsista) 
			throws DAOException, ClassNotFoundException, IOException {
		try {
			if(corsista.getCodcorsista() > 0) {
				CorsistaDAO.getFactory().update(conn, corsista);
			} else {
				corsista.setCodcorsista(CorsistaIdGenerator.getInstance().getNextId());
				CorsistaDAO.getFactory().create(conn, corsista);
			}
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void delete(Corsista corsista) throws DAOException {
		try {
			CorsistaDAO.getFactory().delete(conn, corsista);			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corsista getByCod(long id) throws DAOException {
		try {
			return CorsistaDAO.getFactory().getByCod(conn, id);
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
}
