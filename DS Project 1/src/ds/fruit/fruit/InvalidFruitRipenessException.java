package ds.fruit;

//We've created and used a custom exception, so the user can now know what the exact exception is.
public class InvalidFruitRipenessException extends Exception {
	
	public InvalidFruitRipenessException(String errorMessage) {
        super(errorMessage);
    }
	
}
