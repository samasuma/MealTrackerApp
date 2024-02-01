package main.com.healthtracker.view.meal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.com.healthtracker.model.domain.Meal;
import main.com.healthtracker.model.domain.MealTracker;

public class MealJFrameController implements ActionListener {

	private MealJFrame mealJFrame;
	private MealTracker mealTracker = new MealTracker();

	public MealJFrameController() {
	}

	public MealJFrameController(MealJFrame mealJFrame) {

		this.mealJFrame = mealJFrame;

		mealJFrame.getSubmitButton().addActionListener(this);

		mealJFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(mealJFrame.getSubmitButton())) {
			customerMealAction(e);

		}

	}

	private void customerMealAction(ActionEvent e) {
		Meal myMeal = mealJFrame.getMeal();
		setMealTracker(myMeal);
		mealJFrame.getMyMeal().setListData(getMealTracker().getMeals().toArray());

	}

	public MealTracker getMealTracker() {
		return mealTracker;

	}

	public void setMealTracker(Meal myMeal) {
		mealTracker.addMeal(myMeal);

	}

}
