package test03;

public class UserDemo {
    public static void main(String[] args) {
        //工厂
        UserPoolFactory2 userPoolFactory=new UserPoolFactory2();
        //配置类
        UserPoolConfig userPoolConfig=new UserPoolConfig();
        //资源池
        UserPool userPool=new UserPool(userPoolFactory,userPoolConfig);
            try {
                User user1 = userPool.borrowObject();
                user1.setName("aa");
                user1.setAge(18);
                user1.setHeight("16.5");
                System.out.println(user1);

                User user2 = userPool.borrowObject();
                user2.setName("bb");
                user2.setAge(22);
                user2.setHeight("18.5");
                System.out.println(user2);


                //将获取的资源对象，返还给资源池
                userPool.returnObject(user1);

                User user3 = userPool.borrowObject();
                user3.setName("cc");
                user3.setAge(32);
                user3.setHeight("19.5");
                System.out.println(user3);

            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
