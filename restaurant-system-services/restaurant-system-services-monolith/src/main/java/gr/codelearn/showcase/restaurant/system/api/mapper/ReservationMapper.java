package gr.codelearn.showcase.restaurant.system.api.mapper;

import gr.codelearn.showcase.restaurant.system.api.resource.ReservationResource;
import gr.codelearn.showcase.restaurant.system.domain.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface ReservationMapper extends BaseMapper<Reservation, ReservationResource> {
	@Mapping(target = "customerId", source = "customer.id")
	ReservationResource toResource(Reservation domain);
}
