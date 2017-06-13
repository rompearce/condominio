package gestionale.condominio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Condominio",schema="gestionecondominio")

public class Condominio {
	
	@Id
	@GeneratedValue
	private Integer idCondominio;
	@Column
	private String nome;
	@Column
	private int numeroAppartamenti;
	@Column
	private double superficieTot;
	
	//private double superficie ;
//	@Column
//	private double speseCondominio;

	public double getSuperficieTot() {
		return superficieTot;
	}

	public void setSuperficieTot(double superficieTot) {
		this.superficieTot = superficieTot;
	}

	@OneToMany(fetch=FetchType.EAGER,mappedBy=  "idCondominio")
	List<Appartamento> listaAppartamenti = new ArrayList<Appartamento>();

	
	@Transient
	private static final int COSTO_GESTIONE = 50;

//	Scanner scanner = new Scanner(System.in);
	
	public Condominio() {
		super();
	}
	
	public Condominio(String nome, List<Appartamento> listaAppartamenti) {
		super();
		this.nome = nome;
		this.numeroAppartamenti = listaAppartamenti.size();
		//this.superficie = calcoloSuperficie(listaAppartamenti);
		//this.speseCondominio = (listaAppartamenti.size()*COSTO_GESTIONE);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroAppartamenti() {
		return numeroAppartamenti;
	}

	public void setNumeroAppartamenti(int numeroAppartamenti) {
		this.numeroAppartamenti = numeroAppartamenti;
	}

	
//	public double getSuperficie() {
//		return superficie;
//	}
//
//	public void setSuperficie(double superficie) {
//		this.superficie = superficie;
//	}

//	public double getspeseCondominio() {
//		return speseCondominio;
//	}
//
//	public void setCostoGestioneTotale(double speseCondominio) {
//		this.speseCondominio= speseCondominio;
//	}

	public Integer getIdCondominio() {
		return idCondominio;
	}

	public void setIdCondominio(Integer idCondominio) {
		this.idCondominio = idCondominio;
	}

	public List<Appartamento> getListaAppartamenti() {
		return listaAppartamenti;
	}

	public void setListaAppartamenti(List<Appartamento> listaAppartamenti) {
		this.listaAppartamenti = listaAppartamenti;
	}

	double calcoloSuperficie(List<Appartamento> listaAppartamenti){
		double superficie=0;
		for (Appartamento app : listaAppartamenti) {
		superficie += app.getDimensione();
		}
		return superficie;
	}
	
//	Condominio inserimentoCondominio(Scanner scanner){
//		
//		System.out.println("Inserire il nome del condominio");
//		String nomeCondominio = scanner.nextLine();
//		System.out.println("Inserire il numero di appartamenti");
//		int numeroAppartamnti = scanner.nextInt();
//		scanner.nextLine();
//		List<Appartamento> listaAppartamnti = new ArrayList<Appartamento>();
//		for (int i = 0; i < numeroAppartamnti; i++) {
//			Appartamento app = Appartamento.inserimentoAppartamento(scanner);
//			listaAppartamnti.add(app);
//		}
//		Condominio cond = new Condominio(nomeCondominio, listaAppartamnti);
//		return cond;
//
//	}
	}
