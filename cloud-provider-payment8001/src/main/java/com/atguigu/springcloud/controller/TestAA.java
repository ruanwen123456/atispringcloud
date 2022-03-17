package com.atguigu.springcloud.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestAA {

    public static void main(String[] args) {
        try {
            Integer.parseInt("q");
        }catch (Exception e){
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            e.printStackTrace(new PrintStream(stream));
            String exception = stream.toString();
            System.out.println("****:"+exception.replaceAll("\r|\n",""));
        }
    }
}
