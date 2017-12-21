package cn.mr.javabeanxml.example2;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 流程图xml配置文件的流程各个环节的节点类 此对象是用来转换传输和转换数据，不作为hibernate的持久化对象
 * 
 * @author xuejiangtao 2014-2-17 下午2:48:52
 */
public class DiagramTaskNode extends DiagramNode {

    /**
     * 对应的环节id
     */
    private long wfStepId;

    /**
     * 对应的工单环节id，多个以英文逗号分隔
     */
    private String orderStepIds;

    /**
     * 候选处理组/人
     */
    private String candidateUsers;

    /**
     * 受理人或者处理人
     */
    private String handlUser;

    /**
     * 完成情况。0表示流程环节，不需要处理。1表示工单环节，待处理。2表示工单环节，在处理。3表示工单环节，已处理。 该字段的常量在DiagramUtils.java中
     */
    private int finishSituation;

    /**
     * 节点在流程图中的显示规格，包括x、y坐标，节点框长度、宽度。
     */
    private String specification;

    /**
     * 流程流向
     */
    private DiagramTransitionNode transition;

    public long getWfStepId() {
        return wfStepId;
    }

    @XmlAttribute(name = "wfStepId")
    public void setWfStepId(long wfStepId) {
        this.wfStepId = wfStepId;
    }

    public String getOrderStepIds() {
        return orderStepIds;
    }

    @XmlAttribute(name = "orderStepIds")
    public void setOrderStepIds(String orderStepIds) {
        this.orderStepIds = orderStepIds;
    }

    public String getCandidateUsers() {
        return candidateUsers;
    }

    @XmlAttribute(name = "candidate-users")
    public void setCandidateUsers(String candidateUsers) {
        this.candidateUsers = candidateUsers;
    }

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

    public String getHandlUser() {
        return handlUser;
    }

    @XmlElement(name = "handlUser")
    public void setHandlUser(String handlUser) {
        this.handlUser = handlUser;
    }

    public int getFinishSituation() {
        return finishSituation;
    }

    @XmlElement(name = "finishSituation")
    public void setFinishSituation(int finishSituation) {
        this.finishSituation = finishSituation;
    }
}
