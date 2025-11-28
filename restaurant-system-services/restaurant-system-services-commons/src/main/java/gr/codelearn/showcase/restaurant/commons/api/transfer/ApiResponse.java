package gr.codelearn.showcase.restaurant.commons.api.transfer;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Value
@Builder
public class ApiResponse<T> implements Serializable {
	//@formatter:off
	String transactionId = UUID.randomUUID().toString().toUpperCase();
	ZonedDateTime createdAt = ZonedDateTime.now();
	T data;
	ApiError apiError;
}
