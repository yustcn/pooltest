package test03;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class UserPoolConfig extends GenericObjectPoolConfig {
    public UserPoolConfig() {
        setMinIdle(5);
        setTestOnBorrow(true);
    }
}
