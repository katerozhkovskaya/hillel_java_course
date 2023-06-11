package lesson28.service;

import lesson28.enums.UserRole;
import lombok.Builder;

@Builder
public record UserDto(String id, String name, String email, UserRole role) {
}
