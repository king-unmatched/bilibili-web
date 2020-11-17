package com.jk.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "es-kz",type = "es-kz-type")
public class ZdbqBean {
    @Id
    private Integer id;
    @Field(type = FieldType.Keyword, analyzer = "ik_synonym", store = true)
    private String   name;
}
