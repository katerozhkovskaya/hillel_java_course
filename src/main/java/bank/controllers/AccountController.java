package bank.controllers;

import bank.service.account.AccountDto;
import bank.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/{id}")
    public AccountDto getAccount(@PathVariable("id") String id) {
        return accountService.findAccount(id);
    }

    @GetMapping
    public List<AccountDto> getAccounts(Pageable pageable) {
        return accountService.findAccounts(pageable);
    }

    @PostMapping
    public AccountDto createAccount(@RequestBody AccountDto account) {
        return accountService.create(account);
    }

    @PutMapping("/{id}")
    public AccountDto updateAccount(@PathVariable("id") String id, @RequestBody AccountDto account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") String id) {
        accountService.deleteAccount(id);
    }
}
