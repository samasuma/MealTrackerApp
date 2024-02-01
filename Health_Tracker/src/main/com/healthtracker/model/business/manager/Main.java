package main.com.healthtracker.model.business.manager;

import java.time.LocalDate;
import java.util.List;


import main.com.healthtracker.model.business.exception.ServiceLoadException;
import main.com.healthtracker.model.domain.Meal;

public class Main {

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
			System.out.println(allMeals.isEmpty());
		
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		

	       

	      
	}

}
