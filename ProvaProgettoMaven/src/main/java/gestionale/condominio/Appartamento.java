package gestionale.condominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "appartamento", schema = "gestionecondominio")
public class Appartamento {

	@Id
	@GeneratedValue()
	private Integer idAppartamento;
	@Column
	private double dimensione ;
	@Column( columnDefinition = "double default 0")
	private double costoTotManutenzione;

	@ManyToOne
	@JoinColumn(name = "idProprietario")
	private Proprietario idProprietario;
	@ManyToOne
	@JoinColumn(name = "idCondominio")
	private Condominio idCondominio;

	@Transient
	public static final int COSTO_MANUTENZIONE = 150;

	public Appartamento() {
		super();
	}

	public Appartamento(double dimensione, Proprietario idProprietario, Condominio idCondominio) {
		super();
		this.dimensione = dimensione;
		this.idProprietario = idProprietario;
		this.idCondominio = idCondominio;
		this.costoTotManutenzione = (dimensione * COSTO_MANUTENZIONE);
	}

	public double calcoloCostoTotManutenzione(double dimensione){
		costoTotManutenzione=dimensione*COSTO_MANUTENZIONE;
		return costoTotManutenzione;
	}
	
	
	public Integer getIdAppartamento() {
		return idAppartamento;
	}

	public void setIdAppartamento(Integer idAppartamento) {
		this.idAppartamento = idAppartamento;
	}

	public Proprietario getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Proprietario idProprietario) {
		this.idProprietario = idProprietario;
	}

	public Condominio getIdCondominio() {
		return idCondominio;
	}

	public void setIdCondominio(Condominio idCondominio) {
		this.idCondominio = idCondominio;
	}

	public double getCostoTotManutenzione() {
		return costoTotManutenzione;
	}

	public void setCostoTotManutenzione(double costoTotManutenzione) {
		this.costoTotManutenzione = costoTotManutenzione;
	}

	public double getDimensione() {
		return dimensione;
	}

	public void setDimensione(double dimensione) {
		this.dimensione = dimensione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(dimensione);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Appartamento other = (Appartamento) obj;
		if (Double.doubleToLongBits(dimensione) != Double.doubleToLongBits(other.dimensione))
			return false;
		return true;
	}
}
