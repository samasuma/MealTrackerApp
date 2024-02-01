package test.java.com.healthtracker.model.domain;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
/**
 * 
 * @author Samuel Asuma
 * 
 * Testing all domain classes 
 *
 */
@Suite
@SelectClasses({ MealTest.class, MealTrackerTest.class, UserTest.class })
public class AllDomainTests {

}
