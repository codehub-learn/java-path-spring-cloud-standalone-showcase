package gr.codelearn.showcase.restaurant.notification.api.transfer;

public record ApiError(Integer status, String message, String path) {
}
