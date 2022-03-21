package com.project.businesscomponent.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.architecture.dao.DAOConstants;
import com.project.architecture.dao.DAOException;
import com.project.architecture.dbaccess.DBAccess;

public class LoginUtility implements DAOConstants {
	private Connection conn;

	public LoginUtility() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public String getNomeAdmin(String nomeadmin) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_NOMEADMIN);
			ps.setString(1, nomeadmin);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public String getCognomeAdmin(String cognomeadmin) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_COGNOMEADMIN);
			ps.setString(1, cognomeadmin);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public String getAdminCod(String codadmin) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_CODADMIN);
			ps.setString(1, codadmin);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
