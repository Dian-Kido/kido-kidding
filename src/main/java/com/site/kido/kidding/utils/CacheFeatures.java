package com.site.kido.kidding.utils;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/12/27.
 */
public class CacheFeatures {

    /*
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws Exception {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);
        CacheConfiguration config = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Integer.class, String.class, ResourcePoolsBuilder.heap(6))
                .withEvictionAdvisor(new TopThreeAreImportantEvictionAdvisor())
                .withExpiry(Expirations.timeToIdleExpiration(Duration.of(3, TimeUnit.SECONDS))).build();
        Cache myCache = cacheManager.createCache("myCache", config);
        try { // key type 错误
            myCache.put("Invalid key type", "sad");
        } catch (Exception e) {
            System.out.println("Invalid key type");
        }
        try { // value type 错误
            myCache.put(1L, 9527L);
        } catch (Exception e) {
            System.out.println("Invalid value type");
        }
        for (int i = 1; i <= 200; i++) { // 超出数量上限，回收策略开始生效：key为1、2、3的条目不被回收
            myCache.put(i, "No. " + i);
        }
        printAllCacheEntries(myCache);

        System.out.println("-------------------------------");
        for (int i = 0; i < 3; i++) { // 等待3秒，3秒内一直没被使用的条目全部过期移除。只有key为1的条目还在。
            myCache.get(1);
            Thread.sleep(1050);
        }
        printAllCacheEntries(myCache);
    }

    private static void printAllCacheEntries(Cache<Integer, String> cache) {
        cache.forEach(new Consumer<Cache.Entry<Integer, String>>() {

            @Override
            public void accept(Cache.Entry<Integer, String> entry) {
                System.out.println(entry.getKey());
            }
        });
    }

    private static class TopThreeAreImportantEvictionAdvisor implements EvictionAdvisor<Integer, String> {

        @Override
        public boolean adviseAgainstEviction(Integer key, String value) {
            return (key.intValue() < 4);
        }
    }

    */
}
