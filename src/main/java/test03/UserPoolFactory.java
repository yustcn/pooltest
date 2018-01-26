package test03;

//PooledObject：池化的对象，是对对象的一个包装，加上了对象的一些其他信息，包括对象的状态（已用、空闲），对象的创建时间等。
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

//PooledObjectFactory：工厂类，负责池化对象的创建，对象的初始化，对象状态的销毁和对象状态的验证。
public class UserPoolFactory implements PooledObjectFactory<User> {


    public PooledObject<User> makeObject() throws Exception {
        System.out.println("make Object");
        User user = new User(Thread.currentThread().getName(), 26, "178cm");
        return new DefaultPooledObject<User>(user);
    }


    public void destroyObject(PooledObject<User> pooledObject) throws Exception {
        System.out.println("destroy Object");
        User user = pooledObject.getObject();
        user = null;
    }
    /**
     * 功能描述：判断资源对象是否有效，有效返回 true，无效返回 false
     *
     * 什么时候会调用此方法
     * 1：从资源池中获取资源的时候，参数 testOnBorrow 或者 testOnCreate 中有一个 配置 为 true 时，则调用  factory.validateObject() 方法
     * 2：将资源返还给资源池的时候，参数 testOnReturn，配置为 true 时，调用此方法
     * 3：资源回收线程，回收资源的时候，参数 testWhileIdle，配置为 true 时，调用此方法
     */
    public boolean validateObject(PooledObject<User> pooledObject) {
        System.out.println("validate Object");
        return true;
    }



    public void activateObject(PooledObject<User> pooledObject) throws Exception {
        System.out.println("activate Object");
    }
    /**
     * 功能描述：钝化资源对象
     *
     * 什么时候会调用此方法
     * 1：将资源返还给资源池时，调用此方法。
     */
    public void passivateObject(PooledObject<User> pooledObject) throws Exception {
        System.out.println("passivate Object");

    }
}
