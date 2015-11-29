package miage.gestioncabinet.client;

import java.util.List;

import miage.gestioncabinet.api.Consultation;
import miage.gestioncabinet.api.ConsultationRemoteService;
import miage.gestioncabinet.api.Interaction;
import miage.gestioncabinet.api.Medecin;
import miage.gestioncabinet.api.PlanningRemoteService;
import miage.gestioncabinet.api.Produit;
import miage.gestioncabinet.api.Traitement;

import com.novarem.jndi.ServiceLocator;
import com.novarem.jndi.ServiceLocatorException;


/**
 * Programme client permettant de tester la saisie d'une consultation
 * Déployer sur JBoss 7 l'application JEE de gestion du cabinet
 * L'application client a besoin de référencer dans son classpath (clic droit sur le projet > Properties > Java Build Path :
 * - le service locator (projet com.novarem.jndi),
 * - le projet contenant l'interface distante (idéalement le projet miage.gestioncabinet.api qui est un simple "jar" compatible Java SE),
 * - le projet EJB (dépendance à l'exécution)
 * @author sraybaud
 *
 */
public class ConsultationTestClient {
	/**
	 * L'interface distante de l'EJB
	 */
	private PlanningRemoteService planningService;
	
	/**
	 * L'interface distante de l'EJB
	 */
	private ConsultationRemoteService csService;

	/**
	 * Constructeur avec lookup pour récupérer le proxy de l'EJB
	 * @see java.lang.Object#Object()
	 */
	public ConsultationTestClient() {
		String service=null;
		try{
			ServiceLocator locator = ServiceLocator.INSTANCE;
			//service="ejb:gestioncabinetear/gestioncabinet-coreM//PlanningService!miage.gestioncabinet.api.PlanningRemoteService?stateful";
			service="ejb:gestioncabinetear/gestioncabinet-coreDB//PlanningDBService!miage.gestioncabinet.api.PlanningRemoteService?stateful";
			this.planningService = (PlanningRemoteService) locator.getRemoteInterface(service);
			//service="ejb:gestioncabinetear/gestioncabinet-coreM//ConsultationService!miage.gestioncabinet.api.ConsultationRemoteService?stateful";
			service="ejb:gestioncabinetear/gestioncabinet-coreDB//ConsultationDBService!miage.gestioncabinet.api.ConsultationRemoteService?stateful";
			this.csService = (ConsultationRemoteService) locator.getRemoteInterface(service);
		}
		catch(ServiceLocatorException e){
			System.out.println("Le service "+service+" est introuvable");
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		ConsultationTestClient app = new ConsultationTestClient();
		try{
			System.out.println("On commence par créer des consultations dans le planning");
			PlanningTestClient.main(null);
			
			System.out.println("On écrit ensuite un scénario de saisie d'une consultation par un médecin");
			Consultation consultation = null;
			for(Medecin m : app.planningService.rechercherMedecins()){
				app.planningService.setMedecin(m);
				for(Consultation c : app.planningService.listerRdv()){
					consultation = c;
					break;
				}
			}
			if(consultation!=null){
				Medecin medecin = consultation.getMedecin();

				app.csService.setConsultation(consultation);
				System.out.println("Démarrage de la "+consultation);
				
				String[] medicaments = {"doliprane" , "ibuprofène", "aspegic", "lovenox", "plavix", "doliprane"};
				for(int i=0 ; i<medicaments.length; i++){
					List<Produit> produits = app.csService.rechercherMedicament(medicaments[i]);
					System.out.println(medecin+" recherche un médicament nommé '"+medicaments[i]+"' : "+produits.size()+" produits trouvés");
					if(!produits.isEmpty()){
						Produit produit = produits.get(0);

						if(consultation.ajouterTraitement(produits.get(0))){
							System.out.println(medecin+" prescrit le "+produit);
						}else{
							System.out.println(medecin+" ne peut pas represcrire le "+produit+" car il l'a déjà prescrit");							
						}
					}
				}
				consultation.setCompteRendu("Le patient a un petit rhume et a du mal à dormir...");
				app.csService.setConsultation(consultation);
				consultation = app.csService.enregistrer();
				System.out.println(medecin+" a enregistré la "+consultation);
				System.out.println(medecin+" procède à une analyse des interactions médicamenteuses...");
				app.csService.analyserPrescription();
				consultation = app.csService.getConsultation();
				System.out.println("... "+consultation.getInteractions().size()+" interactions ont été détectées :");
				for(Interaction im : consultation.getInteractions()){
					System.out.println(im);
				}
				
				System.out.println(medecin+" décide de supprimer les deux premiers produits incriminés de sa prescription");
				if(!consultation.getInteractions().isEmpty()) {
					Interaction interaction = consultation.getInteractions().get(0);
					for(Traitement t : consultation.getPrescription()){
						if(interaction.getProduitA().equals(t.getProduit()) || interaction.getProduitB().equals(t.getProduit())){
							if(consultation.supprimerTraitement(t)){
								System.out.println(medecin+" a supprimé avec succès le "+t);
							}
						}
					}
				}
				
				app.csService.setConsultation(consultation);
				consultation = app.csService.enregistrer();
				System.out.println(medecin+" a enregistré ses modifications sur la "+consultation);
				
				System.out.println(medecin+" procède à une nouvelle analyse des interactions médicamenteuses...");
				app.csService.analyserPrescription();
				consultation = app.csService.getConsultation();
				System.out.println("... "+consultation.getInteractions().size()+" interactions ont été détectées :");
				for(Interaction im : consultation.getInteractions()){
					System.out.println(im);
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}