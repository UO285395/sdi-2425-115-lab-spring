package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @RequestMapping("/professor/add")
    public String getProfessor() {
        return "Adding professor";
    }

    @RequestMapping(value ="/professor/add", method = RequestMethod.POST)
    public String setProfessor() {
        professorService.addProfessors(new Professor());
        return "Adding professor";
    }

    @RequestMapping(value ="/professor/edit", method = RequestMethod.POST)
    public String setEdit() {
        return "Editing professor";
    }


    @RequestMapping("/professor/list")
    public String getProfessorList(){
        return professorService.getListProfessors();
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id){
        professorService.deleteProfessors(professorService.getProfessor(id));
        return "Deleting professor => " + id;
    }

    @RequestMapping("/professor/edit/{id}")
    public String editProfessor(@PathVariable Long id){

        return "Editing professor " + id;
    }

    @RequestMapping("/professor/details")
    public String detailsProfessor(@RequestParam Long id){
        return "Details professor => " + id;
    }





}
