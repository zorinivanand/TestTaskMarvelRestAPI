package ru.zorinivanand.test.test_comics.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zorinivanand.test.test_comics.models.Characters;
import ru.zorinivanand.test.test_comics.service.impl.CharactersServiceImpl;

import javax.validation.Valid;
import java.awt.print.Pageable;

@Controller
@RequestMapping("/characters")
public class CharactersController {



    private final CharactersServiceImpl charactersService;

    public CharactersController(CharactersServiceImpl charactersService) {
        this.charactersService = charactersService;

    }

    @GetMapping("/index")
    public ResponseEntity<?> indexCharacters(Model model){
        model.addAttribute("characters",charactersService.indexCharacters());
        return new ResponseEntity<Characters>(HttpStatus.OK) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> showCharacters(@PathVariable("id")int id, Model model, Pageable pageable){
        model.addAttribute("charcters",charactersService.showCharacters(id));
        return "characters/show" != null &&  !"characters/show".isEmpty()
                ? new ResponseEntity<>("characters/show", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/new")
    public String newCharacters(@ModelAttribute("characters") Characters characters){
        return "characters/new";
    }
    @PostMapping("/create")
    public ResponseEntity<?> createCharacters(@ModelAttribute("characters")@Valid Characters characters){
        charactersService.saveCharacters (characters);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCharacters(@ModelAttribute("character")@Valid Characters characters,@PathVariable("id") int id){
        charactersService.updateCharacters (id,characters);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCharacters (@PathVariable("id") int id){
        charactersService.deleteCharacters  (id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
