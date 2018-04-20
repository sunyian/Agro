package com.example.zy.agro;


import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.zy.agro.MyActivity.InfoActivity;
import com.example.zy.agro.video_page.more_video;
import com.example.zy.agro.video_page.videopage;
import com.example.zy.agro.video_play.play_video;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private DrawerLayout mdrawerLayout;
    private CircleImageView circleImageView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
        View contentView = getLayoutInflater().inflate(R.layout.nav_header, null);
        circleImageView = contentView.findViewById(R.id.headimage);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("info","dddddd");
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("视频");
        toolbar.setTitleMarginStart(350);
        setSupportActionBar(toolbar);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

            actionBar.setDisplayShowTitleEnabled(false);

            actionBar.setHomeAsUpIndicator(R.drawable.pyth);
        }


        FragmentManager FM_videopage = getFragmentManager();
        FragmentTransaction fragmentTransaction_videopage = FM_videopage.beginTransaction();
        videopage f1 = new videopage();
        fragmentTransaction_videopage.replace(R.id.fragment_container, f1);
        fragmentTransaction_videopage.commit();


        init_bottom_navigation_bar();

    }

    private void init_bottom_navigation_bar() {
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setTabSelectedListener(this);
        BadgeItem badgeItem = new BadgeItem().setBackgroundColor(Color.RED).setText("99");
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setActiveColor("#66ccff");
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_video, "视频").setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_video)))
                .addItem(new BottomNavigationItem(R.drawable.ic_question, "问卷").setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_question)))
                .addItem(new BottomNavigationItem(R.drawable.ic_square, "广场").setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_square)))
                .addItem(new BottomNavigationItem(R.drawable.ic_lab, "实验室").setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_lab)))
                .setFirstSelectedPosition(0)
                .initialise(); //所有的设置需在调用该方法前完成
    }


    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.planting_more:
                startActivity(new Intent(MainActivity.this, more_video.class));
                break;
            case R.id.planting_video1:
                startActivity(new Intent(MainActivity.this, play_video.class));
                break;
            default:
                Toast.makeText(MainActivity.this, "not over", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mdrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.main_search:
                Toast.makeText(MainActivity.this, "search", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                FragmentManager FM_videopage = getFragmentManager();
                FragmentTransaction fragmentTransaction_videopage = FM_videopage.beginTransaction();
                videopage f1 = new videopage();
                fragmentTransaction_videopage.replace(R.id.fragment_container, f1);
                fragmentTransaction_videopage.commit();
                break;
            case 1:
                FragmentManager FM_questionnaires = getFragmentManager();
                FragmentTransaction fragmentTransaction_questionnaires = FM_questionnaires.beginTransaction();
                questionnaires f2 = new questionnaires();
                fragmentTransaction_questionnaires.replace(R.id.fragment_container, f2);
                fragmentTransaction_questionnaires.commit();
                break;
            case 2:
                FragmentManager FM_square = getFragmentManager();
                FragmentTransaction fragmentTransaction_square = FM_square.beginTransaction();
                square f3 = new square();
                fragmentTransaction_square.replace(R.id.fragment_container, f3);
                fragmentTransaction_square.commit();
                break;
            case 3:
                FragmentManager FM_laboratory = getFragmentManager();
                FragmentTransaction fragmentTransaction_laboratory = FM_laboratory.beginTransaction();
                laboratory f4 = new laboratory();
                fragmentTransaction_laboratory.replace(R.id.fragment_container, f4);
                fragmentTransaction_laboratory.commit();
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
