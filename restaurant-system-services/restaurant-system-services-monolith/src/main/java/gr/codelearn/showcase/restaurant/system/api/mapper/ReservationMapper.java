package gr.codelearn.showcase.restaurant.system.api.mapper;

import gr.codelearn.showcase.restaurant.commons.api.mapper.BaseMapper;
import gr.codelearn.showcase.restaurant.commons.api.mapper.IgnoreUnmappedMapperConfig;
import gr.codelearn.showcase.restaurant.commons.api.resource.ReservationResource;
import gr.codelearn.showcase.restaurant.system.domain.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface ReservationMapper extends BaseMapper<Reservation, ReservationResource> {
}
