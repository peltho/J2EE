package miage.gestioncabinet.coreDB;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import miage.gestioncabinet.api.Produit;

@Entity
@Table(name="Produit")
public class ProduitDB implements Produit, Serializable {
	
	@Id
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

}
