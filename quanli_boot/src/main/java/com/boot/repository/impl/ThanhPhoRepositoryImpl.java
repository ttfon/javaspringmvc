/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boot.repository.impl;

import java.util.List;
import javax.persistence.Query;

import com.boot.pojos.ThanhPho;
import com.boot.repository.ThanhPhoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class ThanhPhoRepositoryImpl implements ThanhPhoRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Override
    public List<ThanhPho> getAllTP() {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From ThanhPho");
        return q.getResultList();
    }
    
}
