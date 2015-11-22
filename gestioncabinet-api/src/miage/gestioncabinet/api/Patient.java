/**
 * 
 */
package miage.gestioncabinet.api;

import java.util.Calendar;

/**
 * Interface décrivant un patient
 * @author sraybaud - MIAGE
 *
 */
public interface Patient extends Personne{
	/**
	 * Retourne la date de naissance du patient
	 * @return la date correspondante
	 */
	public Calendar getDateNaissance();
	
	/**
	 * Modifie la date de naissance du patient
	 * @param date la date de naissance à modifier
	 */
	public void setDateNaissance(Calendar dateNaissance);
	
	/**
	 * Retourne l'âge du patient
	 * @return l'âge correspondant
	 */
	public Integer getAge();
}
