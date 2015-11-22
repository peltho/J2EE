/**
 * 
 */
package miage.gestioncabinet.api;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 * Interface décrivant une consultation médicale
 * @author sraybaud - MIAGE
 *
 */
public interface Consultation extends Serializable,Comparable<Consultation>{
	/**
	 * Retourne le patient qui consulte
	 * @return le patient correspondant
	 */
	public Patient getPatient();
	
	/**
	 * Modifie le patient qui consulte
	 * @param patient le patient à modifier
	 */
	public void setPatient(Patient patient);
	
	/**
	 * Retourne le médecin consultant
	 * @return le médecin correspondant
	 */
	public Medecin getMedecin();
	
	/**
	 * Modifie le médecin consultant
	 * @param medecin le médecin à modifier
	 */
	public void setMedecin(Medecin medecin);
	
	/**
	 * Retourne la date de début de la consultation
	 * @return la date correspondante
	 */
	public Calendar getDebut();
	
	/**
	 * Modifie la date de rendez-vous de la consultation
	 * @param date la date à modifier
	 */
	public void setDebut(Calendar date);
	
	/**
	 * Retourne la date de fin de la consultation
	 * @return la date correspondante
	 */
	public Calendar getFin();
	
	/**
	 * Modifie la date de fin de la consultation
	 * @param date la date à modifier
	 */
	public void setFin(Calendar date);
	
	/**
	 * Retourne le compte-rendu de la consultation
	 * @return le compte rendu correspondant
	 */
	public String getCompteRendu();
	
	/**
	 * Modifie le compte-rendu de la consultation
	 * @param texte le compte rendu correspondant
	 */
	public void setCompteRendu(String texte);
	
	/**
	 * Retourne la liste des médicaments prescrits
	 * @return la liste correspondante
	 */
	public List<Traitement> getPrescription();
	
	/**
	 * Ajoute le produit fourni à la prescription, sauf s'il a déjà été prescrit
	 * @param produit le produit à prescrire
	 * @return true si le traitement a été ajouté avec succès, false s'il existe déjà
	 */
	public Boolean ajouterTraitement(Produit produit);
	
	/**
	 * Supprimer le traitement fourni de la prescription
	 * @param traitement le traitement à supprimer
	 * @return true si le traitement a été supprimé avec succès, false s'il ne figure pas dans la prescription
	 */
	public Boolean supprimerTraitement(Traitement medicament);
	
	/**
	 * Retourne la liste des interactions de la prescription
	 * @return les interactions correspondantes
	 */
	public List<Interaction> getInteractions();
	
	/**
	 * Modifie la liste des interactions de la prescription
	 * @param interactions la liste des interactions à modifier
	 */
	public void setInteractions(List<Interaction> interactions);

}
