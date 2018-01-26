package test03;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//提供所有对象的存取管理
public class UserPool extends GenericObjectPool<User>{
    public UserPool(PooledObjectFactory<User> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }
}
