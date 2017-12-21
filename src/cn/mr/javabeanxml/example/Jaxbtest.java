package cn.mr.javabeanxml.example;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Jaxbtest {
    public static void main(String[] args) throws Exception {

        StringWriter writer = new StringWriter();
        JAXBContext jc = JAXBContext.newInstance(Colors.class);
        Marshaller ma = jc.createMarshaller();
        ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Colors colors = new Colors();
        Red red = new Red();
        red.setAtt("att-red");
        red.setValue("red");
        Blue blue = new Blue();
        blue.setValue("blue");
        blue.setAtt("att-blue");
        blue.setAtt2("blue-att2");
        colors.setRed(red);
        colors.setBlue(blue);

        ma.marshal(colors, writer);
        System.out.println(writer.toString());

    }
}
