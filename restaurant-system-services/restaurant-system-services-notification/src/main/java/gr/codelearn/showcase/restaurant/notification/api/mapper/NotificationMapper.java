package gr.codelearn.showcase.restaurant.notification.api.mapper;

import gr.codelearn.showcase.restaurant.notification.api.resource.NotificationResource;
import gr.codelearn.showcase.restaurant.notification.domain.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface NotificationMapper extends BaseMapper<Notification, NotificationResource> {
}
