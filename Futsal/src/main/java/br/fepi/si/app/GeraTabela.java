package br.fepi.si.app;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabela {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("futsalPU");
		emf.close();
	}
}