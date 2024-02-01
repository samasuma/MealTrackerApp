/**

This interface represents the functionality of a MealTrackerService,
which manages the tracking of meals for a user.
*/
package main.com.healthtracker.model.services.mealtrackingservice;

import java.time.LocalDate;
import java.util.List;

import main.com.healthtracker.model.services.IService;
import main.com.healthtracker.model.services.exception.MealTrackerServiceException;
import main.java.com.healthtracker.model.domain.Meal;

/**
 * This interface represents the functionality of a MealTrackerService,
 * which manages the tracking of meals for a user.
 */

public interface IMealTrackerService extends IService {
    /**
     * The name of the MealTrackerService.
     */
    public final String NAME = "IMealTrackerService";

	/**
	 * Adds a Meal to the list of tracked meals.
	 *
	 * @param meal The Meal to add.
     * @throws MealTrackerServiceException if the Meal could not be added.
	 */
    void addMeal(Meal meal) throws MealTrackerServiceException;
    /**
     * Returns a List of all Meals that have been tracked.
     *
     * @return The List of all tracked Meals.
     * @throws MealTrackerServiceException if the List of Meals could not be retrieved.
     */
    List<Meal> getAllMeals() throws MealTrackerServiceException;
    /**
     * Returns a List of Meals tracked on a specific date.
     *
     * @param date The date for which to retrieve tracked Meals.
     * @return The List of Meals tracked on the specified date.
     * @throws MealTrackerServiceException if the List of Meals could not be retrieved.
     */
    List<Meal> getMealsByDate(LocalDate date) throws MealTrackerServiceException;
}
