package no.finntech.solr.loadtest;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@Controller
@EnableAutoConfiguration
public class LoadTester {

    SolrServer server = new HttpSolrServer("http://localhost:12200/solr");


	@RequestMapping("/alwaysnew")
	@ResponseBody
    public QueryResponse alwaysNew() throws SolrServerException {
        SolrServer localServer = new HttpSolrServer("http://localhost:12200/solr");
        SolrQuery wildCardQuery = new SolrQuery();
        wildCardQuery.add("q", "*:*");
        return localServer.query(wildCardQuery);
    }

    @RequestMapping("/singleton")
    @ResponseBody
    public QueryResponse singleton() throws SolrServerException {
        SolrQuery wildcardQuery = new SolrQuery();
        wildcardQuery.add("q", "*:*");
        return server.query(wildcardQuery);
    }


    public static void main(String[] args) {
        SpringApplication.run(LoadTester.class, args);
    }
}