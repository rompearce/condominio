package gestionale.condominio;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ServicesCrud crud = new ServicesCrud("jpa-example");
		Gestionale gest = new Gestionale();
		Statistiche stat = new Statistiche();
		while (true) {
			System.out.println(
					"1-per gestire i Proprietari\n" + "2-per gestire i Condomini\n" + "3-per gestire gli appartamenti\n"
							+ "4-per le statistiche");
			int scelta = scanner.nextInt();
			scanner.nextLine();
			switch (scelta) {
			case 1:
				System.out.println("1 - Per inserire un nuovo proprietario\n"
						+ "2 - Per vedere l'elenco dei proprietari\n" + "3 - Per modificare i dati di un proprietario\n"
						+ "4 - Per eliminare un proprietario\n" + "5 - Per terminare");
				int sceltaProprietario = scanner.nextInt();
				scanner.nextLine();
				switch (sceltaProprietario) {
				case 1:
					while (sceltaProprietario == 1) {
						gest.inserimentoProprietario(scanner, crud);
						System.out.println(
								"1 - Per inserire un nuovo proprietario\n" + "2 - Per vedere l'elenco dei proprietari\n"
										+ "3 - Per modificare i dati di un proprietario\n"
										+ "4 - Per eliminare un proprietario\n" + "5 - Per terminare");
						sceltaProprietario = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				case 2:
					while (sceltaProprietario == 2) {
						gest.listaProprietari(crud);
						System.out.println(
								"1 - Per inserire un nuovo proprietario\n" + "2 - Per vedere l'elenco dei proprietari\n"
										+ "3 - Per modificare i dati di un proprietario\n"
										+ "4 - Per eliminare un proprietario\n" + "5 - Per terminare");
						sceltaProprietario = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				case 3:
					while (sceltaProprietario == 3) {
						gest.modificaProprietario(scanner, crud);
						System.out.println(
								"1 - Per inserire un nuovo proprietario\n" + "2 - Per vedere l'elenco dei proprietari\n"
										+ "3 - Per modificare i dati di un proprietario\n"
										+ "4 - Per eliminare un proprietario\n" + "5 - Per terminare");
						sceltaProprietario = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				case 4:
					while (sceltaProprietario == 4) {
						gest.eliminaProprietario(scanner, crud);
						System.out.println(
								"1 - Per inserire un nuovo proprietario\n" + "2 - Per vedere l'elenco dei proprietari\n"
										+ "3 - Per modificare i dati di un proprietario\n"
										+ "4 - Per eliminare un proprietario\n" + "5 - Per terminare");
						sceltaProprietario = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				default:
					break;
				}
				break;
			case 2:
				System.out.println("1 - Per inserire un nuovo condominio\n" + "2 - Per vedere l'elenco dei condominio\n"
						+ "3 - Per modificare i dati di un condominio\n" + "4 - Per eliminare un condominio\n"
						+ "5 - Per terminare");
				int sceltaCondominio = scanner.nextInt();
				scanner.nextLine();
				switch (sceltaCondominio) {
				case 1:
					while (sceltaCondominio == 1) {
						gest.inserimentoCondominio(scanner, crud);
						System.out.println(
								"1 - Per inserire un nuovo condominio\n" + "2 - Per vedere l'elenco dei condominio\n"
										+ "3 - Per modificare i dati di un condominio\n"
										+ "4 - Per eliminare un condominio\n" + "5 - Per terminare");
						sceltaCondominio = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				case 2:
					while (sceltaCondominio == 2) {
						gest.listaCondomini(crud);
						System.out.println(
								"1 - Per inserire un nuovo condominio\n" + "2 - Per vedere l'elenco dei condominio\n"
										+ "3 - Per modificare i dati di un condominio\n"
										+ "4 - Per eliminare un condominio\n" + "5 - Per terminare");
						sceltaCondominio= scanner.nextInt();
						scanner.nextLine();
					}
					break;
				case 3:
					while (sceltaCondominio == 3) {
						gest.modificaCondominio(scanner, crud);
						System.out.println(
								"1 - Per inserire un nuovo condominio\n" + "2 - Per vedere l'elenco dei condominio\n"
										+ "3 - Per modificare i dati di un condominio\n"
										+ "4 - Per eliminare un condominio\n" + "5 - Per terminare");
						sceltaCondominio = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				case 4:
					while (sceltaCondominio == 1) {
						gest.eliminaCondominio(scanner, crud);
						System.out.println(
								"1 - Per inserire un nuovo condominio\n" + "2 - Per vedere l'elenco dei condominio\n"
										+ "3 - Per modificare i dati di un condominio\n"
										+ "4 - Per eliminare un condominio\n" + "5 - Per terminare");
						sceltaCondominio = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				default:
					break;
				}
				break;
			case 3:
				System.out.println(
						"1 - Per inserire un nuovo Appartamento\n" + "2 - Per vedere l'elenco degli Appartamento\n"
								+ "3 - Per modificare i dati di un Appartamento\n"
								+ "4 - Per eliminare un Appartamento\n" + "5 - Per terminare");
				int sceltaAppartamento = scanner.nextInt();
				scanner.nextLine();
				switch (sceltaAppartamento) {
				case 1:
					while (sceltaAppartamento == 1) {
						gest.inserimentoAppartamento(scanner, crud);
						System.out.println("1 - Per inserire un nuovo Appartamento\n"
								+ "2 - Per vedere l'elenco degli Appartamento\n"
								+ "3 - Per modificare i dati di un Appartamento\n"
								+ "4 - Per eliminare un Appartamento\n" + "5 - Per terminare");
						sceltaAppartamento = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				case 2:
					while (sceltaAppartamento == 2) {
						gest.listaAppartamenti(crud);
						System.out.println("1 - Per inserire un nuovo Appartamento\n"
								+ "2 - Per vedere l'elenco degli Appartamento\n"
								+ "3 - Per modificare i dati di un Appartamento\n"
								+ "4 - Per eliminare un Appartamento\n" + "5 - Per terminare");
						sceltaAppartamento = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				case 3:
					while (sceltaAppartamento == 3) {
						gest.modificaAppartamento(scanner, crud);
						System.out.println("1 - Per inserire un nuovo Appartamento\n"
								+ "2 - Per vedere l'elenco degli Appartamento\n"
								+ "3 - Per modificare i dati di un Appartamento\n"
								+ "4 - Per eliminare un Appartamento\n" + "5 - Per terminare");
						sceltaAppartamento = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				case 4:
					while (sceltaAppartamento == 4) {
						gest.eliminaAppartamento(scanner, crud);
						System.out.println("1 - Per inserire un nuovo Appartamento\n"
								+ "2 - Per vedere l'elenco degli Appartamento\n"
								+ "3 - Per modificare i dati di un Appartamento\n"
								+ "4 - Per eliminare un Appartamento\n" + "5 - Per terminare");
						sceltaAppartamento = scanner.nextInt();
						scanner.nextLine();
					}
					break;
				default:
					break;
				}
				break;
			case 4:
				System.out.println("1-per sapere la spesa di un proprietario\n"
						+ "2 - per sapere il condominio più caro\n"
						+ "3 - per saper l'appartamento più costoso\n"
						+ "4 - per conoscere il costo medio di un condominio\n"
						+ "5 -  per terminare");
				int sceltaStatistica = scanner.nextInt();
				scanner.nextLine();
				switch (sceltaStatistica) {
				case 1:
					stat.pagaProprietario(scanner, crud);
					
					break;
				case 2:
					stat.condominioCaro(scanner, crud);
					
					break;
				case 3:
					stat.appartamentoCaro(scanner, crud);
					
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
	}
}
