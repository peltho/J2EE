package miage.gestioncabinet.serviceDB;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import fr.vidal.webservices.interactionservice.ArrayOfInt;
import fr.vidal.webservices.interactionservice.ArrayOfInteractionCouple;
import fr.vidal.webservices.interactionservice.InteractionCouple;
import fr.vidal.webservices.interactionservice.InteractionService;
import fr.vidal.webservices.interactionservice.InteractionService_Service;
import fr.vidal.webservices.interactionservice.InteractionSeverityType;
import fr.vidal.webservices.productservice.Product;
import fr.vidal.webservices.productservice.ProductService;
import fr.vidal.webservices.productservice.ProductService_Service;
import fr.vidal.webservices.productservice.ProductType;
import miage.gestioncabinet.api.Consultation;
import miage.gestioncabinet.api.ConsultationRemoteService;
import miage.gestioncabinet.api.GestionCabinetException;
import miage.gestioncabinet.api.Interaction;
import miage.gestioncabinet.api.Produit;
import miage.gestioncabinet.api.Traitement;
import miage.gestioncabinet.coreDB.ConsultationDB;
import miage.gestioncabinet.coreDB.InteractionDB;
import miage.gestioncabinet.coreDB.ProduitDB;

@Stateful
@Remote(ConsultationRemoteService.class)
public class ConsultationDBService implements ConsultationRemoteService {

	private Consultation consultation;
	private ProductService ps;
	private InteractionService is;
	
	@PostConstruct
	public void init() {
		ps = new ProductService_Service().getProductServiceHttpPort();
		is = new InteractionService_Service().getInteractionServiceHttpPort();
	}

	public ConsultationDBService() {}
	
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
			p1.setCis(p.getCis());
			produits.add(p1);
		}
		return produits;
	}

	@Override
	public void analyserPrescription() throws GestionCabinetException {
		List<Traitement> traitements = consultation.getPrescription();

        ArrayOfInt productIds = new ArrayOfInt();

        for (Traitement traitement : traitements) {
        	Product p = ps.searchByCis(traitement.getProduit().getCis());
			productIds.getInt().add(p.getId());
        }

        List<Interaction> interactionsFound = new ArrayList<Interaction>();
        ArrayOfInteractionCouple arrayInteractionsCouple = is.searchInteractionCouplesForProductIds(productIds, InteractionSeverityType.TAKE_INTO_ACCOUNT).getInteractionCoupleList();

        for (InteractionCouple interactionCouple : arrayInteractionsCouple.getInteractionCouple()) {
            Interaction interaction = new InteractionDB();
            // Précautions
            interaction.setPrecautions(interactionCouple.getPrecautionComment());
            
            // Produit A
            Produit produitA = new ProduitDB();
            produitA.setCis(interactionCouple.getProductA().getCis());
            produitA.setNom(interactionCouple.getProductA().getName());
            interaction.setProduitA(produitA);
            
            // Produit B
            Produit produitB = new ProduitDB();
            produitB.setCis(interactionCouple.getProductB().getCis());
            produitB.setNom(interactionCouple.getProductB().getName());
            interaction.setProduitB(produitB);
            
            // Risques
            interaction.setRisques(interactionCouple.getRiskComment());
            
            // Sévérité
            interaction.setSeverite(interactionCouple.getSeverity().value());
            
            //Ajout interaction
            interactionsFound.add(interaction);
        }

        this.consultation.setInteractions(interactionsFound);
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
