package miage.gestioncabinet.coreDB;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import miage.gestioncabinet.api.Personne;

@Entity
@Table(name="Personne")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_personne")
public class PersonneDB implements Personne, Serializable {

	private static final long serialVersionUID = -4486181266291570930L;

	@Id
	private Long ID;
	
	private String nom;
	private String prenom;
	
	public PersonneDB() {
		this.ID = System.currentTimeMillis();
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
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
		PersonneDB other = (PersonneDB) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	
	public String toString() {
		return this.getClass().getSimpleName()+"#"+ID+" "+nom+" "+prenom;
	}

	@Override
	public Long getId() {
		return this.ID;
	}
}
