package com.boot.quanli_boot.NHT;

import com.boot.pojos.ChuyenXe;
import com.boot.service.ChuyenXeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ChuyenXeTest {

    @Autowired
    private ChuyenXeService chuyenXeService;

    static int idChuyenXe = 14;

    static String tenChuyenXe = "Ong noi";

    @Test // addCX(ChuyenXe chuyenxe)
    void testAddChuyenXe() {

        ChuyenXe cx = new ChuyenXe();

        cx.setTenCX(tenChuyenXe);

        this.chuyenXeService.addCX(cx);

        Assertions.assertEquals(tenChuyenXe,this.chuyenXeService.getChuyenXeById(idChuyenXe).getTenCX());

    }

    @Test // getCX()
    void testLayNhieuChuyenXe() {
        int soLuongChuyenXeTrongDB = 7;

        int soLuongChuyenXe = this.chuyenXeService.getCX().size();

        Assertions.assertEquals(soLuongChuyenXeTrongDB,soLuongChuyenXe);

    }

    @Test //getChuyenXeById(int id)
    void testLayMotChuyenXe() {
        ChuyenXe cx = this.chuyenXeService.getChuyenXeById(idChuyenXe);

        Assertions.assertEquals(tenChuyenXe,cx.getTenCX());
    }

    @Test // updateCX(ChuyenXe chuyenxe)
    void testCapNhatChuyenXe() {
        ChuyenXe cx = this.chuyenXeService.getChuyenXeById(idChuyenXe);

        String tenSauKhiCapNhat = "Ong noi !!!!!!!!!!";

        cx.setTenCX(tenSauKhiCapNhat);

        this.chuyenXeService.updateCX(cx);

        cx = this.chuyenXeService.getChuyenXeById(idChuyenXe);

        Assertions.assertEquals(tenSauKhiCapNhat,cx.getTenCX());
    }

    @Test // deleteCX(int id)
    void testXoaChuyenXe() {
        this.chuyenXeService.deleteCX(idChuyenXe);

        Assertions.assertNull(this.chuyenXeService.getChuyenXeById(idChuyenXe));
    }

    @Test // getChuyenXeByTP(String tp)
    void testLayChuyenXeBangTP() {
        String tp = "Đà Nẵng";

        int soLuongTrongDB = 2;

        int soLuongThucTe = this.chuyenXeService.getChuyenXeByTP(tp).size();

        Assertions.assertEquals(soLuongTrongDB,soLuongThucTe);
    }

    @Test // getKSTop4(int page)
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
