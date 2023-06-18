package bank.service.person;

import lombok.Builder;

@Builder
public record PersonDto(
        String uid,
        String name,
        String email
) {
}
