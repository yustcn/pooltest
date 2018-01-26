import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Conn {

   // private  final Logger log = LoggerFactory.getLogger(Conn.class);

    /**
     * 记录对象的创建时间
     */
    private long createTime;


    /**
     * 初始化Conn对象，模拟创建Conn对象平均消耗500ms
     * @throws InterruptedException
     */
    public Conn() throws InterruptedException {
        Thread.sleep(500);
        createTime = System.currentTimeMillis();
        //log.debug(" init conn suc... " + createTime);
        System.out.println(" init conn suc... " + createTime);
    }

    /**
     * 报告Conn对象信息
     */
    public void report() {
    //    log.info("this is a available conn " + createTime);
        System.out.println("this is a available conn " + createTime);
    }
}
