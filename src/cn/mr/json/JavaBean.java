package cn.mr.json;

import java.io.Serializable;

/**
 * 普通JavaBean类
 * @author xuejiangtao
 * 2012-8-23 上午11:21:59
 */
public class JavaBean implements Serializable{
    private static final long serialVersionUID = 8720431164344424704L;
    
    private String id;
    private String name;
    private int age;
    private String addr;
    
    public JavaBean() {
        super();
    }
    
    public JavaBean(String id, String name, int age, String addr) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.addr = addr;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", addr=" + addr + "]";
    }
    
}
