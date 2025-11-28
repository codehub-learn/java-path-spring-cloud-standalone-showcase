package gr.codelearn.showcase.restaurant.notification.api.transfer;

import java.util.List;

public record SelectionPair<T>(List<T> available, List<T> selected) {
}
