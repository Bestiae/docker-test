package com.capco.expensesapp.services;

import com.capco.expensesapp.dtos.PersonDTO;
import com.capco.expensesapp.dtos.PersonShortDTO;
import com.capco.expensesapp.exception.NotFoundException;
import com.capco.expensesapp.models.Person;
import com.capco.expensesapp.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PersonService(PersonRepository repository, ModelMapper modelMapper) {
        this.personRepository = repository;
        this.modelMapper = modelMapper;
    }

    public List<PersonDTO> getAllUsers() {
        log.info("userRepository.findAll()");
        return personRepository.findAll().stream().map((o) -> modelMapper.map(o, PersonDTO.class)).collect(Collectors.toList());
    }

    public PersonDTO findPersonById(Long id) {
        log.info("personRepository.findById({});", id);
        Person person = personRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Person with " + id + " not exist."));
        return modelMapper.map(person, PersonDTO.class);
    }

    public PersonShortDTO findPersonShortById(Long id) {
        log.info("personRepository.findById({});", id);
        Person person = personRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Person with " + id + " not exist."));
        return modelMapper.map(person, PersonShortDTO.class);
    }

    public PersonDTO addFriend(PersonDTO personDTO) {
        Person person = modelMapper.map(personDTO, Person.class);
        log.info("personRepository.save({})", person);
        personRepository.save(person);
        return modelMapper.map(person, PersonDTO.class);
    }

    public void deletePersonById(Long id) {
        log.info("personRepository.findById({});", id);
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person is not present in the table with this id:" + id));
        log.info("personRepository.deletePersonById({});", person.getId());
        personRepository.deletePersonById(person.getId());
    }

    public int countAllPerson() {
        log.info("personRepository.findAll().size();");
        return personRepository.findAll().size();
    }

    public List<PersonDTO> findByFullName(String name) {
        log.info("personRepository.findAllByFull_name({});", name);
        return modelMapper.map(personRepository.findAllByName(name), new TypeToken<List<PersonDTO>>(){}.getType());
    }

    public List<PersonDTO> findAllPersonByCountry(String country) {
        log.info("personRepository.findAllByCountry({}});", country);
        List<Person> person = personRepository.findAllByCountry(country);
        return modelMapper.map(person, new TypeToken<List<PersonDTO>>(){}.getType());
    }


}
