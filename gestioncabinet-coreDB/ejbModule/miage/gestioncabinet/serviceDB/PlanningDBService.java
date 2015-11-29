package miage.gestioncabinet.serviceDB;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.vidal.webservices.interactionservice.InteractionService;
import fr.vidal.webservices.interactionservice.InteractionService_Service;
import fr.vidal.webservices.productservice.ProductService;
import fr.vidal.webservices.productservice.ProductService_Service;
import miage.gestioncabinet.api.Consultation;
import miage.gestioncabinet.api.GestionCabinetException;
import miage.gestioncabinet.api.Medecin;
import miage.gestioncabinet.api.Patient;
import miage.gestioncabinet.api.PlanningRemoteService;
import miage.gestioncabinet.api.Utilisateur;
import miage.gestioncabinet.coreDB.ConsultationDB;
import miage.gestioncabinet.coreDB.MedecinDB;

@Stateful
@Remote(PlanningRemoteService.class)
public class PlanningDBService implements PlanningRemoteService, Serializable {
	
	private Utilisateur user;
	private Calendar dateDebut;
	private Calendar dateFin;
	private Medecin medecin;
	private Consultation rdv;
	private List<Consultation> consultations;
	private List<Medecin> medecins;
	private ArrayList<Patient> patients;
	private ProductService ps;
	private InteractionService is;
	EntityManagerFactory emf;
	EntityManager em;

	public PlanningDBService() {}
	
	private Calendar setBirthdate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		String dateInString = date;
		Date date1 = formatter.parse(dateInString);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		return cal1;
	}
	
	@PostConstruct
	public void init() throws ParseException {
		
		medecins = new ArrayList<Medecin>();
		
		
		Calendar cal = Calendar.getInstance();
		this.dateDebut = cal;
		this.dateFin = cal;
		
		ps = new ProductService_Service().getProductServiceHttpPort();
		is = new InteractionService_Service().getInteractionServiceHttpPort();
		emf = Persistence.createEntityManagerFactory("gestioncabinet");
		em = emf.createEntityManager();

		MedecinDB m1 = em.find(MedecinDB.class, 1L);
		this.medecins = new ArrayList<Medecin>();
		this.medecins.add(m1);
		
		consultations = new ArrayList<Consultation>();
		ConsultationDB c1 = em.find(ConsultationDB.class, 1L);
		this.consultations.add(c1);
				
		/*em.close();
		emf.close();*/

	}

	@Override
	public Utilisateur getUtilisateur() {
		return user;
	}

	@Override
	public List<Medecin> rechercherMedecins() throws GestionCabinetException {
		return this.medecins;
	}

	@Override
	public List<Patient> rechercherPatients(String nom, String prenom, Calendar dateNaissance)
			throws GestionCabinetException {
		List<Patient> patients = new ArrayList<Patient>();
		for(Consultation c : this.consultations) {
			Patient p = c.getPatient();
				if(p.getNom() == nom && p.getPrenom() == prenom && p.getDateNaissance() == dateNaissance) {
					patients.add(p);
				}
		}
		return patients;
	}

	@Override
	public Calendar getDateDebut() {
		return this.dateDebut;
	}

	@Override
	public void setDateDebut(Calendar date) {
		this.dateDebut = date;
	}

	@Override
	public Calendar getDateFin() {
		return this.dateFin;
	}

	@Override
	public void setDateFin(Calendar date) {
		this.dateFin = date;
	}

	@Override
	public Medecin getMedecin() {
		return this.medecin;
	}

	@Override
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	@Override
	public List<Consultation> listerRdv() {
		return this.consultations;
	}

	@Override
	public Consultation getRdvCourant() {
		return this.rdv;
	}

	@Override
	public void setRdvCourant(Consultation rdv) {
		this.rdv = rdv;
	}

	@Override
	public Consultation creerRdv(Calendar date) {
		Consultation c = new ConsultationDB();
		c.setDebut(date);

		return c;
	}

	@Override
	public Consultation enregistrerRdv() throws GestionCabinetException {
		this.consultations.add(this.rdv);
		return this.rdv;
	}

	@Override
	public void supprimerRdv() throws GestionCabinetException {
		this.consultations.remove(getRdvCourant());
		//this.consultations.remove(this.consultations.size()-1);
	}

}