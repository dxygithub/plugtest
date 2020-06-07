package com.plug.test.plugtest.bean;

import com.rabbit.core.annotation.Id;
import com.rabbit.core.enumation.PrimaryKey;
import lombok.Data;

/**
 * @ClassName PlugTest
 * @ClassExplain: 说明
 * @Author Duxiaoyu
 * @Date 2020/6/7 18:27
 * @Since V 1.0
 */
@Data
public class PlugTest extends BaseBean{

    private Integer id;

    @Id
    private Integer plugId;

    private String plugName;

    private String plugDes;

    public PlugTest(Integer id,Integer plugId,String plugName,String plugDes){
        this.id=id;
        this.plugId=plugId;
        this.plugName=plugName;
        this.plugDes=plugDes;
    }

    public PlugTest(){}
}
