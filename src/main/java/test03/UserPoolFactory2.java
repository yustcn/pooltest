package test03;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class UserPoolFactory2 extends BasePooledObjectFactory<User> {
   @Override
    public User create() throws Exception {
        return new User("", -1, "-1");
    }
    @Override
    public PooledObject<User> wrap(User user) {
        return new DefaultPooledObject<User>(user);
    }
}
