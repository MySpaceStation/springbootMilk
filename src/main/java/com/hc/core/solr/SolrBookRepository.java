package com.hc.core.solr;

import com.hc.core.vo.BookVO;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * Created by milk.huchan on 2017/3/11.
 */
public interface SolrBookRepository extends SolrCrudRepository<BookVO, String> {

    List<BookVO> findByName(String name);

//    Page<User> findByNameOrDescription(@Boost(2) String name, String description, Pageable page);
//
//    @Highlight
//    HighlightPage<User> findByNameIn(Collection<String> name, Page page);
//
//    @Query(value = "name:?0")
//    @Facet(fields = { "cat" }, limit=20)
//    FacetPage<User> findByNameAndFacetOnCategory(String name, Pageable page);
}