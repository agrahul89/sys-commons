package domain.brandname.syscode.commons.exception;

public class InitializationException extends RuntimeException {

	private static final long serialVersionUID = 2627995124156334806L;

	public InitializationException(String mesage) {
		super(mesage);
	}

	public InitializationException(String mesage, Throwable cause) {
		super(mesage, cause);
	}

	public InitializationException(Throwable cause) {
		super(cause);
	}

}
