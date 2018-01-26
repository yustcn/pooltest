import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ConnFactory extends BasePooledObjectFactory<Conn> {


    /**
     * 间接实现{@link PooledObjectFactory#makeObject()}方法，表明怎样创建需要管理对象
     */
    @Override
    public Conn create() throws Exception {
        return new Conn();
    }


    /**
     * 在common-pool2中为了统计管理的对象的一些信息，比如调用次数，空闲时间，上次使用时间等，需要对管理的对象进行包装，然后在放入到对象池中
     *
     * @param obj 对象池要管理的对象
     * @return 返回包装后的PooledObject对象
     */
    @Override
    public PooledObject<Conn> wrap(Conn obj) {
        return new DefaultPooledObject<Conn>(obj);
    }

}
