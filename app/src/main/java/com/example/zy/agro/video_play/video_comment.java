package com.example.zy.agro.video_play;

/**
 * Created by 孙毅安 on 2018/3/30.
 */

public class video_comment {
    main_comment main_comment;
    child_comment child_comment1;
    child_comment child_comment2;
    String comment_num;

    public video_comment(main_comment main_comment,child_comment child_comment1,child_comment child_comment2,String comment_num){
        this.main_comment=main_comment;
        this.child_comment1=child_comment1;
        this.child_comment2=child_comment2;
        this.comment_num = comment_num;
    }

    public main_comment getMain_comment() {
        return main_comment;
    }

    public child_comment getChild_comment1() {
        return child_comment1;
    }

    public child_comment getChild_comment2() {
        return child_comment2;
    }

    public String getComment_num() {
        return comment_num;
    }
}
