/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.service.Impl;

import com.boot.pojos.KhachSan;
import com.boot.repository.KhachSanRepository;
import com.boot.service.KhachSanService;
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
public class KhachSanServiceImpl implements KhachSanService {

    @Autowired
    private KhachSanRepository khachSanRepository;
//    @Autowired
//    private Cloudinary cloudinary;


    @Override
    public List<KhachSan> getKS() {
        return this.khachSanRepository.getKS();
    }

    @Override
    public void addPhong(KhachSan ks) {

        ks.setHinhanh("https://ik.imagekit.io/tvlk/apr-asset/dgXfoyh24ryQLRcGq00cIdKHRmotrWLNlvG-TxlcLxGkiDwaUSggleJNPRgIHCX6/hotel/asset/10019967-b5d421db7e4736d3a7d390a50f854215.jpeg?tr=q-40,w-740,h-465&_src=imagekit");
        this.khachSanRepository.addPhong(ks);
    }

    @Override
    public void update(KhachSan ks) {
      this.khachSanRepository.update(ks);
    }

    @Override
    public void delete(int id) {
        this.khachSanRepository.delete(id);
    }

    @Override
    public List<KhachSan> getKhachSanByTP(String lp) {
        return this.khachSanRepository.getKhachSanByTP(lp);
    }

    @Override
    public KhachSan getKSById(int i) {
     return this.khachSanRepository.getKSById(i);
    }

    @Override
    public List<KhachSan> getksmoinhat(int page) {
       return this.khachSanRepository.getksmoinhat(page);
    }

    @Override
    public boolean checkupdate(KhachSan ks) {
        this.khachSanRepository.update(ks);
        return true;
    }

    @Override
    public List<KhachSan> getKSTop8(int i) {
       return this.khachSanRepository.getKSTop8(i);
    }

   
    
}
