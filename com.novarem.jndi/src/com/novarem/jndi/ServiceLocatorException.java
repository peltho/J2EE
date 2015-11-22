/**
 * 
 */
package com.novarem.jndi;

/**
 * Cette exception est levée pour tout problème de connexion à une interface distante
 * @author Sébastien Raybaud - NovaRem
 *
 */
public class ServiceLocatorException extends Exception {

	/**
	 * Numéro de version de la classe
	 */
	private static final long serialVersionUID = 4220009326995490707L;
	
	
	/**
	 * Constructeur
	 */
	public ServiceLocatorException(){
		this(null);
	}
	
	/**
	 * Constructeur
	 */
	public ServiceLocatorException(Throwable e){
		super("L'application cliente ne parvient pas à se connecter au serveur applicatif.\nVeillez à vous assurer que le serveur applicatif est en fonctionnement et qu'il est bien accessible via le réseau.",e);
	}

}
