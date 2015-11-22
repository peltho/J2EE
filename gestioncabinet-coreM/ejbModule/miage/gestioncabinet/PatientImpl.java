package miage.gestioncabinet;

import java.util.Calendar;

import miage.gestioncabinet.api.Patient;

public class PatientImpl extends PersonneImpl implements Patient {

	private Calendar dateNaissance;
	private String	sexe;
	
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
		// TODO
		    
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

}
