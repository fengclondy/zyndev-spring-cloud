package com.zyndev.springbootribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * author: 张瑀楠
 * email : zyndev@gmail.com
 * desc  :
 * date  : 2017/9/16 下午11:02
 * todo  :
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVER/hello", String.class).getBody();
    }

    @RequestMapping("/ribbon-consumer-python")
    public String pythonConsumer() {
        return restTemplate.getForEntity("http://WEBSOCKET-SERVER/tttt", String.class).getBody();
    }

    @ResponseBody
    @RequestMapping("/send/{appId}/{userId}")
    public String sendPython(@PathVariable("appId")String appId, @PathVariable("userId")String userId) {
        System.out.println(" appId:" + appId + "  userId:" + userId);
        return restTemplate.postForEntity("http://WEBSOCKET-SERVER/send/"+ appId +"/" + userId, null ,String.class).getBody();
    }



}
