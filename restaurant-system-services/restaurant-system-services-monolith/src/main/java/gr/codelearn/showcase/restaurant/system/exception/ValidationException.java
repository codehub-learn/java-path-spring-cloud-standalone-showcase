package gr.codelearn.showcase.restaurant.system.exception;

public class ValidationException extends RestaurantException {
	public ValidationException() {
		super();
	}

	public ValidationException(final String message) {
		super(message);
	}

	public ValidationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ValidationException(final Throwable cause) {
		super(cause);
	}
}
