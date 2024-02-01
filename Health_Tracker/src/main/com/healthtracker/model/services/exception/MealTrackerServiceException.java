package main.com.healthtracker.model.services.exception;


public class MealTrackerServiceException extends Exception {
    private static final long serialVersionUID = 1L;

	public MealTrackerServiceException(String message) {
        super(message);
    }
    
    public MealTrackerServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
