package main.com.healthtracker.model.business.manager;

import main.com.healthtracker.model.services.exception.MealTrackerServiceException;
import main.com.healthtracker.model.services.factory.ServiceFactory;
import main.com.healthtracker.model.services.mealtrackingservice.IMealTrackerService;
import main.java.com.healthtracker.model.business.exception.ServiceLoadException;
import main.java.com.healthtracker.model.domain.Meal;

import java.time.LocalDate;
import java.util.List;

public class MealManager extends ManagerSuperType{


    private static MealManager _instance;

    /**
     * keep the constructor private to prevent instantiation by outside callers.
     */
    MealManager() {
        // construct object . . .
    }

    /**
     * Assures that there is only one MealManager created.
     *
     * @return MealManager instance
     */
    public static synchronized MealManager getInstance() {
        if (_instance == null) {
            _instance = new MealManager();
        }
        return _instance;
    }

    /**
     * Adds a meal to the application.
     *
     * @param meal the meal to add
     * @throws ServiceLoadException if the meal tracking service cannot be loaded
     */
    public void addMeal(Meal meal) throws ServiceLoadException {
        try {
            // Initialize the service factory
            ServiceFactory serviceFactory = ServiceFactory.getInstance();

            // Get the meal tracking service
            IMealTrackerService mealTrackerService = (IMealTrackerService) serviceFactory
                    .getService(IMealTrackerService.NAME, null);

            // Add the meal using the meal tracking service
            mealTrackerService.addMeal(meal);
        } catch (ServiceLoadException | MealTrackerServiceException e) {
            throw new ServiceLoadException("Error loading meal tracking service.", e);
        }
    }


    /**
     * Retrieves all meals in the application.
     *
     * @return a list of all meals
     * @throws ServiceLoadException if the meal tracking service cannot be loaded
     */
    public List<Meal> getAllMeals() throws ServiceLoadException {
        try {
            // Initialize the service factory
            ServiceFactory serviceFactory = ServiceFactory.getInstance();

            // Get the meal tracking service
            IMealTrackerService mealTrackerService = (IMealTrackerService) serviceFactory
                    .getService(IMealTrackerService.NAME, null);

            // Retrieve all meals using the meal tracking service
            return mealTrackerService.getAllMeals();
        } catch (ServiceLoadException | MealTrackerServiceException e) {
            throw new ServiceLoadException("Error loading meal tracking service.", e);
        }
    }
    /**
     * Retrieves meals in the application by date.
     *
     * @param date the date of the meals to retrieve
     * @return a list of meals on the specified date
     * @throws ServiceLoadException if the meal tracking service cannot be loaded
     */
    public List<Meal> getMealsByDate(LocalDate date) throws ServiceLoadException {
        try {
            // Get the meal tracking service
            IMealTrackerService mealTrackerService = (IMealTrackerService) ServiceFactory.getInstance()
                    .getService(IMealTrackerService.NAME, null);

            // Retrieve meals by date using the meal tracking service
            return mealTrackerService.getMealsByDate(date);
        } catch (Exception e) {
            throw new ServiceLoadException("Error retrieving meals by date.", e);
        }
    }



}
