package com.atguigu.springcloud.config;

import com.alibaba.compileflow.engine.ProcessEngine;
import com.alibaba.compileflow.engine.ProcessEngineFactory;
import com.alibaba.compileflow.engine.process.preruntime.generator.bean.SpringApplicationContextProvider;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 系统启动时,预加载bpm流程到内存
 * 降低初始化流程所带来的耗时
 */
@Component
@Configuration
public class BpmInitializer implements InitializingBean, ApplicationContextAware {

    @Override
    public void afterPropertiesSet() throws Exception {
        ProcessEngine processEngine = ProcessEngineFactory.getProcessEngine();
        processEngine.preCompile("bpm.sqrt");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContextProvider.applicationContext = applicationContext;
    }

}
