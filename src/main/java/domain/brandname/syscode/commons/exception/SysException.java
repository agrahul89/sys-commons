package domain.brandname.syscode.commons.exception;

public class SysException extends Exception {

	private static final long serialVersionUID = 2627995124156334806L;
	private Errors error = Errors.NA;

	public SysException() {
		super();
	}

	public SysException(Errors error) {
		this(error.getErrorDesc());
		this.error = error;
	}

	public SysException(Errors error, Throwable cause) {
		this(error.getErrorDesc(), cause);
		this.error = error;
	}

	public SysException(String mesage) {
		super(mesage);
	}

	public SysException(String mesage, Throwable cause) {
		super(mesage, cause);
	}

	public SysException(Throwable cause) {
		super(cause);
	}

	protected Errors getError() {
		return error;
	}

}
