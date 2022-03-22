package com.atguigu.springcloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;


@Slf4j
public class DateController {

    public static void main(String[] args) {
        //获取当前时间
        Date date = DateUtil.date();
        log.info("当前时间字符串，格式：yyyy-MM-dd HH:mm:ss::"+date.toString());
        Date date1 = DateUtil.date(Calendar.getInstance());
        log.info("当前时间字符串，格式：yyyy-MM-dd HH:mm:ss::"+date1.toString());
        String date2 = DateUtil.now();
        log.info("当前时间字符串，格式：yyyy-MM-dd HH:mm:ss::"+date2);
        String today= DateUtil.today();
        log.info("当前日期，格式：yyyy-MM-dd:::"+today);

        //日期转化  字符串转日期
        String date3 = "2022-03-28";
        Date date5 = DateUtil.parseDate(date3);
        log.info("格式：yyyy-MM-dd HH:mm:ss::"+date5.toString());


        //日期转化格式化日期输出 formatTime 格式化到时分秒
        String format1 = DateUtil.format(DateUtil.parseDate("2022-03-27"),"yyyy/MM/dd");
        log.info("格式化日期:::"+format1);

        //获取date某个部分
        Date date6 =  DateUtil.date();
        log.info("获取日期的年份:::"+DateUtil.year(date6));
        log.info("获取日期的月份:::"+DateUtil.month(date6));
        log.info("获取日期的月份枚举(英文):::"+DateUtil.monthEnum(date6));

        String zodiac = DateUtil.getZodiac(Month.JANUARY.getValue(), 19);
        log.info(zodiac);
    }
}
