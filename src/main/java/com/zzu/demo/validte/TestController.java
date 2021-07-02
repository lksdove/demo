package com.zzu.demo.validte;

import com.zzu.demo.result.WhhRestResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lks
 * @date 2020/12/10 13:01
 */
@RestController
@RequestMapping("validteTest")
public class TestController {

    @PostMapping("test")
    public WhhRestResult test(@Valid Person person) {
        return WhhRestResult.ok(person);
    }

    @RequestMapping("testJMeter")
    public WhhRestResult testJmeter(){
        return WhhRestResult.ok();
    }
}
