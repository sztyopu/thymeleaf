package com.mkyong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.name}")
    private String welcomeName;

    private String hostname;

    // inject via application.properties
    @Value("${profile.page.name}")
    private String name;

    // inject via application.properties
    @Value("${profile.page.first}")
    private String first;

    // inject via application.properties
    @Value("${profile.page.second}")
    private String second;

    // inject via application.properties
    @Value("${profile.page.third}")
    private String third;

    // inject via application.properties
    @Value("${profile.page.description}")
    private String description;


    @GetMapping("/hello")
    public String hello(Model model) throws UnknownHostException {
        hostname = InetAddress.getLocalHost().getHostName();
        model.addAttribute("welcomeName", welcomeName);
        model.addAttribute("hostname", hostname);
        return "welcome"; //view
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("name", name);
        model.addAttribute("first", first);
        model.addAttribute("second", second);
        model.addAttribute("third", third);
        model.addAttribute("description", description);
        return "profile-page"; //view
    }

/*    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }*/

}