package cn.edu.seu.howard;

import java.lang.reflect.Proxy;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        //静态代理应用
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        UserServiceStaticProxy staticProxy = new UserServiceStaticProxy(userServiceImpl);
        staticProxy.add();

        //错误应用：JDK动态代理
        UserService userService = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(), new UserServiceInvcationHandler(userServiceImpl));
        userService.add();

        //JDK动态代理。缺陷在于只有实现了接口的类才能被动态代理
        ProxyHandler proxy = new ProxyHandler();
        UserService userService1 = (UserService) proxy.bind(new UserServiceImpl());
        userService1.add();
    }
}
