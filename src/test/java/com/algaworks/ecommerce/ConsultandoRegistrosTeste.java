package com.algaworks.ecommerce;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.model.Produto;

public class ConsultandoRegistrosTeste extends EntityManagerTest {

	@Test
	public void buscarPorIdentificador() {
		Produto produto = entityManager.find(Produto.class, 1);
//		Produto produto = entityManager.getReference(Produto.class, 1);

		Assert.assertNotNull(produto);
		Assert.assertEquals("Kindle", produto.getNome());
	}

	@Test
	public void atualizarAReferencia() {
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setNome("Microfone Samson");

		entityManager.refresh(produto);

		Assert.assertEquals("Kindle", produto.getNome());
	}

}
