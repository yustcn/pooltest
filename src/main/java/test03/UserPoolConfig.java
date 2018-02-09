package test03;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class UserPoolConfig extends GenericObjectPoolConfig {
    public UserPoolConfig() {

       // setTestOnBorrow(true);
        setMinIdle(5);
        setSoftMinEvictableIdleTimeMillis(4000L);

        //minIdle: 连接池中最少空闲的连接数,默认为0
        //softMinEvictableIdleTimeMillis：连接空闲的最小时间，达到此值后空闲链接将会被移除，且保留“minIdle”个空闲连接数。负值(-1)表示不移除。默认值1000L * 60L * 30L
    }
}
