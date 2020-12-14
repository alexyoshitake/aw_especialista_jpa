package com.algaworks.ecommerce;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.model.Produto;

public class OperacoesComTransacaoTest extends EntityManagerTest {

	@Test
	public void atualizarObjeto() {
		Produto produto = new Produto();

		produto.setId(1);
		produto.setNome("Kindle Paperwite");
		produto.setDescricao("Conheça o novo Kindle.");
		produto.setValor(new BigDecimal("599"));

		entityManager.getTransaction().begin();
		entityManager.merge(produto);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);
		Assert.assertEquals("Kindle Paperwite", produtoVerificacao.getNome());

	}

	@Test
	public void removerObjeto() {
		Produto produto = entityManager.find(Produto.class, 3);

		entityManager.getTransaction().begin();
		entityManager.remove(produto);
		entityManager.getTransaction().commit();

//		entityManager.clear(); // Não é necessário para operação de remoção

		Produto produtoVerificacao = entityManager.find(Produto.class, 3);
		Assert.assertNull(produtoVerificacao);
	}

	@Test
	public void inserirOPrimeiroObjeto() {

		Produto produto = new Produto();

		produto.setId(2);
		produto.setNome("Câmera Canon");
		produto.setDescricao("A melhor definição para suas fotos!");
		produto.setValor(new BigDecimal("5000"));

		entityManager.getTransaction().begin();
		entityManager.persist(produto);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);

	}

	@Test
	public void abrirEFecharATransacao() {
//		Produto produto = new Produto(); // Somente para o Método não mostrar errros

		entityManager.getTransaction().begin();

//		entityManager.persist(produto);
//		entityManager.merge(produto);
//		entityManager.remove(produto);

		entityManager.getTransaction().commit();

	}
}