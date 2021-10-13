package com.jerry.c3p0datasource.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

public interface TestMapper {

    @Select("SELECT count(1) FROM `adgroup_region_amount`;")
    Integer testSelect();
}
