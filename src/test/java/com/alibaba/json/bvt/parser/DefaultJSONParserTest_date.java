package com.alibaba.json.bvt.parser;

import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;

public class DefaultJSONParserTest_date extends TestCase {
    public void test_date() {
        String text = "{\"date\":\"2011-01-09T13:49:53.254\"}";
        char[] chars = text.toCharArray();
        DefaultJSONParser parser = new DefaultJSONParser(chars, chars.length, ParserConfig.getGlobalInstance(), 0);
        parser.config(Feature.AllowISO8601DateFormat, true);
        JSONObject json = parser.parseObject();
        Assert.assertEquals(new Date(1294552193254L), json.get("date"));
    }
    
    
    public void test_date2() {
        String text = "{\"date\":\"xxxxx\"}";
        char[] chars = text.toCharArray();
        DefaultJSONParser parser = new DefaultJSONParser(chars, chars.length, ParserConfig.getGlobalInstance(), 0);
        parser.config(Feature.AllowISO8601DateFormat, true);
        JSONObject json = parser.parseObject();
        Assert.assertEquals("xxxxx", json.get("date"));
    }
    
    public void test_date3() {
        String text = "{\"1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst\\t\":\"xxxxx\"}";
        char[] chars = text.toCharArray();
        DefaultJSONParser parser = new DefaultJSONParser(chars, chars.length, ParserConfig.getGlobalInstance(), 0);
        parser.config(Feature.AllowISO8601DateFormat, true);
        JSONObject json = parser.parseObject();
        Assert.assertEquals("xxxxx", json.get("1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst\t"));
    }
    
    public void test_date4() {
        String text = "{\"1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst\\t\":\"xxxxx\"}";
        char[] chars = text.toCharArray();
        DefaultJSONParser parser = new DefaultJSONParser(chars, chars.length, ParserConfig.getGlobalInstance(), 0);
        parser.config(Feature.AllowISO8601DateFormat, true);
        JSONObject json = parser.parseObject();
        Assert.assertEquals("xxxxx", json.get("1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst1234567890abcdefghijklmnopqrst\t"));
    }
}
