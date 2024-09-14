package com.server.pard.week3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

    // getting the data right from the url path

    @RequestMapping("/path/{name}")
    public String pathV1(@PathVariable("name") String myName) {
        return "1st path var controller name: " + myName;
    }

    @RequestMapping("/pathV2/{name}")
    public String pathV2(@PathVariable("name") String name) {
        return "2nd path var controller name: " + name;
    }

    @RequestMapping("/pathV3/{name}/{age}")
    public String pathV3(@PathVariable("name") String name, @PathVariable Long age) {
        return "3rd user name: " + name + " age: " + age;
    }
}