package com.zzu.demo.server;

import com.zzu.demo.dao.PersonMapper;
import com.zzu.demo.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserService{
    public final Person person=new Person(1,"lks");

    @Autowired
    private PersonMapper personMapper;



    public Person getPerson() {
        return person;
    }

    public void insertUser() {

//        Person p = new Person();
//        p.setName("启力User");
//        p.setAge(22);
//        p.setEmail("@qq.com");
//        personMapper.insertPerson(p);
    }

    public void testInsert() {
        try {
            ((UserService) AopContext.currentProxy()).insertUser();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    public Person selectPerson(int id){
        return personMapper.selectById(id);
    }
}
