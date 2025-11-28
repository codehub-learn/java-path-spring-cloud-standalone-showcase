package gr.codelearn.showcase.restaurant.commons.api.transfer;

public record ApiError(Integer status, String message, String path) {
}
