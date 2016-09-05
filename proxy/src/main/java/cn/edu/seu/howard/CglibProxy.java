package cn.edu.seu.howard;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/9/5.
 */
public class CglibProxy implements MethodInterceptor{
    private Object target;

    public Object getInstance(Object target){
        this.target = target;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println();
        System.out.println("-----------cglib proxy before----------");
        Object result = method.invoke(target, objects);
        System.out.println("-----------cglib proxy after-----------");
        return result;
    }
}
