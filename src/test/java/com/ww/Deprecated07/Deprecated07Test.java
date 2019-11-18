package com.ww.Deprecated07;

import ch.qos.logback.core.util.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.ww.Deprecated07.entity.OrderCreateParam;
import com.ww.Deprecated07.entity.OrderItemParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sun
 * @create: 2019-11-18 13:52
 * @version: v1.0
 */
@Slf4j
public class Deprecated07Test {

    /**
     * JDK中URL Encoder和URL Decoder为例介绍如何写过期函数的注释和如何替换该过期函数
     */
    @Test
    public void jdkDeprecatedMethod() throws UnsupportedEncodingException {
        // 过期函数
        String url = "http://www.imooc.com/test?name=张三";
        String encode = URLEncoder.encode(url);
        log.info("URL编码结果：" + encode);

        String decode = URLDecoder.decode(encode);
        log.info("URL解码结果：" + decode);

        // 使用新的函数
        encode = URLEncoder.encode(url, Charsets.UTF_8.name());
        log.info("URL编码结果：" + encode);
        decode = URLDecoder.decode(encode, Charsets.UTF_8.name());
        log.info("URL解码结果：" + decode);
    }

    /**
     * 新旧两种接口对比
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testURLUtil() throws UnsupportedEncodingException {

        String url = "http://www.imooc.com/test?name=张三";
        // 旧的函数
        String encodeOrigin = URLEncoder.encode(url);
        String decodeOrigin = URLDecoder.decode(encodeOrigin);

        // 新的函数
        String encodeNew = URLEncoder.encode(url, Charsets.UTF_8.name());
        String decodeNew = URLDecoder.decode(encodeNew, Charsets.UTF_8.name());

        // 结果对比
        Assert.assertEquals(encodeOrigin, encodeNew);
        Assert.assertEquals(decodeOrigin, decodeNew);
    }

    /**
     * 作为接口或对象的提供者，废弃的类、属性、函数加上废弃的原因和替代方案。
     * 同时自己类的变动要通过单元测试进行验证。
     *
     * @throws JsonProcessingException
     */
    @Test
    public void testOriginAndNew() throws JsonProcessingException {

        // 原始JSON属性
        OrderCreateParam orderCreateParamOrigin = new OrderCreateParam();
        orderCreateParamOrigin.setOrderItemDetail("[{\"count\":22,\"name\":\"商品1\"},{\"count\":33,\"name\":\"商品2\"}]");

        // 新的对象属性
        OrderCreateParam orderCreateParamNew = new OrderCreateParam();
        List<OrderItemParam> orderItemParamList = new ArrayList<>(2);
        OrderItemParam orderItemParam = new OrderItemParam();
        orderItemParam.setName("商品1");
        orderItemParam.setCount(22);
        orderItemParamList.add(orderItemParam);

        OrderItemParam orderItemParam2 = new OrderItemParam();
        orderItemParam2.setName("商品2");
        orderItemParam2.setCount(33);
        orderItemParamList.add(orderItemParam2);
        orderCreateParamNew.setOrderItemParams(orderItemParamList);

        ObjectMapper objectMapper = new ObjectMapper();
        Assert.assertEquals(objectMapper.writeValueAsString(orderCreateParamNew.getOrderItemParams()), orderCreateParamOrigin.getOrderItemDetail());
    }
}
