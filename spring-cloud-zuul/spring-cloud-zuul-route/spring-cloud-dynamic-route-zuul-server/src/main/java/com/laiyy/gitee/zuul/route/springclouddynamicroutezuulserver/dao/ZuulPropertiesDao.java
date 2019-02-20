package com.laiyy.gitee.zuul.route.springclouddynamicroutezuulserver.dao;

import com.laiyy.gitee.zuul.route.springclouddynamicroutezuulserver.entity.ZuulRouteEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laiyy
 * @date 2019/2/20 17:23
 * @description
 */
@Component
public class ZuulPropertiesDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ZuulPropertiesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String SQL = "SELECT * FROM zuul_route WHERE enable = TRUE";

    public Map<String, ZuulProperties.ZuulRoute> getProperties() {
        Map<String, ZuulProperties.ZuulRoute> routeMap = new LinkedHashMap<>();
        List<ZuulRouteEntity> list = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(ZuulRouteEntity.class));
        list.forEach(entity -> {
            if (StringUtils.isBlank(entity.getPath())) {
                return;
            }
            ZuulProperties.ZuulRoute route = new ZuulProperties.ZuulRoute();
            BeanUtils.copyProperties(entity, route);
            routeMap.put(route.getPath(), route);
        });
        return routeMap;
    }
}
