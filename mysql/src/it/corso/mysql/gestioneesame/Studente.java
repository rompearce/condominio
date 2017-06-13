package it.corso.mysql.gestioneesame;

import java.util.Scanner;

public class Studente {

	private String nome;
	private String cognome;
	private int matricola;
	private String data;

	public Studente(String nome, String cognome, int matricola, String data) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + matricola;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Studente other = (Studente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (matricola != other.matricola)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Studente [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", data=" + data + "]";
	}

	public Studente verificaDati() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserire nome studente");
		String nome = scanner.nextLine();
		System.out.println("Inserire cognome studente");
		String cognome = scanner.nextLine();
		// System.out.println("Inserire matricola studente");
		// int matricola = inputInt.nextInt();
		// inputInt.nextLine();
		System.out.println("Inserire la data di nascita dello studente");
		String data = scanner.nextLine();
		Studente studente = new Studente(null, null, 0, null);
		boolean verifica = false;

		if (nome == null) {
			System.out.println("Nome non valido");
			verifica = false;
		}
		if (cognome == null) {
			System.out.println("Cognome non valido");
			verifica = false;
		}
		// if (matricola== 0) {
		// System.out.println("Matricola non valida");
		// verifica=false;
		// }
		if (data == null) {
			System.out.println("Data non valida");
			verifica = false;
		} else {
			System.out.println("Studente Valido");
			verifica = true;
		}
		if (verifica) {
			studente.setNome(nome);
			studente.setCognome(cognome);
			// studente.setMatricola(matricola);
			studente.setData(data);
		}
		return studente;
	}
}
