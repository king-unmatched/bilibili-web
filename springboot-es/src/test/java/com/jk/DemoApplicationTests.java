package com.jk;

import com.jk.ElasticRepository.ElasticRepository;
import com.jk.model.BigEs;
import com.jk.model.EsComicvieo;
import com.jk.model.User;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private ElasticRepository ElasticRepository;
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    /*@Test
    public  void highlight(){
        //获取es操作的客户端
        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("index-ik-01").setTypes("index-type").setQuery(QueryBuilders.matchQuery("username", "土豆")).addSort("id", SortOrder.DESC).setFrom(0).setSize(2);

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("username");
        searchRequestBuilder.highlighter(highlightBuilder);
        SearchResponse searchResponse = searchRequestBuilder.get();
        SearchHits hits = searchResponse.getHits();
        Iterator<SearchHit> iterator = hits.iterator();
        ArrayList<User> users = new ArrayList<>();
        while (iterator.hasNext()){
            User user = new User();
            SearchHit next = iterator.next();
            Map<String, HighlightField> highlightFields = next.getHighlightFields();
            Map<String, Object> sourceAsMap = next.getSourceAsMap();
            user.setId(Integer.valueOf(sourceAsMap.get("id").toString()));
            user.setUsername(highlightFields.get("username").getFragments()[0].toString());
            user.setAge(Integer.valueOf(sourceAsMap.get("age").toString()));
            users.add(user);
        }
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(0));
        }
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void esadd() {
        User u = new User();
        u.setId(3);
        u.setUsername("马铃薯");
        u.setAge(202);
        //ElasticRepository.save(u);

    }

    @Test
    public void query() {
        Iterable<BigEs> iterable = ElasticRepository.findAll();
        Iterator<BigEs> iterator = iterable.iterator();
        ArrayList<BigEs> array = new ArrayList<>();
        while (iterator.hasNext()){
            array.add(iterator.next());
        }
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }


    }*/
}
