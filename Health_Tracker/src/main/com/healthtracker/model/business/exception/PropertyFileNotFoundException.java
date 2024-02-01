package main.com.healthtracker.model.business.exception;

public class PropertyFileNotFoundException extends Exception
{
    private static final long serialVersionUID = 1L;

    public PropertyFileNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}


