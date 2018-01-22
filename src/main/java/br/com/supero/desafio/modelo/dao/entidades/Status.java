package br.com.supero.desafio.modelo.dao.entidades;

public enum Status {

	EM_ABERTO("Em aberto"), CONCLUIDA("Concluída");

	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
