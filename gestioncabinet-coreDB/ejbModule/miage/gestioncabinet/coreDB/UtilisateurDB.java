package miage.gestioncabinet.coreDB;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import miage.gestioncabinet.api.Utilisateur;
@Entity
@Table(name="Utilisateur")
public class UtilisateurDB extends PersonneDB implements Utilisateur, Serializable{
	
	private String compte;
	
	@Override
	public String getCompte() {
		return this.compte;
	}
}
