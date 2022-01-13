/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.service.Impl;

import com.boot.pojos.Tour;
import com.boot.repository.TourRepository;
import com.boot.service.TourService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class TourServiceImpl implements TourService {


    @Autowired
    private TourRepository tourRepository;
    @Override
    public List<Tour> showtour() {
        return this.tourRepository.showtour();
    }

    @Override
    public Tour getTourById(int i) {
        return this.tourRepository.getTourById(i);
    }

    @Override
    public void addtour(Tour tour) {

        tour.setImage("https://www.dualshockers.com/static/uploads/2021/11/Powder-in-Arcane-Music-Video-1140x570.jpg");
        this.tourRepository.addtour(tour);
    }

    @Override
    public void delete(int i) {
        this.tourRepository.delete(i);
    }

    @Override
    public void update(Tour tour) {

        tour.setImage("https://www.dualshockers.com/static/uploads/2021/11/Powder-in-Arcane-Music-Video-1140x570.jpg");
        this.tourRepository.update(tour);
    }

    @Override
    public List<Tour> getTourByTP(String string) {
        return this.tourRepository.getTourByTP(string);
    }

    @Override
    public List<Tour> getKSTop8(int i) {
       return this.tourRepository.getKSTop8(i);
    }

   
}
