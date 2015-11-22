package miage.gestioncabinet;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import miage.gestioncabinet.api.Utilisateur;

@Entity
@Table(name="Utilisateur")
public class UtilisateurImpl extends PersonneImpl implements Utilisateur, Serializable {

	private String compte;
	
	@Override
	public String getCompte() {
		return this.compte;
	}

}
