package com.jk.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "index-ik-01",type = "index-type")
public class EsComicvieo {
    @Id
    private Integer id;
    @Field(type = FieldType.Keyword, analyzer = "ik_synonym", store = true)
    private String  name;
    private String  comic_xiaoimg;
    private String  info;
    private Integer playback;
    private String  img;
    private Integer type;
    private String  url;
    private Integer comic_number;
    private Date    to_update;
    private Integer ji_number;
}
