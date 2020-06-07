package com.plug.test.plugtest.enumation;

import com.rabbit.core.enumation.IEnum;

/**
 * @ClassName DelFlag
 * @ClassExplain: 说明
 * @Author Duxiaoyu
 * @Date 2020/6/7 19:14
 * @Since V 1.0
 */
public enum DelFlag implements IEnum<Integer> {

    NO(1),
    YES(2);

    private int value;

    DelFlag(int value){
        this.value=value;
    }

    public static DelFlag convert(int value){
        for (DelFlag delFlag:DelFlag.values()){
            if(delFlag.value==value){
                return delFlag;
            }
        }
        return null;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
