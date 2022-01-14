package com.boot.quanli_boot;

import com.boot.pojos.CartXe;
import com.boot.pojos.DonTour;
import com.boot.pojos.User;
import com.boot.repository.DonTourRepository;
import com.boot.repository.UserRepository;
import com.boot.service.DonTourService;
import com.boot.service.Impl.DonTourServiceImpl;
import com.boot.service.Impl.UserServiceImpl;
import com.boot.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.*;

import static org.mockito.ArgumentMatchers.any;
@SpringBootTest
public class HoaDonTest {

   @Mock
    DonTourRepository donTourRepository;
   @InjectMocks
   DonTourServiceImpl donTourServiceImpl;

   /*@BeforeAll
   List<DonTour> setup(List<DonTour>  list)
   {
       for(int i = 0; i<6 ; i++)
       {
           DonTour dt = new DonTour();
           dt.setId(i);
           dt.setNgaytao(new Date());
           dt.setTongtien(1+i);
           User user = new User();
           user.setId(1);
           dt.setUser(user);
           list.add(dt);
       }
       return list;
   }*/
    @Test
    void testGetAllDonTourValid()
    {
        int expect = 6;
        List<DonTour>  list = new ArrayList<>();
        for(int i = 0; i<6 ; i++)
        {
            DonTour dt = new DonTour();
            dt.setId(i);
            dt.setNgaytao(new Date());
            dt.setTongtien(1+i);
            User user = new User();
            user.setId(1);
            dt.setUser(user);
            list.add(dt);
        }

        Mockito.when(donTourRepository.getAllDonTour()).thenReturn(list);
        List<DonTour> actual = this.donTourServiceImpl.getAllDonTour();
        Assertions.assertEquals(6,actual.size());

    }
    @Test
    void testGetAllDonTourInValid()
    {
        int expect = 6;
        List<DonTour>  list  = new ArrayList<>();
        for(int i = 0; i<expect ; i++)
        {
            DonTour dt = new DonTour();
            dt.setNgaytao(new Date());
            dt.setPhuongthuc("offine");
            dt.setTinhtrang("da thanh toan");
            dt.setTongtien(300000+i);
            list.add(dt);
        }
        Mockito.when(donTourRepository.getAllDonTour()).thenReturn(list);
        List<DonTour> actual = this.donTourServiceImpl.getAllDonTour();
        Assertions.assertNotEquals(3,actual.size());

    }
    @Test
    void testGetDoanhThuValid()
    {
        double expect = 0;
        List<DonTour>  list  = new ArrayList<>();
        for(int i = 0; i<6 ; i++)
        {
            DonTour dt = new DonTour();
            dt.setNgaytao(new Date());
            dt.setTongtien(1+i);
            list.add(dt);
             expect = (list.get(i).getTongtien()) + expect;


        }
        Mockito.when(donTourRepository.getDoanhThu()).thenReturn(list);
        List<DonTour> actual = this.donTourServiceImpl.getDoanhThu();
        Assertions.assertEquals(expect,actual.get(1).getTongtien());

    }
    @Test
    void testGetDoanhThuInValid()
    {
        double expect = 0;
        List<DonTour>  list  = new ArrayList<>();
        for(int i = 0; i<6 ; i++)
        {
            DonTour dt = new DonTour();
            dt.setNgaytao(new Date());
            dt.setTongtien(1+i);
            list.add(dt);
            expect = (list.get(i).getTongtien()) + expect;


        }
        Mockito.when(donTourRepository.getDoanhThu()).thenReturn(list);
        List<DonTour> actual = this.donTourServiceImpl.getDoanhThu();
        Assertions.assertNotEquals(expect,actual.get(1).getTongtien());

    }
    @Test
    void testLishSuById()
    {
        int expect = 6;
        List<DonTour>  list  = new ArrayList<>();
        for(int i = 0; i<6 ; i++)
        {
            DonTour dt = new DonTour();
            dt.setNgaytao(new Date());
            dt.setTongtien(1+i);
            User user = new User();
            user.setId(1);
            dt.setUser(user);
            list.add(dt);



        }

        //System.out.print(list.get(0).getUser().getId());
        Mockito.when(donTourRepository.getLishSuById(1)).thenReturn(list);
        List<DonTour> actual = this.donTourServiceImpl.getLishSuById(1);
        Assertions.assertEquals(expect,actual.size());

    }
    @Test
    void testLishSuByIdInvalid()
    {
        int expect = 1;
        List<DonTour>  list  = new ArrayList<>();
        for(int i = 0; i<6 ; i++)
        {
            DonTour dt = new DonTour();
            dt.setNgaytao(new Date());
            dt.setTongtien(1+i);
            User user = new User();
            user.setId(1);
            dt.setUser(user);
            list.add(dt);



        }

        //System.out.print(list.get(0).getUser().getId());
        Mockito.when(donTourRepository.getLishSuById(1)).thenReturn(list);
        List<DonTour> actual = this.donTourServiceImpl.getLishSuById(1);
        Assertions.assertNotEquals(expect,actual.size());

    }


}
