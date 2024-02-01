package main.com.healthtracker.view.mealtracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.com.healthtracker.view.mainjframe.MainJFrame;
import main.com.healthtracker.view.meal.MealJFrameController;

public class MealTrackerController implements ActionListener {

	private MealTrackerJFrame MealTrackerJFrame;
	private MealJFrameController  mealJFrameController;

	public MealTrackerController(MealTrackerJFrame MealTrackerJFrame) {

		this.MealTrackerJFrame = MealTrackerJFrame;

		MealTrackerJFrame.getHomeButton().addActionListener(this);
		MealTrackerJFrame.getViewMealsButton().addActionListener(this);

		mealJFrameController = new MealJFrameController();
		MealTrackerJFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(MealTrackerJFrame.getViewMealsButton())) {

			populateMeals(e);
		} 

	}

	private void populateMeals(ActionEvent e) {
		
		System.out.println("Tracker bros: " + mealJFrameController.getMealTracker().getMeals().toString() );
		
		MealTrackerJFrame.getMyMeal().setListData(mealJFrameController.getMealTracker().getMeals().toArray());
		
	}

	private void navigateHomePage(ActionEvent e) {
		MealTrackerJFrame.dispose();
		new MainJFrame();

	}

}
