package cn.edu.seu.howard;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的InvocationHandler应当是通用的proxyHandler，不应只对应某个具体的proxy
 */
public class ProxyHandler implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println();
        System.out.println("--------jdk proxy before---------");
        Object result = method.invoke(target, args);
        System.out.println("--------jdk proxy after----------");
        return result;
    }
}
