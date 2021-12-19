/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanli.controllers;

import com.quanli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AD
 */
@Controller
public class TaiXeController {
    @Autowired
    private UserService userDetailService;
    @RequestMapping("/admin/taixe")
    public String qlTaiXe(Model model)
    {
        
        model.addAttribute("user",this.userDetailService.getAllUserTaiXe());
        return "TaiXe";
    }
    
}
