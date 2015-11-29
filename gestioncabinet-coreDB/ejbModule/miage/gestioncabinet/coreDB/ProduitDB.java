package miage.gestioncabinet.coreDB;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import miage.gestioncabinet.api.Produit;

@Entity
@Table(name="Produit")
public class ProduitDB implements Produit, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6077151825568269294L;
	@Id
	private int ID;
	
	public ProduitDB() {};
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	private String cis;
	private String nom;
	
	@Override
	public String getCis() {
		return this.cis;
	}

	@Override
	public void setCis(String cis) {
		this.cis = cis;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return getNom();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cis == null) ? 0 : cis.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		ProduitDB other = (ProduitDB) obj;
		if (cis == null) {
			if (other.cis != null)
				return false;
		} else if (!cis.equals(other.cis))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	
}
