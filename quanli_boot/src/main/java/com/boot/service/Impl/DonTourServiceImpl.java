/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.service.Impl;

import java.util.List;
import java.util.Map;

import com.boot.pojos.CartXe;
import com.boot.pojos.DonTour;
import com.boot.repository.DonTourRepository;
import com.boot.service.DonTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class DonTourServiceImpl implements DonTourService {

    @Autowired
    private DonTourRepository donTourRepository;

    public DonTourServiceImpl(DonTourRepository donTourRepository) {
    }

    @Override
    public List<DonTour> getDoanhThu() {
       return this.donTourRepository.getDoanhThu();
    }

    @Override
    public List<DonTour> getLishSuById(int id) {
        return this.donTourRepository.getLishSuById(id);
    }

    @Override
    public List<DonTour> getAllDonTour() {
        return this.donTourRepository.getAllDonTour();
    }

    @Override
    public boolean xoa(int id) {
        this.donTourRepository.xoa(id);
        return true;
    }

    @Override
    public DonTour getDTById(int id) {
       return this.donTourRepository.getDTById(id);
    }

    @Override
    public boolean update(DonTour donphong) {
        this.donTourRepository.update(donphong);
        return true;
    }

    @Override
    public boolean addDonCX(Map<Integer, CartXe> cart, int id) {
        if(cart !=null)
        return  this.donTourRepository.addDonCX(cart,id);
        else 
            return false;
    }

    @Override
    public boolean add(DonTour dt) {
        this.donTourRepository.add(dt);

        return true;
    }

    @Override
    public List<DonTour> getDoanhThuTheoThang(int thang) {
       return this.donTourRepository.getDoanhThuTheoThang(thang);
    }

   
    
}
