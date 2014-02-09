package com.ba.factory;

import com.ba.exception.BAException;
import com.ba.exception.ServiceLocatorException;
import com.ba.utils.ServiceLocator;

public class GenericFactory {
		 public static Object buildObject(final String dbParam) throws BAException{
			 final ServiceLocator serviceLocator = ServiceLocator.getInstance();
		    	try
				{
		    		final String dbClassName = serviceLocator.getString(dbParam);
		    		final Class dbClazz = Class.forName(dbClassName);
			    	return dbClazz.newInstance();
		    	}
		    	catch(ServiceLocatorException e)
				{
		    		throw new BAException(e, "Service Locator Exception while getting Class Name from the JNDI");
		    	}
		    	catch(ClassNotFoundException e)
				{
		    		throw new BAException(e, "DB Class not found");
		    	}
		    	catch(InstantiationException e)
				{
		    		throw new BAException(e, "Cannot instantiate DB Class");
		    	}
		    	catch(IllegalAccessException	e)
				{
		    		throw new BAException(e, "Illegal Access Exception while instantiating DB Class");
		    	}
		

}
}
