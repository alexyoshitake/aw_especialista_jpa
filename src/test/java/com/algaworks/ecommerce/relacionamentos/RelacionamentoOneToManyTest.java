package com.algaworks.ecommerce.relacionamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.model.Cliente;
import com.algaworks.model.ItemPedido;
import com.algaworks.model.Pedido;
import com.algaworks.model.Produto;
import com.algaworks.model.StatusPedido;

public class RelacionamentoOneToManyTest extends EntityManagerTest {

	@Test
	public void verificarRelacionamento() {
		Cliente cliente = entityManager.find(Cliente.class, 2);

		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setTotal(BigDecimal.TEN);

		pedido.setCliente(cliente);

		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
		Assert.assertFalse(clienteVerificacao.getPedidos().isEmpty());
	}

	@Test
	public void verificarRelacionamentoPedido() {
		Cliente cliente = entityManager.find(Cliente.class, 2);
		Produto produto = entityManager.find(Produto.class, 1);

		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setTotal(BigDecimal.TEN);

		pedido.setCliente(cliente);

		ItemPedido itens = new ItemPedido();
		itens.setPrecoProduto(produto.getValor());
		itens.setQuantidade(1);
		itens.setPedido(pedido);
		itens.setProduto(produto);

		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.persist(itens);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertFalse(pedidoVerificacao.getItens().isEmpty());
	}

}
