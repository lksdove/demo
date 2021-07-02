package com.zzu.demo.apiversioncontrol;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lks
 * @date 2020/12/10 8:45
 */
@RestController
@RequestMapping("versionTest")
public class ApiControllerTest {

    @RequestMapping("test1")
    @APIVersion("v1")
    public int test1() {
        return 1;
    }


    /**
     * 多个版本适用
     * @return
     */
    @RequestMapping("test2")
    @APIVersion(value = {"v1","v2"})
    public int test2() {
        return 1;
    }

    @RequestMapping("test3")
    public int test3() {
        return 1;
    }
}
