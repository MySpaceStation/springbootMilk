package com.hc.core.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * Created by milk.huchan on 2017/3/11.
 */
@Configuration
@EnableSolrRepositories(basePackages = "com.hc.core.solr", multicoreSupport=true)
public class SolrConfig implements EnvironmentAware {
    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.data.solr.");
    }

    @Bean
    public SolrClient solrClient()  {
        String solrHost = propertyResolver.getProperty("host");
        return new HttpSolrClient(solrHost);
    }
}
