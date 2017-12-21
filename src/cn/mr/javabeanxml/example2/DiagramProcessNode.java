package cn.mr.javabeanxml.example2;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 流程图xml配置文件的流程节点对象 此对象是用来转换传输和转换数据，不作为hibernate的持久化对象
 * 
 * @author xuejiangtao 2014-2-17 上午11:15:36
 */
@XmlRootElement(name = "process")
public class DiagramProcessNode extends DiagramNode {

    /**
     * 流程描述
     */
    private String description;

    /**
     * 类型。0表示执行流程。1表示工单
     */
    private int type;

    /**
     * 
     */
    private String xmlns = "";

    /**
     * 流程开始节点
     */
    private DiagramStartNode start;

    /**
     * 流程中的各个环节
     */
    private List<DiagramTaskNode> tasks;

    /**
     * 流程结束节点
     */
    private DiagramEndNode end;

    public String getDescription() {
        return description;
    }

    @XmlAttribute(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getXmlns() {
        return xmlns;
    }

    @XmlAttribute(name = "xmlns")
    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public DiagramStartNode getStart() {
        return start;
    }

    @XmlElement(name = "start")
    public void setStart(DiagramStartNode start) {
        this.start = start;
    }

    public List<DiagramTaskNode> getTasks() {
        return tasks;
    }

    @XmlElement(name = "task")
    public void setTasks(List<DiagramTaskNode> tasks) {
        this.tasks = tasks;
    }

    public DiagramEndNode getEnd() {
        return end;
    }

    @XmlElement(name = "end")
    public void setEnd(DiagramEndNode end) {
        this.end = end;
    }

    public int getType() {
        return type;
    }

    @XmlElement(name = "type")
    public void setType(int type) {
        this.type = type;
    }
}
