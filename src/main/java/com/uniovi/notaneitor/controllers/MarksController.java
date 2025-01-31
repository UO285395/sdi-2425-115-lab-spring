package com.uniovi.notaneitor.controllers;

import org.springframework.web.bind.annotation.*;
import com.uniovi.notaneitor.entities.*;


@RestController
public class MarksController {

    @RequestMapping
    public String getList(){
        return "Getting List";
    }
    @RequestMapping( value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        return "Added " + mark.getDescription() +
                " with score " + mark.getScore()+
                " id: " + mark.getId();
    }


    //Busca un parametro id en la URL
//    @RequestMapping("/mark/details")
//    public String getDetail(@RequestParam Long id) {
//
//        return "Getting Details =>"+ id;
//    }

    //Se le pasa directamente
    @RequestMapping("/mark/details/{id}")
    public String getDetail(@PathVariable Long id) {
        return "Getting Details =>"+ id;
    }

}



