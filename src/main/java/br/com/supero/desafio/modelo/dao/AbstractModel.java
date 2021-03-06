package br.com.supero.desafio.modelo.dao;

import javax.persistence.EntityManager;

import br.com.supero.desafio.modelo.dao.entidades.Entidade;

public abstract class AbstractModel<T extends Entidade> {


	public void insere(T c) throws Exception {
		try {
			getEm().getTransaction().begin();
			getEm().persist(c);
			getEm().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao inserir dado: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	public void atualiza(T c) throws Exception {
		try {
			getEm().getTransaction().begin();
			getEm().merge(c);
			getEm().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao atualizar dado: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	public void remove(T c) throws Exception {
		try {
			getEm().getTransaction().begin();
			c = getEm().merge(c);
			getEm().remove(c);
			getEm().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao excluir dado: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	public T getPeloId(Integer id) throws Exception {
		T c = null;
		try {
			c = getEm().find(getEntidade(), id);
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar dado pelo ID: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return c;
	}

	public abstract EntityManager getEm();
	
	public abstract Class<T> getEntidade();
	
	

}
