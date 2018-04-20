package com.example.zy.agro.video_play;

/**
 * Created by 孙毅安 on 2018/4/18.
 */

public class child_comment {
        private String comment_userid;
        private String comment_date;
        private String comment_content;

        public child_comment(String comment_userid,String comment_date,String comment_content){
            this.comment_userid=comment_userid;
            this.comment_date=comment_date;
            this.comment_content=comment_content;
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
}
