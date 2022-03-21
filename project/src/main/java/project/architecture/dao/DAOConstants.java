package project.architecture.dao;

public interface DAOConstants {
	public static String SELECT_DOCENTI = "Select * from docente";
	public static String SELECT_DOCENTE_BY_PK = "Select * from docente where coddocente = ?";
	public static String SELECT_CORSI_FOR_DOCENTE = "Select nomecorso from corso where coddocente = ?";
}
