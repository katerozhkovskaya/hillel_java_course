package bank.controllers;

import bank.service.account.AccountDto;
import bank.service.account.AccountService;
import bank.service.person.PersonDto;
import bank.service.person.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    private final AccountService accountService;

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable("id") String id) {
        log.info("Getting personById: id={}", id);
        return personService.findPerson(id);
    }

    @GetMapping
    public List<PersonDto> getPersons(Pageable pageable) {
        log.info("Getting all persons");
        return personService.findPersons(pageable);
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto person) {
        log.info("Creating person: personName={}, personEmail={}", person.name(), person.email());
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public PersonDto updatePerson(@PathVariable("id") String id, @RequestBody PersonDto person) {
        log.info("Updating person: personId = {}, personNameToUpdate={}, personEmailToUpdate={}", id, person.name(), person.email());
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        log.info("Deleting person: personId = {}", id);
        personService.deletePerson(id);
    }


    @GetMapping("/{persoid}/accounts")
    public List<AccountDto> getPersonAccounts(@PathVariable("persoid") String personId) {
        log.info("Getting person's accounts: personId = {}", personId);
        return accountService
                .findPersonAccounts(personService.findPerson(personId).uid());
    }

    @PostMapping("/{personId}/accounts")
    public AccountDto createPersonAccount(@PathVariable("personId") String personId, @RequestBody AccountDto account) {
        log.info("Creating person account: personId={}, accountToCreate={}", personId, account);
        return accountService.createPersonAccount(account, personId);
    }

    @DeleteMapping("/{personId}/accounts")
    public void deletePersonAccounts(@PathVariable("id") String personId) {
        log.info("Deleting person accounts: personId = {}", personId);
        accountService.deletePersonAccounts(personService.findPerson(personId).uid());
    }
}
