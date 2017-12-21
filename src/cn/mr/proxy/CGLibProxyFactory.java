package cn.mr.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxyFactory implements MethodInterceptor {

    private Object srcTarget;

    CGLibProxyFactory(Object o) {
        this.srcTarget = o;
    }

    @SuppressWarnings("unchecked")
    public static <T> T proxyTarget(T t) {
        Enhancer en = new Enhancer();
        en.setSuperclass(t.getClass());
        en.setCallback(new CGLibProxyFactory(t));
        T tt = (T) en.create();
        return tt;

    }

    public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
        System.err.println("拦截前...");
        Object o = method.invoke(srcTarget, args);
        System.err.println("拦截后....");
        return o;
    }
}
