package main.java.com.healthtracker.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;



/**
 * Represents a meal tracker that keeps track of meals consumed by a user.
 */
public class MealTracker implements Serializable {
  
	   private static final long serialVersionUID = 1L;
	    private static Map<UUID, MealTracker> instances = new HashMap<>();
	    private List<Meal> meals;

	    /**
	     * Constructs a new MealTracker object with an empty list of meals.
	     */
	    public MealTracker() {
	        meals = new ArrayList<>();
	    }

	    /**
	     * Returns the singleton instance of the MealTracker object for the given user ID.
	     *
	     * @param userId the ID of the user
	     * @return the MealTracker object for the user
	     */
	    public static MealTracker getInstance(UUID userId) {
	        if (!instances.containsKey(userId)) {
	            instances.put(userId, new MealTracker());
	        }
	        return instances.get(userId);
	    }
    /**
     * Adds a new meal to the list of meals, if the meal is valid.
     *
     * @param meal the meal to add
     */
    public void addMeal(Meal meal) {
        if (meal.validate()) {
            meals.add(meal);
        }
    }

    /**
     * Calculates the total number of calories consumed across all meals.
     *
     * @return the total number of calories consumed
     */
    public int getTotalCaloriesConsumed() {
        int totalCalories = 0;
        for (Meal meal : meals) {
            totalCalories += meal.getTotalCalories();
        }
        return totalCalories;
    }

    /**
     * Returns the list of meals tracked by this MealTracker.
     *
     * @return the list of meals
     */
    public List<Meal> getMeals() {
        return meals;
    }
    
    /**

    Removes all meals from the list of meals in this MealTracker instance.
    This is for testing purposes.
    */
    public void clearMeals() {
        meals.clear();
    }

    /**
     * Checks if this MealTracker is equal to another object.
     * Two MealTracker objects are considered equal if they have the same list of meals.
     *
     * @param obj the object to compare
     * @return true if this MealTracker is equal to the other object, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof MealTracker)) return false;
        MealTracker mealTracker = (MealTracker) obj;
        return mealTracker.meals.equals(meals);
    }
}
