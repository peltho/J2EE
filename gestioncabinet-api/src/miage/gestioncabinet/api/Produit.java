/**
 * 
 */
package miage.gestioncabinet.api;

import java.io.Serializable;

/**
 * Interface décrivant une spécialité médicamenteuse
 * @author sraybaud - MIAGE
 *
 */
public interface Produit extends Serializable {	
	/**
	 * Retourne le numéro CIS du produit
	 * @return le code correspondant
	 */
	public String getCis();
	
	/**
	 * Modifie le code CIS du produit
	 * @param cis le code à modifier
	 */
	public void setCis(String cis);
	
	/**
	 * Retourne le nom du produit prescrit
	 * @return le nom correspondant
	 */
	public String getNom();
	
	/**
	 * Modifie le nom du produit prescrit
	 * @param nom le nom à modifier
	 */
	public void setNom(String nom);

}
