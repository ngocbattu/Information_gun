package vidu.demo.information_gun.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import vidu.demo.information_gun.Aciton.ItemClick;
import vidu.demo.information_gun.Adapter.AdapterGun;
import vidu.demo.information_gun.Model.Gun;
import vidu.demo.information_gun.R;

public class TrangChuActivity extends AppCompatActivity {
//    Toolbar toolbar;
    ArrayList<Gun> arrayList;
    AdapterGun adapterGun;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_trang_chu);

        mRecyclerView = findViewById (R.id.recy_view_danh_Sach_gun);
        mRecyclerView.setLayoutManager (new GridLayoutManager (this,2));
        arrayList = new ArrayList<> ();
        arrayList.add (new Gun (R.drawable.sung1,"Súng trường đổ bộ ASM-DT","Tula Arms Plant","Liên Xô"));
        arrayList.add (new Gun (R.drawable.acr,"ACR","Remington Arms\n" +
                "Bushmaster","Hoa Kỳ"));
        arrayList.add (new Gun (R.drawable.akm,"AKM","Izhmash\n" +
                "Tula Arms Plant","Liên Xô"));

        arrayList.add (new Gun (R.drawable.sung7,"OTs-12 Tiss","KBP Instrument Design Bureau","Nga"));
        arrayList.add (new Gun (R.drawable.famas,"FAMAS","Nexter","Pháp"));
        arrayList.add (new Gun (R.drawable.barrett_rec7,"Barrett REC7","Barrett Firearms Manufacturing"," Hoa Kỳ"));
        arrayList.add (new Gun (R.drawable.sung3,"Súng trường EM-2","Royal Small Arms Factory","Anh Quốc"));
        arrayList.add (new Gun (R.drawable.sung4,"HK416","Heckler & Koch","Đức"));
        adapterGun = new AdapterGun (this, arrayList, new ItemClick () {
            @Override
            public void chiTiet(Gun gun) {
                chiTietGun(gun);
            }
        });
        mRecyclerView.setAdapter (adapterGun);
        adapterGun.notifyDataSetChanged ();
    }

    private void chiTietGun(Gun gun) {
        for(int i=0;i<arrayList.size ();i++){
            if(arrayList.get (i).getTenSung ().contains (gun.getTenSung ())){
                Intent intent = new Intent (TrangChuActivity.this,ChiTietSanPhamActivity.class);
                intent.putExtra ("_anhSung",arrayList.get (i).getAnhSung ());
                intent.putExtra ("_tenSung",arrayList.get (i).getTenSung ());
                intent.putExtra ("_nhaSanXuat",arrayList.get (i).getNhaSanXuat ());
                intent.putExtra ("_quocGia",arrayList.get (i).getQuocGia ());
                startActivity (intent);
            }

        }
    }

}