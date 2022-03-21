package com.project.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.businesscomponent.model.Docente;

public class DocentiDAO implements DAOConstants{
	private Statement stmt;
	private ResultSet rs;
	
	public static DocentiDAO getFactory() {
		return new DocentiDAO();
	}
	
	private DocentiDAO() {
		
	}
	
	public Docente findByPk(Connection conn, byte codDocente) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SELECT_DOCENTE_BY_PK);
		ps.setByte(1, codDocente);
		Docente docente = new Docente();
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			docente.setCodDocente(rs.getByte(1));
			docente.setNome(rs.getString(2));
			docente.setCognome(rs.getString(3));
			docente.setCv(rs.getString(4));
		}
		return docente;
	}
	
	public ArrayList<Docente> getDocenti(Connection conn) throws SQLException {
		stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery(SELECT_DOCENTI);
		ArrayList<Docente> lista = new ArrayList<Docente>();
		rs.beforeFirst();
		while(rs.next()) {
			Docente docente = new Docente();
			docente.setCodDocente(rs.getByte(1));
			docente.setNome(rs.getString(2));
			docente.setCognome(rs.getString(3));
			docente.setCv(rs.getString(4));
			lista.add(docente);
		}
		return lista;
	}
	
	public ArrayList<Docente> moreThanOne(Connection conn) throws SQLException {
		stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery(SELECT_DOCENTE_MORE_CORSO);
		ArrayList<Docente> lista = new ArrayList<Docente>();
		rs.beforeFirst();
		while(rs.next()) {
			Docente docente = new Docente();
			docente.setCodDocente(rs.getByte(1));
			docente.setNome(rs.getString(2));
			docente.setCognome(rs.getString(3));
			docente.setCv(rs.getString(4));
			lista.add(docente);
		}
		return lista;
	}
}
