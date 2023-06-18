package bank.lesson30;

import bank.BankApplication;
import bank.repository.account.Account;
import bank.repository.account.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BankApplication.class)
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    protected AccountRepository accountRepository;
    @Autowired
    protected MockMvc mockMvc;

    @BeforeEach
    void clearAccountsBeforeEachTest() {
        accountRepository.deleteAll();
    }

    @Test
    void shouldGetAllAccounts() throws Exception {

        var iban = "UA1234567890123456";

        var accountUid = UUID.randomUUID().toString();
        var personUid = UUID.randomUUID().toString();
        accountRepository.save(Account.builder()
                .uid(accountUid)
                .iban(iban)
                .balance(1000L)
                .personId(personUid)
                .build());

        mockMvc.perform(get("/api/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].uid", is(accountUid)))
                .andExpect(jsonPath("$[0].personId", is(personUid)))
                .andExpect(jsonPath("$[0].iban", is(iban)));
    }

    @Test
    void shouldGetAccountById() throws Exception {

        var iban = "UA1234567890123456";
        var accountUid = UUID.randomUUID().toString();
        var personUid = UUID.randomUUID().toString();
        var account = accountRepository.save(Account.builder()
                .uid(accountUid)
                .iban(iban)
                .balance(1010L)
                .personId(personUid)
                .build());

        mockMvc.perform(get("/api/accounts/{id}", account.getUid()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uid", is(accountUid)))
                .andExpect(jsonPath("$.personId", is(personUid)))
                .andExpect(jsonPath("$.iban", is(iban)));
    }

    @Test
    void shouldCreateAccount() throws Exception {

        var iban = "UA1234567890123456";
        String requestBody = "{\"iban\": \"" + iban + "\", \"balance\":\"1001\"}";
        mockMvc.perform(post("/api/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.iban", is(iban)))
                .andExpect(jsonPath("$.uid").isNotEmpty());
    }

    @Test
    void shouldUpdateAccount() throws Exception {
        var iban = "UA1234567890123456";
        var balanceToUpdate = 2000;
        var accountUid = UUID.randomUUID().toString();
        var personUid = UUID.randomUUID().toString();
        var account = accountRepository.save(Account.builder()
                .uid(accountUid)
                .iban(iban)
                .balance(1000L)
                .personId(personUid)
                .build());

        String requestBody = "{\"balance\": \"" + balanceToUpdate + "\"}";
        mockMvc.perform(put("/api/accounts/{id}", account.getUid())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uid", is(accountUid)))
                .andExpect(jsonPath("$.personId", is(personUid)))
                .andExpect(jsonPath("$.iban", is(iban)))
                .andExpect(jsonPath("$.balance", is(balanceToUpdate)));
    }


    @Test
    void shouldDeleteAccount() throws Exception {

        var iban = "UA1234567890123456";
        var accountUid = UUID.randomUUID().toString();
        var personUid = UUID.randomUUID().toString();
        var account = accountRepository.save(Account.builder()
                .uid(accountUid)
                .iban(iban)
                .balance(1000L)
                .personId(personUid)
                .build());

        var query = delete("/api/accounts/{id}", account.getUid());

        mockMvc.perform(query)
                .andExpect(status().isOk());
    }
}

