/**
 * 
 */
package miage.gestioncabinet.api;

import java.io.Serializable;

/**
 * Interface décrivant une interaction médicamenteuse
 * @author sraybaud - MIAGE
 *
 */
public interface Interaction extends Serializable {	
	/**
	 * Retourne le premier produit incriminé
	 * @return le produit correspondant
	 */
	public Produit getProduitA();
	
	/**
	 * Modifie le premier produit incriminé
	 * @param produit le produit à modifier
	 */
	public void setProduitA(Produit produit);
	
	/**
	 * Retourne le second produit incriminé
	 * @return le produit correspondant
	 */
	public Produit getProduitB();
	
	/**
	 * Modifie le second produit incriminé
	 * @param produit le produit à modifier
	 */
	public void setProduitB(Produit produit);
	
	/**
	 * Retourne la sévérité de l'interaction
	 * @return la sévérité correspondante
	 */
	public String getSeverite();
	
	/**
	 * Modifie la sévérité de l'interaction
	 * @param severite la sévérité à modifier
	 */
	public void setSeverite(String severite);
	
	/**
	 * Retourne les risques liés de l'interaction
	 * @return les risques correspondants
	 */
	public String getRisques();
	
	/**
	 * Modifie les risques liés à l'interaction
	 * @param risques les risques à modifier
	 */
	public void setRisques(String risques);
	
	/**
	 * Retourne les précautions à prendre vis à vis de l'interaction
	 * @return les précautions correspondantes
	 */
	public String getPrecautions();
	
	/**
	 * Modifie les précautions à prendre vis à vis de l'interaction
	 * @return precautions les précautions à modifier
	 */
	public void setPrecautions(String precautions);

}
