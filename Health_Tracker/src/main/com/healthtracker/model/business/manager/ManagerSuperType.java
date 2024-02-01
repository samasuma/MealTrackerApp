package main.com.healthtracker.model.business.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.com.healthtracker.model.business.exception.PropertyFileNotFoundException;
import main.com.healthtracker.model.services.manager.PropertyManager;

public abstract class ManagerSuperType {

    protected static final Logger logger = LogManager.getLogger();

    static
    {
        try
        {
            ManagerSuperType.loadProperties();
        }
        catch (PropertyFileNotFoundException propertyFileNotFoundException)
        {
        	logger.error("Application Properties failed to be loaded - Application exiting...");
            System.exit(1); // since we can't load the properties and this being crucial we'll exit the application!
        }
    } // end of static initializer block




    public static void loadProperties () throws PropertyFileNotFoundException
    {
        /*
         * FAQ: How to pass in Properties file to app while I'm testing?
         *
         * Answer:
         *
         * If using ANT:
         * ============
         * Property file is located by making a call to
         * System.getProperty(prop_location), which actually
         * reads off from the target runTestDriver in build.xml
         *   <sysproperty key="prop_location" value="${prop.dir}application.properties"/>
         *
         * If running in Eclipse
         * =====================
         *
         * Right click on the unit test and navigate to
         *       1. Run As -> Run Configuration
         *       2. Select Arguments Tab
         *       3. In VM Arguments section, add the -D property
         * 	           -Dprop_location=<drive><location>\application.properties
         *            Example:
         * 	           -Dprop_location=E:\FleetRental\config\application.properties
         *
         * If running on command line
         * ==========================
         * you'd pass in the above -D option with the java command.
         */

        String propertyFileLocation = System.getProperty("prop_location");

        if (propertyFileLocation != null)
        {
        	
            // Now that we have the property file location, lets have the
            // PropertyManager class load it up
            PropertyManager.loadProperties(propertyFileLocation);
        }
        else
        {
            logger.error("Property file location not set. Passed in value is: " + propertyFileLocation + ".");
            throw new PropertyFileNotFoundException ("Property file location not set", null);
        }


    } //end loadPropertie
}
