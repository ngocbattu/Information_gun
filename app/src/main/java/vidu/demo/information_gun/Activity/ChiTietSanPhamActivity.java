package vidu.demo.information_gun.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import vidu.demo.information_gun.R;

public class ChiTietSanPhamActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView image_anh_sung ;
    TextView txt_ten , txt_nha_san_xuat , txt_quoc_gia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_chi_tiet_san_pham);
        toolbar = findViewById (R.id.toolbar_trang_chu);
        image_anh_sung = findViewById (R.id.image_anh_gun_ct);
        txt_ten = findViewById (R.id.txt_ten_sung_ct);
        txt_nha_san_xuat = findViewById (R.id.txt_nha_san_xuat_ct);
        txt_quoc_gia = findViewById (R.id.txt_quoc_gia_ct);
        setSupportActionBar (toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);
        getSupportActionBar ().setTitle ("");
        Intent i = getIntent ();
       int anh =  i.getIntExtra ("_anhSung",0);
       String ten =  i.getStringExtra ("_tenSung");
       String NSX =  i.getStringExtra ("_nhaSanXuat");
       String quocGia = i.getStringExtra ("_quocGia");

        Glide.with (this).load (anh).into (image_anh_sung);
        txt_ten.setText ("Tên súng : " + ten);
        txt_nha_san_xuat.setText ("Nhà sản xuất : " + NSX);
        txt_quoc_gia.setText ("Quốc gia : " + quocGia);
    }
        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}