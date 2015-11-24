package miage.gestioncabinet.coreDB;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import miage.gestioncabinet.api.Medecin;


@Entity
@Table(name="Medecin")
@DiscriminatorValue("medecin")
public class MedecinDB extends PersonneDB implements Medecin, Serializable {
	private String compte;
	private String RPPS;
	
	public MedecinDB() {}
	
	@Override
	public String getCompte() {
		return this.compte;
	}

	@Override
	public String getRPPS() {
		return this.RPPS;
	}
}
