package main.com.healthtracker.view.meal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.com.healthtracker.model.domain.Meal;
import main.com.healthtracker.model.domain.MealTracker;
import main.com.healthtracker.view.mainjframe.MainJFrame;

public class MealJFrameController implements ActionListener {

	private MealJFrame mealJFrame;
	private MealTracker mealTracker = new MealTracker();

	public MealJFrameController() {
	}

	public MealJFrameController(MealJFrame mealJFrame) {

		this.mealJFrame = mealJFrame;

		mealJFrame.getHomeButton().addActionListener(this);

		mealJFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(mealJFrame.getSubmitButton())) {
			System.out.println("Grahh");
			// navigateHomePage(e);
		} else if (e.getSource().equals(mealJFrame.getHomeButton())) {
			System.out.println("Grahh, Boom!");
			customerMealAction(e);

		}

	}

	private void customerMealAction(ActionEvent e) {
		Meal myMeal = mealJFrame.getMeal();
		setMealTracker(myMeal);
		System.out.println(myMeal.toString());
		System.out.println("challenge: "+ getMealTracker().getMeals().toString());
		
		
System.out.println("Tracker bros: " + getMealTracker().getMeals().toString() );
		
mealJFrame.getMyMeal().setListData(getMealTracker().getMeals().toArray());
		
	}

	private void navigateHomePage(ActionEvent e) {
		mealJFrame.dispose();
		new MainJFrame();

	}

	public MealTracker getMealTracker() {
		return mealTracker;

	}

	public void setMealTracker(Meal myMeal) {
		mealTracker.addMeal(myMeal);

	}

}
