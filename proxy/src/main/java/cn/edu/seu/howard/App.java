package cn.edu.seu.howard;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        UserServiceStaticProxy staticProxy = new UserServiceStaticProxy(userServiceImpl);
        staticProxy.add();
    }
}
