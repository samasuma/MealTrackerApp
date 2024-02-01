package test.com.healthtracker.model.domain;

import main.com.healthtracker.model.domain.Meal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class MealTest {
	/**
	 * Tests the getTotalCalories method.
	 */
	@Test
	public void testGetTotalCalories() {
		Meal meal = new Meal("Pizza", 300, 2);
		Assertions.assertEquals(600, meal.getTotalCalories());
	}
	/**
	 * Tests the getName method.
	 */
	@Test
	public void testGetName() {
		Meal meal = new Meal("Pizza", 300, 2);
		Assertions.assertEquals("Pizza", meal.getName());
	}
/**
	 * Tests the getCaloriesPerServing method.
	 */
	@Test
	public void testGetCaloriesPerServing() {
		Meal meal = new Meal("Pizza", 300, 2);
		Assertions.assertEquals(300, meal.getCaloriesPerServing());
	}
/**
	 * Tests the getNumberOfServings method.
	 */
	@Test
	public void testGetNumberOfServings() {
		Meal meal = new Meal("Pizza", 300, 2);
		Assertions.assertEquals(2, meal.getNumberOfServings());
	}
/**
	 * Tests the setName method.
	 */
	@Test
	public void testSetName() {
		Meal meal = new Meal("Pizza", 300, 2);
		meal.setName("Burger");
		Assertions.assertEquals("Burger", meal.getName());
	}
/**
	 * Tests the setCaloriesPerServing method.
	 */
	@Test
	public void testSetCaloriesPerServing() {
		Meal meal = new Meal("Pizza", 300, 2);
		meal.setCaloriesPerServing(400);
		Assertions.assertEquals(400, meal.getCaloriesPerServing());
	}
/**
	 * Tests the setNumberOfServings method.
	 */
	@Test
	public void testSetNumberOfServings() {
		Meal meal = new Meal("Pizza", 300, 2);
		meal.setNumberOfServings(3);
		Assertions.assertEquals(3, meal.getNumberOfServings());
	}
/**
	 * Tests the Validate method.
	 */
	@Test
	public void testValidate() {
		Meal meal1 = new Meal("", 300, 2);
		Meal meal2 = new Meal("Pizza", -300, 2);
		Meal meal3 = new Meal("Pizza", 300, -2);
		Meal meal4 = new Meal("Pizza", 300, 2);
		Assertions.assertFalse(meal1.validate());
		Assertions.assertFalse(meal2.validate());
		Assertions.assertFalse(meal3.validate());
		Assertions.assertTrue(meal4.validate());
	}
/**
	 * Tests the HashCode method.
	 */
	@Test
	public void testHashCode() {
		Meal meal1 = new Meal("Pizza", 300, 2);
		Meal meal2 = new Meal("Pizza", 300, 2);
		Meal meal3 = new Meal("Burger", 400, 3);
		Assertions.assertEquals(meal1.hashCode(), meal2.hashCode());
		Assertions.assertNotEquals(meal1.hashCode(), meal3.hashCode());
	}
/**
	 * Tests the Equals method.
	 */
	@Test
	public void testEquals() {
		Meal meal1 = new Meal("Pizza", 300, 2);
		Meal meal2 = new Meal("Pizza", 300, 2);
		Meal meal3 = new Meal("Burger", 400, 3);
		Assertions.assertEquals(meal1, meal2);
		Assertions.assertNotEquals(meal1, meal3);
	}
/**
	 * Tests the ToString method.
	 */
	@Test
	public void testToString() {
		Meal meal = new Meal("Pizza", 300, 2);
		Assertions.assertEquals("Meal [name=Pizza, caloriesPerServing=300, numberOfServings=2]", meal.toString());
	}
/**
	 * Tests the GetDate method.
	 */
	@Test
	public void testGetDate() {
		LocalDate date = LocalDate.of(2022, 5, 10);
		Meal meal = new Meal("Pizza", 300, 2, date);
		Assertions.assertEquals(date, meal.getDate());
	}
}

