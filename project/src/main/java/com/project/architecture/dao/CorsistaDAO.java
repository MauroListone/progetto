package com.project.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.project.businesscomponent.model.Corsista;

public class CorsistaDAO implements GenericDAO<Corsista>, DAOConstants{
	
	public static CorsistaDAO getFactory() throws DAOException { 
		  return new CorsistaDAO(); 
		  }
	  
	  private CachedRowSet rowSet;
	  
	  private CorsistaDAO() throws DAOException {
	  
	  try { rowSet = RowSetProvider.newFactory().createCachedRowSet(); } 
	  catch
	  (SQLException sql) { throw new DAOException(sql); 
	  }
	  
	  
	  }

	@Override
	public void create(Connection conn, Corsista entity) throws DAOException {
		try { 
			  rowSet.setCommand(SELECT_CORSISTA); 
			  rowSet.execute(conn);
			  rowSet.moveToInsertRow();
			  rowSet.updateLong(1, entity.getCodcorsista());
			  rowSet.updateString(2, entity.getNomecorsista()); 
			  rowSet.updateString(3, entity.getCognomecorsista()); 
			  rowSet.updateString(4, entity.getPrecedentiformativi()); 
			  
			  rowSet.insertRow(); 
			  rowSet.moveToCurrentRow(); 
			  rowSet.acceptChanges();
		  
		  } catch (SQLException sql) { 
			  throw new DAOException(sql); 
			  }
		
	}

	@Override
	public void update(Connection conn, Corsista entity) throws DAOException {
		try { 
			  PreparedStatement ps = conn.prepareStatement(UPDATE_CORSISTA); 
			  ps.setString(1, entity.getNomecorsista()); 
			  ps.setString(2, entity.getCognomecorsista());
			  ps.setString(3, entity.getPrecedentiformativi()); 
			  ps.setLong(4, entity.getCodcorsista());
			  ps.execute();
			  conn.commit();
			  }catch (SQLException sql) { 
				  throw new DAOException(sql); 
			  }
		
	}

	@Override
	public void delete(Connection conn, Corsista entity) throws DAOException {
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSISTA);
			ps.setLong(1, entity.getCodcorsista());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corsista[] getCorsisti(Connection conn) throws DAOException{
		Corsista[] corsisti = null;
		
		
		return corsisti;
	}
	
	public int getNumCorsisti(Connection conn) throws DAOException{
		int numCorsisti = 0;
		
		return numCorsisti;
	}

	@Override
	public Corsista getByCod(Connection conn, long id) throws DAOException {
		Corsista corsista = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_BY_PK);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();				
			
			//rs.next() serve nell'if altriment rs mi darebbe nullpointerException
			if(rs.next()) {
				corsista = new Corsista();
				corsista.setCodcorsista(rs.getLong(1));
				corsista.setNomecorsista(rs.getString(2));
				corsista.setCognomecorsista(rs.getString(3));
				corsista.setPrecedentiformativi(rs.getString(4));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}

	@Override
	public Corsista[] getAll(Connection conn) throws DAOException {
		
		Corsista[] corsisti = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);
			/**
			 * x sapere quanti record ho, non avrei potuto richiamarlo se non avessi scroll sopra
			 */
			rs.last();
			/**
			 * getRow() mi dice su che riga siamo cosi imposto la dimensione dell'array
			 */
			corsisti = new Corsista[rs.getRow()];
			//mi riposiziono in prima posizione riavvolgo cioè il cursore
			rs.beforeFirst();
			//qui stiamo leggendo quindi la data deve essere di tipo util
			for (int i = 0; rs.next(); i++) {
				Corsista c = new Corsista();
				c.setCodcorsista(rs.getLong(1));
				c.setNomecorsista(rs.getString(2));
				c.setCognomecorsista(rs.getString(3)); 
				c.setPrecedentiformativi(rs.getString(4));
				corsisti[i] = c;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}
	
}
