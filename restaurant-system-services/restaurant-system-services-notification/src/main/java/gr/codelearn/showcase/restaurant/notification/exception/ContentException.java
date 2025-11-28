package gr.codelearn.showcase.restaurant.notification.exception;

public class ContentException extends RestaurantException {
	public ContentException() {
		super();
	}

	public ContentException(final String message) {
		super(message);
	}

	public ContentException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ContentException(final Throwable cause) {
		super(cause);
	}
}
