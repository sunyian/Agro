package com.example.zy.agro.video_page;

/**
 * Created by 孙毅安 on 2018/3/27.
 */

public class video {
    private String video_title;
    private String video_class;
    private String video_watch;
    private int imageid;

    public video(String video_title,String video_class,String video_watch,int imageid){
        this.video_title=video_title;
        this.video_class=video_class;
        this.video_watch=video_watch;
        this.imageid=imageid;
    }
    public String getVideo_title(){
        return video_title;
    }
    public String getVideo_class(){
        return video_class;
    }
    public String getVideo_watch(){
        return video_watch;
    }
    public int getImageid(){
        return imageid;
    }
}
