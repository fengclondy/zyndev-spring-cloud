package com.zyndev.springbootribbonconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @HystrixCommand(fallbackMethod = "ribbonConsumerFallBack")
    @RequestMapping("/hello-hello")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVER/hello", String.class).getBody();
    }

    public String ribbonConsumerFallBack() {
        return "{'result':200,'timeout':100}";
    }

    @RequestMapping("/python-hello")
    public String pythonHelloConsumer() {
        return restTemplate.getForEntity("http://WEBSOCKET-SERVER/hello", String.class).getBody();
    }

    @RequestMapping("/python-sidecar")
    public String pythonSideCarConsumer() {
        return restTemplate.getForEntity("http://WEBSOCKET-SERVER/sidecar", String.class).getBody();
    }

}
