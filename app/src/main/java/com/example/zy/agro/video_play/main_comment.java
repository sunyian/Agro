package com.example.zy.agro.video_play;

/**
 * Created by 孙毅安 on 2018/4/18.
 */

public class main_comment {
    private int comment_headimage;
    private String comment_userid;
    private String comment_date;
    private String comment_content;
    private String comment_like;

    public main_comment(int comment_headimage,String comment_userid,String comment_date,String comment_content,String comment_like){
        this.comment_headimage=comment_headimage;
        this.comment_userid=comment_userid;
        this.comment_date=comment_date;
        this.comment_content=comment_content;
        this.comment_like=comment_like;
    }
    public int getcomment_headimage(){
        return comment_headimage;
    }
    public String getcomment_userid(){
        return comment_userid;
    }
    public String getcomment_date(){
        return comment_date;
    }
    public String getcomment_content(){
        return comment_content;
    }
    public String getComment_like() {return comment_like;}
}
