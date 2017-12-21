package cn.mr.proxy;

public class TargetObject implements ITargetObject, ITargetObjectNew {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String doSth(String value) {
        String result = "[TargetObject]: doSth(" + value + ")";

        System.out.println(result);
        if (true) {
            throw new RuntimeException("heihei");
        }
        return result;
    }

    public void doAotherThing() {
        System.out.println("[TargetObject]: doAotherThing");
    }
}
