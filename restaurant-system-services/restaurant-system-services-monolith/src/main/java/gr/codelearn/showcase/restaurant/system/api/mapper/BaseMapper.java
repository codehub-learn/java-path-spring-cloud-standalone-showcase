package gr.codelearn.showcase.restaurant.system.api.mapper;

import java.util.List;

public interface BaseMapper<D, R> {
	//@formatter:off
	R toResource(D domain);
	List<R> toResources(List<D> domains);
	D toDomain(R resource);
	List<D> toDomains(List<R> resources);
}
