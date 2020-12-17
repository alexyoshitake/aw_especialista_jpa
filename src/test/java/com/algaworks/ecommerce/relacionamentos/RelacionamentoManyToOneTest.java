package com.algaworks.ecommerce.relacionamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.model.Cliente;
import com.algaworks.model.Pedido;
import com.algaworks.model.StatusPedido;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

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

		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerificacao.getCliente());
	}

}
