package cn.mr.proxy;

public class CGLibClient {
    public static void main(String[] args) {
        TargetObject target = new TargetObject();
//        CGLibProxyFactory proxyFactory = new CGLibProxyFactory(target);
        TargetObject proxy = (TargetObject) CGLibProxyFactory.proxyTarget(target);
        proxy.doAotherThing();
    }
}
