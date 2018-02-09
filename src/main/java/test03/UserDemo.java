package test03;
/*
*实现 删除那些idle了五分钟以上的对象，而不是把所有idle的对象删除 ，需要配置以下参数：

userPool.setMinIdle(3);//连接池中最少空闲的连接数,默认为0.
userPool.setSoftMinEvictableIdleTimeMillis(3000L);//连接空闲的最小时间，达到此值后空闲链接将会被移除，且保留“minIdle”个空闲连接数。默认为-1.
userPool.setTimeBetweenEvictionRunsMillis(1000L);//“空闲链接”检测线程，检测的周期，毫秒数。如果为负值，表示不运行“检测线程”。默认为-1.
userPool.setNumTestsPerEvictionRun(3);//对于“空闲链接”检测线程而言，每次检测的链接资源的个数。默认为3.

特别注意：
userPool.setTimeBetweenEvictionRunsMillis(1000L);//“空闲链接”检测线程，检测的周期，毫秒数。如果为负值，表示不运行“检测线程”。默认为-1.
这个参数一定要配上。不配置，其他参数都不起作用。
 */

/**
 * 附件：参数表

 maxActive: 链接池中最大连接数,默认为8.
 maxIdle: 链接池中最大空闲的连接数,默认为8.
 minIdle: 连接池中最少空闲的连接数,默认为0.
 maxWait: 当连接池资源耗尽时，调用者最大阻塞的时间，超时将跑出异常。单位，毫秒数;默认为-1.表示永不超时.
 minEvictableIdleTimeMillis: 连接空闲的最小时间，达到此值后空闲连接将可能会被移除。负值(-1)表示不移除。
 softMinEvictableIdleTimeMillis: 连接空闲的最小时间，达到此值后空闲链接将会被移除，且保留“minIdle”个空闲连接数。默认为-1.
 numTestsPerEvictionRun: 对于“空闲链接”检测线程而言，每次检测的链接资源的个数。默认为3.
 testOnBorrow: 向调用者输出“链接”资源时，是否检测是有有效，如果无效则从连接池中移除，并尝试获取继续获取。默认为false。建议保持默认值.
 testOnReturn: 向连接池“归还”链接时，是否检测“链接”对象的有效性。默认为false。建议保持默认值.
 testWhileIdle: 向调用者输出“链接”对象时，是否检测它的空闲超时；默认为false。如果“链接”空闲超时，将会被移除。建议保持默认值.
 timeBetweenEvictionRunsMillis: “空闲链接”检测线程，检测的周期，毫秒数。如果为负值，表示不运行“检测线程”。默认为-1.
 whenExhaustedAction: 当“连接池”中active数量达到阀值时，即“链接”资源耗尽时，连接池需要采取的手段, 默认为1：
 -> 0 : 抛出异常，
 -> 1 : 阻塞，直到有可用链接资源
 -> 2 : 强制创建新的链接资源
 参考链接：http://blog.csdn.net/xun_2015/article/details/52400182
 */
public class UserDemo {
    public static void main(String[] args) {
        //工厂
        UserPoolFactory2 userPoolFactory=new UserPoolFactory2();
        //配置类
        UserPoolConfig userPoolConfig=new UserPoolConfig();

        //资源池
        UserPool userPool=new UserPool(userPoolFactory,userPoolConfig);

        userPool.setMinIdle(3);


        //userPool.setMinEvictableIdleTimeMillis(3000L);
        userPool.setSoftMinEvictableIdleTimeMillis(3000L);
        userPool.setTimeBetweenEvictionRunsMillis(1000L);
        userPool.setNumTestsPerEvictionRun(3);


        System.out.println("userPool.getMinIdle()="+userPool.getMinIdle());
        System.out.println("userPool.getNumIdle()"+userPool.getNumIdle());
        System.out.println("userPool.getMaxIdle()="+userPool.getMaxIdle());
        System.out.println("userPool.getSoftMinEvictableIdleTimeMillis()="+userPool.getSoftMinEvictableIdleTimeMillis());

            try {
                User user1 = userPool.borrowObject();
                user1.setName("user1");
                user1.setAge(18);
                user1.setHeight("16.5");

                User user2 = userPool.borrowObject();
                user2.setName("user2");
                user2.setAge(22);
                user2.setHeight("18.5");

                User user3 = userPool.borrowObject();
                user3.setName("user3");
                user3.setAge(18);
                user3.setHeight("16.5");

                User user4 = userPool.borrowObject();
                user4.setName("user4");
                user4.setAge(18);
                user4.setHeight("16.5");

                User user5 = userPool.borrowObject();
                user5.setName("user4");
                user5.setAge(18);
                user5.setHeight("16.5");

                User user6 = userPool.borrowObject();
                user6.setName("user4");
                user6.setAge(18);
                user6.setHeight("16.5");





                //将获取的资源对象，返还给资源池
                userPool.returnObject(user1);
                userPool.returnObject(user2);
                userPool.returnObject(user3);
                userPool.returnObject(user4);
                userPool.returnObject(user5);
                userPool.returnObject(user6);

                System.out.println("userPool.getNumIdle()"+userPool.getNumIdle());




                Thread.sleep(9000L);

                System.out.println("======= 9000L after==============");

                System.out.println("userPool.getNumIdle()"+userPool.getNumIdle());



            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
