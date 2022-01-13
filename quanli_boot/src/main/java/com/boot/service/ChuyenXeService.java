/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.service;

import com.boot.pojos.ChuyenXe;

import java.util.List;

/**
 *
 * @author AD
 */
public interface ChuyenXeService {
    void addCX(ChuyenXe chuyenxe);
    List<ChuyenXe> getCX();
    void deleteCX(int id);
    List<ChuyenXe> getChuyenXeByTP(String tp);
    List<ChuyenXe> getChuyenXediByTP(int tp); //khong xai
    ChuyenXe getChuyenXeById(int id);
    void updateCX(ChuyenXe chuyenxe);
    List<ChuyenXe> getKSTop4(int page);
}
