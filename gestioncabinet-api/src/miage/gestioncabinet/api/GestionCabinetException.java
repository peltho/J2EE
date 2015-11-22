/**
 * 
 */
package miage.gestioncabinet.api;

/**
 * Exception applicative
 * @author sraybaud
 *
 */
public class GestionCabinetException extends Exception {

	/**
	 * Numéro de série de la classe
	 */
	private static final long serialVersionUID = 6208834462723123480L;

	/**
	 * 
	 */
	public GestionCabinetException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public GestionCabinetException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public GestionCabinetException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public GestionCabinetException(Throwable cause) {
		super(cause);
	}
	
	

}
