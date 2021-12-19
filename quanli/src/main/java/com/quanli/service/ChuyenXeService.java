/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.service;

import com.quanli.pojos.ChuyenXe;
import com.quanli.pojos.KhachSan;
import java.util.List;

/**
 *
 * @author AD
 */
public interface ChuyenXeService {
     void addCX(ChuyenXe chuyenxe);
     List<ChuyenXe> getKS();
    void deleteCX(int id);
    List<ChuyenXe> getChuyenXeByTP(String tp);
    List<ChuyenXe> getChuyenXediByTP(String tp);
    ChuyenXe getChuyenXeById(int id);
    void updateCX(ChuyenXe chuyenxe);
}