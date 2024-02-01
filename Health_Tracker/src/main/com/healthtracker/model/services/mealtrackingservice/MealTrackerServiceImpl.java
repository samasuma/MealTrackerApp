/**

This class provides implementation for the MealTrackerService interface.
It stores a list of meals and provides methods to add a meal, get all meals, and get meals by date.
*/
package main.com.healthtracker.model.services.mealtrackingservice;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import main.com.healthtracker.model.domain.Meal;
import main.com.healthtracker.model.domain.MealTracker;
import main.com.healthtracker.model.services.exception.MealTrackerServiceException;

public class MealTrackerServiceImpl implements IMealTrackerService {
	private final MealTracker mealTracker;

	/**
	 * Constructs a MealTrackerServiceImpl object with a new MealTracker.
	 */
	public MealTrackerServiceImpl(UUID userId) {
	    this.mealTracker = MealTracker.getInstance(userId);
	}

	/**
	 * Adds a meal to the MealTracker.
	 *
	 * @param meal The meal to add.
	 * @throws MealTrackerServiceException If the meal is null or invalid.
	 */
	@Override
	public void addMeal(Meal meal) throws MealTrackerServiceException {
		 if (meal == null) {
		        throw new MealTrackerServiceException("Meal cannot be null");
		    }
		    try {
		        mealTracker.addMeal(meal);
		    } catch (Exception e) {
		        throw new MealTrackerServiceException("Failed to add meal", e);
		    }
	}

	/**
	 * Returns an unmodifiable list of all meals.
	 *
	 * @return A list of all meals.
	 * @throws MealTrackerServiceException If the list of meals is null.
	 */
	@Override
	public List<Meal> getAllMeals() throws MealTrackerServiceException {
		  try {
		        List<Meal> allMeals = Collections.unmodifiableList(mealTracker.getMeals());
		        return allMeals;
		    } catch (Exception e) {
		        throw new MealTrackerServiceException("Failed to get all meals", e);
		    }
	}

	/**
	 * Returns a list of meals that were eaten on a specific date.
	 *
	 * @param date The date to filter meals by.
	 * @return A list of meals eaten on the specified date.
	 * @throws MealTrackerServiceException If the date is null.
	 */
	@Override
	public List<Meal> getMealsByDate(LocalDate date) throws MealTrackerServiceException {

	    try {
	        return mealTracker.getMeals().stream()
	                .filter(meal -> meal.getDate().equals(date))
	                .collect(Collectors.toList());
	    } catch (Exception e) {
	        throw new MealTrackerServiceException("Failed to get all meals by date", e);
	    }
	}

}
