package com.project.architecture.dao;

public interface DAOConstants {
	String SELECT_DOCENTI = "Select * from docente";
	String SELECT_DOCENTE_BY_PK = "Select * from docente where coddocente = ?";
	String SELECT_DOCENTE_MORE_CORSO = "Select nomedocente, count(d.coddocente) from docente d, corso c where d.coddocente = c.coddocente group by nomedocente having count(d.coddocente) > 1";
	
	String SELECT_CORSISTA = "Select * from corsista";
	
	
	String DELETE_CORSISTA = "Delete from corsista where codcorso = ?";
	
	String UPDATE_CORSISTA = "Update corsista set nomecorsista = ? , cognomecorsista = ? where codcorso = ?";
	
	
	String DURATA_MEDIA = "Select avg(datafinecorso-datainiziocorso) from corso";
	
	String COMMENTI_CORSO = "Select count(*) from corso where commenticorso IS NOT NULL";
	
	String SELECT_NOMEADMIN = "Select nomeadmin from admin where nomeadmin = ?";
	String SELECT_COGNOMEADMIN = "Select cognomeadmin from admin where cognomeadmin = ?";
	String SELECT_CODADMIN = "Select codadmin from admin where codadmin = ?";
}
