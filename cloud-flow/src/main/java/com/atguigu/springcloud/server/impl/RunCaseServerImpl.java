package com.atguigu.springcloud.server.impl;

import com.alibaba.compileflow.engine.ProcessEngine;
import com.alibaba.compileflow.engine.ProcessEngineFactory;
import com.atguigu.springcloud.server.RunCaseServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class RunCaseServerImpl implements RunCaseServer {
    @Override
    public void run() {
        //code在bpm文件中定义
        String code = "bpm.sqrt";

        //执行流程的入参
        Map<String, Object> context = new HashMap<>();
        context.put("num", 4);
        log.info("context::::"+context);
        try {
            ProcessEngine processEngine = ProcessEngineFactory.getProcessEngine();
            Map<String, Object> result = processEngine.execute(code, context);
            System.out.println(result.get("numSqrt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
