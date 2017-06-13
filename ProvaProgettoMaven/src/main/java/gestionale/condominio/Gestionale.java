package gestionale.condominio;

import java.awt.geom.FlatteningPathIterator;
import java.util.List;
import java.util.Scanner;

public class Gestionale {

	public void inserimentoProprietario(Scanner scanner, ServicesCrud crud) {
		// String regexCF = "[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]";
		System.out.println("Inserire il cognome del proprietario");
		String cognome = scanner.nextLine();
		System.out.println("Inserire il nome del proprietario");
		String nome = scanner.nextLine();
		boolean flag = true;
		while (flag == true) {
			System.out.println("Inserire il Codice Fiscale del proprietario");
			String codiceFiscale = scanner.nextLine();
			Proprietario nuovoProprietario = new Proprietario();
			if (nuovoProprietario.verificaCodFiscale(codiceFiscale) == true) {
				nuovoProprietario.setNome(nome);
				nuovoProprietario.setCognome(cognome);
				nuovoProprietario.setCodicefiscale(codiceFiscale);
				crud.jpaCreate(nuovoProprietario);
				// System.out.println(nuovoProprietario);
				flag = false;
			} else {
				System.out.println("Codice Fiscale non valido");
			}
		}
	}

	public void modificaProprietario(Scanner scanner, ServicesCrud crud) {
		listaProprietari(crud);
		System.out.println("Inserire l'id del proprietario da modificare");
		int idProprietarioModifica = scanner.nextInt();
		scanner.nextLine();
		Proprietario proprietarioModifica = (Proprietario) crud
				.jpaRead("select p from Proprietario p where idProprietario = " + idProprietarioModifica)
				.getSingleResult();
		System.out.println(
				"1-per modificare il nome\n" + "2-per modificare il cognome\n" + "3-per modificare il codice fiscale");
		int modifica = scanner.nextInt();
		scanner.nextLine();
		switch (modifica) {
		case 1:
			System.out.println("Inserire il nuovo nome");
			String nuovoNome = scanner.nextLine();
			proprietarioModifica.setNome(nuovoNome);
			break;
		case 2:
			System.out.println("Inserire il nuovo cognome");
			String nuovoCognome = scanner.nextLine();
			proprietarioModifica.setCognome(nuovoCognome);
			break;
		case 3:
			boolean flag = false;
			while (flag == false) {
				System.out.println("Inserire il nuovo codice fiscale");
				String nuovoCodFiscale = scanner.nextLine();
				if (proprietarioModifica.verificaCodFiscale(nuovoCodFiscale)) {
					proprietarioModifica.setCodicefiscale(nuovoCodFiscale);
					flag = true;
				} else {
					System.out.println("Codice fiscale non valido");
					flag = false;
				}

			}
			break;
		default:
			break;
		}
		crud.jpaUpdate(proprietarioModifica);
	}

	public void listaProprietari(ServicesCrud crud) {
		List listaProprietari = crud.jpaRead("select p from Proprietario p").getResultList();
		listaProprietari.stream().forEach(System.out::println);
	}

	public void eliminaProprietario(Scanner scanner, ServicesCrud crud){
		listaProprietari(crud);
		System.out.println("Inserire l'id del proprietario da eliminare");
		int idProprietarioElimina = scanner.nextInt();
		scanner.nextLine();
		Proprietario proprietarioElimina = (Proprietario) crud
				.jpaRead("select p from Proprietario p where idProprietario = " + idProprietarioElimina)
				.getSingleResult();
		crud.jpaDelete(proprietarioElimina);
	}

	public void inserimentoCondominio(Scanner scanner, ServicesCrud crud){
		System.out.println("Inserire il nome del Condominio");
		String nome = scanner.nextLine();
		System.out.println("Inserire il numero di appartamenti del Condominio");
		int numeroAppartamenti = scanner.nextInt();
		scanner.nextLine();
		Condominio nuovoCondominio = new Condominio();		
		nuovoCondominio.setNome(nome);
		nuovoCondominio.setNumeroAppartamenti(numeroAppartamenti);
		nuovoCondominio.setSuperficieTot(0);
		crud.jpaCreate(nuovoCondominio);
				// System.out.println(nuovoCondominio);
}

	public void listaCondomini(ServicesCrud crud){
		List listaCondomini= crud.jpaRead("select c from Condominio c").getResultList();
		listaCondomini.stream().forEach(System.out::println);
	}

	public void modificaCondominio(Scanner scanner, ServicesCrud crud) {
		listaCondomini(crud);
		System.out.println("Inserire l'id del Condominio da modificare");
		int idCondominioModifica = scanner.nextInt();
		scanner.nextLine();
		Condominio condominioModifica = (Condominio) crud
				.jpaRead("select c from Condominio c where idCondominio = " + idCondominioModifica)
				.getSingleResult();
		System.out.println(
				"1-per modificare il nome\n" + "2-per modificare il numero di appartamenti\n" + "3-per terminare");
		int modifica = scanner.nextInt();
		scanner.nextLine();
		switch (modifica) {
		case 1:
			System.out.println("Inserire il nuovo nome");
			String nuovoNome = scanner.nextLine();
			condominioModifica.setNome(nuovoNome);
			break;
		case 2:
			System.out.println("Inserire il nuovo numero di appartamenti");
			int nuovoNumeroAppartamenti= scanner.nextInt();
			scanner.nextLine();
			condominioModifica.setNumeroAppartamenti(nuovoNumeroAppartamenti);
			break;
		default:
			break;
		}
		crud.jpaUpdate(condominioModifica);
	}	

	public void eliminaCondominio(Scanner scanner, ServicesCrud crud){
		listaCondomini(crud);
		System.out.println("Inserire l'id del Condominio da eliminare");
		int idCondominioElimina = scanner.nextInt();
		scanner.nextLine();
		Condominio condominioElimina = (Condominio) crud
				.jpaRead("select p from Condominio p where idCondominio = " + idCondominioElimina)
				.getSingleResult();
		crud.jpaDelete(condominioElimina);
	}

	public void inserimentoAppartamento(Scanner scanner, ServicesCrud crud) {
		listaCondomini(crud);
		System.out.println("Inserire l'id del Condominio a cui associare l'appartamento");
		int idCondominio = scanner.nextInt();
		scanner.nextLine();
		Condominio condominio = (Condominio) crud
				.jpaRead("select c from Condominio c where idCondominio = " + idCondominio)
				.getSingleResult();
		System.out.println("Inserire l'id del Proprietario a cui associare l'appartamento");
		int idProprieatrio = scanner.nextInt();
		scanner.nextLine();
		Proprietario proprietario= (Proprietario) crud
				.jpaRead("select p from Proprietario p where idProprietario = " + idProprieatrio)
				.getSingleResult();
		System.out.println("Inserire la dimensione dell'appartamento");
		double dimensione = scanner.nextInt();
				scanner.nextLine();
				Appartamento nuovoAppartamento = new Appartamento();
				nuovoAppartamento.setIdCondominio(condominio);
				condominio.getListaAppartamenti().add(nuovoAppartamento);
				nuovoAppartamento.setIdProprietario(proprietario);
				proprietario.getListaAppartamenti().add(nuovoAppartamento);
				nuovoAppartamento.setDimensione(dimensione);
				nuovoAppartamento.setCostoTotManutenzione(nuovoAppartamento.calcoloCostoTotManutenzione(dimensione));
				condominio.setSuperficieTot(condominio.calcoloSuperficie(condominio.getListaAppartamenti()));
				crud.jpaCreate(nuovoAppartamento);
				crud.jpaUpdate(condominio);
				// System.out.println(nuovoAppartamento);
				
		}
	
	public void modificaAppartamento(Scanner scanner, ServicesCrud crud) {

		listaAppartamenti(crud);
		System.out.println("Inserire l'id del Appartamento da modificare");
		int idAppartamentoModifica = scanner.nextInt();
		scanner.nextLine();
		Appartamento appartamentoModifica = (Appartamento) crud
				.jpaRead("select a from Appartamento a where idAppartamento = " + idAppartamentoModifica)
				.getSingleResult();
		System.out.println(
				"Inserire la dimensione dell'appartamento ");
		int modificaDimensione = scanner.nextInt();
		scanner.nextLine();
		appartamentoModifica.setDimensione(modificaDimensione);
		appartamentoModifica.setCostoTotManutenzione(appartamentoModifica.calcoloCostoTotManutenzione(modificaDimensione));
		crud.jpaUpdate(appartamentoModifica);
	}

	public void listaAppartamenti(ServicesCrud crud){
		List listaAppartamenti= crud.jpaRead("select a from Appartamento a").getResultList();
		listaAppartamenti.stream().forEach(System.out::println);
	}

	public void eliminaAppartamento(Scanner scanner, ServicesCrud crud){
		listaAppartamenti(crud);
		System.out.println("Inserire l'id dell Appartamento da eliminare");
		int idAppartamentoElimina = scanner.nextInt();
		scanner.nextLine();
		Appartamento appartamentoElimina = (Appartamento) crud
				.jpaRead("select a from Appartamento a where idAppartamento = " + idAppartamentoElimina)
				.getSingleResult();
		crud.jpaDelete(appartamentoElimina);
	}
}



