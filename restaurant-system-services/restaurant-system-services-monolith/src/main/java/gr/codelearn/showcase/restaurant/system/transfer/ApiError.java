package gr.codelearn.showcase.restaurant.system.transfer;

import lombok.Value;

@Value
public class ApiError {
	Integer status;
	String message;
	String path;
}
