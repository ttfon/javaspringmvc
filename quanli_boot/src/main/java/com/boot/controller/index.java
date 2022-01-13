package com.boot.controller;

import com.boot.pojos.Tour;
import com.boot.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class index {

    @Autowired
    private TourService tourService;

    @RequestMapping("/")
    public String test() {
        List<Tour> list = this.tourService.showtour();
        return list.get(0).getIdtour()+ " - " + list.get(0).getNametour();
    }
}
