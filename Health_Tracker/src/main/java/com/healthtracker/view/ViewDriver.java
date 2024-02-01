package main.java.com.healthtracker.view;

import javax.swing.UIManager;

import main.java.com.healthtracker.view.meal.MealJFrame;
import main.java.com.healthtracker.view.meal.MealJFrameController;

public class ViewDriver {

	public ViewDriver() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		} catch (Exception e) {
			e.printStackTrace();
		}

		MealJFrame mealJFrame = new MealJFrame();

		MealJFrameController mainJFrameController = new MealJFrameController(mealJFrame);

	}

	public static void main(String[] args) {
		new ViewDriver();

	}

}
