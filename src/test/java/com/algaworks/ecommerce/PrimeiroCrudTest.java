package com.algaworks.ecommerce;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.model.Cliente;

public class PrimeiroCrudTest extends EntityManagerTest {

	@Test
	public void inserirRegistro() {
		Cliente cliente = new Cliente();

		cliente.setNome("João da Silva Sauro");

		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
		Assert.assertNotNull(clienteVerificacao);

	}

	@Test
	public void buscarPorIdentificador() {
		Cliente cliente = entityManager.find(Cliente.class, 2);

		Assert.assertNotNull(cliente);
		Assert.assertEquals("Paulo Ricardo", cliente.getNome());
	}

	@Test
	public void atualizarRegistro() {
		Cliente cliente = entityManager.find(Cliente.class, 3);

		cliente.setNome("Felipe da Silva Filho");

		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
		Assert.assertEquals("Felipe da Silva Filho", clienteVerificacao.getNome());
	}

	@Test
	public void removerRegistro() {
		Cliente cliente = entityManager.find(Cliente.class, 4);

		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
		Assert.assertNull(clienteVerificacao);

	}
}
