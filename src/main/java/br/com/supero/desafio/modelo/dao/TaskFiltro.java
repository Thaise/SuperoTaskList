package br.com.supero.desafio.modelo.dao;

import java.util.ArrayList;

import br.com.supero.desafio.modelo.dao.entidades.Task;

public class TaskFiltro {

	public static String montaQuery(Task produtoFiltro) {
		String queryFinal = "select t from Task t WHERE t.flExcluido = 0 ";
		ArrayList<String> query = new ArrayList<String>();

		if (!estaVazio(produtoFiltro.getTitulo())) {
			query.add("t.titulo like '%" + produtoFiltro.getTitulo() + "%'");
		}

		if (produtoFiltro.getStatus() != null) {
			query.add("t.status = "+produtoFiltro.getStatus().ordinal());
		}

		if (!query.isEmpty()) {
			for (String s : query) {
				queryFinal += " AND " + s;
			}
		}

		return queryFinal;
	}

	private static boolean estaVazio(String valor) {
		return valor == null || valor.isEmpty();
	}

}
