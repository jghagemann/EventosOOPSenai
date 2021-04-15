package src.senai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Evento implements Agendamento {

	private String nome;
	private LocalDate data;
	private Usuario organizador;
	private List<Usuario> participantes;
	private String descricao;

	public Evento(String nome, LocalDate data, Usuario organizador, String descricao) {
		this.nome = nome;
		this.data = data;
		this.organizador = organizador;
		this.participantes = new ArrayList<Usuario>();
		this.descricao = descricao;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setData(String data) {
		String format = "dd/MM/yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		this.data = LocalDate.parse(data, formatter);
	}

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}

	public void addParticipante(Usuario participante) {
		this.participantes.add(participante);

	}

	public void deleteParticipante(Usuario participante) {
		this.participantes.remove(participante);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Evento [nome=" + nome + ", data=" + data + ", organizador=" + organizador + "]";
	}

}
