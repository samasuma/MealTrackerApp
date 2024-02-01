package main.com.healthtracker.model.business.manager;

import java.time.LocalDate;
import java.util.List;

import main.java.com.healthtracker.model.business.exception.ServiceLoadException;
import main.java.com.healthtracker.model.domain.Meal;

import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;

public class Main {
	
    protected static final Logger logger = LogManager.getLogger();


	public static void main(String[] args) {
		
		
		 
		 Meal meal = new Meal("Test Meal", 500, 2, LocalDate.now());

	      
		 MealManager mealManager = MealManager.getInstance();
		 try {
			mealManager.addMeal(meal);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			List<Meal> allMeals = mealManager.getAllMeals();
			logger.info(allMeals.isEmpty());
		
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		

	       

	      
	}

}
