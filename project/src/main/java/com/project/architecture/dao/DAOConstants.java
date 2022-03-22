package com.project.architecture.dao;

public interface DAOConstants {
	String SELECT_DOCENTI = "Select * from docente";
	String SELECT_DOCENTE_BY_PK = "Select * from docente where coddocente = ?";
	String SELECT_DOCENTE_MORE_CORSO = "Select nomedocente, count(d.coddocente) from docente d, corso c where d.coddocente = c.coddocente group by nomedocente having count(d.coddocente) > 1";
	
	String SELECT_CORSISTA = "Select * from corsista";
	
	String SELECT_CORSISTA_BY_PK = "Select * from corsista where codcorsista = ?";
	String DELETE_CORSISTA = "Delete from corsista where codcorsista = ?";
	
	String UPDATE_CORSISTA = "Update corsista set nomecorsista = ?, cognomecorsista = ? where codcorsista = ?";
	
	String SELECT_NOMEADMIN = "Select nomeadmin from admin where nomeadmin = ?";
	String SELECT_COGNOMEADMIN = "Select cognomeadmin from admin where cognomeadmin = ?";
	String SELECT_CODADMIN = "Select codadmin from admin where codadmin = ?";
	
	String SELECT_CORSO = "Select * from corso";
	String DELETE_CORSO = "Delete from corso where codcorso = ?";
	String UPDATE_CORSO = "Update corso set nomecorso = ?, datainiziocorso = ?, datafinecorso = ?, "
			+ "costocorso = ?, commenticorso = ?, aulacorso = ?, coddocente = ?, postidisponibili = ? "
			+ "where codcorso = ?";
	String SELECT_CORSO_BYCOD = "Select * from corso where codcorso = ?";
	String SELECT_ULTIMO_CORSO = "select * "
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
	String SELECT_CORSO_SEQ = "Select corso_seq.nextval from dual";
	String SELECT_CORSO_MAX_FREQUENZA = "select * "
			+ "from corso "
			+ "order by postidisponibili asc "
			+ "fetch first 1 rows only";
	String SELECT_CORSI_POSTI_DISPONIBILI = "select * from corso where postidisponibili > 0";
}
