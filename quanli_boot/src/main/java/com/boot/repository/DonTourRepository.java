/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.repository;



import com.boot.pojos.CartXe;
import com.boot.pojos.DonTour;

import java.util.List;
import java.util.Map;

/**
 *
 * @author AD
 */
public interface DonTourRepository {
    List<DonTour> getDoanhThu();
     List<DonTour> getLishSuById(int id);
    List<DonTour> getAllDonTour();
    boolean xoa(int  id);
    DonTour getDTById(int id);
    boolean update(DonTour donphong);
    boolean addDonCX(Map<Integer, CartXe> cart, int id);
    List<DonTour> getDoanhThuTheoThang(int thang);
    boolean add(DonTour dt);
     
}
