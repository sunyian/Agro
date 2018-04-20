package com.example.zy.agro.MyActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zy.agro.MainActivity;
import com.example.zy.agro.MyApplication;
import com.example.zy.agro.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class AdActivity extends AppCompatActivity {


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
            Intent intent = new Intent(AdActivity.this, GuideActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            SharedPreferences preferences_user = getSharedPreferences("user_login", 0);
            String user_true = preferences_user.getString("user_login", "false");
            SharedPreferences preferences_tourist = getSharedPreferences("tourist", 0);
            String tourist = preferences_tourist.getString("tourist", "false");
            if (user_true.equals("false") && tourist.equals("false")) {
                Intent intent = new Intent(AdActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Intent intent = new Intent(AdActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }

        }
    }
}
