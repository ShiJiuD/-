package com.dongdan.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * LocalDateTime 多格式反序列化器  接收前端传入的日期格式
 * 兼容前端可能传入的各种日期格式（ISO / 空格分隔 / 带不带秒 / 带不带毫秒）
 */
public class FlexibleLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final List<DateTimeFormatter> FORMATTERS = List.of(
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"),
        DateTimeFormatter.ISO_LOCAL_DATE_TIME
    );

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String text = p.getText().trim();
        if (text.isEmpty()) {
            return null;
        }

        for (DateTimeFormatter fmt : FORMATTERS) {
            try {
                return LocalDateTime.parse(text, fmt);
            } catch (DateTimeParseException ignored) {
                // 尝试下一个格式
            }
        }

        throw ctxt.weirdStringException(text, LocalDateTime.class,
            "不能解析为 LocalDateTime，支持格式：yyyy-MM-dd HH:mm:ss[.SSS] / yyyy-MM-dd'T'HH:mm[:ss][.SSS]");
    }
}
