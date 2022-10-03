package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

//JDK动态代理
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------------begin " + method.getName() + "-----------------");
        Object result = method.invoke(target, args);
        System.out.println("-----------------end " + method.getName() + "-----------------");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }

    //    泛型带来的问题
    public static void method(List<String> list) {
        System.out.println("invoke method(List<String> list)");
    }

//    public static void method(List<Integer> list) {
//        System.out.println("invoke method(List<Integer> list)");
//    }


}
