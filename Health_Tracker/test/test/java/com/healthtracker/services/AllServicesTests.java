/**

JUnit test suite that includes all the tests for the services.
*/
package test.java.com.healthtracker.services;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import test.com.healthtracker.model.services.mealtrackingservice.MealTrackerServiceImplTest;
import test.java.com.healthtracker.model.services.factory.ServiceFactoryTest;

@Suite
@SelectClasses({ServiceFactoryTest.class, MealTrackerServiceImplTest.class})
public class AllServicesTests {

}
