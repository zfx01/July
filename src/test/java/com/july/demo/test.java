package com.july.demo;

import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

public class test {
    public static void main(String[] args) {
        String version = SpringVersion.getVersion();
        String version1 = SpringBootVersion.getVersion();
        System.out.println(version+"---"+version1);
    }
}
