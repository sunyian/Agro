package com.example.zy.agro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        QMUIStatusBarHelper.translucent(this);

        TextView text_return_login = findViewById(R.id.text_return_login);
        text_return_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Button button_msg =  findViewById(R.id.btn_msg);
        button_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
