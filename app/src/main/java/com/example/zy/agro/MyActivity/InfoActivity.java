package com.example.zy.agro.MyActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.zy.agro.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

public class InfoActivity extends AppCompatActivity {

    private long exitTime = 0;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        QMUIGroupListView qmuiGroupListView = findViewById(R.id.listview_info);

        QMUIStatusBarHelper.translucent(this);
        initlistview_info(qmuiGroupListView);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

    private Context getActivity() {
        return this;
    }

    private Context getContext() {
        return this;
    }

    private void initlistview_info(QMUIGroupListView qmuiGroupListView)
    {
        QMUICommonListItemView up_question_item = qmuiGroupListView.createItemView("上传题库");
        up_question_item.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        QMUICommonListItemView question_manger_item = qmuiGroupListView.createItemView("出题管理");
        question_manger_item.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView point_item = qmuiGroupListView.createItemView("积分日志");
        point_item.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        point_item.setDetailText("65");
        QMUICommonListItemView answer_item = qmuiGroupListView.createItemView("我的回答");
        answer_item.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView video_collect_item = qmuiGroupListView.createItemView("我的视频收藏");
        video_collect_item.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        QMUICommonListItemView video_item = qmuiGroupListView.createItemView("上传视频管理");
        video_item.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView log_item = qmuiGroupListView.createItemView("养殖日志");
        log_item.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        QMUICommonListItemView log_exit = qmuiGroupListView.createItemView("退出登录");
        log_item.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof QMUICommonListItemView) {
                    CharSequence text = ((QMUICommonListItemView) v).getText();
                    if (text.equals("退出登录"))
                    {
                        Intent intent = new Intent(InfoActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        SharedPreferences preferences = getSharedPreferences("tourist",0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("tourist", "false");
                        editor.commit();
                        preferences = getSharedPreferences("user_login", 0);
                        editor = preferences.edit();
                        editor.putString("user_login", "false");
                        editor.commit();
                    }
                }
            }
        };

        QMUIGroupListView.newSection(getContext())
                .addItemView(video_collect_item, onClickListener)
                .addItemView(video_item, onClickListener)
                .addTo(qmuiGroupListView);

        QMUIGroupListView.newSection(getContext())
                .addItemView(point_item, onClickListener)
                .addItemView(answer_item, onClickListener)
                .addTo(qmuiGroupListView);

        QMUIGroupListView.newSection(getContext())
                .addItemView(up_question_item, onClickListener)
                .addItemView(question_manger_item, onClickListener)
                .addTo(qmuiGroupListView);

        QMUIGroupListView.newSection(getContext())
                .addItemView(log_item, onClickListener)
                .addTo(qmuiGroupListView);

        QMUIGroupListView.newSection(getContext())
                .addItemView(log_exit, onClickListener)
                .addTo(qmuiGroupListView);
    }

}
