/**
 * 
 */
package miage.gestioncabinet.api;

import java.io.Serializable;

/**
 * Interface décrivant une prescription médicamenteuse
 * @author sraybaud - MIAGE
 *
 */
public interface Traitement extends Serializable {	
	/**
	 * Retourne le produit prescrit
	 * @return la spécialité médicamenteuse
	 */
	public Produit getProduit();
	
	/**
	 * Modifie le produit prescrire
	 * @param produit le produit à modifier
	 */
	public void setProduit(Produit produit);
	
	/**
	 * Retourne la posologie
	 * @return la posologie
	 */
	public String getPosologie();
	
	/**
	 * Modifie la posologie de la prescription
	 * @param posologie la posologie à modifier
	 */
	public void setPosologie(String posologie);

}
