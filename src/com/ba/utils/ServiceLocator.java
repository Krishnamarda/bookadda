package com.ba.utils;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ba.exception.BAException;
import com.ba.exception.ServiceLocatorException;



/**
 * This class is an implementation of the Service Locator pattern. It is used
 * to looukup resources such as EJBHomes, JMS Destinations, etc. This
 * implementation uses the "singleton" strategy and also the "caching"
 * strategy. This implementation is intended to be used on the web tier and not
 * on the ejb tier.
 */
public class ServiceLocator
{
	
	private InitialContext iContext;
	//used to hold references to EJBHomes/JMS Resources for re-use
	final private Map<String,DataSource> cache = Collections.synchronizedMap(new HashMap<String,DataSource>());
	//	This cache map used for caching DB impl names
	final private Map<String,String> cacheImplClsMap = Collections.synchronizedMap(new HashMap<String,String>());

	private static ServiceLocator instance = new ServiceLocator();

	public static ServiceLocator getInstance()
	{
		return instance;
	}

	private ServiceLocator()
	{
		try
		{
			iContext = new InitialContext();
		}
		catch (Exception e)
		{
			
		}
	}

	
	/**
	 * This method obtains the datasource itself for a caller
	 *
	 * @return the DataSource corresponding to the name parameter
	 */
	public DataSource getDataSource(final String dataSourceName)
		throws ServiceLocatorException
	{
		DataSource dataSource =  cache.get(dataSourceName);
		if (dataSource == null)
		{
			try
			{
				dataSource = (DataSource) iContext.lookup(dataSourceName);
				cache.put(dataSourceName, dataSource);
			}
			catch (Exception e)
			{
				throw new ServiceLocatorException(e, "Exception in ServiceLocator.getDataSource()");
			}
		}
		return dataSource;
	}

	/**
	 * This method obtains the UserTransaction itself for a caller
	 *
	 * @return the UserTransaction corresponding to the name parameter
	 */
	/*
	 * Unused public UserTransaction getUserTransaction(String utName) throws
	 * Exception { try { return (UserTransaction)
	 * ic.lookup(utName); } catch (Exception e) { throw new
	 * Exception(e); } }
	 */

	/**
	 * @return the URL value corresponding to the env entry name.
	 */
	public URL getUrl(final String envName) throws Exception
	{
		try
		{
			return (URL) iContext.lookup(envName);
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}

	/**
	 * @return the boolean value corresponding to the env entry such as
	 *            SEND_CONFIRMATION_MAIL property.
	 */
	public boolean getBoolean(final String envName) throws Exception
	{
		try
		{
			return ((Boolean) iContext.lookup(envName)).booleanValue();
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
	}


	/**
	 * This method looks up the DBImpl class name and add it in Cache Map
	 * If it's already present then it will take value from map
	 * @param envname - Name of the class to search for look up.
	 * @return DB impl class name
	 */
	public String getString(final String envName) throws ServiceLocatorException
	{
		//System.out.println("Input Parameter name"+envName);
		//Declaring local varibles
		String implClassName = null;
		try{
			//Checks the class name exist in the cache map
			implClassName= cacheImplClsMap.get(envName);


			//If class name doesnot exist in cacheImplCls Map add check in
			//lookup and add the name in cache.
			if(implClassName == null){
				//Look up the DB class
				implClassName =(String)iContext.lookup(envName);
				//Put the class name in cache Map
				cacheImplClsMap.put(envName, implClassName);
			}
			//System.out.println("Class name = "+implClassName);

		}catch (Exception e){
			throw new ServiceLocatorException(e, "Exception while Initial context lookup.");
		}
		return implClassName;
	}
}