package com.hc.core.solr;

import com.hc.core.vo.BookVO;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * Created by milk.huchan on 2017/3/11.
 */
public interface SolrBookRepository extends SolrCrudRepository<BookVO, String> {

    List<BookVO> findByName(String name);
    
}