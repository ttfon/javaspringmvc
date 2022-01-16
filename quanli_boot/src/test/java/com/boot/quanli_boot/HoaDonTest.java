package com.boot.quanli_boot;

import com.boot.pojos.DonTour;
import com.boot.pojos.User;
import com.boot.repository.DonTourRepository;
import com.boot.service.DonTourService;
import com.boot.service.Impl.DonTourServiceImpl;
import com.boot.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;

@SpringBootTest
public class HoaDonTest {

    @Autowired
    private DonTourService donTourService;
    @Autowired
    private UserService userService;

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

    /*@Test
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

        Mockito.when(this.donTourService.getAllDonTour()).thenReturn(list);
        List<DonTour> actual = this.donTourService.getAllDonTour();
        Assertions.assertEquals(expect,actual.size());

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
        Mockito.when(donTourService.getAllDonTour()).thenReturn(list);
        List<DonTour> actual = this.donTourService.getAllDonTour();
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
        Mockito.when(donTourService.getDoanhThu()).thenReturn(list);
        List<DonTour> actual = this.donTourService.getDoanhThu();
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
        Mockito.when(donTourService.getDoanhThu()).thenReturn(list);
        List<DonTour> actual = this.donTourService.getDoanhThu();
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
        Mockito.when(donTourService.getLishSuById(1)).thenReturn(list);
        List<DonTour> actual = this.donTourService.getLishSuById(1);
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
        Mockito.when(donTourService.getLishSuById(1)).thenReturn(list);
        List<DonTour> actual = this.donTourService.getLishSuById(1);
        Assertions.assertNotEquals(expect,actual.size());

    }*/
    @Test
    void getAllValid()
    {
        List<DonTour> list = donTourService.getAllDonTour();
        int actual = list.size() ;
        Assertions.assertEquals(13,actual);
    }
    @Test
    void getAllInValid()
    {
        List<DonTour> list = donTourService.getAllDonTour();
        int actual = list.size() ;
        Assertions.assertNotEquals(1,actual);
    }
    @Test
    void getLishSuByIdValid()
    {
        List<DonTour> list = donTourService.getLishSuById(19);
        int actual = list.size();
        Assertions.assertEquals(5,actual);

    }
    @Test
    void getLishSuByIdInValid()
    {
        List<DonTour> list = donTourService.getLishSuById(19);
        int actual = list.size();
        Assertions.assertNotEquals(10,actual);

    }
    @Test
    void addHD()
    {
        DonTour dt = new DonTour();
        dt.setUser(this.userService.getUserById(19));
        dt.setNgaytao(new Date());
        dt.setTongtien(100000);
        dt.setPhuongthuc("offline");
        dt.setTinhtrang("da thanh toan");

        Assertions.assertTrue(this.donTourService.add(dt));
    }
    @Test
    void update()
    {
        List<DonTour> list = donTourService.getAllDonTour();
        DonTour dt = this.donTourService.getDTById(list.get(0).getId());
        dt.setTongtien(200000);

        Assertions.assertTrue(this.donTourService.update(dt));
    }
    @Test
    void xoa()
    {
        List<DonTour> list = donTourService.getAllDonTour();
        Assertions.assertTrue(this.donTourService.xoa(list.get(0).getId()));
    }

}