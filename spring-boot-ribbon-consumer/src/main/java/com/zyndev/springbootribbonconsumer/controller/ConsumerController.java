package com.zyndev.springbootribbonconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @HystrixCommand(fallbackMethod = "ribbonConsumerFallBack")
    @RequestMapping("/ribbon-consumer")
    public String helloConsumer(@RequestParam("key")String key) {
        System.out.println("key " + key);
        return restTemplate.getForEntity("http://HELLO-SERVER/hello", String.class).getBody();
    }

    public String ribbonConsumerFallBack(String key) {
        return "{'result':200,'timeout':100}";
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
