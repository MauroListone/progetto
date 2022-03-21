package com.project.architecture.dao;

public interface DAOConstants {
	public static String SELECT_DOCENTI = "Select * from docente";
	public static String SELECT_DOCENTE_BY_PK = "Select * from docente where coddocente = ?";
	public static String SELECT_DOCENTE_MORE_CORSO = "Select nomedocente, count(d.coddocente) from docente d, corso c where d.coddocente = c.coddocente group by nomedocente having count(d.coddocente) > 1";
}
