package com.project.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.project.businesscomponent.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants {
private CachedRowSet rowSet;
	
	public static CorsoDAO getFactory() throws DAOException  {
		return new CorsoDAO();
	}
		
	private CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
	}
 
	@Override
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorso());
			rowSet.updateString(2, entity.getNomeCorso());
			rowSet.updateDate(3, new java.sql.Date(entity.getDataInizioCorso().getTime()));
			rowSet.updateDate(4, new java.sql.Date(entity.getDataFineCorso().getTime()));
			rowSet.updateDouble(5, entity.getCostoCorso());
			rowSet.updateString(6, entity.getCommentiCorso());
			rowSet.updateString(7, entity.getAulaCorso());
			rowSet.updateLong(8, entity.getCodDocente());
			rowSet.updateInt(9, entity.getPostiDisponibili());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch(SQLException sql){
			throw new DAOException(sql);
		}	
	}

	@Override
	public void update(Connection conn, Corso entity) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATE_CORSO);
			ps.setString(1, entity.getNomeCorso());
			ps.setDate(2, new java.sql.Date(entity.getDataInizioCorso().getTime()));
			ps.setDate(3, new java.sql.Date(entity.getDataFineCorso().getTime()));
			ps.setDouble(4, entity.getCostoCorso());
			ps.setString(5, entity.getCommentiCorso());
			ps.setString(6, entity.getAulaCorso());
			ps.setLong(7, entity.getCodDocente());
			ps.setInt(8, entity.getPostiDisponibili());
			ps.setLong(9, entity.getCodCorso());
			ps.execute();
			conn.commit();
		} catch(SQLException sql){
			throw new DAOException(sql);
		}	
	}

	@Override
	public void delete(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, entity.getCodCorso());
			ps.execute();
			conn.commit();
		} catch(SQLException sql){
			throw new DAOException(sql);
		}	
		
	}

	@Override
	public Corso getByCod(Connection conn, long id) throws DAOException {
		Corso corso = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_BYCOD);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				corso = new Corso();
				corso.setCodCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				corso.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setCodDocente(rs.getLong(8));
				corso.setPostiDisponibili(rs.getInt(9));
			}
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		Corso[] corsi = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = stmt.executeQuery(SELECT_CORSO);
			rs.last();
			corsi = new Corso[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Corso c = new Corso();
				c.setCodCorso(rs.getLong(1));
				c.setNomeCorso(rs.getString(2));
				c.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				c.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				c.setCostoCorso(rs.getDouble(5));
				c.setCommentiCorso(rs.getString(6));
				c.setAulaCorso(rs.getString(7));
				c.setCodDocente(rs.getLong(8));
				c.setPostiDisponibili(rs.getInt(9));
				corsi[i] = c;
			}
			rs.close();
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return corsi;
	}
	
	//Ritorna il corso più frequentato, ovvero quello con meno posti disponibili.
	public Corso getCorsoMaxFrequenza(Connection conn) throws DAOException{
		Corso corso = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSO_MAX_FREQUENZA);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				corso = new Corso();
				corso.setCodCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				corso.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setCodDocente(rs.getLong(8));
				corso.setPostiDisponibili(rs.getInt(9));
			}
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return corso;
	}
	
	//ritorna il corso con la data di inizio maggiore, overo l'ultimo iniziato
	public Corso getUltimoCorso(Connection conn) throws DAOException{
		Corso corso = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_ULTIMO_CORSO);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				corso = new Corso();
				corso.setCodCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				corso.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setCodDocente(rs.getLong(8));
				corso.setPostiDisponibili(rs.getInt(9));
			}
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return corso;
	}
	
	public int getDurataMediaCorsi(Connection conn) throws DAOException{
		PreparedStatement ps;
		int durataMedia = 0;
		try {
			ps = conn.prepareStatement(SELECT_DURATA_MEDIA);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				durataMedia = rs.getInt(1);
			}
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return durataMedia;
	}
	
	public int getNumeroCommenti(Connection conn) throws DAOException{
		PreparedStatement ps;
		int numCommenti = 0;
		try {
			ps = conn.prepareStatement(COMMENTI_CORSO);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				numCommenti = rs.getInt(1);
			}
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return numCommenti;
	}
	
	public Corso[] getCorsiPostiDisponibili(Connection conn) throws DAOException {
		Corso[] corsi = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = stmt.executeQuery(SELECT_CORSI_POSTI_DISPONIBILI);
			rs.last();
			corsi = new Corso[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Corso c = new Corso();
				c.setCodCorso(rs.getLong(1));
				c.setNomeCorso(rs.getString(2));
				c.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				c.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				c.setCostoCorso(rs.getDouble(5));
				c.setCommentiCorso(rs.getString(6));
				c.setAulaCorso(rs.getString(7));
				c.setPostiDisponibili(rs.getInt(8));
				c.setCodDocente(rs.getLong(9));
				corsi[i] = c;
			}
			rs.close();
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return corsi;
	}
}
