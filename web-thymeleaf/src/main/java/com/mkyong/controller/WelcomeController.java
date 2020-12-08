package com.mkyong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.name}")
    private String welcomeName;

    private String hostname;
    private String ip;

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

    @Autowired
    private ServletContext servletContext;


    @GetMapping("/hello")
    public String hello(Model model) throws UnknownHostException, MalformedURLException {
        hostname = InetAddress.getLocalHost().getHostName();
        ip = InetAddress.getLocalHost().getHostAddress();

        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();

        //URL url = new URL("http://localhost/");
        //String _Path = url.getPath();

        System.out.println("Ez az: " + servletContext.getContextPath());

        model.addAttribute("welcomeName", welcomeName);
        model.addAttribute("hostname", hostname);
        model.addAttribute("ip", ip);
        model.addAttribute("today", today);
        model.addAttribute("time", time);
       // model.addAttribute("_Path", _Path);

        return "table"; //view


    }

    @GetMapping("/profile")
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