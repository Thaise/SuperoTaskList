package br.com.supero.desafio.controle;

import java.util.Date;

import br.com.supero.desafio.controle.util.MensagemUtils;
import br.com.supero.desafio.modelo.dao.TaskModel;
import br.com.supero.desafio.modelo.dao.entidades.Status;
import br.com.supero.desafio.modelo.dao.entidades.Task;

public class TaskManagedBeansUtils  {
	
	public void excluir(Task task, TaskModel model) {
		try {
			task.setFlExcluido(1);
			model.atualiza(task);
			MensagemUtils.mostraMensagem("Task excluída com sucesso", false);
		} catch (Exception e) {
			MensagemUtils.mostraMensagem("Erro ao excluir Task", true);
		}
	}
}
