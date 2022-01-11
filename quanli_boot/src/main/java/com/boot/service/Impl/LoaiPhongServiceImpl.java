/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.service.Impl;

import java.util.List;

import com.boot.pojos.LoaiPhong;
import com.boot.repository.LoaiPhongRepository;
import com.boot.service.LoaiPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class LoaiPhongServiceImpl implements LoaiPhongService {

    @Autowired
    private LoaiPhongRepository loaiPhongRepository;
    @Override
    public List<LoaiPhong> getLP() {
        return this.loaiPhongRepository.getLP();
    }

    @Override
    public void addLP(LoaiPhong lp) {
        this.loaiPhongRepository.addLP(lp);
    }

    @Override
    public void update(LoaiPhong lp) {
        this.loaiPhongRepository.update(lp);
    }

    @Override
    public void delete(int id) {
       this.loaiPhongRepository.delete(id);
    }
    
}
