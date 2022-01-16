/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.service;

import com.boot.pojos.CartXe;
import com.boot.pojos.DonTour;

import java.util.List;
import java.util.Map;

/**
 *
 * @author AD
 */
public interface DonTourService {
<<<<<<< HEAD
     List<DonTour> getDoanhThu();
      List<DonTour> getLishSuById(int id);
       List<DonTour> getAllDonTour();
    boolean xoa(int  id);
=======
    List<DonTour> getDoanhThu();
    List<DonTour> getLishSuById(int id);
    List<DonTour> getAllDonTour();
    void xoa(int  id);
>>>>>>> ab67c146c5920e5827ad68bb3a0d5843977910b2
    DonTour getDTById(int id);
    boolean update(DonTour donphong);
    boolean addDonCX(Map<Integer, CartXe> cart, int id);
    boolean add(DonTour dt);
    List<DonTour> getDoanhThuTheoThang(int thang);
   
}
