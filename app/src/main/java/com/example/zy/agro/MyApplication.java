package com.example.zy.agro;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {
    private static String message;
    @Override
    public void onCreate() {
        super.onCreate();
        message = "MyApplication";
    }

    public static void showmessage()
    {
        Log.d("myapp", message);
    }
}
