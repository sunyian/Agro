package com.example.zy.agro.video_play;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zy.agro.R;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class play_video extends AppCompatActivity {
    private List<video_comment> comments = new ArrayList<>();

    video_comment new1,new2,new3;


    private JCVideoPlayerStandard jcVideoPlayerStandard;
    String s1 = "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play);

//        getSupportActionBar().setTitle("jiecaovideoplayer的使用");
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);
        jcVideoPlayerStandard.setUp(s1, jcVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "视频标题");

        ///        RecyclerView
        initcomments();



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.comment_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        CommentAdapter adapter = new CommentAdapter(R.layout.comment_item,comments);
//        CommentAdapter adapter = new CommentAdapter(comments);
        recyclerView.setAdapter(adapter);

        judgecomment();

    }

    private void judgecomment() {
//        RelativeLayout relativeLayout = findViewById(R.layout.comment_item).findViewById(R.id.more_comment);
//        relativeLayout.setVisibility(View.VISIBLE);
//        RelativeLayout recyclerView = findViewById(R.id.more_comment);
//        recyclerView.setVisibility(View.VISIBLE);
////        recyclerView.setVisibility(View.VISIBLE);
//        findViewById(R.id.child2_comment).setVisibility(View.VISIBLE);
//        findViewById(R.id.child1_comment).setVisibility(View.VISIBLE);

//        for(int i=0;i<comments.size();i++){
//            if(Integer.parseInt(comments.get(i).getComment_num()) > 2){
//
//            } else if(Integer.parseInt(comments.get(i).getComment_num()) == 2){
//                findViewById(R.id.more_comment).setVisibility(View.GONE);
//            } else if(Integer.parseInt(comments.get(i).getComment_num()) == 1){
//                findViewById(R.id.more_comment).setVisibility(View.GONE);
//                findViewById(R.id.child2_comment).setVisibility(View.GONE);
//            } else if(Integer.parseInt(comments.get(i).getComment_num()) == 0){
//                findViewById(R.id.more_comment).setVisibility(View.GONE);
//                findViewById(R.id.child1_comment).setVisibility(View.GONE);
//                findViewById(R.id.child2_comment).setVisibility(View.GONE);
//            } else{
//                Toast.makeText(this, "error num", Toast.LENGTH_SHORT).show();
//            }
//        }
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    private void initcomments() {
        main_comment main_comment = new main_comment(R.drawable.lunb9,"麻辣小龙虾","19:20","小龙虾真好吃","123");
        child_comment child_comment1 = new child_comment("芝士焗土豆","19:21","土豆真好吃");
        child_comment child_comment2 = new child_comment("想不出吃啥了","20:01","想完了今晚喝西北风吧");

        main_comment main_comment1 = new main_comment(R.drawable.lunb10,"麻辣烤鱼","19:22","烤鱼真好吃","110");
        child_comment child_comment3 = new child_comment("牛肉饼汉堡","19:21","我爱牛肉");
        child_comment child_comment4 = new child_comment("想不出吃啥了","20:01","沙县小吃走一波");

        child_comment child_comment_empty = new child_comment(null,null,null);

        new1 = new video_comment(main_comment,child_comment1,child_comment2,"1");
        new2 = new video_comment(main_comment1,child_comment3,child_comment4,"2");
        new3 = new video_comment(main_comment,child_comment2,child_comment1,"3");

        for(int i=0;i<3;i++) {
            comments.add(new1);
            comments.add(new2);
            comments.add(new3);
        }
    }
}




