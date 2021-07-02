package com.zzu.demo.dao;

import com.zzu.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User selectUser(int id);
}
