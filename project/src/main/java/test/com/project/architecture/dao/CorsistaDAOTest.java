package test.com.project.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.project.architecture.dao.CorsistaDAO;
import com.project.architecture.dao.DAOException;
import com.project.architecture.dbaccess.DBAccess;
import com.project.businesscomponent.model.Corsista;


@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {
	
	private static Corsista corsista;
	private static Connection conn;

	/**
	 * creo dei dati fittizzi per eseguire il test
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodcorsista(5);//perchè prima ne ho creati 5
		corsista.setNomecorsista("Jorge");
		corsista.setCognomecorsista("Bergoglio");
		corsista.setPrecedentiformativi("laurea");
	}

	
	
	//ho più test quindi li ordino cosi prima create poi update ecc...
	
		@Test
		@Order(1)
		void testCreate() {
			try {
				CorsistaDAO.getFactory().create(conn, corsista);
				System.out.println("Creato Corsista");
			} catch (Exception exc) {
				exc.printStackTrace();
				fail("Create articolo fallito");
			}
		}
		
		@Test
		@Order(2)
		void testUpdateGetById() {
			try {
				corsista = new Corsista();
				corsista.setCodcorsista(5); //deve prendere l'id di un corsista esistente
				corsista.setNomecorsista("Joseph");
				corsista.setCognomecorsista("Ratzinger");
				corsista.setPrecedentiformativi("diploma");
				
				CorsistaDAO.getFactory().update(conn, corsista);
				System.out.println("Corsista Modificato");
				
				Corsista cors = CorsistaDAO.getFactory().getByCod(conn, 5);
				System.out.println(cors.toString());
				
			} catch (Exception exc) {
				exc.printStackTrace();
				fail(exc.getMessage());
			}
		}
		
		
		@Test
		@Order(3)
		void testGetAll() {
			try {
				Corsista[] articoli = CorsistaDAO.getFactory().getAll(conn);
				assertNotNull(articoli);
			} catch (DAOException exc) {
				exc.printStackTrace();
				fail("Recupero getAll fallito");
			}
			
		}
	
	/**
	 * elimino i dati fittizi dopo aver eseguito il test
	 * @throws Exception
	 */
	
	
	  @AfterAll static void tearDownAfterClass() throws Exception {
	  
	  try { CorsistaDAO.getFactory().delete(conn, corsista); corsista = null;
	  System.out.println("Delete funzionante"); } catch (DAOException exc) {
	  exc.printStackTrace(); fail("Recupero getAll fallito"); } }
	 
	 

	

}
