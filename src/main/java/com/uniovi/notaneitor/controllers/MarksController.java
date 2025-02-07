package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.services.MarksService;
import com.uniovi.notaneitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.uniovi.notaneitor.entities.*;


@Controller
public class MarksController {

    private final MarksService marksService;
    private final UsersService usersService;
    public MarksController(MarksService marksService, UsersService usersService) {
        this.marksService = marksService;
        this.usersService = usersService;
    }


    //    @RequestMapping("/mark/list")
//    public String getList(){
//        return marksService.getMarks().toString();
//    }
@RequestMapping("/mark/list")
public String getList(Model model){
    model.addAttribute("markList",marksService.getMarks());
    return "mark/list";
}


@RequestMapping(value="/mark/add")
public String getMark(Model model){
     model.addAttribute("usersList", usersService.getUsers());
     return "mark/add";
}

    @RequestMapping( value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        marksService.addMark(mark);
        return "redirect:/mark/list";
    }

//    @RequestMapping( value = "/mark/add", method = RequestMethod.POST)
//    public String setMark(@ModelAttribute Mark mark) {
//        return "Added " + mark.getDescription() +
//                " with score " + mark.getScore()+
//                " id: " + mark.getId();
//    }


    //Busca un parametro id en la URL
//    @RequestMapping("/mark/details")
//    public String getDetail(@RequestParam Long id) {
//
//        return "Getting Details =>"+ id;
//    }

    //Se le pasa directamente
    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";
    }

        @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "redirect:/mark/list";
    }
    @RequestMapping(value = "/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/edit";
    }

    @RequestMapping("/mark/list/update")
    public String updateList(Model model) {
    model.addAttribute("markList",marksService.getMarks());
    return "mark/list::marksTable";
    }


    @RequestMapping(value = "/mark/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Mark mark, @PathVariable Long id) {
        Mark originalMark = marksService.getMark(id);
        // modificar solo score y description
        originalMark.setScore(mark.getScore());
        originalMark.setDescription(mark.getDescription());
        marksService.addMark(originalMark);
        return "redirect:/mark/details/" + id;
    }



}



