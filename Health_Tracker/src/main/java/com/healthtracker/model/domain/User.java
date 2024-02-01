package main.java.com.healthtracker.model.domain;

import java.util.UUID;

/**
 * Represents a user who is tracking their nutrition.
 */
public class User {

    private UUID userId;
    private String name;
    private int age;
    private int heightInCm;
    private double weightInKg;
    private String gender;
    private int dailyCalorieGoal;

    /**
     * Constructs a new User object.
     *
     * @param name the name of the user
     * @param age the age of the user
     * @param heightInCm the height of the user in centimeters
     * @param weightInKg the weight of the user in kilograms
     * @param gender the gender of the user
     * @param dailyCalorieGoal the user's daily calorie goal
     */
    public User(String name, int age, int heightInCm, double weightInKg, String gender, int dailyCalorieGoal) {
        this.userId = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.heightInCm = heightInCm;
        this.weightInKg = weightInKg;
        this.gender = gender;
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    /**
     * Returns the user's ID.
     *
     * @return the user's ID
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Returns the user's name.
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the user's age.
     *
     * @return the user's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the user's height in centimeters.
     *
     * @return the user's height in centimeters
     */
    public int getHeightInCm() {
        return heightInCm;
    }

    /**
     * Returns the user's weight in kilograms.
     *
     * @return the user's weight in kilograms
     */
    public double getWeightInKg() {
        return weightInKg;
    }

    /**
     * Returns the user's gender.
     *
     * @return the user's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Returns the user's daily calorie goal.
     *
     * @return the user's daily calorie goal
     */
    public int getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    /**
     * Sets the user's name.
     *
     * @param name the new name for the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the user's age.
     *
     * @param age the new age for the user
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the user's height in centimeters.
     *
     * @param heightInCm the new height in centimeters for the user
     */
    public void setHeightInCm(int heightInCm) {
        this.heightInCm = heightInCm;
    }

    /**
     * Sets the user's weight in kilograms.
     *
     * @param weightInKg the new weight in kilograms for the user
     */
    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }
    }
