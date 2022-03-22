package com.project.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.architecture.dao.DAOConstants;
import com.project.architecture.dao.DAOException;
import com.project.architecture.dbaccess.DBAccess;

public class CorsistaIdGenerator implements IdGeneratorInterface, DAOConstants {

	private static CorsistaIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	//implemento il singleton
	
	private CorsistaIdGenerator() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	
	 public static CorsistaIdGenerator getInstance() throws DAOException, ClassNotFoundException, IOException {
		 if(istanza == null)
			 istanza = new CorsistaIdGenerator();
		 return istanza;
	 }
	 //fine implementazione singleton
	/**
	 * ho inserito questo metodo nell'interface in modo che tutti i generatori abbiano questo metodo
	 * per ritornare il valore univoco per fare gli inserimenti dentro la tabella
	 * @throws ClassNotFOundException, DAOException, IOException 
	 * @throws SQLException 
	 * 
	 */
	 
	 @Override
		public long getNextId() throws ClassNotFoundException, DAOException, IOException  {
			long id = 0;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(SELECT_CORSISTA_SEQ);
				rs.next();
				id = rs.getLong(1);
			} catch(SQLException sql){
				throw new DAOException(sql);
			}
			return id;
		}
}
