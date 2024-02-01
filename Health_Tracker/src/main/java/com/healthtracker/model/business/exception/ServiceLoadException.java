package main.java.com.healthtracker.model.business.exception;

public class ServiceLoadException extends Exception {
    private static final long serialVersionUID = 1L;

    public ServiceLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}

