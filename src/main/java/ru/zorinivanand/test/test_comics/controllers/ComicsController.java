package ru.zorinivanand.test.test_comics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zorinivanand.test.test_comics.dao.ModelsDAO;
import ru.zorinivanand.test.test_comics.models.Comics;

import javax.validation.Valid;


@Controller
@RequestMapping("/comics")
public class ComicsController {


    private final ModelsDAO modelsDAO;

    public ComicsController (ModelsDAO modelsDAO) {
        this.modelsDAO = modelsDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("comics",modelsDAO.index1());
        return "comics/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id, Model model){
        model.addAttribute("comics",modelsDAO.show1 (id));
        return "comics/show";
    }
    @GetMapping("/new")
    public String newComics(@ModelAttribute("comics") Comics comics){
        return "comics/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("comics")@Valid Comics comics,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "comics/new";

        modelsDAO.save1(comics);
        return "redirect:/comics";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("comics",modelsDAO.show1(id));
        return "comics/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("comics")@Valid Comics comics, BindingResult bindingResult,@PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "comics/edit";
        modelsDAO.update1 (id,comics);
        return "redirect:/comics";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        modelsDAO.delete1 (id);
        return "redirect:/comics";
    }
}
