/**
 * 
 */
/**
 * @author bluewater
 *
 */
module Health_Tracker {
	requires org.junit.jupiter.api;
	requires junit;
	requires org.junit.platform.suite.api;
	requires java.desktop;
	requires org.apache.logging.log4j;
    exports test.com.healthtracker.model.services.factory;
    opens test.com.healthtracker.model.services.factory to org.junit.platform.commons;
    opens test.com.healthtracker.model.services.mealtrackingservice to org.junit.platform.commons;


}