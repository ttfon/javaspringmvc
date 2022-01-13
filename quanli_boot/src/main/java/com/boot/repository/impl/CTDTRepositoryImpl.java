/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.repository.impl;

import com.boot.pojos.CTDonTour;
import com.boot.repository.CTDTRepository;
import java.util.List;
import javax.persistence.Query;
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
public class CTDTRepositoryImpl implements CTDTRepository {

//     @Autowired
//    private LocalSessionFactoryBean sessionFactoryBean;

    private static LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

    @Override
    public List<CTDonTour> getCTByIdDP(int id) {
      Session session = this.sessionFactoryBean.getObject().getCurrentSession();
         Query q = session.createQuery("From CTDonTour ct where ct.dontour.id =:id ");
         q.setParameter("id", id);
        return q.getResultList(); }
    
}
