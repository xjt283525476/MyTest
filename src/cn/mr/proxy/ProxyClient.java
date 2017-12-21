package cn.mr.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyClient {

    public static void main(String[] args) {
        ITargetObject target = new TargetObject();
        InvocationHandler proxyHandler = new ProxyHandler(target);
        // 创建代理对象，注意这里被代理的对象类必须实现至少一个接口
        ITargetObject proxy = (ITargetObject) Proxy.newProxyInstance(target.getClass().getClassLoader(), target
                .getClass().getInterfaces(), proxyHandler);
        // 通过代理执行方法
        proxy.doSth("guoqiang");
    }
}
