package com.example.zy.agro.video_play;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zy.agro.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 孙毅安 on 2018/3/30.
 */

public class CommentAdapter extends BaseQuickAdapter<video_comment,BaseViewHolder>{

    public CommentAdapter(int layoutResId, List<video_comment> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, video_comment video_comment) {
        baseViewHolder.setImageResource(R.id.comment_headimage,video_comment.getMain_comment().getcomment_headimage())
                .setText(R.id.comment_userid,video_comment.getMain_comment().getcomment_userid())
                .setText(R.id.comment_date,video_comment.getMain_comment().getcomment_date())
                .setText(R.id.comment_content,video_comment.getMain_comment().getcomment_content())
                .setText(R.id.comment_like,video_comment.getMain_comment().getComment_like())

                .setText(R.id.child1_comment_userid,video_comment.getChild_comment1().getcomment_userid())
                .setText(R.id.child1_comment_date,video_comment.getChild_comment1().getcomment_date())
                .setText(R.id.child1_comment_content,video_comment.getChild_comment1().getcomment_content())

                .setText(R.id.child2_comment_userid,video_comment.getChild_comment2().getcomment_userid())
                .setText(R.id.child2_comment_date,video_comment.getChild_comment2().getcomment_date())
                .setText(R.id.child2_comment_content,video_comment.getChild_comment2().getcomment_content());
    }
}
