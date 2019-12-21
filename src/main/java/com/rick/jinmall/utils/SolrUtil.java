package com.rick.jinmall.utils;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.*;

/**
 * Solr工具类
 */
public class SolrUtil {

    /**
     * 批量增加索引
     */
    public static void addIndex(SolrClient solrClient, Map<String, Object> map) throws IOException, SolrServerException {
        // 必须先添加id
        SolrInputDocument document = new SolrInputDocument();
        Object idValue = map.get("id");
        document.addField("id", idValue);

        if (map != null) {
            Set<Map.Entry<String, Object>> entrySet = map.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ("id".equals(key)) {
                    continue;
                }

                Map<String, Object> operation = new HashMap<>();
                operation.put("set", value);
                document.addField(key, operation);
            }
        }

        UpdateResponse response = solrClient.add(document);
        solrClient.commit();
    }

    public static List<String> searchInfoFromSolr(SolrClient solrClient, String searchName)
            throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        query.setQuery("productName:" + "*" + searchName + "* or productDesc:" + "*" + searchName + "*");
        QueryResponse response = solrClient.query(query);
        SolrDocumentList docs = response.getResults();
        int count = docs.size();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            SolrDocument sd = docs.get(i);
            String idValue = (String) sd.getFieldValue("id");
            list.add(idValue);
        }
        return list;
    }
}
