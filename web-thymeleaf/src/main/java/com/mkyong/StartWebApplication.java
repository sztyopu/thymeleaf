package com.mkyong;

import ch.qos.logback.core.property.FileExistsPropertyDefiner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class StartWebApplication {




    public static void main(String[] args) throws UnknownHostException, MalformedURLException {
        SpringApplication.run(StartWebApplication.class, args);

        String hostname = InetAddress.getLocalHost().getHostName();
        String ip = InetAddress.getLocalHost().getHostAddress();

        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();

        URL url = new URL("http://localhost/");
        String _Path = url.getPath();

        System.out.println(hostname);
        System.out.println(ip);
        System.out.println(today +" " + time);

        System.out.println(_Path);
    }



}