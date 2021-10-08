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
	
	public List<Produto> buscarTodos(){
		String jpql = "SELECT p FROM Produto p ";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
}
