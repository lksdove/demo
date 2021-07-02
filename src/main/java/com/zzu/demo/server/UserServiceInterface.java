package com.zzu.demo.server;

import com.zzu.demo.entity.Person;

/**
 * @author lks
 * @date 2021/5/11 13:15
 */
public interface UserServiceInterface {
    void insertUser();
    void testInsert();
    Person selectPerson(int id);
}
