package br.ucsal.enzo.controller;

import br.ucsal.enzo.domain.Person;
import br.ucsal.enzo.service.PersonService;
import dto.PersonPostRequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("msg")
@Log4j2
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/all")
    public String index(Model model){
        model.addAttribute("pessoas", personService.listALl());
        return "index";
    }
    @GetMapping("/addnew")
    public String addNewPerson(Model model) {
        Person p = new Person();
        model.addAttribute("pessoa", p);
        return "novaPessoa";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("PersonPostRequestBody") PersonPostRequestBody personPostRequestBody) {
        personService.save(personPostRequestBody);
        return "redirect:/msg/all";
    }


    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok(personService.listALl());
    }
    @GetMapping(path = "/{id}")
    public  ResponseEntity<Person> findByIdOrThrowBadRequestException(@PathVariable long id){
        return  ResponseEntity.ok(personService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity <Person> save(@RequestBody PersonPostRequestBody personPostRequestBody){
        return new  ResponseEntity<>(personService.save(personPostRequestBody), HttpStatus.CREATED) ;
    }
}
