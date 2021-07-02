package com.zzu.demo.controller;

import com.alibaba.fastjson.JSON;
import com.zzu.demo.apiversioncontrol.APIVersion;
import com.zzu.demo.dao.vo.Obj;
import com.zzu.demo.entity.Person;
import com.zzu.demo.entity.User;
import com.zzu.demo.exception.ParaException;
import com.zzu.demo.hutoolDemo.mail.WhhMailUtil;
import com.zzu.demo.server.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author lks
 * @date 2020/11/18 16:25
 */
@Slf4j
@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
//@Valid
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Obj obj;
    @Autowired
    private Test1 test1;

    @PostMapping("getPerson")
    public Person selectPerson(Integer id) {
        return new Person(1,"asd");
//        return userService.selectPerson(id);
    }

    @RequestMapping("/apiVersion")
    @APIVersion("v1")
    public int apiVersion() {
        return 1;
    }

    /**
     * HuTool邮件工具类测试
     *
     * @return
     */
    @RequestMapping("/sendEmail")
    public String sendEmail() {
        WhhMailUtil.send("likangshuai@wahaha.com.cn", "邮件工具类", "这是测试", false);
        return "success";
    }

    /**
     * 测试接口
     *
     * @param dogDTO
     * @return
     */
    @PostMapping("/test")
    public String test(@Valid @RequestBody DogDTO dogDTO) {
        Optional<String> sex = dogDTO.getSex();
        if (sex == null) {

        }else{
            String s = sex.get();
            System.err.println(s);
        }
        System.err.println(dogDTO.getSex());
        return "success";
    }

    //    public static void main(String[] args) throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        System.err.println(mapper.writeValueAsString(new DogDTO()));
//    }
    public static void main(String[] args) {
        User user = new User();
        user.setId(100);
        user.setName("qwe");
        user.setAge(200);
        String userStr = JSON.toJSONString(user);
        System.err.println(userStr);
        User parseObject = JSON.parseObject(userStr, User.class);
        System.err.println(parseObject.toString());
    }
}
