package com.jk.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "short-video",type = "short-video-type")
public class EsShortVideo {
    @Id
    private Integer short_id;
    @Field(type = FieldType.Keyword, analyzer = "ik_synonym", store = true)
    private String  video_name;
    private String  video_img;
    private String  video_url;
    private String  video_duration;
    private Date create_time;
    private Integer video_author;
    private Integer video_counts;
    private String  video_info;

}
