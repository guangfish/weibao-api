package com.new4s.weibao.api.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by chenhj on 2017/9/28.
 */
@Service
public class GlobalVariable {
    Logger logger = LoggerFactory.getLogger(GlobalVariable.class);

    public void init(){
        logger.info("初始化全局变量开始！~~~~~~~~~~~~~~~");

        //这里可以做初始化操作
        
        logger.info("初始化全局变量完成！~~~~~~~~~~~~~~~");
    }

}
