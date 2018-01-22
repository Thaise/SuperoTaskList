package br.com.supero.desafio.modelo.dao.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task implements Entidade {

	public static final String BUSCA_GERAL = "buscaGeral";
	public static final String BUSCA_POR_TITULO = "buscaPorTitulo";
	public static final String BUSCA_POR_CONCLUIDAS = "buscaPorConcluidas";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_task")
	private Integer idTask;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "status_atual")
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "dt_criacao")
	private Date dtCriacao;

	@Column(name = "dt_edicao")
	private Date dtEdicao;

	@Column(name = "dt_conclusao")
	private Date dtConclusao;

	@Column(name = "fl_excluido")
	private int flExcluido;

	public Integer getIdTask() {
		return idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Date getDtEdicao() {
		return dtEdicao;
	}

	public void setDtEdicao(Date dtEdicao) {
		this.dtEdicao = dtEdicao;
	}

	public Date getDtConclusao() {
		return dtConclusao;
	}

	public void setDtConclusao(Date dtConclusao) {
		this.dtConclusao = dtConclusao;
	}

	public int getFlExcluido() {
		return flExcluido;
	}

	public void setFlExcluido(int flExcluido) {
		this.flExcluido = flExcluido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dtConclusao == null) ? 0 : dtConclusao.hashCode());
		result = prime * result + ((dtCriacao == null) ? 0 : dtCriacao.hashCode());
		result = prime * result + ((dtEdicao == null) ? 0 : dtEdicao.hashCode());
		result = prime * result + flExcluido;
		result = prime * result + ((idTask == null) ? 0 : idTask.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dtConclusao == null) {
			if (other.dtConclusao != null)
				return false;
		} else if (!dtConclusao.equals(other.dtConclusao))
			return false;
		if (dtCriacao == null) {
			if (other.dtCriacao != null)
				return false;
		} else if (!dtCriacao.equals(other.dtCriacao))
			return false;
		if (dtEdicao == null) {
			if (other.dtEdicao != null)
				return false;
		} else if (!dtEdicao.equals(other.dtEdicao))
			return false;
		if (flExcluido != other.flExcluido)
			return false;
		if (idTask == null) {
			if (other.idTask != null)
				return false;
		} else if (!idTask.equals(other.idTask))
			return false;
		if (status != other.status)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [idTask=" + idTask + ", titulo=" + titulo + ", status=" + status + ", descricao=" + descricao
				+ ", dtCriacao=" + dtCriacao + ", dtEdicao=" + dtEdicao + ", dtConclusao=" + dtConclusao
				+ ", flExcluido=" + flExcluido + "]";
	}

}
