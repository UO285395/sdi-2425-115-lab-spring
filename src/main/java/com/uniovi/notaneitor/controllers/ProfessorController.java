package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.ProfessorService;
import com.uniovi.notaneitor.validators.AddProfessorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.StampedLock;

@Controller
public class ProfessorController {
    private final  AddProfessorValidator addProffesorValidator;

    @Autowired
    private ProfessorService professorService;

    public ProfessorController(AddProfessorValidator addProffesorValidator) {
        this.addProffesorValidator = addProffesorValidator;
    }

    @RequestMapping("/professor/add")
    public String getProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/add";
    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@Validated Professor professor, BindingResult result) {
        addProffesorValidator.validate(professor, result);
        if (result.hasErrors()) {
            return "professor/add";
        }
        professorService.addProfessor(professor);
        return "redirect:/professor/list";
    }


    @RequestMapping("/professor/list")
    public String getList(Model model){
        model.addAttribute("professorList", professorService.getProfessors());
        return "/professor/list";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id){
        professorService.deleteProfessor(id);
        return "redirect:/professor/list";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id){
        model.addAttribute("professor", professorService.getProfessor(id));
        return "/professor/details";
    }

    @RequestMapping(value = "/professor/edit/{id}", method = RequestMethod.GET)
    public String getEdit(Model model, @PathVariable Long id) {
        Professor professor = professorService.getProfessor(id);
        model.addAttribute("professor", professor);
        return "professor/edit";
    }

    @RequestMapping(value = "/professor/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@Validated @ModelAttribute Professor professor, BindingResult result, @PathVariable Long id, Model model) {
        addProffesorValidator.validate(professor, result);
        if (result.hasErrors()) {
            model.addAttribute("professor", professor);
            return "professor/edit";
        }
        professor.setId(id);
        professorService.addProfessor(professor);
        return "redirect:/professor/details/" + id;
    }


}
