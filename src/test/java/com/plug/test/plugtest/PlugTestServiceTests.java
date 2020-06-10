package com.plug.test.plugtest;

import com.plug.test.plugtest.bean.PlugTest;
import com.plug.test.plugtest.service.PlugTestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName PlugTestServiceTests
 * @Author duxiaoyu
 * @Date 2020/6/9 11:25
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
public class PlugTestServiceTests {

    @Autowired
    private PlugTestService plugTestService;

    @Test
    public void addObject(){
        PlugTest plugTest=new PlugTest();
        plugTest.setId(11);
        plugTest.setPlugName("windos");
        plugTest.setPlugDes("操作系统");
        String result=plugTestService.addObject(plugTest);
        log.info("result==>"+result);
    }
}
