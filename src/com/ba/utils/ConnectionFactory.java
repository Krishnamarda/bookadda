/******************************************************************************************************************
 * Description    :     ConnectionFactory
 * 						This is a base class that contains common methods such as sqlCleanUp, getConnection that
 * 						will be inherited by DAO classes
 *
 * Known Bugs     :     None
 *
 * Modification Log
 * Date                 Author                               Description
 * -------------------------------------------------------------------------
 * June 07, 2013         Sumit Joshi            			Created
 * -------------------------------------------------------------------------
 *******************************************************************************************************************/

package com.ba.utils;

/**
 * DAOImpl
 * This class contains common methods such as sqlCleanUp, getConnecttion that can be used
 * by DAO Impl classes
 *
 * @author Infosys Technologies Limited
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ba.exception.BAException;
import com.ba.exception.ServiceLocatorException;



public class ConnectionFactory {
	


	/**
	 * Clean up sql objects
	 *
	 * @param Connection
	 * @param Statement
	 * @param ResultSet
	 *
	 * @throws ServletException
	 */

	protected void sqlCleanUp(Connection con, Statement pStmt, ResultSet rSet) {


	try {

		if (rSet != null)

		{

			rSet.close();

		}

		if (pStmt != null)

		{

			pStmt.close();

		}

		if (con != null)

		{

			con.close();

		}

		// connections

		rSet = null;

		pStmt = null;

		con = null;

	} catch (Exception e) {


	}
	}


	/**
	 * This is the default method that will be invoked from the action class.
	 *
	 * @param String
	 *
	 * @return Connection
	 * @throws ProductIDTO
	 */


	protected Connection getConnection(final String dataSourceName)

			throws BAException {

		final ServiceLocator serviceLocator = ServiceLocator.getInstance();

		try {
			
			return serviceLocator.getDataSource(dataSourceName).getConnection();
			
		} catch (ServiceLocatorException e) {
			throw new BAException(e,
					"Service Locator Exception while getting datasource from DataSource");
		} catch (Exception e) {
			throw new BAException(e,
					"Exception while getting connection from DataSource");
		}

		}
}
