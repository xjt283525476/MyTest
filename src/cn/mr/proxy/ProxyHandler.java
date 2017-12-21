package cn.mr.proxy;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private Object target;

    public ProxyHandler(Object target) {
        super();
        this.target = target;
    }

    public Object invoke(Object object, Method method, Object[] param) throws Throwable {
        // 以下是添加的额外的方法，这里是before advice
        System.out.println("before calling " + method);
        Object result = null;
        try {
            result = method.invoke(target, param);// 这里是执行被代理类的方法，也可以添加判断逻辑来确定是否执行该方法
        } catch (Exception e) {
            // 以下是添加的额外的方法，这里是throw advice
            System.err.println(e.toString());
        }

        // 以下是添加的额外的方法，这里是after advice
        System.out.println("after calling " + method);
        return result;
    }
}
