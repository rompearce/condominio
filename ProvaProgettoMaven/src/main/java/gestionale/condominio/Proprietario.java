package gestionale.condominio;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;

@Entity
@Table(name = "Proprietario", schema = "gestionecondominio")
public class Proprietario {
	@Id
	@GeneratedValue
	private Integer idProprietario;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private String codicefiscale;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idProprietario")
	List<Appartamento> listaAppartamenti = new ArrayList<Appartamento>();

	// @Transient

	public Proprietario() {
		super();
	}

	public Proprietario(String nome, String cognome, String codicefiscale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codicefiscale = codicefiscale;
	}

	public Integer getId() {
		return idProprietario;
	}

	public void setId(Integer id) {
		this.idProprietario = id;
	}

	public List<Appartamento> getListaAppartamenti() {
		return listaAppartamenti;
	}

	public void setListaAppartamenti(List<Appartamento> listaAppartamenti) {
		this.listaAppartamenti = listaAppartamenti;
	}

	@Override
	public String toString() {
		return "Proprietario:\nidProprietario=" + idProprietario + ", nome=" + nome + ", cognome=" + cognome
				+ ", codicefiscale=" + codicefiscale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codicefiscale == null) ? 0 : codicefiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
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
		Proprietario other = (Proprietario) obj;
		if (codicefiscale == null) {
			if (other.codicefiscale != null)
				return false;
		} else if (!codicefiscale.equals(other.codicefiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
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

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public boolean verificaCodFiscale(String codiceFiscale) {

		String regexCF = "[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]";
		boolean verifica = false;
		if (Pattern.matches(regexCF, codiceFiscale)) {
			verifica = true;
		} else {
			verifica = false;
		}
		return verifica;
	}
}
