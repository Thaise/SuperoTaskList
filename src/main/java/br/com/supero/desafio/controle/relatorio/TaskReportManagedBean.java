package br.com.supero.desafio.controle.relatorio;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.supero.desafio.controle.TaskManagedBeansUtils;
import br.com.supero.desafio.controle.util.MensagemUtils;
import br.com.supero.desafio.modelo.dao.TaskModel;
import br.com.supero.desafio.modelo.dao.entidades.Status;
import br.com.supero.desafio.modelo.dao.entidades.Task;

@ViewScoped
@ManagedBean
public class TaskReportManagedBean implements Serializable {

	@EJB
	private TaskModel taskModel;
	private Task taskFiltro;
	private Task paraDeletar;
	private LazyTaskDataModel lazyModel;
	private List<Status> statusLista = Arrays.asList(Status.values());

	@PostConstruct
	public void init() {
		taskFiltro = new Task();
		lazyModel = new LazyTaskDataModel(taskModel, taskFiltro);
		limpar();
	}

	public String atualiza(Integer id) throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro_task.jsf?id=" + id);
		return null;
	}

	public void selecionaParaDeletar(Task t) {
		setParaDeletar(t);
	}

	public void excluir() {
		new TaskManagedBeansUtils().excluir(paraDeletar, taskModel);
	}

	public void alterarStatus(Task task) {
		try {
			task.setStatus(task.getStatus().equals(Status.EM_ABERTO) ? Status.CONCLUIDA : Status.EM_ABERTO);
			task.setDtConclusao(new Date());
			taskModel.atualiza(task);
			MensagemUtils.mostraMensagemInfo("Status da Task alterado");
		} catch (Exception e) {
			MensagemUtils.mostraMensagemErro("Erro ao alterar status da Task");
		}
	}

	public void limpar() {
		taskFiltro = new Task();
		lazyModel.setTaskFiltro(taskFiltro);
	}

	public void setParaDeletar(Task paraDeletar) {
		this.paraDeletar = paraDeletar;
	}

	public Task getParaDeletar() {
		return paraDeletar;
	}

	public Task getTaskFiltro() {
		return taskFiltro;
	}

	public void setTaskFiltro(Task taskFiltro) {
		this.taskFiltro = taskFiltro;
	}

	public LazyTaskDataModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyTaskDataModel lazyModel) {
		this.lazyModel = lazyModel;
	}

	public List<Status> getStatusLista() {
		return statusLista;
	}

	public void setStatusLista(List<Status> statusLista) {
		this.statusLista = statusLista;
	}

}
