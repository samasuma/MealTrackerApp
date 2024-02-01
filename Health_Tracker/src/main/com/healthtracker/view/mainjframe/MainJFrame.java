package main.com.healthtracker.view.mainjframe;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import main.com.healthtracker.view.mealtracker.MealTrackerJFrame;


public class MainJFrame extends JFrame {

	private static final long serialVersionUID = 6474170048018335981L;
	private Button homeButton;

	private Button mealButton;

	private Button mealTrackerButton;

	private MainJFrameController mainJFrameController;
	
	public MainJFrame() {
		// Frame setup
		this.setTitle("MyMealTracker");
		this.setSize(500, 300);

		// Layout
		setLayout(new FlowLayout());

		homeButton = new Button("Home");
		add(homeButton);

		mealButton = new Button("Meal");
		add(mealButton);

		mealTrackerButton = new Button("Meal Tracker");
		add(mealTrackerButton);
		
		mainJFrameController = new MainJFrameController(this);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public Button getHomeButton() {
		return homeButton;
	}

	public Button getMealTrackerButton() {
		return mealTrackerButton;
	}

	public Button getMealButton() {
		return mealButton;
	}
	
	/*
	 * private class MealTrackerButtonListener implements ActionListener { public
	 * void actionPerformed(ActionEvent evt) { new MealTrackerJFrame(); } }
	 */


}
