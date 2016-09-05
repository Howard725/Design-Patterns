package cn.edu.seu.howard;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ***************** 错误的写法******************
 * 如果仅针对某个接口编写InvocationHandler则跟静态代理无异
 * 正确的写法见{@link cn.edu.seu.howard.ProxyHandler}
 */
public class UserServiceInvcationHandler implements InvocationHandler {

    private Object target;

    public UserServiceInvcationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println();
        System.out.println("--------WRONG jdk proxy before---------");
        Object result = method.invoke(target, args);
        System.out.println("--------WRONG jdk proxy after----------");
        return result;
    }
}
