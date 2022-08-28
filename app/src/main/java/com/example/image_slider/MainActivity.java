package com.example.image_slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class

MainActivity extends AppCompatActivity {

    private ViewPager mViewPager ;
    private CircleIndicator mCircleIndicator ;
    private List<photo> mListPhoto ;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if(mViewPager.getCurrentItem() == mListPhoto.size() -1  )
            {
                mViewPager.setCurrentItem(0);

            }else {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.vp_001) ;
        mCircleIndicator = findViewById(R.id.cricle_indicator) ;

        mListPhoto = getListPhoto() ;
        PhotoViewAdapter adapter   = new PhotoViewAdapter(mListPhoto) ;
        mViewPager.setAdapter(adapter);

        mCircleIndicator.setViewPager(mViewPager);
        mHandler.postDelayed(mRunnable,3000) ;
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    mHandler.removeCallbacks(mRunnable);
                    mHandler.postDelayed(mRunnable,3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private List<photo>     getListPhoto (){
        List<photo> list = new ArrayList<>() ;
        list.add(new photo(R.drawable.in43_1));
        list.add(new photo(R.drawable.in43_2));
        list.add(new photo(R.drawable.in43_3));
        list.add(new photo(R.drawable.in43_4));
        return list ;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable,3000) ;
    }
}