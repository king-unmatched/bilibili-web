package com.jk.ElasticRepository;

import com.jk.model.BigEs;
import com.jk.model.EsComicvieo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticRepository extends ElasticsearchRepository <BigEs,Integer>{
}
