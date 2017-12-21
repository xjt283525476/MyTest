package cn.mr.designPatterns.Prototype;

import cn.mr.designPatterns.Prototype.mypackage.Graphic;

/*
 *  A concrete prototype to draw a line
 */
public class LineSymbol extends Graphic {
    public LineSymbol() {
    }

    public void DoSomething() {
        System.out.println("I am used to draw a line !");
    }
}