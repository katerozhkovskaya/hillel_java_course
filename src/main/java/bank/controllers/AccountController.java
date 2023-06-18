package bank.controllers;

import bank.service.PersonOperationsService;
import bank.service.account.AccountDto;
import bank.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final PersonOperationsService personOperationsService;
    Currency fromCurrency = Currency.getInstance("UAH");
    Currency toCurrency = Currency.getInstance("USD");

    @GetMapping("/{id}")
    public AccountDto getAccount(@PathVariable("id") String id) {
        log.info("Getting account by Id': id={}", id);
        return accountService.findAccount(id);
    }

    @GetMapping
    public List<AccountDto> getAccounts(Pageable pageable) {
        log.info("Getting all accounts");
        return accountService.findAccounts(pageable);
    }

    @PostMapping
    public AccountDto createAccount(@RequestBody AccountDto account) {
        log.info("Getting account data: accountIBAN={}, accountBalanceUAH={}, accountCurrency={}, personId={}",
                account.iban(), account.balance(), account.currency(), account.personId());

        if (account.currency() == null || account.currency().equals("UAH")) {

            log.info("Creating account in UAH: accountIBAN={}, accountBalanceUAH={}, personId={}",
                    account.iban(), account.balance(), account.personId());

            return accountService.create(AccountDto.builder()
                    .iban(account.iban())
                    .balance(account.balance())
                    .currency("UAH")
                    .personId(account.personId())
                    .build());
        } else {
            CompletableFuture<Double> conversionResult = personOperationsService.convert(fromCurrency, toCurrency, account.balance());
            long convertedAmount = conversionResult.join().longValue();

            log.info("Creating account in USD: accountIBAN={}, accountBalanceUSD={}, personId={}",
                    account.iban(), convertedAmount, account.personId());

            return accountService.create(AccountDto.builder()
                    .iban(account.iban())
                    .balance(convertedAmount)
                    .personId(account.personId())
                    .currency("USD")
                    .build());
        }
    }

    @PutMapping("/{id}")
    public AccountDto updateAccount(@PathVariable("id") String id, @RequestBody AccountDto account) {
        log.info("Updating account: accountId={}, accountBalance={}", id, account.balance());
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") String id) {
        log.info("Deleting account: accountId = {}", id);
        accountService.deleteAccount(id);
    }
}
