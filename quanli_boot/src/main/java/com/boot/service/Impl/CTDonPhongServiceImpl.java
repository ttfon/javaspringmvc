/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.service.Impl;

import java.util.List;

import com.boot.pojos.CTDonPhong;
import com.boot.repository.CTDonPhongRepository;
import com.boot.service.CTDonPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class CTDonPhongServiceImpl implements CTDonPhongService {

    @Autowired
    private CTDonPhongRepository cTDonPhongRepository;
    @Override
    public List<CTDonPhong> getCTDonPhong() {
       return this.cTDonPhongRepository.getCTDonPhong();
    }

    @Override
    public List<CTDonPhong> getCTByIdDP(int id) {
       return this.cTDonPhongRepository.getCTByIdDP(id);
    }
    
}
