package vn.edu.eiu.qlnhanvien;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_tenNhanVien, edt_tenPhongban, edt_ngaylamViec;
    Button btn_tinhLuong, btn_next , btn_thongKe;
    CheckBox checkBox;
    ImageButton imageButton;
    TextView textViewLuong, textViewTongNhanVien, textViewTongNhanVienChinhThuc, textViewTongChiLuong,
             textViewNhanVienLamNhieuNgayNhat, textViewNhanVienCaoLuongNhat;
    DanhSachNhanVIen danhSachNhanVIen = new DanhSachNhanVIen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControls();
        addEvent();

    }

    private void addEvent() {
        btn_tinhLuong.setOnClickListener(MainActivity.this);
        btn_next.setOnClickListener(MainActivity.this);
        btn_thongKe.setOnClickListener(MainActivity.this);
        imageButton.setOnClickListener(MainActivity.this);
    }

    private void getControls() {
        edt_tenNhanVien = (EditText) findViewById(R.id.edt_tenNhanVien);
        edt_tenPhongban =(EditText) findViewById(R.id.edt_tenPhongBan);
        edt_ngaylamViec = (EditText) findViewById(R.id.edt_ngayLamViec);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        btn_tinhLuong = (Button) findViewById(R.id.btn_tinhLuong);
        btn_thongKe = (Button) findViewById(R.id.btn_thongke);
        btn_next = (Button) findViewById(R.id.btn_next);
        textViewLuong = (TextView)findViewById(R.id.textViewLuong);
        textViewNhanVienCaoLuongNhat = (TextView) findViewById(R.id.textViewNhanVienLuongCaoNhat);
        textViewNhanVienLamNhieuNgayNhat = (TextView) findViewById(R.id.textViewNhanVienlamNhieuNgayNhat);
        textViewTongChiLuong = (TextView) findViewById(R.id.textViewTongChiLuong);
        textViewTongNhanVienChinhThuc = (TextView) findViewById(R.id.textViewTongNhanVienChinhThuc);
        textViewTongNhanVien = (TextView) findViewById(R.id.textViewTongNhanVien);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tinhLuong:
                doTinhLuong();
                break;
            case R.id.btn_next:
                doNext();
                break;
            case R.id.btn_thongke:
                doThongKe();
                break;
            case R.id.imageButton:
                doExit();
                break;
        }

    }

    private void doExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Canh Bao ");
        builder.setMessage("Ban co muon thoat chuong trinh");
        builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setNegativeButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.create().show();
    }

    private void doNext() {
        edt_tenNhanVien.setText("");
        edt_tenPhongban.setText("");
        edt_ngaylamViec.setText("0");
        edt_tenNhanVien.requestFocus();
        checkBox.setChecked(false);
    }

    private void doThongKe() {
        textViewTongNhanVien.setText(danhSachNhanVIen.tongNhanVien() + "");
        textViewTongNhanVienChinhThuc.setText(danhSachNhanVIen.tongNhanVienChinhThuc() + "");
        textViewTongChiLuong.setText(danhSachNhanVIen.tongChiLuong() + "");
        textViewNhanVienLamNhieuNgayNhat.setText(danhSachNhanVIen.nhanVienLamViecNhieuNgayNhat() + "");
        textViewNhanVienCaoLuongNhat.setText(danhSachNhanVIen.luongCaoNhat() + "");
    }

    private void doTinhLuong() {
        String ten = edt_tenNhanVien.getText() + "";
        ten = ten.trim();
        if(ten.length() == 0){
            Toast.makeText(MainActivity.this, "ten nhan vien khong duoc phep de trong", Toast.LENGTH_LONG).show();
            edt_tenNhanVien.requestFocus();
            return;
        }
        String soNgaylamViec = edt_ngaylamViec.getText().toString().trim();
        if(soNgaylamViec.equals("")){
            Toast.makeText(MainActivity.this,"So ngay lam viec khong duoc de trong", Toast.LENGTH_LONG).show();
            edt_ngaylamViec.requestFocus();
            edt_ngaylamViec.selectAll();
            return;
        }
        int soNgaylamViecInt = Integer.parseInt(edt_ngaylamViec.getText().toString());
        if(soNgaylamViecInt < 1){
            Toast.makeText(MainActivity.this, "So ngay lam viec toi thieu la 1", Toast.LENGTH_SHORT).show();
            edt_ngaylamViec.requestFocus();
            edt_ngaylamViec.selectAll();
            return;
        }
        NhanVien nhanVien = new NhanVien();
        nhanVien.setTenNV(ten);
        nhanVien.setSoNgayLam(soNgaylamViecInt);
        nhanVien.setChinhThuc(checkBox.isChecked());
        textViewLuong.setText(nhanVien.tinhLuong() + "");
        danhSachNhanVIen.addNhanVien(nhanVien);



    }
}
