package gr.codelearn.showcase.restaurant.system.exception;

import lombok.Getter;

// This exception is thrown when an item is not found in the database.
@Getter
public class ResourceNotFoundException extends ContentException {
	private String resource;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}

	public ResourceNotFoundException(final String message, final String resource) {
		super(message);
		this.resource = resource;
	}

	public ResourceNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(final Throwable cause) {
		super(cause);
	}
}
