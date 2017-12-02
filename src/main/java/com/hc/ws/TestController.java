package com.hc.ws;

import com.hc.core.solr.SolrBookRepository;
import com.hc.core.vo.BookVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by milk.huchan on 2017/3/10.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private SolrClient solrClient;

    @Resource
    private SolrBookRepository solrBookRepository;

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    @ApiOperation(value = "测试接口", notes = "测试接口详细描述")
    public String show(@ApiParam(required = true, name = "name", value = "书名") @RequestParam(name = "name") String stuName) {
        SolrQuery query = new SolrQuery();
        QueryResponse response = null;
        query.setQuery("name:" + stuName);
        try {
            response = solrClient.query(query);
            SolrDocumentList solrDocumentList = response.getResults();
            for (SolrDocument sd : solrDocumentList) {
                System.out.println("solr获取值id：" + sd.getFieldValue("id"));
                System.out.println("solr获取值：" + sd.getFieldValue("price"));
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  response.toString();
    }

    @RequestMapping(value = "/showRepository", method = RequestMethod.POST)
    @ApiOperation(value = "测试接口", notes = "测试接口详细描述")
    public List<BookVO> showRepository(@ApiParam(required = true, name = "name", value = "书名") @RequestParam(name = "name") String stuName) {

        return solrBookRepository.findByName(stuName);
    }
}
