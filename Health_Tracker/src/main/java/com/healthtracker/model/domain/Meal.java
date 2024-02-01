package main.java.com.healthtracker.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The Meal class represents a single meal with a name, number of servings, and
 * calories per serving.
 */

public class Meal implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int caloriesPerServing;
	private int numberOfServings;
	private LocalDate date;

	/**
	 * Constructs a new Meal object with the specified name, calories per serving,
	 * and number of servings.
	 *
	 * @param name               the name of the meal
	 * @param caloriesPerServing the number of calories per serving
	 * @param numberOfServings   the number of servings
	 */
	public Meal(String name, int caloriesPerServing, int numberOfServings) {
		this.name = name;
		this.caloriesPerServing = caloriesPerServing;
		this.numberOfServings = numberOfServings;
	}

	/**
	 * Constructs a new Meal object with the specified name, calories per serving,
	 * and number of servings, and date.
	 *
	 * @param name               the name of the meal
	 * @param caloriesPerServing the number of calories per serving
	 * @param numberOfServings   the number of servings
	 * @param date               the date the meal was consumed
	 */
	public Meal(String name, int caloriesPerServing, int numberOfServings, LocalDate date) {
		this.name = name;
		this.caloriesPerServing = caloriesPerServing;
		this.numberOfServings = numberOfServings;
		this.date = date;
	}

	/**
	 * Calculates and returns the total number of calories in the meal.
	 *
	 * @return the total number of calories
	 */
	public int getTotalCalories() {
		return this.caloriesPerServing * this.numberOfServings;
	}

	/**
	 * Returns the name of the meal.
	 *
	 * @return the name of the meal
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the number of calories per serving.
	 *
	 * @return the number of calories per serving
	 */
	public int getCaloriesPerServing() {
		return caloriesPerServing;
	}

	/**
	 * Returns the number of servings.
	 *
	 * @return the number of servings
	 */
	public int getNumberOfServings() {
		return numberOfServings;
	}

	/**
	 * Sets the name of the meal.
	 *
	 * @param name the new name of the meal
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the number of calories per serving.
	 *
	 * @param caloriesPerServing the new number of calories per serving
	 */
	public void setCaloriesPerServing(int caloriesPerServing) {
		this.caloriesPerServing = caloriesPerServing;
	}

	/**
	 * Sets the number of servings.
	 *
	 * @param numberOfServings the new number of servings
	 */
	public void setNumberOfServings(int numberOfServings) {
		this.numberOfServings = numberOfServings;
	}

	/**
	 * Validates the meal by checking that the name is not empty and the number of
	 * servings and calories per serving are positive.
	 *
	 * @return true if the meal is valid, false otherwise
	 */
	public boolean validate() {
		return !name.isEmpty() && caloriesPerServing > 0 && numberOfServings > 0;
	}

	/**
	 * Returns the hash code value for the meal.
	 *
	 * @return the hash code value for the meal
	 */
	@Override
	public int hashCode() {
		return Objects.hash(caloriesPerServing, name, numberOfServings);
	}

	/**
	 * Compares this meal to the specified object for equality.
	 *
	 * @param obj the object to compare to
	 * @return true if the meal and the specified object are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Meal))
			return false;
		Meal meal = (Meal) obj;
		return meal.name.equals(name) && meal.caloriesPerServing == caloriesPerServing
				&& meal.numberOfServings == numberOfServings;
	}

	/**
	 * Returns a String representation of the Meal object.
	 *
	 * @return A String representation of the Meal object.
	 */
	@Override
	public String toString() {
		return "Meal [name=" + name + ", caloriesPerServing=" + caloriesPerServing + ", numberOfServings="
				+ numberOfServings + "]";
	}

	/**
	 * Returns the date set for this object.
	 *
	 * @return the date set for this object
	 */
	public LocalDate getDate() {
		return date;
	}
}
