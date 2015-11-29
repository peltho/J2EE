package miage.gestioncabinet.coreDB;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import miage.gestioncabinet.api.Produit;
import miage.gestioncabinet.api.Traitement;

@Entity
@Table(name="Traitement")
public class TraitementDB implements Traitement, Serializable {
	
	@Id
	private int ID;
	private String posologie;
	@OneToOne(targetEntity=ProduitDB.class)
	@JoinColumn(name="ID")
	private Produit p;
	
	public TraitementDB() {}
	
	@Override
	public Produit getProduit() {
		return p;
	}

	@Override
	public void setProduit(Produit produit) {
		this.p = produit;
	}

	@Override
	public String getPosologie() {
		return this.posologie;
	}

	@Override
	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
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
		TraitementDB other = (TraitementDB) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
}
