package bank.service;

import bank.repository.Account;
import bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<AccountDto> findAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable).stream()
                .map(this::mapAccount)
                .toList();
    }

    public AccountDto findAccount(String uid) {
        return accountRepository.findByUid(uid)
                .map(this::mapAccount)
                .orElse(null);
    }

    public List<AccountDto> findPersonAccounts(String personUid) {
        return accountRepository
                .findByPersonId(personUid)
                .stream()
                .map(this::mapAccount)
                .toList();
    }

    public void deleteAccount(String uid) {
        var account =  accountRepository.findByUid(uid).orElseThrow();
        accountRepository.delete(account);
    }

    public void deletePersonAccounts(String uid) {
        var account =  accountRepository.findByPersonId(uid);
        account.forEach(accountRepository::delete);
    }

    public AccountDto updateAccount(String uid, AccountDto account) {
        var accountToUpdate = accountRepository.findByUid(uid).orElseThrow();
        accountToUpdate.setBalance(account.balance());
        return mapAccount(accountRepository.save(accountToUpdate));
    }

    public AccountDto create(AccountDto account) {
        var savedAccount = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .balance(account.balance())
                .iban(account.iban())
                .personId(account.personId())
                .build());
        return mapAccount(savedAccount);
    }

    public AccountDto createPersonAccount(AccountDto account, String personId) {
        var savedAccount = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .balance(account.balance())
                .iban(account.iban())
                .personId(personId)
                .build());
        return mapAccount(savedAccount);
    }

    private AccountDto mapAccount(Account account) {
        return AccountDto.builder()
                .uid(account.getUid())
                .iban(account.getIban())
                .balance(account.getBalance())
                .personId(account.getPersonId())
                .build();
    }
}
