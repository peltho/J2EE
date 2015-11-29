package miage.gestioncabinet.coreDB;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import miage.gestioncabinet.api.Interaction;
import miage.gestioncabinet.api.Produit;

@Entity
@Table(name="Interaction")
public class InteractionDB implements Interaction, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3658261078250146106L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
		InteractionDB other = (InteractionDB) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Id
	private Long ID;
	private String severite;
	private String risques;
	private String precautions;
	@OneToOne(targetEntity=ProduitDB.class)
	@JoinColumn(name="id_produitA")
	private Produit pA;
	@OneToOne(targetEntity=ProduitDB.class)
	@JoinColumn(name="id_produitB")
	private Produit pB;
	
	public InteractionDB() {}
	
	@Override
	public Produit getProduitA() {
		return pA;
	}

	@Override
	public void setProduitA(Produit produit) {
		this.pA = produit;
	}

	@Override
	public Produit getProduitB() {
		return pB;
	}

	@Override
	public void setProduitB(Produit produit) {
		this.pB = produit;
	}

	@Override
	public String getSeverite() {
		return this.severite;
	}

	@Override
	public void setSeverite(String severite) {
		this.severite = severite;
	}

	@Override
	public String getRisques() {
		return this.risques;
	}

	@Override
	public void setRisques(String risques) {
		this.risques = risques;
	}

	@Override
	public String getPrecautions() {
		return this.precautions;
	}

	@Override
	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}
}
