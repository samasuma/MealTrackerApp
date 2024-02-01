package main.com.healthtracker.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.com.healthtracker.view.meal.MealJFrame;
import main.com.healthtracker.view.mealtracker.MealTrackerJFrame;

public class MainJFrameController implements ActionListener {

	private MainJFrame mainJFrame;

	public MainJFrameController(MainJFrame mainJFrame) {

		this.mainJFrame = mainJFrame;

		mainJFrame.getHomeButton().addActionListener(this);
		mainJFrame.getMealButton().addActionListener(this);
		mainJFrame.getMealTrackerButton().addActionListener(this);
		
		mainJFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(mainJFrame.getHomeButton())) {

			navigateHomePage(e);
		} else if (e.getSource().equals(mainJFrame.getMealButton())) {
			navigateMealPage(e);
	
		} else if (e.getSource().equals(mainJFrame.getMealTrackerButton())) {
			navigateMealTrackerPage(e);
		}

	}

	private void navigateMealTrackerPage(ActionEvent e) {
		mainJFrame.dispose();
		new MealTrackerJFrame();

	}

	private void navigateMealPage(ActionEvent e) {
		//mainJFrame.dispose();
		new MealJFrame();

	}

	private void navigateHomePage(ActionEvent e) {
		mainJFrame.dispose();
		new MainJFrame();

	}

}
