/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.repository.impl;


import java.util.List;
import javax.persistence.Query;

import com.boot.pojos.CTDonPhong;
import com.boot.repository.CTDonPhongRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AD
 */
@Repository
@Transactional
public class CTDonPhongRepositoryImpl implements CTDonPhongRepository {

     @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public List<CTDonPhong> getCTDonPhong() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         Query q = session.createQuery("From CTDonPhong ");
        return q.getResultList();
    }

    @Override
    public List<CTDonPhong> getCTByIdDP(int id) {
         Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         Query q = session.createQuery("From CTDonPhong ct where ct.donphong.id =:id ");
         q.setParameter("id", id);
        return q.getResultList();
         
    }
    
}
