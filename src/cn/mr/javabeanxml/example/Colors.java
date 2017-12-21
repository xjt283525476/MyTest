package cn.mr.javabeanxml.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Colors")
@XmlAccessorType(XmlAccessType.FIELD)
public class Colors {

    @XmlElement(name = "red", nillable = true)
    private Red red;

    @XmlElement(name = "blue", nillable = true)
    private Blue blue;

    public Red getRed() {
        return red;
    }

    public Blue getBlue() {
        return blue;
    }

    public void setRed(Red red) {
        this.red = red;
    }

    public void setBlue(Blue blue) {
        this.blue = blue;
    }
}
