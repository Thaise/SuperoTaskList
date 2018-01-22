package br.com.supero.desafio.controle.relatorio;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.supero.desafio.modelo.dao.TaskModel;
import br.com.supero.desafio.modelo.dao.entidades.Task;

public class LazyTaskDataModel extends LazyDataModel<Task> {

	private List<Task> datasource;
	private Task taskFiltro;
	private TaskModel taskModel;

	public LazyTaskDataModel(TaskModel taskModel, Task taskFiltro) {
		this.taskModel = taskModel;
		this.taskFiltro = taskFiltro;
	}

	@Override
	public Task getRowData(String rowKey) {
		for (Task task : datasource) {
			if (task.getIdTask().equals(rowKey))
				return task;
		}

		return null;
	}

	@Override
	public Object getRowKey(Task car) {
		return car.getIdTask();
	}

	@Override
	public List<Task> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Task> data = null;
		try {
			data =  taskModel.busca(taskFiltro);
			
			int dataSize = data.size();
			this.setRowCount(dataSize);

			if (dataSize > pageSize) {
				try {
					return data.subList(first, first + pageSize);
				} catch (IndexOutOfBoundsException e) {
					return data.subList(first, first + (dataSize % pageSize));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public void setTaskFiltro(Task taskFiltro) {
		this.taskFiltro = taskFiltro;
	}
}