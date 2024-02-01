package main.java.com.healthtracker.view.meal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.com.healthtracker.model.services.exception.MealTrackerServiceException;
import main.com.healthtracker.model.services.mealtrackingservice.IMealTrackerService;
import main.java.com.healthtracker.model.domain.Meal;
import main.java.com.healthtracker.model.domain.MealTracker;

public class MealJFrameController implements ActionListener {

	private MealJFrame mealJFrame;
	private MealTracker mealTracker = new MealTracker();
    private IMealTrackerService mealTrackerService;


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
		try {
			mealJFrame.getMyMeal().setListData(getMealTracker().getAllMeals().toArray());
		} catch (MealTrackerServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public IMealTrackerService getMealTracker() {
		return mealTrackerService;

	}

	public void setMealTracker(Meal myMeal) {
		
		try {
			mealTrackerService.addMeal(myMeal);
		} catch (MealTrackerServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
