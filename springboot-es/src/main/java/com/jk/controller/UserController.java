package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.BigEs;
import com.jk.model.EsShortVideo;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class UserController {
    @Autowired
    private com.jk.ElasticRepository.ElasticRepository ElasticRepository;
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;
   /* @Autowired
    private EsService esService;*/
    //查询高亮和自动纠正
    @RequestMapping("listfuzzes")
    public ArrayList<BigEs> listSearchByPinyin(@RequestParam  String value){
		//自动纠正查询  
		/*参数：fuzziness(）定义最大的编辑距离 
				prefixLength(0)	定义最初始不会被“模糊”的term的数量
				maxExpansions(10) 定义fuzzy query会扩展的最大term的数量。默认为50*/
        FuzzyQueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", value)
                .fuzziness(Fuzziness.TWO)
                .prefixLength(0)
                .maxExpansions(10);
		//高亮对象
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");

		//elasticsearchTemplate综合查询
        SearchRequestBuilder requestBuilder = elasticsearchTemplate.getClient().prepareSearch("es-video")
                .setTypes("es-video")
                .setQuery(queryBuilder)
                .highlighter(highlightBuilder)
                .addSort("id", SortOrder.DESC).setFrom(0).setSize(5);
        System.out.println(requestBuilder);
		// 获取查询返回的对象
        SearchResponse response = requestBuilder.get();

		 // 通过SearchResponse对象获取命中的结果集
        SearchHits searchHits = response.getHits();

		// 命中的结果集获取iterator迭代器
        Iterator<SearchHit> iterator = searchHits.iterator();

		//定义一个索引实体类
        ArrayList<BigEs> bigesArray = new ArrayList<>();

		//迭代循环
        while (iterator.hasNext()){
            BigEs biges = new BigEs();
            SearchHit next = iterator.next();

			//获取高亮对象
            Map<String, HighlightField> highlightFields = next.getHighlightFields();
			
			//获取迭代的map集合
            Map<String, Object> sourceAsMap = next.getSourceAsMap();
			
			//赋值
            biges.setId(Integer.valueOf(sourceAsMap.get("id").toString()));
            biges.setName(highlightFields.get("name").getFragments()[0].toString());
            biges.setImg(sourceAsMap.get("img").toString());
            biges.setInfo(sourceAsMap.get("info").toString());
            biges.setUrl(sourceAsMap.get("url").toString());
            biges.setComic_number(Integer.valueOf(sourceAsMap.get("comic_number").toString()));
            bigesArray.add(biges);
        }
        for (int i = 0; i < bigesArray.size(); i++) {
            System.out.println(bigesArray.get(i));
        }
        //String s = JSONObject.toJSONString(bigesArray);
        return bigesArray;
    }
    
	
	//查询高亮
	@RequestMapping("es")
    public ArrayList<BigEs> queryes(String name){
        //获取es操作的客户端
        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("es-video").setTypes("es-video").setQuery(QueryBuilders.matchQuery("name", name)).addSort("id", SortOrder.DESC).setFrom(0).setSize(5);

        // 获取高亮对象
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        // 将高亮对象放入查询对象中
        searchRequestBuilder.highlighter(highlightBuilder);
        // 获取查询返回的对象
        SearchResponse searchResponse = searchRequestBuilder.get();
        // 通过SearchResponse对象获取命中的结果集
        SearchHits hits = searchResponse.getHits();
        // 命中的结果集获取iterator迭代器
        Iterator<SearchHit> iterator = hits.iterator();
        ArrayList<BigEs> bigesArray = new ArrayList<>();
        while (iterator.hasNext()){
            BigEs biges = new BigEs();
            SearchHit next = iterator.next();

            Map<String, HighlightField> highlightFields = next.getHighlightFields();
            Map<String, Object> sourceAsMap = next.getSourceAsMap();
            biges.setId(Integer.valueOf(sourceAsMap.get("id").toString()));
            biges.setName(highlightFields.get("name").getFragments()[0].toString());
            biges.setImg(sourceAsMap.get("img").toString());
            biges.setInfo(sourceAsMap.get("info").toString());
            biges.setUrl(sourceAsMap.get("url").toString());
            biges.setComic_number(Integer.valueOf(sourceAsMap.get("comic_number").toString()));
            bigesArray.add(biges);
        }
        for (int i = 0; i < bigesArray.size(); i++) {
            System.out.println(bigesArray.get(i));
        }
        String s = JSONObject.toJSONString(bigesArray);
        return bigesArray;
    }
	//新增索引数据
   /* @RequestMapping("esadd")
    public void esadd() {
        *//*BigEs bigEs = new BigEs();
        String array="";
        Integer ids=0;*//*
        List<BigEs> esComicvieo=esService.querycomicvideo();
        for (int i = 0; i <esComicvieo.size() ; i++) {

            System.out.println(esComicvieo.get(i));
            ElasticRepository.save(esComicvieo.get(i));

        }
    }*/
	//自动补全
    @RequestMapping("queryzdbq")
    public List<String> listSuggestCompletion(@RequestParam  String value) {

        /*String suggestField="name";//指定在哪个字段搜索
        String suggestValue="王二";//输入的信息
        Integer suggestMaxCount=10;//获得最大suggest条数*/

        CompletionSuggestionBuilder suggestionBuilderDistrict = new CompletionSuggestionBuilder("name.suggest").prefix(value).size(10);
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion("name-suggest", suggestionBuilderDistrict);//添加suggest

        //设置查询builder的index,type,以及建议
        if(elasticsearchTemplate==null)
            System.out.println( "this is Template null  ***************************************************");
        SearchRequestBuilder requestBuilder = elasticsearchTemplate.getClient().prepareSearch("es-video").setTypes("es-video").suggest(suggestBuilder);
        System.out.println(requestBuilder.toString());

        SearchResponse response = requestBuilder.get();
        Suggest suggest = response.getSuggest();//suggest实体

        Set<String> suggestSet = new HashSet<>();//set
        int maxSuggest = 0;
        if (suggest != null) {
            Suggest.Suggestion result = suggest.getSuggestion("name-suggest");//获取suggest,name任意string
            for (Object term : result.getEntries()) {

                if (term instanceof CompletionSuggestion.Entry) {
                    CompletionSuggestion.Entry item = (CompletionSuggestion.Entry) term;
                    if (!item.getOptions().isEmpty()) {
                        //若item的option不为空,循环遍历
                        for (CompletionSuggestion.Entry.Option option : item.getOptions()) {
                            String tip = option.getText().toString();
                            if (!suggestSet.contains(tip)) {
                                suggestSet.add(tip);
                                ++maxSuggest;
                            }
                        }
                    }
                }
                if (maxSuggest >= 10) {
                    break;
                }
            }
        }

        List<String> suggests = Arrays.asList(suggestSet.toArray(new String[]{}));

        suggests.forEach((s)->{
            System.out.println(s);

        });

        return	 suggests;
    }
}
