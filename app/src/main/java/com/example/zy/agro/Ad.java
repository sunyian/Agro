package com.example.zy.agro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class Ad extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        QMUIStatusBarHelper.translucent(this);

        handler.sendEmptyMessageDelayed(0,3000);

    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            jump();
        }
    };

    public void jump(){
        Boolean isfirst = false;
        SharedPreferences preferences = getSharedPreferences("ad_flag",0);
        isfirst = preferences.getBoolean("ad_flag", true);
        if (isfirst) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("ad_flag", false);
            editor.commit();
            Intent intent = new Intent(Ad.this, Guide.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent = new Intent(Ad.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
