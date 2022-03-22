package com.project.businesscomponent.facade;

import java.io.IOException;

import com.project.architecture.dao.DAOException;
import com.project.businesscomponent.CorsistaBC;
import com.project.businesscomponent.CorsoBC;
import com.project.businesscomponent.model.Corsista;
import com.project.businesscomponent.model.Corso;


//Nella facade implemento il singleton

public class CorsistaFacade {
	
	private static CorsistaFacade cF;
	
	private CorsistaFacade() {	
	}
	
	public static CorsistaFacade getInstance() {
		 if(cF == null)
			 cF = new CorsistaFacade();
		 return cF;
	}
	
	//fine singleton
	
	//devo fare una lista dei metodi che il client potrà usare
	
	public Corsista[] getCorsisti() 
			throws DAOException, ClassNotFoundException, IOException {
		CorsistaBC aBC = new CorsistaBC();
		return aBC.getCorsisti(); 
	}

	public void createCorsista(Corsista corsista) 
			throws DAOException, ClassNotFoundException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		cBC.create(corsista);
	}
	
	public Corso[] getCorsi() 
			throws DAOException, ClassNotFoundException, IOException {
		CorsoBC cBC = new CorsoBC();
		return cBC.getCorsi(); 
	}

	

}
