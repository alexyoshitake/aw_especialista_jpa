package com.algaworks.ecommerce.mapeamentobasico;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.model.Categoria;

public class EstrategiaChavePrimariaTeste extends EntityManagerTest {

	@Test
	public void testarEstrategiaAuto() {
		Categoria categoria = new Categoria();
		categoria.setNome("Eletrônicos");

		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
		Assert.assertNotNull(categoriaVerificacao);
	}

}
