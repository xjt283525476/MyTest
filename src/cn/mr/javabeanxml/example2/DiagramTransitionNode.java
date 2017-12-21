package cn.mr.javabeanxml.example2;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * 流程图xml配置文件的流程transaction类 此对象是用来转换传输和转换数据，不作为hibernate的持久化对象
 * 
 * @author xuejiangtao 2014-2-17 下午2:30:00
 */
public class DiagramTransitionNode extends DiagramNode {

    /**
     * 下一环节名称
     */
    private String nextStepName;

    /**
     * 节点在流程图中的显示规格，包括x、y坐标，节点框长度、宽度。
     */
    private String specification;

    public String getSpecification() {
        return specification;
    }

    @XmlAttribute(name = "g")
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getNextStepName() {
        return nextStepName;
    }

    @XmlAttribute(name = "to")
    public void setNextStepName(String nextStepName) {
        this.nextStepName = nextStepName;
    }
}
