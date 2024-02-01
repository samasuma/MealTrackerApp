package test.java.com.healthtracker.model.business.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import main.com.healthtracker.model.business.manager.MealManager;
import main.java.com.healthtracker.model.business.exception.ServiceLoadException;
import main.java.com.healthtracker.model.domain.Meal;

/**
 * The MealManagerTest class contains JUnit test cases for the MealManager class.
 */
public class MealManagerTest {

    private MealManager mealManager;

    /**
     * Initializes the MealManager instance before each test case.
     * @throws ServiceLoadException 
     */
    @BeforeEach
    public void setUp() throws ServiceLoadException {
        mealManager = MealManager.getInstance();
        
      
    }

    /**
     * Tests the addMeal method of the MealManager class.
     * Verifies that the meal is added correctly to the application.
     *
     * @throws ServiceLoadException if the meal tracking service cannot be loaded
     */
    @Test
    public void testAddMeal() throws ServiceLoadException {
        // Create a new meal
        Meal meal = new Meal("Test Meal", 500, 2, LocalDate.now());

        // Add the meal using the meal manager
        mealManager.addMeal(meal);

        // Retrieve all meals using the meal manager
        List<Meal> meals = mealManager.getAllMeals();

        // Verify that the meal was added correctly
        Assertions.assertTrue(meals.contains(meal), "Meal was not added correctly");
    }

    /**
     * Tests the getAllMeals method of the MealManager class.
     * Verifies that all meals are retrieved correctly from the application.
     *
     * @throws ServiceLoadException if the meal tracking service cannot be loaded
     */
    @Test
    public void testGetAllMeals() throws ServiceLoadException {
        // Retrieve all meals using the meal manager
        List<Meal> meals = mealManager.getAllMeals();

        // Verify that the list of meals is not null
        Assertions.assertNotNull(meals);
    }

    /**
     * Tests the getMealsByDate method of the MealManager class.
     * Verifies that meals are retrieved correctly by date from the application.
     *
     * @throws ServiceLoadException if the meal tracking service cannot be loaded
     */
    @Test
    @DisplayName("Test getMealsByDate() method")
    void testGetMealsByDate() throws ServiceLoadException {
        // Create some test meals with specific dates
    	  Meal meal1 = new Meal("Test Meal", 500, 2, LocalDate.now());
    	  Meal meal2 = new Meal("Test Meal", 150, 2, LocalDate.now());
    	  Meal meal3 = new Meal("Test Meal", 50, 3, LocalDate.now().minusDays(1));
        
        // Add the meals to the application using the MealManager
        mealManager.addMeal(meal1);
        mealManager.addMeal(meal2);
        mealManager.addMeal(meal3);
        
        // Get the meals by date using the MealManager
        List<Meal> meals = mealManager.getMealsByDate(LocalDate.now());
        
        // Assert that the correct meals were retrieved
        Assertions.assertEquals(2, meals.size());
        Assertions.assertTrue(meals.contains(meal1));
        Assertions.assertTrue(meals.contains(meal2));
    }
}
