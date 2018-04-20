package com.example.zy.agro.video_page;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zy.agro.R;

import java.util.List;

/**
 * Created by 孙毅安 on 2018/3/27.
 */

public class VideoAdapter extends ArrayAdapter<video>{
    private int resourceid;
    public VideoAdapter(@NonNull Context context, int resource, @NonNull List<video> objects) {
        super(context, resource, objects);
        resourceid=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        video video=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view= LayoutInflater.from(getContext()).inflate(resourceid,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.video_title = (TextView)view.findViewById(R.id.title_video);
            viewHolder.video_class = (TextView)view.findViewById(R.id.class_video);
            viewHolder.video_watch = (TextView)view.findViewById(R.id.watch_video);
            viewHolder.video_image = (ImageView)view.findViewById(R.id.image_video);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.video_image.setImageResource(video.getImageid());
        viewHolder.video_title.setText(video.getVideo_title());
        viewHolder.video_class.setText(video.getVideo_class());
        viewHolder.video_watch.setText(video.getVideo_watch());
        return view;
    }

    class ViewHolder {
        ImageView video_image;
        TextView video_title;
        TextView video_class;
        TextView video_watch;
    }
}
