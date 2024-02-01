/**

JUnit test suite that includes all the tests for the services.
*/
package test.com.healthtracker.services;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import test.com.healthtracker.model.services.factory.ServiceFactoryTest;
import test.com.healthtracker.model.services.mealtrackingservice.MealTrackerServiceImplTest;

@Suite
@SelectClasses({ServiceFactoryTest.class, MealTrackerServiceImplTest.class})
public class AllServicesTests {

}
