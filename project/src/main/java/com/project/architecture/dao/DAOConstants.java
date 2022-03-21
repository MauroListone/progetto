package com.project.architecture.dao;

public interface DAOConstants {
	String SELECT_DOCENTI = "Select * from docente";
	String SELECT_DOCENTE_BY_PK = "Select * from docente where coddocente = ?";
	String SELECT_DOCENTE_MORE_CORSO = "Select nomedocente, count(d.coddocente) from docente d, corso c where d.coddocente = c.coddocente group by nomedocente having count(d.coddocente) > 1";
	
	String SELECT_CORSISTA = "Select * from corsista";
	
	
	String DELETE_CORSISTA = "Delete from corsista where codcorso = ?";
	
	String UPDATE_CORSISTA = "Update corsista set nomecorsista = ? , cognomecorsista = ? where codcorso = ?";
	
	
	String DURATA_MEDIA = "Select avg(datafinecorso-datainiziocorso) from corso";
	
	String SELECT_NOMEADMIN = "Select nomeadmin from admin where nomeadmin = ?";
	String SELECT_COGNOMEADMIN = "Select cognomeadmin from admin where cognomeadmin = ?";
	String SELECT_CODADMIN = "Select codadmin from admin where codadmin = ?";
	
	String SELECT_CORSO = "Select * from corso";
	String DELETE_CORSO = "Delete from corso where codcorso = ?";
	String UPDATE_CORSO = "Update corso set nomecorso = ?, datainiziocorso = ?, datafinecorso = ?, "
			+ "costocorso = ?, commenticorso = ?, aulacorso = ?, coddocente = ?";
	String SELECT_CORSO_BYCOD = "Select * from corso where codcorso = ?";
	String SELECT_ULTIMO_CORSO = "select datainizio corso, nomecorso "
									+ "from corso "
									+ "where datainiziocorso = (select max(datainiziocorso) "
									+ "from corso)";
	String SELECT_DURATA_MEDIA = " select avg(datafinecorso-datainiziocorso) from corso";
	String COMMENTI_CORSO = "select count(*) from corso where commenticorso is not null";
	String SELECT_DOCENTE_MAX_CORSI = "select nomedocente, count(d.coddocente) "
			+ "from docente d, corso c "
			+ "where d.coddocente = c.coddocente "
			+ "group by nomedocente "
			+ "having count(d.coddocente) > 1 "
			+ "order by count(d.coddocente) desc "
			+ "fetch first 1 rows only";
}
