package bank.service;

import lombok.Builder;

@Builder
public record AccountDto(
        String uid,
        String iban,
        Long balance,
        String personId
) {
}
