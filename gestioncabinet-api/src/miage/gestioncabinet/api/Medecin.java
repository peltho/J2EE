/**
 * 
 */
package miage.gestioncabinet.api;

/**
 * Interface décrivant un médecin
 * @author sraybaud - MIAGE
 *
 */
public interface Medecin extends Utilisateur{
	
	/**
	 * Retourne le numéro RPPS du médecin
	 * @return son numéro RPPS
	 */
	public String getRPPS();
}
