package gr.codelearn.showcase.restaurant.system.api.transfer;

public record ApiError(Integer status, String message, String path) {
}
