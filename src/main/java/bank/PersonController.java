package bank;

import bank.service.AccountDto;
import bank.service.AccountService;
import bank.service.PersonDto;
import bank.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    private final AccountService accountService;

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable("id") String id) {
        return personService.findPerson(id);
    }

    @GetMapping
    public List<PersonDto> getPersons(Pageable pageable) {
        return personService.findPersons(pageable);
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto person) {
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public PersonDto updatePerson(@PathVariable("id") String id, @RequestBody PersonDto person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        personService.deletePerson(id);
    }


    @GetMapping("/{persoid}/accounts")
    public List<AccountDto> getPersonAccounts(@PathVariable("persoid") String personId) {
        return accountService
                .findPersonAccounts(personService.findPerson(personId).uid());
    }

    @PostMapping("/{personId}/accounts")
    public AccountDto createPersonAccount(@PathVariable("personId") String personId, @RequestBody AccountDto account) {
        return accountService.createPersonAccount(account, personId);
    }

    @DeleteMapping("/{personId}/accounts")
    public void deletePersonAccounts(@PathVariable("id") String personId) {
        accountService.deletePersonAccounts(personService.findPerson(personId).uid());
    }
}
