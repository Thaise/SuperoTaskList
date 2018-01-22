package br.com.supero.desafio.controle;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.supero.desafio.controle.util.MensagemUtils;
import br.com.supero.desafio.modelo.dao.AbstractModel;
import br.com.supero.desafio.modelo.dao.TaskModel;
import br.com.supero.desafio.modelo.dao.entidades.Status;
import br.com.supero.desafio.modelo.dao.entidades.Task;

@ViewScoped
@ManagedBean
public class TaskManagedBean extends AbstractManagedBean<Task> {

	private static final String PAGINA_PESQUISA = "index.jsf";
	private Task task;
	@EJB
	private TaskModel taskModel;

	@PostConstruct
	public void init() {
		task = new Task();
		getIdAtualizacao();
	}

	public String insereOuAtualiza() {
		try {
			if (task.getIdTask() == null) {
				task.setStatus(Status.EM_ABERTO);
				task.setDtCriacao(new Date());
				task.setDtEdicao(task.getDtCriacao());
				insere();
			} else {
				task.setDtEdicao(new Date());
				atualiza();
			}
			return PAGINA_PESQUISA;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public String excluir(){
		new TaskManagedBeansUtils().excluir(task, taskModel);
		return PAGINA_PESQUISA;
	}

	public void limpar() {
		task = new Task();
	}

	public String cancelar() {
		return PAGINA_PESQUISA;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@Override
	protected AbstractModel<Task> getModel() {
		return taskModel;
	}

	@Override
	protected Task getEntidade() {
		return task;
	}

	@Override
	protected void setEntidade(Task entidade) {
		setTask(entidade);
	}

}
