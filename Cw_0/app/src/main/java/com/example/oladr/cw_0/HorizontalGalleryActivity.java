package com.example.oladr.cw_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sanyuzhang.circular.viewpager.cvp.view.CircularViewPager;

import me.relex.circleindicator.CircleIndicator;

public class HorizontalGalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_gallery);

        Intent intent = getIntent();
        int start_pos = intent.getIntExtra("image_pos", 0);

        final CircularViewPager viewPager = findViewById(R.id.viewPager);
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager());
        viewPager.setFragmentAdapter(adapter, getSupportFragmentManager());
        viewPager.setCurrentItem(start_pos);

        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
    }
}
