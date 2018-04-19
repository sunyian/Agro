package com.example.zy.agro.MyActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zy.agro.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class ChangePasswordActivity extends AppCompatActivity {

    public TextView text_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        QMUIStatusBarHelper.translucent(this);

        text_signin = findViewById(R.id.text_chpwd_login);

        text_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
