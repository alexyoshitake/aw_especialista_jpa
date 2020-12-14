package com.algaworks.ecommerce;

import org.junit.Test;

import com.algaworks.model.Produto;

public class OperacoesComTransacaoTest extends EntityManagerTest {

	@Test
	public void abrirEFecharATransacao() {
		Produto produto = new Produto(); // Somente para o Método não mostrar errros

		entityManager.getTransaction().begin();

		entityManager.persist(produto);
		entityManager.merge(produto);
		entityManager.remove(produto);

		entityManager.getTransaction().commit();

	}
}
