package com.jk.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "es-video",type = "es-video")
public class BigEs {
    @Id
    private Integer id;
    @Field(type = FieldType.Keyword, analyzer = "ik_synonym", store = true)
    private String   name;
   /* private String   comic_video_xiaoimg;
    private String   comic_video_info;
    private Integer  comic_video_playback;
    private String   comic_video_img;
    private Integer  comic_video_type;
    private String   comic_video_url;
    private Integer  comic_video_number;
    private Date     comic_video_to_update;
    private Integer  comic_video_ji_number;*/

    //private String  comic_xiaoimg;
    private String  info;
    //private Integer playback;
    private String  img;
    //private Integer type;
    private String  url;

    private Integer comic_number;
    /*private Date    to_update;
    private Integer ji_number;

     private String   short_video_img;
    private String   short_video_url;
    private String   short_video_duration;
    private Date     short_video_create_time;
    private Integer  short_video_author;
    private Integer  short_video_counts;
    private String   short_video_info;

    private String  video_img;
    private String  video_url;
    private String  video_duration;
    private Date create_time;
    private Integer video_author;
    private Integer video_counts;
    private String  video_info;*/
}
