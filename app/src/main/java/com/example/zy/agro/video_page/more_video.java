package com.example.zy.agro.video_page;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.zy.agro.MainActivity;
import com.example.zy.agro.R;

import java.util.ArrayList;
import java.util.List;

public class more_video extends AppCompatActivity {
    private List<video> videos=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_more);


        //        设置顶部栏
        Toolbar toolbar  = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.arrowmini);
        }

//        初始化video数据
        initVideo();
        VideoAdapter adapter = new VideoAdapter(more_video.this,R.layout.video_more_item,videos);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        System.out.println();

        // Example of a call to a native method
    }

    private void initVideo() {
        for (int i=0;i<20;i++){
            video newvideo = new video("loli","分类：种植业","播放量：1500",R.drawable.loli);
            videos.add(newvideo);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(more_video.this, MainActivity.class));
                break;
            default:
        }
        return  true;
    }
}
