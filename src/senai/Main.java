package src.senai;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		System.out.println("--- Sistema de Eventos ---");
		Usuario usuario1 = new Usuario("João");
		Usuario usuario2 = new Usuario("Maria");
		Usuario usuario3 = new Usuario("Edson");
		
		System.out.println("--- Evento 1 ---");
		EventoPresencial evento1 = new EventoPresencial("Java for Dummies", LocalDate.of(2020, 8, 10), usuario1,
				"Primeiro Evento Presencial", "SENAI/SC", 20);
		evento1.addParticipante(usuario2);
		evento1.addParticipante(usuario3);
		evento1.deleteParticipante(usuario2);
		evento1.setData("12/10/2020");
		System.out.println(evento1);

		System.out.println("--- Evento 2 ---");
		EventoVirtual evento2 = new EventoVirtual("PostgreSQL for Dummies", LocalDate.of(2020, 9, 7), usuario2,
				"Segundo Evento Virtual", "http://eventovirtual.org.br/123");
		evento2.addParticipante(usuario2);
		System.out.println(evento2);

		System.out.println("--- Compromisso ---");
		Compromisso compromisso = new Compromisso("Reunião de Planejamento", LocalDate.of(2020, 10, 10));

		Agendamento[] agendamentos = new Agendamento[3];
		agendamentos[0] = evento1;
		agendamentos[1] = evento2;
		agendamentos[2] = compromisso;

		for (Agendamento agendamento : agendamentos) {
			System.out.println(agendamento);
		}
		System.out.println("--- FIM ---");
	}

}
