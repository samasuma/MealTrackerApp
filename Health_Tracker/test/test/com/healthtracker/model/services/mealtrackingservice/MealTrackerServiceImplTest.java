/**

This class provides the Junit tests for the MealTrackerServiceImpl class.
*/
package test.com.healthtracker.model.services.mealtrackingservice;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import main.com.healthtracker.model.services.exception.MealTrackerServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.com.healthtracker.model.services.mealtrackingservice.IMealTrackerService;
import main.com.healthtracker.model.services.mealtrackingservice.MealTrackerServiceImpl;
import main.java.com.healthtracker.model.domain.Meal;

import static org.junit.jupiter.api.Assertions.*;

public class MealTrackerServiceImplTest {

    private IMealTrackerService mealTrackerService;
    private Meal meal;
    private UUID userId;
    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
    	userId = UUID.randomUUID();
        mealTrackerService = new MealTrackerServiceImpl(userId);
        LocalDate date = LocalDate.of(2022, 5, 10);
        meal = new Meal("Chicken Alfredo", 800, 1, date);
    }
    /**
     * Tests adding a meal to the meal tracker service.
     */
    @Test
    public void testAddMeal() {
        try {
            int initialCount = mealTrackerService.getAllMeals().size();
            mealTrackerService.addMeal(meal);
            int finalCount = mealTrackerService.getAllMeals().size();

            assertEquals(initialCount + 1, finalCount, "Meal count should have increased by 1");
        } catch (MealTrackerServiceException e) {
            e.printStackTrace();
            fail("MealTrackerServiceException");
        }
    }
    /**
     * Tests getting all meals from the meal tracker service.
     */
    @Test
    public void testGetAllMeals() {
        try {
            mealTrackerService.addMeal(meal);
            List<Meal> meals = mealTrackerService.getAllMeals();
            assertNotNull(meals, "List of meals should not be null");
            assertTrue(meals.contains(meal), "List of meals should contain the added meal");
        } catch (MealTrackerServiceException e) {
            e.printStackTrace();
            fail("MealTrackerServiceException");
        }
    }
}
