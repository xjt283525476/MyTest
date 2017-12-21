package cn.mr.designPatterns.Iterator;

/**
 *
 */
import java.io.*;
import java.util.*;

public class Test  {
    public static void main(String[] args) {
        String fileName = "E:\\workspace\\eclipse2013\\MyTest\\src\\cn\\mr\\designPatterns\\Iterator\\data.txt";
        DataVector dataVector = new DataVector(fileName);
        Iterator iVector = dataVector.CreateIterator();
        for(iVector.First(); ! iVector.IsDone(); iVector.Next()) {
            iVector.CurrentItem();
        }
    }
}