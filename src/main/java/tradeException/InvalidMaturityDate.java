package tradeException;

public class InvalidMaturityDate extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidMaturityDate(String message) {
		super(message);
	}

}
