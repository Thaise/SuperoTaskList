package br.com.supero.desafio.modelo.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;

import br.com.supero.desafio.modelo.dao.entidades.Task;
import br.com.supero.desafio.modelo.dao.entidades.conexao.ProdutorEntityManager;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TaskModel extends AbstractModel<Task> {

	private EntityManager em;

	public List<Task> busca(Task taskFiltro) throws Exception {
		List<Task> tasks = null;
		try {
			tasks = getEm().createQuery(TaskFiltro.montaQuery(taskFiltro)).getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar Tasks: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return tasks;
	}

	@Override
	public EntityManager getEm() {
		if (em == null)
			em = new ProdutorEntityManager().criaEntityManager();
		return em;
	}

	@Override
	public Class<Task> getEntidade() {
		return Task.class;
	}

}
