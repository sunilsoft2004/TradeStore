package tradeException;

public class InvalidVersion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidVersion(String message) {
		super(message);
	}

}
