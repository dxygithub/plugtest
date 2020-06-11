package com.plug.test.plugtest;

import cn.hutool.json.JSONUtil;
import com.plug.test.plugtest.bean.PlugTest;
import com.plug.test.plugtest.enumation.DelFlag;
import com.plug.test.plugtest.service.PlugTestService;
import com.rabbit.core.constructor.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void queryObjectList(){
        List<PlugTest> plugTestList=plugTestService.queryObjectList(new QueryWrapper<>().
                /*where("del_flag", DelFlag.NO.getValue()).*/
                ge("id",1).
                setColumn("id,plug_des,plug_name,del_flag").
                limit(0,10).
                orderBy("id",QueryWrapper.DESC),PlugTest.class);
        log.info(plugTestList !=null ? JSONUtil.toJsonStr(plugTestList) : "selectList failed...");
    }

    @Test
    public void delete(){
        // 逻辑删除
        Long result=plugTestService.deleteObject("8031320f9a0c4898847d52a6eba8b363",PlugTest.class);
        log.info(result>0?"deleteObject success...":"deleteObject failed...");

    }
}
