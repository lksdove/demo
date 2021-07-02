package com.zzu.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzu.demo.entity.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "persons")
public interface PersonMapper extends BaseMapper<Person> {

    @Select("<script>\n" +
            "select * \n" +
            "from person\n" +
            "<where>\n" +
            "\t<if test = 'id != null and id != &quot;&quot;'>\n" +
            "\t\tid = #{id}\n" +
            "\t</if>\n" +
            "</where>\n" +
            "</script>")
    Person selectById(int id);

    int testInsert(Person person);

    List<Person> listByIds(@Param("ids") Integer[] ids);

    @Cacheable
    List<Person> selectByPerson(Person person);

    int insertPerson(Person person);

    void updatePerson(Person person);
}
