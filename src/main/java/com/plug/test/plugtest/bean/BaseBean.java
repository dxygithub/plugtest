package com.plug.test.plugtest.bean;

import com.plug.test.plugtest.enumation.DelFlag;
import com.rabbit.core.annotation.Column;
import com.rabbit.core.annotation.Create;
import com.rabbit.core.annotation.Delete;
import com.rabbit.core.annotation.Update;
import com.rabbit.core.typehandler.IEnumTypeHandler;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName BaseBean
 * @ClassExplain: 说明
 * @Author Duxiaoyu
 * @Date 2020/6/7 18:29
 * @Since V 1.0
 */
@Data
public class BaseBean {

    private Date createTime;

    private Date updateTime;

    @Delete(physicsDel = false,value = 8)
    //@Column(typeHandler = IEnumTypeHandler.class)
    private Integer delFlag;

    @Create
    public void insert(){
        this.createTime=new Date();
        this.delFlag=DelFlag.NO.getValue();
    }

    @Update
    public void update(){
        this.updateTime=new Date();
    }
}
