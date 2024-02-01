package test.java.com.healthtracker.model.domain;

import org.junit.jupiter.api.Test;

import main.java.com.healthtracker.model.domain.Meal;
import main.java.com.healthtracker.model.domain.MealTracker;
import main.java.com.healthtracker.model.domain.User;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
/**
 * Unit tests for the MealTracker class.
 */
public class MealTrackerTest {
	private User user;
	private MealTracker mealTracker;
	
	@BeforeEach
	void setUp() {
		user = new User("John Doe", 30, 180, 75.0, "Male", 2000);
        mealTracker = MealTracker.getInstance(user.getUserId());
	}

	
	  /**
     * Tests adding a valid meal to a meal tracker.
     */
    @Test
    public void testAddValidMeal() {
        Meal meal = new Meal("Chicken Alfredo", 800, 2);
        mealTracker.addMeal(meal);

        assertEquals(1, mealTracker.getMeals().size());
        assertTrue(mealTracker.getMeals().contains(meal));
    }

    /**
     * Tests adding an invalid meal to a meal tracker.
     */
    @Test
    public void testAddInvalidMeal() {
        Meal meal = new Meal("", -100, 0);
        mealTracker.addMeal(meal);

        assertEquals(0, mealTracker.getMeals().size());
    }

   
    /**
     * Tests calculating the total calories consumed by a meal tracker.
     */
    @Test
    public void testGetTotalCaloriesConsumed() {
    	
        Meal meal1 = new Meal("Chicken Alfredo", 800, 2);
        Meal meal2 = new Meal("Caesar Salad", 250, 1);
        Meal meal3 = new Meal("Garlic Bread", 150, 2);

        mealTracker.addMeal(meal1);
        mealTracker.addMeal(meal2);
        mealTracker.addMeal(meal3);
        int expectedTotalCalories = meal1.getTotalCalories() + meal2.getTotalCalories() + meal3.getTotalCalories();
        int actualTotalCalories = mealTracker.getTotalCaloriesConsumed();

        assertEquals(expectedTotalCalories, actualTotalCalories);
    }


    /**
     * Tests the equals method for the MealTracker class.
     */
    @Test
    public void testEquals() {
        MealTracker mealTracker1 = MealTracker.getInstance(user.getUserId());
        MealTracker mealTracker2 = MealTracker.getInstance(user.getUserId());
        Meal meal1 = new Meal("Chicken Alfredo", 800, 2);
        Meal meal2 = new Meal("Chicken Alfredo", 800, 2);

        mealTracker1.addMeal(meal1);
        mealTracker1.addMeal(meal2);

        mealTracker2.addMeal(meal2);
        mealTracker2.addMeal(meal1);

        assertTrue(mealTracker1.equals(mealTracker2));
    }

    /**
     * Tests the getTotalCalories method for the Meal class.
     */
    @Test
    public void testMealGetTotalCalories() {
        Meal meal = new Meal("Chicken Alfredo", 800, 2);

        assertEquals(1600, meal.getTotalCalories());
    }

    /**
     * Tests the validate method for the Meal class.
     */
    @Test
    public void testMealValidate() {
        Meal validMeal = new Meal("Chicken Alfredo", 800, 2);
        Meal invalidMeal = new Meal("", -100, 0);

        assertTrue(validMeal.validate());
        assertFalse(invalidMeal.validate());
    }

    /**
     * Tests the equals method for the Meal class.
     */
    @Test
    public void testMealEquals() {
        Meal meal1 = new Meal("Chicken Alfredo", 800, 2);
        Meal meal2 = new Meal("Chicken Alfredo", 800, 2);
        Meal meal3 = new Meal("Caesar Salad", 250, 1);

        assertTrue(meal1.equals(meal2));
        assertFalse(meal1.equals(meal3));
    }
}