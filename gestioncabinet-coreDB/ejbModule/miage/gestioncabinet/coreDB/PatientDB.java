package miage.gestioncabinet.coreDB;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;

import miage.gestioncabinet.api.Patient;

@Entity
@Table(name="Patient")
public class PatientDB extends PersonneDB implements Patient, Serializable {
	private Calendar dateNaissance;
	private String sexe;
	
	@Override
	public Calendar getDateNaissance() {
		return this.dateNaissance;
	}

	@Override
	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public Integer getAge() {
		return 0;
	}
}
