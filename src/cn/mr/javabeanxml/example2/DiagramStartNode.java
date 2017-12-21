package cn.mr.javabeanxml.example2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 流程图xml配置文件的开始节点对象 此对象是用来转换传输和转换数据，不作为hibernate的持久化对象
 * 
 * @author xuejiangtao 2014-2-17 下午1:59:49
 */
public class DiagramStartNode extends DiagramNode {

    /**
     * 节点在流程图中的显示规格，包括x、y坐标，节点框长度、宽度。
     */
    private String specification;

    /**
     * 流程流向
     */
    private DiagramTransitionNode transition;

    public String getSpecification() {
        return specification;
    }

    @XmlAttribute(name = "g")
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public DiagramTransitionNode getTransition() {
        return transition;
    }

    @XmlElement(name = "transition")
    public void setTransition(DiagramTransitionNode transition) {
        this.transition = transition;
    }

}
