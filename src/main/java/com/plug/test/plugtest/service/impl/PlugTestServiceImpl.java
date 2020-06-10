package com.plug.test.plugtest.service.impl;

import com.plug.test.plugtest.bean.PlugTest;
import com.plug.test.plugtest.mapper.PlugTestMapper;
import com.plug.test.plugtest.service.PlugTestService;
import com.rabbit.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName PlugTestServiceImpl
 * @Author duxiaoyu
 * @Date 2020/6/9 11:19
 * @Version 1.0
 */
@Service
public class PlugTestServiceImpl extends BaseServiceImpl<PlugTestMapper> implements PlugTestService {

    @Autowired
    private PlugTestMapper plugTestMapper;
}
