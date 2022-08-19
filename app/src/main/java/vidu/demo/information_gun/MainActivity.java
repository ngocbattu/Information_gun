package vidu.demo.information_gun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import vidu.demo.information_gun.Activity.TrangChuActivity;
import vidu.demo.information_gun.Adapter.AdapterViewPage;
import vidu.demo.information_gun.Model.Photos;

public class MainActivity extends AppCompatActivity {
    ArrayList<Photos> arrayList;
    AdapterViewPage adapterViewPage;
    ViewPager mViewPager;
    CircleIndicator mCircleIndicator;
    Timer mTimer;
    Button btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mViewPager = findViewById (R.id.view_page_chuyen_anh);
        mCircleIndicator = findViewById (R.id._CircleIndicator);
        btn_start = findViewById (R.id.btn_start);

        arrayList = new ArrayList<> ();
        arrayList.add (new Photos (R.drawable.slide1));
        arrayList.add (new Photos (R.drawable.slide3));
        arrayList.add (new Photos (R.drawable.slide4));
        adapterViewPage = new AdapterViewPage (this,arrayList);
        mViewPager.setAdapter (adapterViewPage);
        mCircleIndicator.setViewPager (mViewPager);
        adapterViewPage.registerDataSetObserver (mCircleIndicator.getDataSetObserver ());
        AotuSlideImage();

        btn_start.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (MainActivity.this, TrangChuActivity.class));
            }
        });
    }
    private void AotuSlideImage() {
        if(arrayList == null || arrayList.isEmpty () || mViewPager == null){
            return;
        }
        if(mTimer == null){
            mTimer = new Timer ();
        }
        mTimer.schedule (new TimerTask () {
            @Override
            public void run() {
                new Handler (Looper.getMainLooper ()).post (new Runnable () {
                    @Override
                    public void run() {
                        int index_anh = mViewPager.getCurrentItem ();
                        int int_list_image = arrayList.size () - 1;
                        if(index_anh < int_list_image){
                            index_anh++;
                            mViewPager.setCurrentItem (index_anh);
                        }else {
                            mViewPager.setCurrentItem (0);
                        }
                    }
                });
            }
        },6000,6000);
    }
}