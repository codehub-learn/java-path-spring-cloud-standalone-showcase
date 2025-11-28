package gr.codelearn.showcase.restaurant.commons.exception;

public class RestaurantException extends RuntimeException {
	public RestaurantException() {
		super();
	}

	public RestaurantException(final String message) {
		super(message);
	}

	public RestaurantException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public RestaurantException(final Throwable cause) {
		super(cause);
	}
}
