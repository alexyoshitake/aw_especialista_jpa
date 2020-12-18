package com.algaworks.ecommerce.relacionamentos;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.model.PagamentoCartao;
import com.algaworks.model.Pedido;
import com.algaworks.model.StatusPagamento;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

	@Test
	public void verificarRelacionamento() {
		Pedido pedido = entityManager.find(Pedido.class, 1);

		PagamentoCartao pagamento = new PagamentoCartao();
		pagamento.setNumero("1234");
		pagamento.setStatus(StatusPagamento.PROCESSANDO);
		pagamento.setPedido(pedido);

		entityManager.getTransaction().begin();
		entityManager.persist(pagamento);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerificacao.getPagamento());
	}
}
