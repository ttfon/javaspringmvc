/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.service.Impl;

import java.util.List;

import com.boot.pojos.CTDonTour;
import com.boot.repository.CTDTRepository;
import com.boot.service.CTDTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AD
 */
@Service
public class CTDTServiceImpl implements CTDTService {

    @Autowired
    private CTDTRepository cTDTRepository;
    @Override
    public List<CTDonTour> getCTByIdDP(int id) {
      return this.cTDTRepository.getCTByIdDP(id);
    }
    
}
