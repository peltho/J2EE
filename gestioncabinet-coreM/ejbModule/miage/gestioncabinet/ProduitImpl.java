package miage.gestioncabinet;

import miage.gestioncabinet.api.Produit;

public class ProduitImpl implements Produit {

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
