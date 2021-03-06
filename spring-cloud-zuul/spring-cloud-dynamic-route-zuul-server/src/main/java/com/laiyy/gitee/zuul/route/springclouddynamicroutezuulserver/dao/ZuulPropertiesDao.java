package com.laiyy.gitee.zuul.route.springclouddynamicroutezuulserver.dao;

import com.laiyy.gitee.zuul.route.springclouddynamicroutezuulserver.entity.ZuulRouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * @author laiyy
 * @date 2019/2/20 17:23
 * @description
 */
public interface ZuulPropertiesDao extends JpaRepository<ZuulRouteEntity, Integer> {

    @Query("FROM ZuulRouteEntity WHERE enabled = TRUE")
    List<ZuulRouteEntity> findAllByParams();

}
