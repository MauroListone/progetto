package com.project.businesscomponent.facade;

import java.io.IOException;

import com.project.architecture.dao.DAOException;
import com.project.businesscomponent.CorsistaBC;
import com.project.businesscomponent.model.Corsista;


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

}
