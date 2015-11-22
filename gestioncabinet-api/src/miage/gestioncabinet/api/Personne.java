/**
 * 
 */
package miage.gestioncabinet.api;

import java.io.Serializable;

/**
 * Interface décrivant une personne dans l'application
 * @author sraybaud - MIAGE
 *
 */
public interface Personne extends Serializable {
	/**
	 * Retourne l'id de la personne
	 */
	public Long getId();
	
	/**
	 * Retourne le nom de la personne
	 * @return son nom
	 */
	public String getNom();
	
	/**
	 * Modifie le nom de la personne
	 * @param nom le nom à modifier
	 */
	public void setNom(String nom);
	
	/**
	 * Retourne le prénom de la personne
	 * @return son prénom
	 */
	public String getPrenom();
	
	/**
	 * Modifie le prénom de la personne
	 * @param prenom le prénom à modifier
	 */
	public void setPrenom(String prenom);
	
	public String toString();

}
