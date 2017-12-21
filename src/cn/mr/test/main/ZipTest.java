package cn.mr.test.main;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
//  
//import java.util.zip.ZipEntry;  
//import java.util.zip.ZipOutputStream;  

public class ZipTest {
    public static void main(String[] args) throws Exception {
        ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("c:/Test.zip"), 1024));
        zos.putNextEntry(new ZipEntry("中文.txt"));
        zos.write("中文".getBytes("utf-8"));
        zos.putNextEntry(new ZipEntry("にほんご .txt"));
        zos.write("にほんご".getBytes("utf-8"));
        zos.putNextEntry(new ZipEntry("EngLish.txt"));
        zos.write("EngLish".getBytes("utf-8"));
        zos.putNextEntry(new ZipEntry("Nichts zu danken.txt"));
        zos.write("Nichts zu danken!".getBytes("utf-8"));
        zos.putNextEntry(new ZipEntry("                 .txt"));
        zos.write("                 ".getBytes("utf-8"));

        zos.setEncoding("GB2312");
        // zos.setComment("12323");
        zos.closeEntry();
        zos.close();
    }
}
