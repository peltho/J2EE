/**
 * 
 */
package miage.gestioncabinet.api;

import java.util.List;

/**
 * Interface distante du service de gestion d'une consultation
 * @author sraybaud - MIAGE
 *
 */
public interface ConsultationRemoteService{
	/**
	 * Retourne le rendez-vous de consultation courant
	 * @return le consultation correspondante
	 */
	public Consultation getConsultation();
	
	/**
	 * Modifie la consultation courante
	 * @param consultation la consultation courante
	 */
	public void setConsultation(Consultation consultation);
	
	/**
	 * Recherche la liste des produits correspondant au mot-clé fourni en argument
	 * @param keyword le mot-clé saisi
	 * @return la liste des produits correspondants
	 */
	public List<Produit> rechercherMedicament(String keyword) throws GestionCabinetException;
	
	/**
	 * Procède à l'analyse des interactions médicamenteuseses de la prescription de la consultation courante
	 */
	public void analyserPrescription() throws GestionCabinetException;
	
	/**
	 * Sauvegarde la consultation courante
	 * @return la consultation après avoir été sauvegardée
	 */
	public Consultation enregistrer() throws GestionCabinetException;
	
	/**
	 * Supprime la consultation courante
	 */
	public void supprimer() throws GestionCabinetException;	
	
}
