package com.itheima.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 19856
 * @creator 2022/11/25-23:58
 */
@Component
@Endpoint(id = "pay",enableByDefault = true)
public class PayEndpoint {

    @ReadOperation
    public Object getPay(){
        System.out.println("=======pay=========");
        //调用业务操作，获取支付相关信息结果，最终return出去
         Map payMap = new HashMap();
         payMap.put("level 1",103);
         payMap.put("level 2",315);
         payMap.put("level 3",666);
        return payMap;

    }
}
