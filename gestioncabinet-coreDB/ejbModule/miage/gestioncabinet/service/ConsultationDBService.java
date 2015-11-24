package miage.gestioncabinet.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.vidal.webservices.interactionservice.InteractionService;
import fr.vidal.webservices.interactionservice.InteractionService_Service;
import fr.vidal.webservices.productservice.Product;
import fr.vidal.webservices.productservice.ProductService;
import fr.vidal.webservices.productservice.ProductService_Service;
import fr.vidal.webservices.productservice.ProductType;
import miage.gestioncabinet.api.Consultation;
import miage.gestioncabinet.api.ConsultationRemoteService;
import miage.gestioncabinet.api.GestionCabinetException;
import miage.gestioncabinet.api.Medecin;
import miage.gestioncabinet.api.Produit;
import miage.gestioncabinet.api.Traitement;
import miage.gestioncabinet.coreDB.ConsultationDB;
import miage.gestioncabinet.coreDB.MedecinDB;
import miage.gestioncabinet.coreDB.ProduitDB;

@Stateful
@Remote(ConsultationRemoteService.class)
public class ConsultationDBService implements ConsultationRemoteService {

	private Consultation consultation;
	private List<Produit> produits;
	private List<Traitement> traitements;
	private List<Medecin> medecins;
	private ProductService ps;
	private InteractionService is;
	
	@PostConstruct
	public void init() {
		/*Produit p = new ProduitImpl();
		p.setNom("plavix");
		p.setCis("cisPlavix");
		this.produits.add(p);
		
		Medecin m1 = new MedecinImpl();
		m1.setNom("Pellegatta");
		m1.setPrenom("Thomas");
		
		this.medecins = new ArrayList<Medecin>();
		this.medecins.add(m1);
		this.traitements = new ArrayList<Traitement>();*/
		
		ps = new ProductService_Service().getProductServiceHttpPort();
		is = new InteractionService_Service().getInteractionServiceHttpPort();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioncabinet");
		EntityManager em = emf.createEntityManager();
		MedecinDB m1 = em.find(MedecinDB.class, 1);
		this.medecins = new ArrayList<Medecin>();
		this.medecins.add(m1);
		
		em.close();
		emf.close();
	}

	public ConsultationDBService() {
		this.produits = new ArrayList<Produit>();
	}
	
	@Override
	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(ConsultationDB consultation) {
		this.consultation = consultation;
	}

	@Override
	public List<Produit> rechercherMedicament(String keyword) throws GestionCabinetException {
		List<Produit> produits = new ArrayList<Produit>();
		List<Product> products = ps.searchByNameAndType(keyword, ProductType.VIDAL).getProduct();
		for(Product p : products) {
			Produit p1 = new ProduitDB();
			p1.setNom(p.getName());
			produits.add(p1);
		}
		return produits;
	}

	@Override
	public void analyserPrescription() throws GestionCabinetException {
		// Récupérer le tableau des ID des produits
		// InteractionResult ir = is.getInteractionCouplesForProductIds(productIds, severity);
	}

	@Override
	public Consultation enregistrer() throws GestionCabinetException {
		return this.consultation;
	}

	@Override
	public void supprimer() throws GestionCabinetException {
		this.consultation = null;
	}

	@Override
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

}
