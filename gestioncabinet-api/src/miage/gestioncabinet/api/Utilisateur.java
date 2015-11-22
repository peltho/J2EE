/**
 * 
 */
package miage.gestioncabinet.api;

/**
 * Interface décrivant un utilisateur, c'est-à-dire une personne utilisatrice
 * de l'application
 * @author sraybaud - MIAGE
 *
 */
public interface Utilisateur extends Personne{
	
	/**
	 * Retourne le nom de compte de l'utilisateur
	 * @return son nom de compte
	 */
	public String getCompte();
}
