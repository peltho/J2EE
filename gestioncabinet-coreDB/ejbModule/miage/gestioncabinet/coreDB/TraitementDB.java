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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3397962635019844248L;
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
}
