package cn.mr.javabeanxml.example2;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * 流程图xml配置文件的流程节点基类 此对象是用来转换传输和转换数据，不作为hibernate的持久化对象
 * 
 * @author xuejiangtao 2014-2-17 下午2:48:39
 */
public abstract class DiagramNode {

    private String name;

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }
}
