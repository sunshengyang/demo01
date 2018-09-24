package cn.itcast.recommend.engine.cache;


import cn.itcast.recommend.engine.utils.MyShardedJedisPool;

public class RedisHandler {
    public static String getValueByHashField(String key, String field) {
        return MyShardedJedisPool.getResource().hget(key, field);
    }

    public static String getString(String key) {
        return MyShardedJedisPool.getResource().get(key);
    }
}
