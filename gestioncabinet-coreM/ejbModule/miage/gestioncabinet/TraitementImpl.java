package miage.gestioncabinet;

import miage.gestioncabinet.api.Produit;
import miage.gestioncabinet.api.Traitement;

public class TraitementImpl implements Traitement {

	private Long ID;
	private String posologie;
	private Produit p;
	
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

}
