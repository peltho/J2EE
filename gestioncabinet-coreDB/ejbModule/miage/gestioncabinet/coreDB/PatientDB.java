package miage.gestioncabinet.coreDB;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import miage.gestioncabinet.api.Patient;

@Entity
@Table(name="Patient")
@DiscriminatorValue("patient")
public class PatientDB extends PersonneDB implements Patient, Serializable {
	private Calendar dateNaissance;
	private String sexe;
	@Transient
	private int age;
	
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
