package miage.gestioncabinet.coreDB;

import javax.persistence.Entity;
import javax.persistence.Table;

import miage.gestioncabinet.api.Medecin;
@Entity
@Table(name="Medecin")
public class MedecinDB extends PersonneDB implements Medecin {
	private String compte;
	private String RPPS;
	
	@Override
	public String getCompte() {
		return this.compte;
	}

	@Override
	public String getRPPS() {
		return this.RPPS;
	}
}
