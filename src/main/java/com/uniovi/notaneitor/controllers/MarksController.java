package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.uniovi.notaneitor.entities.*;


@RestController
public class MarksController {

    @Autowired
    private MarksService marksService;

    @RequestMapping("/mark/list")
    public String getList(){
        return marksService.getMarks().toString();
    }

    @RequestMapping( value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        marksService.addMark(mark);
        return "OK";
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
    public String getDetail(@PathVariable Long id) {
       return marksService.getMark(id).toString();
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "OK";
    }


}



