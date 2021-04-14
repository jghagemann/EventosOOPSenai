package src.senai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Evento {

	private String nome;
	private LocalDate data;
	private Usuario organizador;
	private Usuario[] participantes;
	private int posicaoParticipantes = 0;
	private String descricao;

	public Evento(String nome, LocalDate data, Usuario organizador, String descricao) {
		this.nome = nome;
		this.data = data;
		this.organizador = organizador;
		this.participantes = new Usuario[10];
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
		this.participantes[this.posicaoParticipantes] = participante;
		this.posicaoParticipantes++;
	}

	public void deleteParticipante(Usuario participante) {
		for (int i = 0; i < participantes.length; i++) {
			if (participantes[i] == participante) {
				Arrays.asList(participantes).remove(participantes[i]);
			}
			this.posicaoParticipantes--;
		}

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
