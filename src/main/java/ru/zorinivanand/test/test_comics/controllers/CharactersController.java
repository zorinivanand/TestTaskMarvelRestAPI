package ru.zorinivanand.test.test_comics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zorinivanand.test.test_comics.dao.ModelsDAO;
import ru.zorinivanand.test.test_comics.models.Characters;

import javax.validation.Valid;
@Controller
@RequestMapping("/characters")
public class CharactersController {



    private final ModelsDAO modelsDAO;

    public CharactersController(ModelsDAO modelsDAO) {
        this.modelsDAO = modelsDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("characters",modelsDAO.index2());
        return "characters/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id, Model model){
        model.addAttribute("charcters",modelsDAO.show2(id));
        return "characters/show";
    }
    @GetMapping("/new")
    public String newCharacters(@ModelAttribute("characters") Characters characters){
        return "characters/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("characters")@Valid Characters characters,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "characters/new";

        modelsDAO.save2 (characters);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("characters",modelsDAO.show2(id));
        return "characters/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("character")@Valid Characters characters, BindingResult bindingResult,@PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "characters/edit";
        modelsDAO.update2 (id,characters);
        return "redirect:/characters";
    }
    @DeleteMapping("/{id}")
    public String delete2 (@PathVariable("id") int id){
        modelsDAO.delete2  (id);
        return "redirect:/characters";
    }
}
