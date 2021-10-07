package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence
			.createEntityManagerFactory("loja");// � o nome passado no persistence-unit
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	

}
