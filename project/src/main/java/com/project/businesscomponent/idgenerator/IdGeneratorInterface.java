package com.project.businesscomponent.idgenerator;

import java.io.IOException;

import com.project.architecture.dao.DAOException;

public interface IdGeneratorInterface {

	/**
	 * Quando ci sono le sequenze in oracle questi componenti ci sono sempre
	 * un metodo che deve avere è quello che ritorna un long e si chiama getNextId(), deve rilanciare 
	 * le eccezzioni perchè si deve comunque connettere al db per avere il valore della sequenza
	 * sul generatore di id si implementa un singleton di modo che controlliamo di non avere più istante cntemporaneamente
	 */
	long getNextId() throws ClassNotFoundException, DAOException, IOException;
}
