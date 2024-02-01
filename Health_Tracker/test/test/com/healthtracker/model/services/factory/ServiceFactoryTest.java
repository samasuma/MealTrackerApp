package test.com.healthtracker.model.services.factory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import main.com.healthtracker.model.business.exception.ServiceLoadException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.com.healthtracker.model.services.factory.ServiceFactory;
import main.com.healthtracker.model.services.mealtrackingservice.IMealTrackerService;

/**
 * JUnit test class for the ServiceFactory.
 */
//Update this test class to use the new ServiceFactory class.
public class ServiceFactoryTest {

	@Test
	@DisplayName("Test getInstance() method")
	void testGetInstance() {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		assertTrue(serviceFactory instanceof ServiceFactory);
	}

	@Test
	@DisplayName("Test getService() method")
	void testGetService() throws ServiceLoadException {
		IMealTrackerService mealTrackerService;
		 UUID userId = UUID.randomUUID();
			mealTrackerService = (IMealTrackerService) ServiceFactory.getInstance()
					.getService(IMealTrackerService.NAME, userId);
			assertTrue(mealTrackerService instanceof IMealTrackerService);
	}
	


}
