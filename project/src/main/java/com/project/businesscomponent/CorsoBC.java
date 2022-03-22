package com.project.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.architecture.dao.CorsoDAO;
import com.project.architecture.dao.DAOException;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.idgenerator.CorsoIdGenerator;
import com.project.businesscomponent.model.Corso;



public class CorsoBC {
private Connection conn;
	
	public CorsoBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Corso[] getCorsi() throws DAOException {
		try {
			return CorsoDAO.getFactory().getAll(conn);
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	   
	public void createOrUpdate(Corso corso) throws DAOException, ClassNotFoundException, IOException {
		try {
			if(corso.getCodCorso() > 0) {
				CorsoDAO.getFactory().update(conn, corso);
			} else {
				corso.setCodCorso(CorsoIdGenerator.getInstance().getNextId());
				CorsoDAO.getFactory().create(conn, corso);
			}
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	
	public void delete(Corso corso) throws DAOException {
		try {
			CorsoDAO.getFactory().delete(conn, corso);
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	
	public Corso[] searchArticolo(String query) throws DAOException {
		ArrayList<Corso> lista = new ArrayList<Corso>();
		String[] criterioRicerca = query.toLowerCase().split(" ");
		for(Corso a : getCorsi()) 
			for(String s : criterioRicerca) 
				if(a.getNomeCorso().toLowerCase().contains(s) || 
						a.getAulaCorso().toLowerCase().contains(s))
					lista.add(a);
		
		Corso[] corsi = new Corso[lista.size()];
		for(int i = 0; i<lista.size();i++) {
			corsi[i] = lista.get(i);
		}
		return corsi;
	}
	
	public Corso getByCod(long id) throws DAOException {
		try {
			return CorsoDAO.getFactory().getByCod(conn, id);
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
	
}
