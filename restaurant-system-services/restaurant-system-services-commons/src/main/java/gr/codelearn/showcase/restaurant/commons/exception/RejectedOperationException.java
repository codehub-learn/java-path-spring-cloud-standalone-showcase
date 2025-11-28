package gr.codelearn.showcase.restaurant.commons.exception;

public class RejectedOperationException extends ValidationException {
	public RejectedOperationException() {
		super();
	}

	public RejectedOperationException(final String message) {
		super(message);
	}

	public RejectedOperationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public RejectedOperationException(final Throwable cause) {
		super(cause);
	}
}
