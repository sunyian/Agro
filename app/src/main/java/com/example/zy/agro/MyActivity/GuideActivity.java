package com.example.zy.agro.MyActivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.zy.agro.MyAdapter.GuideAdapter;
import com.example.zy.agro.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity  {

    private ArrayList<View> list;
    private ViewPager viewPager;
    private GuideAdapter guideAdapter;
    private ImageView point_0;
    private ImageView point_1;
    private ImageView point_2;
    private ImageView point_3;
    private ImageView guide_skip;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewPager = findViewById(R.id.guide_viewpager);
        point_0 = findViewById(R.id.guide_point_0);
        point_1 = findViewById(R.id.guide_point_1);
        point_2 = findViewById(R.id.guide_point_2);
        point_3 = findViewById(R.id.guide_point_3);
        guide_skip = findViewById(R.id.guide_skip);

        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(getBaseFragmentActivity());

        list = new ArrayList<View>();
        LayoutInflater layoutInflater = getLayoutInflater();
        list.add(layoutInflater.inflate(R.layout.guide_one, null, false));
        list.add(layoutInflater.inflate(R.layout.guide_two, null, false));
        list.add(layoutInflater.inflate(R.layout.guide_three, null, false));
        list.add(layoutInflater.inflate(R.layout.guide_four, null, false));
        guideAdapter = new GuideAdapter(list);
        viewPager.setAdapter(guideAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0)
                {

                    point_0.setImageResource(R.drawable.ic_point_full);
                    point_1.setImageResource(R.drawable.ic_point_null);
                    point_2.setImageResource(R.drawable.ic_point_null);
                    point_3.setImageResource(R.drawable.ic_point_null);
                }
                else if (position == 1)
                {
                    point_0.setImageResource(R.drawable.ic_point_null);
                    point_1.setImageResource(R.drawable.ic_point_full);
                    point_2.setImageResource(R.drawable.ic_point_null);
                    point_3.setImageResource(R.drawable.ic_point_null);
                }
                else if (position == 2)
                {
                    point_0.setImageResource(R.drawable.ic_point_null);
                    point_1.setImageResource(R.drawable.ic_point_null);
                    point_2.setImageResource(R.drawable.ic_point_full);
                    point_3.setImageResource(R.drawable.ic_point_null);
                }
                else if (position == 3)
                {
                    point_0.setImageResource(R.drawable.ic_point_null);
                    point_1.setImageResource(R.drawable.ic_point_null);
                    point_2.setImageResource(R.drawable.ic_point_null);
                    point_3.setImageResource(R.drawable.ic_point_full);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        guide_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }

        });
    }

    public Activity getBaseFragmentActivity() {
        return this;
    }

}
