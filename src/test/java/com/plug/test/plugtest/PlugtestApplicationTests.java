package com.plug.test.plugtest;

import com.plug.test.plugtest.bean.PlugTest;
import com.plug.test.plugtest.mapper.PlugTestMapper;
import com.rabbit.core.constructor.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@Slf4j
class PlugtestApplicationTests {

    @Autowired
    private PlugTestMapper plugTestMapper;

    @Test
    void contextLoads() {
        PlugTest plugTest = new PlugTest();
        plugTest.setId(2);
        plugTest.setPlugId(1002);
        plugTest.setPlugName("oracle");
        plugTest.setPlugDes("关系型数据库");
        int result = plugTestMapper.insert(plugTest);
        log.info(result > 0 ? "insert success..." : "insert failed...");
    }

    @Test
    public void insert() {
        // 自动生成主键
        PlugTest plugTest = new PlugTest(2, null, "oracle", "关系型数据库");
        int result = plugTestMapper.insert(plugTest);
        log.info(result > 0 ? " auto generate primary key insert success..." : "auto generate primary key insert failed...");
    }

    @Test
    public void insertBatch() {
        List<PlugTest> entityList = Stream.of(
                new PlugTest(6, 1006, "redis", "非关系型数据库"),
                new PlugTest(7, 1007, "mogoDB", "非关系型数据库"),
                new PlugTest(8, 1008, "memercache", "非关系型数据库")
        ).collect(Collectors.toList());
        int result = plugTestMapper.insertBatch(entityList);
        log.info(result > 0 ? "insertBatch success..." : "insertBatch failed...");
    }

    @Test
    public void updateById() {
        PlugTest plugTest = new PlugTest(null, 1004, "h2", "小型关系型数据库");
        int result = plugTestMapper.updateById(plugTest);
        log.info(result > 0 ? "updateById success..." : "updateById failed...");
    }

    @Test
    public void updateBatchById() {
        List<PlugTest> entityList = Stream.of(
                new PlugTest(null, 1002, "redis", "非关系型数据库"),
                new PlugTest(null, 1003, "mogoDB", "非关系型数据库"),
                new PlugTest(null, 1004, "memercache", "非关系型数据库")
        ).collect(Collectors.toList());
        int result = plugTestMapper.updateBatchById(entityList);
        log.info(result > 0 ? "updateBatchById success..." : "updateBatchById failed...");
    }

    @Test
    public void deleteById() {
        int result = plugTestMapper.deleteById(1004);
        log.info(result > 0 ? "deleteById success..." : "deleteById failed...");
    }

    @Test
    public void deleteBatchById() {
        List<Object> idList = Stream.of(1002, 1003).collect(Collectors.toList());
        int result = plugTestMapper.deleteBatchById(idList);
        log.info(result > 0 ? "deleteBatchById success..." : "deleteBatchById failed...");
    }

    @Test
    public void selectCount(){
        Integer count=plugTestMapper.selectCount(new QueryWrapper<>().where("1",1));
        log.info(count > 0 ? "selectCount success count is "+count : "selectCount failed...");
    }

    @Test
    public void selectById(){
        PlugTest plugTest=plugTestMapper.selectById(1002);
        log.info(plugTest !=null ? plugTest.toString() : "selectById failed...");
    }

    @Test
    public void selectBatchIds(){
        List<PlugTest> plugTests=plugTestMapper.selectBatchIds(Arrays.asList(1002,1003,1004));
        plugTests.forEach(PlugTest::getPlugName);
    }

    @Test
    public void selectOne(){
        PlugTest plugTest=plugTestMapper.selectOne(new QueryWrapper<>().where("plug_id",1002).isNotNull("plug_id"));
        log.info(plugTest !=null ? plugTest.toString() : "selectOne failed...");
    }
}
