package main.com.healthtracker.model.services.factory;

import java.lang.reflect.Constructor;
import java.util.UUID;

import main.com.healthtracker.model.services.mealtrackingservice.IMealTrackerService;
import main.java.com.healthtracker.model.business.exception.ServiceLoadException;


/**
 * Returns an instance of the MealTrackerService.
 * 
 * @return a new MealTrackerServiceImpl object.
 */

public class ServiceFactory {
    private ServiceFactory() {
    }

    private static ServiceFactory serviceFactory = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return serviceFactory;
    }
/*** This method is used to get the service object.
     * @param serviceName
     * @return
     * @throws ServiceLoadException
     */
	public IMealTrackerService getService(String serviceName, UUID userId) throws ServiceLoadException {
    	try {
                Class<?> c = Class.forName(getImplName(serviceName));
                Constructor<?> constructor = c.getConstructor(UUID.class);
                return (IMealTrackerService) constructor.newInstance(userId);
            } catch (Exception e) {
                serviceName = serviceName + " not loaded";
                throw new ServiceLoadException(serviceName, e);
            }

    }
  //-Dprop_location=\config\application.properties --- Running on Windows
  //-Dprop_location=/config/application.properties --- Running on MAC

/*** This method is used to get the implementation name from the properties file.
     * @param serviceName
     * @return
     * @throws Exception
     */
    public String getImplName(String serviceName) throws Exception {
        java.util.Properties props = new java.util.Properties();
        String propsFileLocation = System.getProperty("user.dir") + System.getProperty("prop_location");
        java.io.FileInputStream fis = new java.io.FileInputStream(propsFileLocation);
        props.load(fis);
        fis.close();
        return props.getProperty(serviceName);
    }
}
