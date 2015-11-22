package miage.gestioncabinet;

import miage.gestioncabinet.api.Personne;

public class PersonneImpl implements Personne {

	private String nom;
	private String prenom;
	private long ID;
	
	public PersonneImpl() {
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
		PersonneImpl other = (PersonneImpl) obj;
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
