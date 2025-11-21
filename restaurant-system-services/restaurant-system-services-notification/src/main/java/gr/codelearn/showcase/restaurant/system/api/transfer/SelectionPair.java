package gr.codelearn.showcase.restaurant.system.api.transfer;

import java.util.List;

public record SelectionPair<T>(List<T> available, List<T> selected) {
}
