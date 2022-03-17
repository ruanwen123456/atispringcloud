package com.baidu.webflux;


import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class LambdaTest {

    public static void main(String[] args) {

        //Predicate 断言
        Predicate<Integer> predicate =i -> i<9;
        System.out.println(predicate.negate().test(9));

        //Consumer 接口
    }
}
