package com.example.zy.agro.video_page;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zy.agro.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * Created by 孙毅安 on 2018/4/13.
 */

public class videopage extends Fragment {
    private View mView;
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    private int oldPosition = 0;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;

    private int[] image_ids = new int[]
            {R.drawable.lunb1, R.drawable.lunb2, R.drawable.lunb3, R.drawable.lunb4};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.video_page, container, false);

        setView();
        return mView;
    }

    private void setView() {
        mViewPaper = (ViewPager) mView.findViewById(R.id.carousel);
        images = new ArrayList<ImageView>();
        for (int i = 0; i < image_ids.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(image_ids[i]);
            images.add(imageView);
        }
        dots = new ArrayList<View>();
        dots.add(mView.findViewById(R.id.dot_1));
        dots.add(mView.findViewById(R.id.dot_2));
        dots.add(mView.findViewById(R.id.dot_3));
        dots.add(mView.findViewById(R.id.dot_4));

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);
        mViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dots.get(position).setBackgroundResource(R.mipmap.dotb);
                dots.get(oldPosition).setBackgroundResource(R.mipmap.dotw);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class ViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(images.get(position));
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(images.get(position));
            return images.get(position);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPagerTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }

    private class ViewPagerTask implements Runnable {
        @Override
        public void run() {
            currentItem = (currentItem + 1) % image_ids.length;
            mHandler.sendEmptyMessage(0);
        }
    }
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        };
    };
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if(scheduledExecutorService != null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }
}

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        isRunning=false;
//    }
//
//    public void initView() {
//
////        viewPager = view.findViewById(R.id.carousel);
////        viewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener) getActivity());
////        ll_point_container = (LinearLayout)view.findViewById(R.id.dot);
//
//    }
//
//    private void initData() {
//        imageResIds = new int[]
//                {R.drawable.loli,R.drawable.link,R.drawable.like,R.drawable.search};
//        imageViewList = new ArrayList<>();
//
//        ImageView imageView;
//        View pointView;
//        LinearLayout.LayoutParams layoutParams;
//        for (int i = 0; i < imageResIds.length; i++) {
//            // 初始化要显示的图片对象
//            imageView = new ImageView(getActivity());
//            imageView.setBackgroundResource(imageResIds[i]);
//            imageViewList.add(imageView);
//
//            // 加小白点, 指示器
//            pointView = new View(getActivity());
//            pointView.setBackgroundResource(R.mipmap.dotw);
//            layoutParams = new LinearLayout.LayoutParams(5, 5);
//            if (i != 0)
//                layoutParams.leftMargin = 10;
//            // 设置默认所有都不可用
//            pointView.setEnabled(false);
//            ll_point_container.addView(pointView, layoutParams);
//        }
//    }
//
//    private void initAdapter() {
//        ll_point_container.getChildAt(0).setEnabled(true);
//        tv_desc.setText(contentDescs[0]);
//        previousSelectedPosition = 0;
//
//        // 设置适配器
//        viewPager.setAdapter(new carousel_adapter());
//
//        // 默认设置到中间的某个位置
//        int pos = Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2 % imageViewList.size());
//        // 2147483647 / 2 = 1073741823 - (1073741823 % 5)
//        viewPager.setCurrentItem(5000000); // 设置到某个位置
//    }
//
//    public class carousel_adapter extends PagerAdapter {
//        @Override
//        public int getCount() {
//            return Integer.MAX_VALUE;
//        }
//
//        // 3. 指定复用的判断逻辑, 固定写法
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
////          System.out.println("isViewFromObject: "+(view == object));
//            // 当划到新的条目, 又返回来, view是否可以被复用.
//            // 返回判断规则
//            return view == object;
//        }
//
//        // 1. 返回要显示的条目内容, 创建条目
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            System.out.println("instantiateItem初始化: " + position);
//            // container: 容器: ViewPager
//            // position: 当前要显示条目的位置 0 -> 4
//
////          newPosition = position % 5
//            int newPosition = position % imageViewList.size();
//
//            ImageView imageView = imageViewList.get(newPosition);
//            // a. 把View对象添加到container中
//            container.addView(imageView);
//            // b. 把View对象返回给框架, 适配器
//            return imageView; // 必须重写, 否则报异常
//        }
//    }

//    @Override
//    public void onPageScrolled(int position, float positionOffset,
//                               int positionOffsetPixels) {
//        // 滚动时调用
//    }

//    @Override
//    public void onPageSelected(int position) {
//        // 新的条目被选中时调用
//        System.out.println("onPageSelected: " + position);
//        int newPosition = position % imageViewList.size();
//
//        //设置文本
//        tv_desc.setText(contentDescs[newPosition]);
//
////      for (int i = 0; i < ll_point_container.getChildCount(); i++) {
////          View childAt = ll_point_container.getChildAt(position);
////          childAt.setEnabled(position == i);
////      }
//        // 把之前的禁用, 把最新的启用, 更新指示器
//        ll_point_container.getChildAt(previousSelectedPosition).setEnabled(false);
//        ll_point_container.getChildAt(newPosition).setEnabled(true);
//
//        // 记录之前的位置
//        previousSelectedPosition = newPosition;
//
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//        // 滚动状态变化时调用
//    }
