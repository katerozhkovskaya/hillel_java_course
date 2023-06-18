package bank.service.person;

import bank.repository.person.Person;
import bank.repository.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<PersonDto> findPersons(Pageable pageable) {
        return personRepository.findAll(pageable).stream()
                .map(this::mapPerson)
                .toList();
    }

    public PersonDto findPerson(String id) {
        return personRepository
                .findByUid(id)
                .map(this::mapPerson)
                .orElseThrow();
    }

    public void deletePerson(String uid) {
        var person =  personRepository.findByUid(uid).orElseThrow();
        personRepository.delete(person);
    }

    public PersonDto updatePerson(String uid, PersonDto person) {
        var personToUpdate = personRepository.findByUid(uid).orElseThrow();
        personToUpdate.setName(person.name());
        personToUpdate.setEmail(person.email());
        return mapPerson(personRepository.save(personToUpdate));
    }

    public PersonDto create(PersonDto person) {
        var savedPerson = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name(person.name())
                .email(person.email())
                .build());
        return mapPerson(savedPerson);
    }

    private PersonDto mapPerson(Person person) {
        return PersonDto.builder()
                .uid(person.getUid())
                .name(person.getName())
                .email(person.getEmail())
                .build();
    }
}
