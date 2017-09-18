package com.zyndev.springbootsidecar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * Author: 张瑀楠 wb.yunan.zhang@renren-inc.com
 * TODO:
 */
@RestController
public class HomeController {

    @RequestMapping("index")
    public Map python() {
        Map result = new HashMap<String, String>();
        result.put("status", "200");
        return result;
    }

}
