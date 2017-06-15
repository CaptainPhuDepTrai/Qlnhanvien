package vn.edu.eiu.qlnhanvien;

/**
 * Created by Admin on 6/15/2017.
 */

public class NhanVien {
    private String tenNV;
    String tenPB;
    private int soNgayLam;
    private boolean isChinhThuc;
    public static final int luongThoiVu = 90000;
    public static final int luongChinhThuc = 150000;


    public NhanVien(){

    }
    public NhanVien(String tenNV, String tenPB, int soNgayLam, boolean isChinhThuc) {
        this.tenNV = tenNV;
        this.tenPB = tenPB;
        this.soNgayLam = soNgayLam;
        this.isChinhThuc = isChinhThuc;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public boolean isChinhThuc() {
        return isChinhThuc;
    }

    public void setChinhThuc(boolean isChinhThuc) {
        this.isChinhThuc = isChinhThuc;
    }

    public static int getLuongThoiVu() {
        return luongThoiVu;
    }

    public static int getLuongChinhThuc() {
        return luongChinhThuc;
    }

    public double tinhLuong(){
        if(isChinhThuc() == false){
            return luongThoiVu * soNgayLam;
        }
        else {
            return luongChinhThuc * soNgayLam;
        }
    }
}
