package com.example.zy.agro.MyActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zy.agro.MyApplication;
import com.example.zy.agro.R;
import com.example.zy.agro.ReturnForm.JsonUtils;
import com.example.zy.agro.ReturnForm.Result;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    TextView text_phone;
    TextView text_password;
    Button btn_login;
    TextView text_unlogin;
    private int mCurrentDialogStyle = com.qmuiteam.qmui.R.style.QMUI_Dialog;

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_phone = findViewById(R.id.text_phone);
        text_password = findViewById(R.id.text_password);
        btn_login = findViewById(R.id.btn_login);

        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(getBaseFragmentActivity());

        TextView text_login_sign = findViewById(R.id.text_login_sign);
        text_login_sign.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                            JSONObject json_re = new JSONObject(re_info);
//                            Log.d("success_re", json_re.toString());
                        OkHttpClient client = new OkHttpClient();
                        FormBody formBody = new FormBody.Builder()
                                .add("username", text_phone.getText().toString())
                                .add("password", text_password.getText().toString())
                                .build();
                        Request request = new Request.Builder()
                                .url("http://112.74.53.186:8080/login")
                                .post(formBody)
                                .build();
                        try {
                            Response response = client.newCall(request).execute();
                            String re_info = response.body().string();
//                                Log.d("success_re", re_info);
                            Result result = JsonUtils.jsonToPojo(re_info, Result.class);
                            if (result.getSuccess().toString().equals("true"))
                            {
                                Intent intent = new Intent(LoginActivity.this, InfoActivity.class);
                                startActivity(intent);
                                finish();
                                SharedPreferences preferences = getSharedPreferences("user_login",0);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("user_login", text_phone.getText().toString());
                                editor.commit();
                            }
                            else
                            {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                            new QMUIDialog.MessageDialogBuilder(getActivity())
                                                    .setTitle("登录失败")
                                                    .setMessage("用户不存在，请重新输入或注册一个新的帐户。")
                                                    .addAction("注册", new QMUIDialogAction.ActionListener() {
                                                        @Override
                                                        public void onClick(QMUIDialog dialog, int index) {
                                                            dialog.dismiss();
                                                            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                                                            startActivity(intent);
                                                        }
                                                    })
                                                    .addAction(0, "重新登录", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                                                        @Override
                                                        public void onClick(QMUIDialog dialog, int index) {
                                                            dialog.dismiss();
                                                        }
                                                    })
                                                    .create(mCurrentDialogStyle).show();
                                        }
                                });
                                Log.d("success_re", result.getSuccess().toString());
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }

    public Activity getBaseFragmentActivity() {
        return this;
    }

    public Context getActivity() {
        return this;
    }
}
