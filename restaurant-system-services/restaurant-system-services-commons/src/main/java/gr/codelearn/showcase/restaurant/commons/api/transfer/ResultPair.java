package gr.codelearn.showcase.restaurant.commons.api.transfer;

public interface ResultPair<T1, T2> {
	T1 getKey();

	T2 getValue();
}
