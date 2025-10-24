package gr.codelearn.showcase.restaurant.system.api.mapper;

import gr.codelearn.showcase.restaurant.system.api.resource.CustomerResource;
import gr.codelearn.showcase.restaurant.system.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface CustomerMapper extends BaseMapper<Customer, CustomerResource> {
}
