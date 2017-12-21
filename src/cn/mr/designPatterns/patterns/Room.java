package cn.mr.designPatterns.patterns;

/*
 * AbstractFactory
 */
public abstract  class Room  {
    public abstract Wall makeWall();
    public abstract Door makeDoor();
}