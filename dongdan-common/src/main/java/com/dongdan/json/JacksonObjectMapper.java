package com.dongdan.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;


public class JacksonObjectMapper extends ObjectMapper {
    // 精细化日期格式：yyyy-MM-dd HH:mm:ss.SSS 带毫秒
    public static final String DATE_TIME_FULL_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss.SSS";

    public JacksonObjectMapper() {
        // 1. 全局时区 东八区
        setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        // ===================== 一、处理老日期类 java.util.Date =====================
        // Date 序列化输出 带毫秒完整时间
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FULL_PATTERN);
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        setDateFormat(dateFormat);

        // ===================== 二、Java8 时间类 完整精细化序列化/反序列化 =====================
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FULL_PATTERN);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_PATTERN);

        // LocalDateTime 序列化（输出统一用完整格式）
        // 输出的时候把 LocalDateTime类型的对象 转成字符串，格式为 yyyy-MM-dd HH:mm:ss.SSS
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));

        // LocalDateTime 反序列化（兼容多种输入格式）  json 转化为 LocalDateTime 类型
        // 支持格式：yyyy-MM-dd HH:mm:ss.SSS / yyyy-MM-dd HH:mm:ss / yyyy-MM-dd HH:mm / yyyy-MM-dd'T'HH:mm:ss.SSS / yyyy-MM-dd'T'HH:mm:ss / yyyy-MM-dd'T'HH:mm / yyyy-MM-dd'T'HH:mm:ss.SSS
        // 其他格式会报出异常
        javaTimeModule.addDeserializer(LocalDateTime.class, new FlexibleLocalDateTimeDeserializer());

        // LocalDate 只保留年月日
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));

        // LocalTime 时分秒毫秒
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(timeFormatter));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(timeFormatter));

        // 兼容：前端传时间戳数字也能解析成 LocalDateTime / Date
        // 关闭默认输出时间戳数组
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        registerModule(javaTimeModule);

        // ===================== 三、Long转字符串 防止JS精度丢失 =====================
        SimpleModule longModule = new SimpleModule();
        // ToStringSerializer.instance  Jackson 内置序列化器，作用：把数字 Long 统一转成 JSON 字符串输出
        longModule.addSerializer(Long.class, ToStringSerializer.instance);
        longModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        registerModule(longModule);

        // ===================== 四、通用容错配置 =====================
        // 前端多传未知字段不报错
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 空对象不抛异常
        disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 格式化输出（开发打开，生产注释）
        // enable(SerializationFeature.INDENT_OUTPUT);

        // ===================== 五、空值控制（按需开启） =====================
        // setSerializationInclusion(JsonInclude.Include.NON_NULL); // 不输出null字段
        // setSerializationInclusion(JsonInclude.Include.NON_EMPTY); // 不输出空字符串/空集合
    }
}