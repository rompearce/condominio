package gestionale.condominio;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Statistiche {

	Scanner scanner = new Scanner(System.in);
	ServicesCrud crud = new ServicesCrud("jpa-example");

	public void pagaProprietario(Scanner scanner, ServicesCrud crud) {
		
		System.out.println("Inserire l'id del proprietario");
		int idProprietario = scanner.nextInt();
		scanner.nextLine();
		List listaAppartamenti= crud.jpaRead("select a from Appartamento a where idProprietario = "+idProprietario).getResultList();
		List listaCondomini =crud.jpaRead("select c from Condominio c").getResultList();
		
		double spesaManutenzione = calcoloSpesaManutenzione(listaAppartamenti);		
		System.out.println("La spesa per la manutenzione è : " + spesaManutenzione);
		double spesaCondominio=calcoloSpesaCondominio(listaCondomini,listaAppartamenti);
		System.out.println("La spesa per il condominio è : " + spesaCondominio);
		double pagamento = spesaManutenzione+spesaCondominio;
		System.out.println("La spesa totale è: " + pagamento);
	}

	private double calcoloSpesaCondominio(List<Condominio> listaCondomini,List<Appartamento> listaAppartamenti) {
		double superf=0;
		double rapporto=0;
		double spesaCondominio =0;
		double costoTotCondominio=0;
		for (Condominio condominio : listaCondomini) {
			for (Appartamento appartamento : listaAppartamenti) {
				if(condominio.getIdCondominio()==appartamento.getIdCondominio().getIdCondominio()){
					superf=condominio.getSuperficieTot();
					costoTotCondominio=condominio.getNumeroAppartamenti()*50; 
					rapporto=appartamento.getDimensione()/superf;
					spesaCondominio += costoTotCondominio*rapporto;
				}
			}
		}
		
		return spesaCondominio;
	}

	private double calcoloSpesaManutenzione(List<Appartamento> listaAppartamenti) {
		double spesaManutenzione =0;
		for (Appartamento appartamento : listaAppartamenti) {
			spesaManutenzione += appartamento.getCostoTotManutenzione();
		}
		return spesaManutenzione;
	}

	public void condominioCaro(Scanner scanner, ServicesCrud crud) {
		List listaCondomini =crud.jpaRead("select c from Condominio c").getResultList();
		Comparator<Condominio> comparator = (c1,c2)-> Integer.compare(c1.getNumeroAppartamenti() ,c2.getNumeroAppartamenti());
		Condominio caro = (Condominio) listaCondomini.stream().max(comparator).get();
		System.out.println("I condominio più caro è: "+caro.getNome()+"con "+caro.getNumeroAppartamenti()+" appartamenti");
		
	}

	public void appartamentoCaro(Scanner scanner, ServicesCrud crud) {

		List<Appartamento> listaAppartamento = crud.jpaRead("select a from Appartamento a").getResultList(); 
		Comparator<Appartamento> comp = (a1,a2) -> Double.compare(a1.getCostoTotManutenzione(), a2.getCostoTotManutenzione());
		Appartamento appCaro = listaAppartamento.stream().max(comp).get();
		System.out.println("L' appartamento più costoso appartiene al condominio id "+appCaro.getIdCondominio()+" assegnato al proprietario id"+appCaro.getIdProprietario()+"\n"
				+ "con una dimensione di "+appCaro.getDimensione()+" ed un costo pari a :"+appCaro.getCostoTotManutenzione());
	}

	public void condominioCostoMedio(Scanner scanner, ServicesCrud crud) {
		double costoMedio;
		double costo=0;
		List<Condominio> listaCondomini =crud.jpaRead("select c from Condominio c").getResultList();
		for (Condominio condominio : listaCondomini) {
			costo += (condominio.getNumeroAppartamenti()*50);
			costoMedio=(costo/listaCondomini.size());			
		}
		
		
	}

}
