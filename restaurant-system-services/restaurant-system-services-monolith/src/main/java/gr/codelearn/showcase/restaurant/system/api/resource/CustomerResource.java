package gr.codelearn.showcase.restaurant.system.api.resource;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record CustomerResource(Long id, @NotEmpty String name, @NotEmpty String phone, @Email String email) {
}
