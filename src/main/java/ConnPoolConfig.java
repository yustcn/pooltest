import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ConnPoolConfig extends GenericObjectPoolConfig {

    public ConnPoolConfig() {
        // defaults to make your life with connection pool easier :)
        setMinIdle(5);
        setTestOnBorrow(true);
    }

}