package gr.codelearn.showcase.restaurant.notification.api.controller;

import gr.codelearn.showcase.restaurant.notification.api.mapper.NotificationMapper;
import gr.codelearn.showcase.restaurant.notification.api.resource.NotificationResource;
import gr.codelearn.showcase.restaurant.notification.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class NotificationController {
	private final NotificationService notificationService;
	private final NotificationMapper notificationMapper;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody @Valid NotificationResource notificationResource) {
		notificationService.sendReservationConfirmation(notificationMapper.toDomain(notificationResource));
	}
}