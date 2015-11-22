package com.novarem.jndi;

public interface ServiceLocator {
	/**
	 * Retourne l'instance singleton
	 * @return le singleton du service locator
	 */
	public static final ServiceLocator INSTANCE = ServiceLocatorImpl.getInstance();

	/**
	 * Retourne l'interface distante en fonction du chemin jdni fourni en argument
	 * @throws ServiceLocatorException
	 * @param jdniName adresse recherchée dans l'annuaire
	 * @return l'interface distante publiée
	 */
	public Object getRemoteInterface(String jdniName) throws ServiceLocatorException;

}
