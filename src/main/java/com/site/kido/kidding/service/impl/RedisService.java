package com.site.kido.kidding.service.impl;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/30.
 */
//@Service("redisService")
public class RedisService {
/*
    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisUtil redisUtil;

    private RedisTemplate redisTemplate;

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    public void testMul() {

        ValueOperations vo = redisTemplate.opsForValue();
        vo.set("A", "a");//初始化数据
        vo.set("B", "b");
        vo.set("C", "c");
        redisTemplate.setEnableTransactionSupport(true);

        redisTemplate.multi();     //开始事务
        vo.set("A", "a2");         //将A的值变成a2
        String b_value = String.valueOf(vo.get("B"));    //获取B的值

        logger.error("事务读到b_value：" + b_value);

        if ("b".equals(b_value)) {
            vo.set("C", "c2");
        }

        logger.error("事务结果：" + JSON.toJSONString(redisTemplate.exec()));

    }

    public void testMul1() {

        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        vo.set("A", "a");//初始化数据
        vo.set("B", "b");
        vo.set("C", "c");
        redisTemplate.setEnableTransactionSupport(true);

        try {
            redisTemplate.watch("B");
            String b_value = String.valueOf(vo.get("B"));    //获取B的值
            logger.error("事务读到b_value：" + b_value);
            if ("b".equals(b_value)) {
                redisTemplate.multi();     //开始事务
                vo.set("A", "a2");         //将A的值变成a2
                vo.set("C", "c2");         //将C的值变成c2
                logger.error("事务结果：" + JSON.toJSONString(redisTemplate.exec()));
            } else {
                redisTemplate.unwatch();
                logger.error("解除watch...");
            }
        } catch (Exception e) {
            redisTemplate.discard();//取消事务，放弃执行事务块内的所有命令
            logger.error("取消事务，放弃执行事务块内的所有命令");
        }

    }
    */
}
