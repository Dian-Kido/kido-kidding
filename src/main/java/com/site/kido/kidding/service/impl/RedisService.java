package com.site.kido.kidding.service.impl;

import com.alibaba.fastjson.JSON;
import com.site.kido.kidding.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/30.
 */
//@Service("redisService")
public class RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    public void testMul() {

        ValueOperations vo = redisTemplate.opsForValue();
        vo.set("b", 2);
        logger.error("原始b的值：" + vo.get("b"));
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        vo.set("b", 3);
        logger.error("事务中b的值：" + vo.get("b"));
        vo.set("b", 4);
        logger.error("事务中b的值：" + vo.get("b"));
        logger.error("事务结果：" + JSON.toJSONString(redisTemplate.exec()));
        logger.error("事务后b的值：" + vo.get("b"));

    }
}
