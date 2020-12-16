package com.algaworks.ecommerce;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.model.Produto;

public class OperacoesComTransacaoTest extends EntityManagerTest {

	@Test
	public void mostrarDiferencaPersistMerge() {

		Produto produtoPersist = new Produto();

		produtoPersist.setId(5);
		produtoPersist.setNome("Smartfone One Plus");
		produtoPersist.setDescricao("O processador mais rápido.");
		produtoPersist.setValor(new BigDecimal("2000"));

		entityManager.getTransaction().begin();
		entityManager.persist(produtoPersist);
		produtoPersist.setNome("Smartfone Two Plus");
		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacao = entityManager.find(Produto.class, produtoPersist.getId());
		Assert.assertNotNull(produtoVerificacao);
		
		//
		
		Produto produtoMerge = new Produto();
		
		produtoMerge.setId(6);
		produtoMerge.setNome("Notebook Dell");
		produtoMerge.setDescricao("O melhor da categoria.");
		produtoMerge.setValor(new BigDecimal("2000"));
		
		entityManager.getTransaction().begin();
		produtoMerge = entityManager.merge(produtoMerge);
		produtoMerge.setNome("Notebook Dell 2");
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Produto produtoVerificacaoMerge = entityManager.find(Produto.class, produtoMerge.getId());
		Assert.assertNotNull(produtoVerificacaoMerge);

	}

	@Test
	public void inserirObjetoComMerge() {

		Produto produto = new Produto();

		produto.setId(4);
		produto.setNome("Microfone Rode Videmic");
		produto.setDescricao("A melhor qualidade de Som!");
		produto.setValor(new BigDecimal("1000"));

		entityManager.getTransaction().begin();
		entityManager.merge(produto);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertNotNull(produtoVerificacao);

	}

	@Test
	public void atualizarObjetoGerenciado() {
		Produto produto = entityManager.find(Produto.class, 1);

		entityManager.getTransaction().begin();
		produto.setNome("Kindle Paperwite 2ª geração");
		produto.setValor(new BigDecimal("599"));
		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		Assert.assertEquals("Kindle Paperwite 2ª geração", produtoVerificacao.getNome());
		Assert.assertEquals(new BigDecimal("599").setScale(2), produtoVerificacao.getValor());

	}

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
