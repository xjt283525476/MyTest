package cn.mr.designPatterns.Prototype;

import cn.mr.designPatterns.Prototype.mypackage.Graphic;

/*
 *  A concrete prototype to draw a note
 */
public class NoteSymbol extends Graphic {
    public NoteSymbol() {
    }

    public void DoSomething() {
        System.out.println("I am used to draw a note !");
    }
}