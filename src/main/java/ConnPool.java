import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;

public class ConnPool extends GenericObjectPool<Conn>{
    public ConnPool(ConnPoolConfig config) {
        super(new ConnFactory(),config);
    }
}
