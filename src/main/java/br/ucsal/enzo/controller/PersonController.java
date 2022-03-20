package br.ucsal.enzo.controller;

import br.ucsal.enzo.domain.Person;
import br.ucsal.enzo.service.PersonService;
import dto.PersonPostRequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("msg")
@Log4j2
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok(personService.listALl());
    }
    @GetMapping(path = "/{id}")
    public  ResponseEntity<Person> findByIdOrThrowBadRequestException(@PathVariable long id){
        return  ResponseEntity.ok(personService.findByIdOrThrowBadRequestException(id));
    }

}
