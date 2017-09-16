package com.zyndev.springbooteurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * author: 张瑀楠
 * email : zyndev@gmail.com
 * desc  :
 * date  : 2017/9/16 下午10:09
 * todo  :
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public Map index() {
        ServiceInstance instance = client.getLocalServiceInstance();
        Map<String, String> result = new HashMap<>();
        result.put("host", instance.getHost());
        result.put("serviceId", instance.getServiceId());
        result.put("email","zyndev@gmail.com");
        return result;
    }
}
