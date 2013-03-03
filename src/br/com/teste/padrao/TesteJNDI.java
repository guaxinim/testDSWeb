package br.com.teste.padrao;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TesteJNDI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//FerramentaAulaService service;
		
		System.out.println("##### Start");
		
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		props.setProperty("org.omg.CORBA.ORBInitialHost", "10.37.0.119");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

		/*props.setProperty("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
		props.setProperty("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");
		props.setProperty("org.omg.CORBA.ORBInitialHost", "10.37.0.119");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3528");
		*/
		
		
		
		try {
		
		final Hashtable jndiProperties = new Hashtable();
        /*jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        jndiProperties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        jndiProperties.put("java.naming.provider.url", "jnp://10.37.0.119:4447");*/
		
		jndiProperties.put("java.naming.factory.initial","org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put("java.naming.provider.url","remote://10.37.0.119:4447");
		jndiProperties.put("jboss.naming.client.ejb.context","true");
        
		/*jndiProperties.put("endpoint.name","client-endpoint");
		jndiProperties.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED","false");
        jndiProperties.put("remote.connection.default.host","10.20.30.40");
        jndiProperties.put("remote.connection.default.port", "4447");
        jndiProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS","false");
		jndiProperties.put("remote.connection.default.username","jboss");
		jndiProperties.put("remote.connection.default.password","MTIzNDU2");*/
        
		Context context;	
		context = new InitialContext(jndiProperties);
        	
        //service = (FerramentaAulaService) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		
        //String addr= "java:jboss/exported/portaldoprofessor/portaldoprofessor-ejb/FerramentaAulaServiceBean!br.gov.mec.portaldoprofessor.v3.ferramentaaula.FerramentaAulaService"; 
        String addr= "ejb:portaldoprofessor/portaldoprofessor-ejb/FerramentaAulaServiceBean!br.gov.mec.portaldoprofessor.v3.ferramentaaula.FerramentaAulaService";
        //service = (FerramentaAulaService) context.lookup(addr);
				
			
			//service = (FerramentaAulaService) new InitialContext(props).lookup("FerramentaAulaServiceBean");
		} catch (NamingException e) {
			throw new IllegalStateException("Erro ao carregar serviços", e);
		}
		
		//System.out.println("##### OK" + service);

	}

}
