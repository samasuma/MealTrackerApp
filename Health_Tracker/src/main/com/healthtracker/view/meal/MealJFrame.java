package main.com.healthtracker.view.meal;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import main.com.healthtracker.model.domain.Meal;

public class MealJFrame extends JFrame {

	private Button submitButton;
	private JLabel mealLbl, nameLbl, servingsLbl, caloriesLbl;
	private JTextField nameField, caloriesField, servingsField;
	private JList myMeal;

	private static final long serialVersionUID = 6004340328645563816L;

	private MealJFrameController mealJFrameController;

	public MealJFrame() {

		this.setTitle("Meal");
		this.setSize(500, 500);

		// Layout
		setLayout(new FlowLayout());

		mealLbl = new JLabel("Meal");
		add(mealLbl);

		nameLbl = new JLabel("Name");
		add(nameLbl);

		nameField = new JTextField(20);
		add(nameField);

		caloriesLbl = new JLabel("Calories");
		add(caloriesLbl);

		caloriesField = new JTextField(20);
		add(caloriesField);

		servingsLbl = new JLabel("Servings");
		add(servingsLbl);

		servingsField = new JTextField(20);
		add(servingsField);

		submitButton = new Button("Submit");
		add(submitButton);

		myMeal = new JList();
		add(myMeal);

		mealJFrameController = new MealJFrameController(this);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public JList getMyMeal() {
		return myMeal;
	}

	public Button getSubmitButton() {
		return submitButton;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getCaloriesField() {
		return caloriesField;
	}

	public JTextField getServingsField() {
		return servingsField;
	}

	public Meal getMeal() {

		String meal_name = getNameField().getText();

		String calories = getCaloriesField().getText();
		
		int meal_calories = Integer.parseInt(calories);

		String servings = getServingsField().getText();
		int meal_servings = Integer.parseInt(servings);

		Meal myMeal = new Meal(meal_name, meal_calories, meal_servings);

		return myMeal;
	}
	
	
}
