package br.fepi.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.fepi.model.Carro;
import br.fepi.model.Cliente;
import br.fepi.model.Locacao;

public class OperacoesApp {

	public static void inserir(EntityManager em) throws ParseException {
		Cliente cliente1 = new Cliente("11111111111", "Robisval Creison");
		Cliente cliente2 = new Cliente("22222222222", "Lindorval Rogério");
		Cliente cliente3 = new Cliente("33333333333", "Silviano Matias");
		
		Carro carro1 = new Carro("Fiat 137", "PPK6969");
		Carro carro2 = new Carro("Brasilia", "KUH2424");
		Carro carro3 = new Carro("Variant", "DST4511");
		
		Locacao locacao1 = new Locacao(cliente2, carro1, new SimpleDateFormat("dd/MM/yy").parse("11/09/2001"), null);
		Locacao locacao2 = new Locacao(cliente1, carro3, new SimpleDateFormat("dd/MM/yy").parse("20/09/2020"), new SimpleDateFormat("dd/MM/yy").parse("20/10/2020"));
		Locacao locacao3 = new Locacao(cliente3, carro2, new SimpleDateFormat("dd/MM/yy").parse("05/03/2020"), null);
		
		em.persist(cliente1);
		em.persist(cliente2);
		em.persist(cliente3);
		
		em.persist(carro1);
		em.persist(carro2);
		em.persist(carro3);
		
		em.persist(locacao1);
		em.persist(locacao2);
		em.persist(locacao3);
	}
	
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			inserir(em);
			et.commit();
			System.out.println("Sucesso na operação!");
		} catch (Exception e) {
			et.rollback();
			System.out.println("Erro na operação"+e.getMessage());
		} 
		  finally {
			em.close();
			emf.close();
		}

	}

}
