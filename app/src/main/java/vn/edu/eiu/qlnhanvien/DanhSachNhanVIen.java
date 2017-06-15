package vn.edu.eiu.qlnhanvien;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Admin on 6/15/2017.
 */

public class DanhSachNhanVIen {
    ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
    public void addNhanVien(NhanVien nv){
        listNV.add(nv);
    }

    public double tongChiLuong() {
        double tien = 0.0;
        for(NhanVien nv:listNV){
            tien += nv.tinhLuong();
        }
        return tien;

    }
    public int tongNhanVien(){
        return listNV.size();
    }

    public  int tongNhanVienChinhThuc(){
        int cout = 0;
        for (NhanVien nv:listNV) {
            if (nv.isChinhThuc() ){
                cout ++;
            }
        }
        return cout;
    }
    public String nhanVienLamViecNhieuNgayNhat() {
        if(listNV.size() > 0) {
            Collections.sort(listNV, new Comparator<NhanVien>() {
                @Override
                public int compare(final NhanVien object1, final NhanVien object2) {
                    return object1.getSoNgayLam() -  object2.getSoNgayLam();
                }
            } );
        }

        return listNV.get(listNV.size() - 1).getTenNV();
    }
    public String luongCaoNhat() {
        if(listNV.size() > 0) {
            Collections.sort(listNV, new Comparator<NhanVien>() {
                @Override
                public int compare(final NhanVien object1, final NhanVien object2) {
                    return object1.getSoNgayLam() -  object2.getSoNgayLam();
                }
            } );
        }

        return listNV.get(listNV.size() - 1).tinhLuong() + "";
    }

}
