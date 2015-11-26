package miage.gestioncabinet.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import miage.gestioncabinet.api.Consultation;
import miage.gestioncabinet.api.Medecin;
import miage.gestioncabinet.api.Patient;
import miage.gestioncabinet.api.PlanningRemoteService;

import com.novarem.jndi.ServiceLocator;
import com.novarem.jndi.ServiceLocatorException;


/**
 * Programme client permettant de tester le planning.
 * Déployer sur JBoss 7 l'application JEE de gestion du cabinet
 * L'application client a besoin de référencer dans son classpath (clic droit sur le projet > Properties > Java Build Path :
 * - le service locator (projet com.novarem.jndi),
 * - le projet contenant l'interface distante (idéalement le projet miage.gestioncabinet.api qui est un simple "jar" compatible Java SE),
 * - le projet EJB (dépendance à l'exécution)
 * @author sraybaud
 *
 */
public class PlanningTestClient {
	/**
	 * L'interface distante de l'EJB
	 */
	private PlanningRemoteService ejb;

	/**
	 * Constructeur avec lookup pour récupérer le proxy de l'EJB
	 * @see java.lang.Object#Object()
	 */
	public PlanningTestClient() {
		//String service="ejb:gestioncabinetear/gestioncabinet-coreM//PlanningService!miage.gestioncabinet.api.PlanningRemoteService?stateful";
		String service="ejb:gestioncabinetear/gestioncabinet-coreDB//PlanningDBService!miage.gestioncabinet.api.PlanningRemoteService?stateful";

		try{
			ServiceLocator locator = ServiceLocator.INSTANCE;
			this.ejb = (PlanningRemoteService) locator.getRemoteInterface(service);
		}
		catch(ServiceLocatorException e){
			System.out.println("Le service "+service+" est introuvable");
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		PlanningTestClient app = new PlanningTestClient();
		System.out.println("On développe un scénario de test du planning de consultation");
		
		try{
			List<Medecin> medecins = app.ejb.rechercherMedecins();
			System.out.println("Liste des médecins enregistrés : "+medecins);
			
			Medecin medecin = medecins.get(0);
			//System.out.println(medecin.getCompte());
			app.ejb.setMedecin(medecin);
			System.out.println("Sélection du médecin courant : "+medecin);
				
			DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			System.out.println("Planning du jour : du "+df.format(app.ejb.getDateDebut().getTime())+" au "+df.format(app.ejb.getDateFin().getTime()));
			String[] noms = {"MARTIN", "DUPOND", "GIUDICELLI"};
			String[] prenoms = {"Jean", "Henri", "Jeannette"};
			String[] datesNaissance = {"12/03/1964", "23/02/1958", "20/07/1943"};
			for(int i=0 ; i<3 ; i++){
				Calendar date = (Calendar) app.ejb.getDateDebut().clone();
				date.set(Calendar.HOUR_OF_DAY, 9);
				date.add(Calendar.HOUR_OF_DAY, i);
				Consultation rdv = app.ejb.creerRdv(date);
				Calendar dateNaissance = Calendar.getInstance();
				dateNaissance.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(datesNaissance[i]));
				List<Patient> patients = app.ejb.rechercherPatients(noms[i], prenoms[i], dateNaissance);
				System.out.println("Recherche si patient existant avec nom="+noms[i]+", prenom="+prenoms[i]+", dateNaissance="+datesNaissance[i]+" : "+patients.size()+" patient(s) trouvé(s)");
				if(patients.isEmpty()){
					rdv.getPatient().setNom(noms[i]);
					rdv.getPatient().setPrenom(prenoms[i]);
					rdv.getPatient().setDateNaissance(dateNaissance);
				}else{
					rdv.setPatient(patients.get(0));
				}
				app.ejb.setRdvCourant(rdv);
				app.ejb.enregistrerRdv();
				System.out.println("Enregistrement réussi du rdv de "+rdv+" (patient(e) de "+rdv.getPatient().getAge()+" ans).");
			}
			
			List<Consultation> rdvs = app.ejb.listerRdv();
			System.out.println("Recherche des "+rdvs.size()+" rendez-vous pris pour la journée de "+medecin+" :");
			for(Consultation rdv : rdvs){
				System.out.println("- "+rdv);
			}
			
			Consultation rdv = rdvs.get(1);
			app.ejb.setRdvCourant(rdv);
			app.ejb.supprimerRdv();
			System.out.println("Annulation du rdv de "+rdv);
			
			rdvs = app.ejb.listerRdv();
			System.out.println("Il ne reste plus que "+rdvs.size()+" rendez-vous pour le "+medecin+" :");
			for(Consultation r : rdvs){
				System.out.println("- "+r);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}