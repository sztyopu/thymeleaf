package com.sf.springserverinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class SpringServerInfoController {

    @Autowired
    private ServletContext servletContext;

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




    @GetMapping("/")
    public String init(Model model) throws UnknownHostException, MalformedURLException {

        //Server name
        hostname = InetAddress.getLocalHost().getHostName();

        //Server adress
        ip = InetAddress.getLocalHost().getHostAddress();

        //Server Date+Time
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();

        //Server URL
        //URL url = new URL("http://localhost/");
        //String _Path = url.getPath();
        System.out.println("Ez az Url: " + servletContext.getContextPath());

        model.addAttribute("hostname", hostname);
        model.addAttribute("ip", ip);
        model.addAttribute("today", today);
        model.addAttribute("time", time);
        // model.addAttribute("_Path", _Path);

        return "table";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("name", name);
        model.addAttribute("first", first);
        model.addAttribute("second", second);
        model.addAttribute("third", third);
        model.addAttribute("description", description);
        return "profile-page";
    }
}



