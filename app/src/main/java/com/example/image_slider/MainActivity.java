package com.example.image_slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class

MainActivity extends AppCompatActivity {

    private ViewPager mViewPager ;
    private CircleIndicator mCircleIndicator ;
    private List<photo> mListPhoto ;

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
    }

    private List<photo>     getListPhoto (){
        List<photo> list = new ArrayList<>() ;
        list.add(new photo(R.drawable.in43_1));
        list.add(new photo(R.drawable.in43_2));
        list.add(new photo(R.drawable.in43_3));
        list.add(new photo(R.drawable.in43_4));
        return list ;
    }
}