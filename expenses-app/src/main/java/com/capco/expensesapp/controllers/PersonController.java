package com.capco.expensesapp.controllers;

import com.capco.expensesapp.dtos.PersonDTO;
import com.capco.expensesapp.dtos.PersonShortDTO;
import com.capco.expensesapp.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/size")
    public int countAllPerson() {
        log.info("personService.countAllPerson();");
        System.out.println("LOL funguje!");
        return personService.countAllPerson();
    }

    @GetMapping("/test")
    public String test() {
        return "you need to learn more about docker compose.";
    }

    @GetMapping("/all")
    public List<PersonDTO> getAllPersons(){
        log.info("personService.getAllUsers();");
        return personService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public PersonDTO getFriendById(@PathVariable(value = "id")  Long id) { //@Min(value = 0, message = "Friends id must be more then 0")
        log.info("getFriendById({})", id);
        return personService.findPersonById(id);
    }

    @GetMapping("/get-short/{id}")
    public PersonShortDTO getFriendShortById(@PathVariable(value = "id") @Min(value = 0, message = "Friends id must be more then 0") Long id) {
        log.info("getFriendShortById({})", id);
        return personService.findPersonShortById(id);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public PersonDTO addFriend(@RequestBody @Valid PersonDTO personDTO) {
        log.info("personService.addFriend({})", personDTO);
        return personService.addFriend(personDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteFriendById(@PathVariable(value = "id") @Min(value = 0, message = "Friends id must be more then 0") Long id) {
        log.info("personService.deletePersonById({});", id);
        personService.deletePersonById(id);
    }

    @GetMapping("/full-name")
    public List<PersonDTO> findPersonByName(@RequestParam(required = true) String name) {
        log.info("personService.findByFullName({});", name);
        return personService.findByFullName(name);
    }

    @GetMapping("/get")
    public List<PersonDTO> findALlByCountry(@RequestParam String country) {
        log.info("personService.findAllPersonByCountry({}});", country );
        return personService.findAllPersonByCountry(country);
    }

}
