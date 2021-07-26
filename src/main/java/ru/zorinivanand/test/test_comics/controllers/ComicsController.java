package ru.zorinivanand.test.test_comics.controllers;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zorinivanand.test.test_comics.models.Comics;
import ru.zorinivanand.test.test_comics.service.impl.ComicsServiceImpl;

import javax.validation.Valid;
import java.awt.print.Pageable;


@Controller
@RequestMapping("/comics")
public class ComicsController {


    private final ComicsServiceImpl comicsService;

    public ComicsController(ComicsServiceImpl comicsService) {
        this.comicsService = comicsService;

    }

    @GetMapping()
    public ResponseEntity<?> indexComics(Model model){
        model.addAttribute("comics",comicsService.indexComics());
        return new ResponseEntity<Comics>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> showComics(@RequestParam("id")int id, Model model, @PageableDefault(sort = { "id" }, direction = SpringDataWebProperties.Sort.Direction.DESC)Pageable pageable){
        model.addAttribute("comics",comicsService.showComics (id));
        return "comics/show" != null &&  !"comics/show".isEmpty()
                ? new ResponseEntity<>("comics/show", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/new")
    public String newComics(@ModelAttribute("comics") Comics comics){
        return "comics/new";
    }
    @PostMapping()
    public ResponseEntity<?> createComics(@ModelAttribute("comics")@Valid Comics comics){
        comicsService.saveComics(comics);
            return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateComics(@ModelAttribute("comics")@Valid Comics comics,@PathVariable("id") int id){
        comicsService.updateComics (id,comics);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComics(@PathVariable("id") int id){
        comicsService.deleteComics (id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
