package cn.mr.javabeanxml.example2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import cn.mr.javabeanxml.SmsDeliverReq;

public class Test {

    /**
     * XML转换为javabean Jul 25, 2013 9:39:05 PM xuejiangtao添加此方法
     * 
     * @param <T>
     * @param xml
     * @param t
     * @return
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToBean(String xml, T t) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Unmarshaller um = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        t = (T) um.unmarshal(sr);
        return t;
    }

    /**
     * javabean转换为XML Jul 25, 2013 9:39:09 PM xuejiangtao添加此方法
     * 
     * @param smsDeliverReq
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public static <T> StringWriter beanToXml(T t) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Marshaller m = context.createMarshaller();
        StringWriter sw = new StringWriter();
        m.marshal(t, sw);
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化
        m.marshal(t, new FileOutputStream("src/cn/mr/javabeanxml/test.xml"));
        return sw;
    }

    /**
     * Jul 24, 2013 10:12:39 PM xuejiangtao添加此方法
     * 
     * @param args
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    /*
     * public static void main(String[] args) throws JAXBException, FileNotFoundException { DiagramProcessNode process =
     * new DiagramProcessNode(); process.setName("通用任务工单流程"); process.setDescription("通用任务工单流程");
     * 
     * DiagramStartNode start = new DiagramStartNode(); start.setName("开始"); start.setSpecification("100,50,110,50");
     * 
     * DiagramTransitionNode transition0 = new DiagramTransitionNode(); transition0.setName("");
     * transition0.setNextStepName("环节1"); transition0.setSpecification("122,22");
     * 
     * start.setTransition(transition0); process.setStart(start);
     * 
     * 
     * DiagramEndNode end = new DiagramEndNode(); end.setName("结束"); end.setSpecification("100,50,110,50");
     * process.setEnd(end);
     * 
     * 
     * List<DiagramTaskNode> tasks = new ArrayList<DiagramTaskNode>(); DiagramTaskNode task1 = new DiagramTaskNode();
     * task1.setName("环节1"); task1.setWfStepId(111); task1.setOrderStepIds(""); task1.setCandidateUsers("张三,李四,王五"); //
     * task1.setSpecification("121,2123,110,50"); DiagramTransitionNode transition1 = new DiagramTransitionNode();
     * transition1.setName(""); transition1.setNextStepName("环节2"); transition1.setSpecification("122,22");
     * task1.setTransition(transition1);
     * 
     * DiagramTaskNode task2 = new DiagramTaskNode(); task2.setName("环节2"); task2.setWfStepId(222);
     * task2.setOrderStepIds(""); task2.setCandidateUsers("张三,李四,王五"); task2.setSpecification("121,2123,110,50");
     * DiagramTransitionNode transition2 = new DiagramTransitionNode(); transition2.setName("");
     * transition2.setNextStepName("环节3"); transition2.setSpecification("122,22"); task2.setTransition(transition2);
     * 
     * DiagramTaskNode task3 = new DiagramTaskNode(); task3.setName("环节3"); task3.setWfStepId(333);
     * task3.setOrderStepIds(""); task3.setCandidateUsers("张三,李四,王五"); task3.setSpecification("121,2123,110,50");
     * DiagramTransitionNode transition3 = new DiagramTransitionNode(); transition3.setName("");
     * transition3.setNextStepName("结束"); transition3.setSpecification("122,22"); task3.setTransition(transition3);
     * 
     * tasks.add(task1); tasks.add(task2); tasks.add(task3);
     * 
     * process.setTasks(tasks);
     * 
     * StringWriter sw = beanToXml(process); System.out.println(sw.toString());
     * 
     * String aaa =
     * "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><process description=\"通用任务工单流程\" name=\"通用任务工单流程\"><end g=\"100,50,110,50\" name=\"结束\"/><start g=\"100,50,110,50\" name=\"开始\"><transition g=\"122,22\" to=\"环节1\" name=\"\"/></start><task wfStepId=\"111\" orderStepIds=\"\" candidate-users=\"张三,李四,王五\" name=\"环节1\"><transition g=\"122,22\" to=\"环节2\" name=\"\"/></task><task wfStepId=\"222\" g=\"121,2123,110,50\" orderStepIds=\"\" candidate-users=\"张三,李四,王五\" name=\"环节2\"><transition g=\"122,22\" to=\"环节3\" name=\"\"/></task><task wfStepId=\"333\" g=\"121,2123,110,50\" orderStepIds=\"\" candidate-users=\"张三,李四,王五\" name=\"环节3\"><transition g=\"122,22\" to=\"结束\" name=\"\"/></task></process>"
     * ;
     * 
     * String aaa = "<?xml version="1.0" standalone="yes"?>"+
     * "<process xmlns="http://jbpm.org/4.4/jpdl" name="盐城资产盘点工单流程">"+ "<end g="953,200,110,50" name="结束"/>"+
     * "<start g="547,287,110,50" name="开始">"+ "<transition to="盐城资产盘点工单流程发起环节" g="359,1205" name=""/>"+ "</start>"+
     * "<task orderStepIds="" g="121,2123,110,50" wfStepId="7706" name="盐城资产盘点工单流程发起环节">"+
     * "<transition to="盐城资产盘点工单流程审核环节" g="122,22" name=""/>"+ "</task>"+
     * "<task orderStepIds="" g="121,2123,110,50" wfStepId="7707" name="盐城资产盘点工单流程审核环节">"+
     * "<transition to="盐城资产盘点工单流程调度环节" g="122,22" name=""/>"+ "</task>"+
     * "<task orderStepIds="" g="121,2123,110,50" wfStepId="7708" name="盐城资产盘点工单流程调度环节">"+
     * "<transition to="盐城资产盘点工单流程执行环节" g="122,22" name=""/>"+ "</task>"+
     * "<task orderStepIds="" g="121,2123,110,50" wfStepId="7709" name="盐城资产盘点工单流程执行环节">"+
     * "<transition to="盐城资产盘点工单流程归档环节" g="122,22" name=""/>"+ "</task>"+
     * "<task orderStepIds="" g="121,2123,110,50" wfStepId="7710" name="盐城资产盘点工单流程归档环节">"+
     * "<transition to="结束" g="122,22" name=""/>"+ "</task>"+ "</process>"; DiagramProcessNode xmlToBean =
     * xmlToBean(aaa, new DiagramProcessNode()); System.out.println(xmlToBean.toString()); }
     */

    public static void main(String[] args) {
        List<DiagramTaskNode> tasks1 = new ArrayList<DiagramTaskNode>();
        DiagramTaskNode task1 = new DiagramTaskNode();
        task1.setFinishSituation(1);

        DiagramTaskNode task2 = new DiagramTaskNode();
        task2.setFinishSituation(2);

        tasks1.add(task1);
        tasks1.add(task2);

        DiagramProcessNode process = new DiagramProcessNode();
        process.setTasks(tasks1);

        List<DiagramTaskNode> tasks = process.getTasks();
        for (DiagramTaskNode diagramTaskNode : tasks) {
            diagramTaskNode.setFinishSituation(2);
        }
        System.out.println(process.toString());
    }
}
