package miage.gestioncabinet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import miage.gestioncabinet.api.Consultation;
import miage.gestioncabinet.api.Interaction;
import miage.gestioncabinet.api.Medecin;
import miage.gestioncabinet.api.Patient;
import miage.gestioncabinet.api.Produit;
import miage.gestioncabinet.api.Traitement;

public class ConsultationImpl implements Consultation {

	private Long ID;
	private Calendar dateDebut;
	private Calendar dateFin;
	private String compteRendu;
	private Medecin medecin;
	private Patient patient;
	private List<Traitement> traitements;
	private List<Interaction> interactions;
	
	public ConsultationImpl() {
		this.traitements = new ArrayList<Traitement>();
		this.interactions = new ArrayList<Interaction>();
		this.ID = System.currentTimeMillis();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultationImpl other = (ConsultationImpl) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Calendar getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Calendar dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Calendar getDateFin() {
		return dateFin;
	}

	public void setDateFin(Calendar dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public Patient getPatient() {
		Patient p;
		if(this.patient == null) {
			p = new PatientImpl();
		} else
			p = this.patient;
		return p;
	}

	@Override
	public void setPatient(Patient patient) {
		this.patient = (PatientImpl) patient;
	}

	@Override
	public Medecin getMedecin() {
		return this.medecin;
	}

	@Override
	public void setMedecin(Medecin medecin) {
		this.medecin = (MedecinImpl) medecin;
	}

	@Override
	public Calendar getDebut() {
		return this.dateDebut;
	}

	@Override
	public void setDebut(Calendar date) {
		this.dateDebut = date;
	}

	@Override
	public Calendar getFin() {
		return this.dateFin;
	}

	@Override
	public void setFin(Calendar date) {
		this.dateFin = date;
	}

	@Override
	public String getCompteRendu() {
		return this.compteRendu;
	}

	@Override
	public void setCompteRendu(String texte) {
		this.compteRendu = texte;
	}

	@Override
	public List<Traitement> getPrescription() {
		return this.traitements;
	}

	@Override
	public Boolean ajouterTraitement(Produit produit) {
		Boolean flag = false;
		Traitement t = new TraitementImpl();
		t.setProduit(produit);
		if(!this.traitements.isEmpty() && !this.traitements.contains(t)) {
			this.traitements.add(t);
			flag = true;
		}
		return flag;
	}

	@Override
	public Boolean supprimerTraitement(Traitement medicament) {
		traitements.remove(medicament);
		return true;
	}

	@Override
	public List<Interaction> getInteractions() {
		return interactions;
	}

	@Override
	public void setInteractions(List<Interaction> interactions) {
		this.interactions = interactions;
	}

	@Override
	public int compareTo(Consultation o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return this.getClass().getSimpleName()+"#"+getID();
	}

}
