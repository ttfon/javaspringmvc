package com.boot.controller;

import com.boot.pojos.ChuyenXe;
import com.boot.pojos.KhachSan;
import com.boot.pojos.Tour;
import com.boot.service.ChuyenXeService;
import com.boot.service.KhachSanService;
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

    @Autowired
    private ChuyenXeService chuyenXeService;

    @Autowired
    private KhachSanService khachSanService;
    @RequestMapping("/")
    public String test() {
        List<Tour> list = this.tourService.showtour();
        List<ChuyenXe> list1 = this.chuyenXeService.getCX();
        ChuyenXe cx = this.chuyenXeService.getChuyenXeById(1);
//        return list.get(0).getIdtour()+ " - " + list.get(0).getNametour();

        return cx.getTenCX();
        // return list1.get(0).getIdCX()+ " - " + list1.get(0).getTenCX();

    }
}