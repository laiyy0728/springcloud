package com.laiyy.gitee.feign.multi.params.springcloudfeignmultiparamscomsumer.interceptor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author laiyy
 * @date 2019/1/24 10:33
 * @description 实现 Feign Request 拦截器，实现 GET 传递 POJO
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    private final ObjectMapper objectMapper;
    @Autowired
    public FeignRequestInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override
    public void apply(RequestTemplate template) {
        if ("GET".equals(template.method()) && template.body() != null) {
            try {
                JsonNode jsonNode = objectMapper.readTree(template.body());
                template.body(null);

                Map<String, Collection<String>> queries = new HashMap<>();

                buildQuery(jsonNode, "", queries);

                template.queries(queries);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {
        if (!jsonNode.isContainerNode()) {
            // 如果是叶子节点
            if (jsonNode.isNull()) {
                return;
            }
            Collection<String> values = queries.get(path);
            if (CollectionUtils.isEmpty(values)) {
                values = new ArrayList<>();
                queries.put(path, values);
            }
            values.add(jsonNode.asText());
            return;
        }
        if (jsonNode.isArray()){
            // 如果是数组节点
            Iterator<JsonNode> elements = jsonNode.elements();
            while (elements.hasNext()) {
                buildQuery(elements.next(), path, queries);
            }
        } else {
            Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                if (StringUtils.hasText(path)) {
                    buildQuery(entry.getValue(), path + "." + entry.getKey(), queries);
                } else {
                    // 根节点
                    buildQuery(entry.getValue(), entry.getKey(), queries);
                }
            }
        }
    }
}
