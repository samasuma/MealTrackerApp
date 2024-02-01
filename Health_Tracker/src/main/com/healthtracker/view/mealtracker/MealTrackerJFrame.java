package main.com.healthtracker.view.mealtracker;

import java.awt.Button;
import java.awt.FlowLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;

import main.com.healthtracker.model.domain.MealTracker;
import main.com.healthtracker.view.meal.MealJFrameController;

public class MealTrackerJFrame extends JFrame {

	private Button homeButton, viewMealsButton, addMealButton;

	private JList myMeal;

	private static final long serialVersionUID = 6794624103029945824L;

	private MealTrackerController mealTrackerJFrameController;

	public MealTrackerJFrame() {
		this.setTitle("Meal Tracker");
		this.setSize(500, 500);

		// Layout
		setLayout(new FlowLayout());

		homeButton = new Button("Home");
		add(homeButton);

		myMeal = new JList();
		add(myMeal);

		viewMealsButton = new Button("View Meals");
		add(viewMealsButton);

		addMealButton = new Button("Add Meal");
		add(addMealButton);

		mealTrackerJFrameController = new MealTrackerController(this);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public JList getMyMeal() {
		return myMeal;
	}

	public Button getHomeButton() {
		return homeButton;
	}

	public Button getViewMealsButton() {
		return viewMealsButton;
	}

	public Button getAddMealButton() {
		return addMealButton;
	}

}
