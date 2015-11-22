package com.novarem.jndi;

import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * @author sraybaud
 * Implantation d'un service locator sous forme de singleton.
 * 
 * Pour créer un ServiceLocator capable de se connecter à l'interface distante d'EJB déployé sur JBoss 7, veillez à ajouter à la racine du classpath (./src depuis l'interface de prog, de façon à ce 
 * que ce soit reporté à la racine ./bin) :
 * 
 * 1. un fichier jboss-ejb-client.properties avec les propriétés suivantes :
 * endpoint.name=client-endpoint
 * remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED=false
 * remote.connections=default
 * remote.connection.default.host=localhost
 * remote.connection.default.port=4447
 * remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS=false
 * remote.connection.default.username=
 * remote.connection.default.password=
 * 
 * 2. un fichier jndi.properties avec la propriété suivante :
 * java.naming.factory.url.pkgs=org.jboss.ejb.client.naming
 * 
 * 3. ajouter dans le classpath (depuis Eclipse, clic droit sur le projet>Properties --> Java Build Path, onglet Libraries : * les librairies clientes de JBoss compilées dans le jar JBoss/bin/client/jboss-client.jar
 * 
 *
 */
public class ServiceLocatorImpl implements ServiceLocator{
	/**
	 * INSTANCE SINGLETON
	 */
	private static ServiceLocator INSTANCE;
	
	/**
	 * Retourne l'instance singleton
	 * @return le singleton du service locator
	 */
	public static ServiceLocator getInstance(){
		if(INSTANCE==null){
			INSTANCE=new ServiceLocatorImpl();
		}
		return INSTANCE;
	}
	
	/**
	 * Contexte initial
	 */
	private Context initialContext;
	
	/**
	 * Cache
	 */
	private Map<String,Object> cache;
	
	/**
	 * Construit une instance de service locator
	 * @throws ServiceLocatorException
	 */
	private ServiceLocatorImpl(){
		try{
			cache = new Hashtable<String, Object>();
			initialContext = new InitialContext();
		}
		catch(Exception e){
			System.out.println(e);
		}		
	}
	
	/**
	 * Méthode unique du service locator permettant d'obtenir un proxy d'EJB à partir d'une adresse jndi valide.
	 * Pour Jboss 7, l'interface distante d'un EJB est accessible à partir de l'adresse suivante :
	 * ejb:appliName/moduleName//BeanName!fullyQualifiedName, auquel on ajoute la mention ?stateful pour appeler un EJB avec état.
	 * Exemple d'adresse JNDI :
	 * 	ejb:MasterSIS/fr.amu.sis.coreM/NoteService!fr.amu.sis.api.ejb.NoteRemoteService?stateful
	 * @param jndiName adresse JNDI de l'interface distante de l'EJB (attention à la syntaxe spécifique pour JBoss)
	 * @return le proxy de l'interface distante
	 */
	public Object getRemoteInterface(String jndiName) throws ServiceLocatorException{
		Object remoteInterface = cache.get(jndiName);
		if(remoteInterface==null){
			try{
				remoteInterface = initialContext.lookup(jndiName);
				cache.put(jndiName, remoteInterface);
			}
			catch(Exception e){
				ServiceLocatorException ex = new ServiceLocatorException(e);
				throw ex;
			}
		}
		return remoteInterface;		
	}
}
