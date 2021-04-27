package src.senai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Evento implements Agendamento {

	private String nome;
	private LocalDate data;
	private Usuario organizador;
	private List<Usuario> participantes;
	private String descricao;
	private CategoriaEventoEnum categoriaEvento;

	/**
	 * Construtor padrão
	 * 
	 * @param nome        do evento
	 * @param data        do evento
	 * @param organizador do evento
	 * @param descricao   do evento
	 */

	public Evento(String nome, LocalDate data, Usuario organizador, String descricao) {
		this.nome = nome;
		this.data = data;
		this.organizador = organizador;
		this.participantes = new MeuArrayList<Usuario>();
		this.descricao = descricao;
		this.categoriaEvento = CategoriaEventoEnum.PALESTRA;

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
		if (participante == this.organizador) {
			throw new RuntimeException("O participante informado é o organizador do evento");
		}
		this.verificarLimitesPacote();
		this.participantes.add(participante);

	}

	public void deleteParticipante(Usuario participante) {
		this.participantes.remove(participante);
	}

	public int getQuantidadeParticipantes() {
		return this.participantes.size();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaEventoEnum getCategoriaEvento() {
		return categoriaEvento;
	}

	public void setCategoriaEvento(CategoriaEventoEnum categoriaEvento) {
		this.categoriaEvento = categoriaEvento;
	}

	protected void verificarLimitesPacote() {
		switch (this.organizador.getPacote()) {
		case GRATUITO:
			if (participantes.size() > 30) {
				throw new RuntimeException("O pacote gratuito permite eventos até 30 participantes");
			}
			break;

		case BASICO:
			if (participantes.size() > 100) {
				throw new RuntimeException("O pacote básico permite eventos até 30 participantes");
			}
			break;

		case PROFISSIONAL:
			if (participantes.size() > 500) {
				throw new RuntimeException("O pacote profissional permite eventos até 500 participantes");
			}
			break;

		default:
			break;
		}
	}

	protected void verificarCategoriaEvento() {
		switch (this.getCategoriaEvento()) {
		case PALESTRA:
			System.out.println("O evento é uma palestra");
			break;

		case SIMPOSIO:
			System.out.println("O evento é um simpósio");
			break;

		case SHOW:
			System.out.println("O evento é um show");
			break;

		case MEETUP:
			System.out.println("O evento é um meetup");
			break;

		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "Evento [nome=" + nome + ", data=" + data + ", organizador=" + organizador + ", parcicipantes= "
				+ participantes + "]";
	}

}
