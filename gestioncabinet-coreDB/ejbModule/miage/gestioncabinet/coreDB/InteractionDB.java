package miage.gestioncabinet.coreDB;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import miage.gestioncabinet.api.Interaction;
import miage.gestioncabinet.api.Produit;

@Entity
@Table(name="Interaction")
public class InteractionDB implements Interaction, Serializable {
	@Id
	private Long ID;
	private String severite;
	private String risques;
	private String precautions;
	private Produit pA, pB;
	
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
