package gr.codelearn.showcase.restaurant.commons.api.transfer;

import java.util.List;

public record SelectionPair<T>(List<T> available, List<T> selected) {
}
