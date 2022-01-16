package com.boot.quanli_boot;

import com.boot.pojos.ChuyenXe;
import com.boot.service.ChuyenXeService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChuyenXeTest {

    @Autowired
    private ChuyenXeService chuyenXeService;

    int idChuyenXe = 14;

    int soLuongChuyenXeTrongDB = 7;

    String tenChuyenXe = "Ong noi";

    @Before
    void start() {
        List<ChuyenXe> list = this.chuyenXeService.getCX();

        idChuyenXe = list.get(list.size()-1).getIdCX(); // lay id cua chuyen xe moi nhat

        soLuongChuyenXeTrongDB = list.size();

        System.err.println("Start");
    }

    @Test // addCX(ChuyenXe chuyenxe)
    @Order(1)
    void testAddChuyenXe() {

        ChuyenXe cx = new ChuyenXe();

        cx.setTenCX(tenChuyenXe);

        this.chuyenXeService.addCX(cx);

        List<ChuyenXe> list = this.chuyenXeService.getCX();

        idChuyenXe = list.get(list.size()-1).getIdCX(); // lay id cua chuyen xe moi nhat

        Assertions.assertEquals(tenChuyenXe,this.chuyenXeService.getChuyenXeById(idChuyenXe).getTenCX());

    }

    @Test // getCX()
    @Order(2)
    void testLayNhieuChuyenXe() {
        List<ChuyenXe> list = this.chuyenXeService.getCX();

        soLuongChuyenXeTrongDB = list.size();

        // hien tai dang lay so luong trong DB

        int soLuongChuyenXe = list.size();

//        soLuongChuyenXe = 7; // <<<< muon custom so luong expect thi uncomment

        Assertions.assertEquals(soLuongChuyenXeTrongDB,soLuongChuyenXe);

    }

    @Test //getChuyenXeById(int id)
    @Order(3)
    void testLayMotChuyenXe() {

        int idChuyenXeDauTien = 1;

        tenChuyenXe = "14C32323";

        ChuyenXe cx = this.chuyenXeService.getChuyenXeById(idChuyenXeDauTien);

        Assertions.assertEquals(tenChuyenXe,cx.getTenCX());
    }

    @Test // updateCX(ChuyenXe chuyenxe)
    @Order(4)
    void testCapNhatChuyenXe() {
        List<ChuyenXe> list = this.chuyenXeService.getCX();

        idChuyenXe = list.get(list.size()-1).getIdCX(); // lay id cua chuyen xe moi nhat

        ChuyenXe cx = this.chuyenXeService.getChuyenXeById(idChuyenXe);

        String tenSauKhiCapNhat = "Ong noi !!!!!!!!!!";

        cx.setTenCX(tenSauKhiCapNhat);

        this.chuyenXeService.updateCX(cx);

        cx = this.chuyenXeService.getChuyenXeById(idChuyenXe);

        Assertions.assertEquals(tenSauKhiCapNhat,cx.getTenCX());
    }

    @Test // deleteCX(int id)
    @Order(5)
    void testXoaChuyenXe() {

        List<ChuyenXe> list = this.chuyenXeService.getCX();

        idChuyenXe = list.get(list.size()-1).getIdCX(); // lay id cua chuyen xe moi nhat

        this.chuyenXeService.deleteCX(idChuyenXe);

        Assertions.assertNull(this.chuyenXeService.getChuyenXeById(idChuyenXe));
    }

    @Test // getChuyenXeByTP(String tp)
    @Order(6)
    void testLayChuyenXeBangTP() {
        String tp = "Đà Nẵng";

        int soLuongTrongDB = 2;

        int soLuongThucTe = this.chuyenXeService.getChuyenXeByTP(tp).size();

        Assertions.assertEquals(soLuongTrongDB,soLuongThucTe);
    }

    @Test // getKSTop4(int page)
    @Order(7)
    void testLayBonChuyenXeDau() {
        int[] id = {1, 7, 8, 9};

        int[] idThat = {0,0,0,0};

        List<ChuyenXe> list = this.chuyenXeService.getKSTop4(1);

        for(int i = 0; i < 4;i++) {
            idThat[i] = list.get(i).getIdCX();
        }

        Assertions.assertArrayEquals(id,idThat);

    }

}
