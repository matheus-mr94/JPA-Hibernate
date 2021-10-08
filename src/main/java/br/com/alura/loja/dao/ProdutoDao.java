package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}

	public void remover(Produto produto) {
		produto = em.merge(produto); // garantir que esteja no estado MANAGED
		this.em.remove(produto);
	}

	public Produto bucarPorId(Long id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p ";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome"; // No JPA a consulta é orientada a objetos. nome das entidades e nome dos atributos
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)// nome do parâmetro e o valor que quer substituir
				.getResultList();
	}

	public List<Produto> buscarPorNomeDaCategoria(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";//Por ser um relacionamento a consulta é feita por join mas o JPA realiza isso de forma simplificada
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
}
