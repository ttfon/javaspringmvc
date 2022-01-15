package com.boot.quanli_boot;

import com.boot.pojos.Tour;
import com.boot.service.TourService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QuanliBootApplicationTests {

    @Autowired
    private TourService tourService;

//    @Test
//    void contextLoads() {
//        int tourQuantity = 8;
//        List<Tour> list = this.tourService.showtour();
//        Assertions.assertEquals(tourQuantity,list.size());
//    }


//    @Test
//    void testOK() {
//        int tourQuantity = 7;
//        List<Tour> list = this.tourService.showtour();
//        Assertions.assertEquals(tourQuantity,list.size());
//    }
//
//    @Test
//    void testNotOK() {
//        int tourQuantity = 8;
//        List<Tour> list = this.tourService.showtour();
//        Assertions.assertEquals(tourQuantity,list.size());
//    }

    @Test
    void testFirstTourIDSuccess() {
        List<Tour> list = this.tourService.showtour();
        int expect = 1;
        int actual = list.get(0).getIdtour();
        Assertions.assertEquals(expect,actual);
    }

    @Test
    void testFirstTourIDFail() {
        List<Tour> list = this.tourService.showtour();
        int expect = 2;
        int actual = list.get(0).getIdtour();
        Assertions.assertEquals(expect,actual);
    }

}
