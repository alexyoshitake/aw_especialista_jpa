package com.algaworks.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.model.Produto;

public class IniciarUnidadeDePersistencia {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Produto produto = em.find(Produto.class, 1);
		System.out.println(produto.getNome());
		
		em.close();
		entityManagerFactory.close();
	}

}
