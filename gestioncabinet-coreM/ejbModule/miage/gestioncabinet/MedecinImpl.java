package miage.gestioncabinet;

import miage.gestioncabinet.api.Medecin;

public class MedecinImpl extends PersonneImpl implements Medecin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3630536685882102514L;
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
