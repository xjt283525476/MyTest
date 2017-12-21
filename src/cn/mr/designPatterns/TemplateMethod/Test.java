package cn.mr.designPatterns.TemplateMethod;

/**
 *  A test client
 */
public class Test  {
    public static void main(String[] args) {
        // You should change the path of "test.txt" in your local machine
        String fileName = "E:\\workspace\\eclipse2013\\MyTest\\src\\cn\\mr\\designPatterns\\TemplateMethod\\test.txt";
        String url = "http://www.the9.com/main.htm";
        
        AbstractRead fileRead = new ReadFile();
        AbstractRead htmlRead = new ReadHtml();

        fileRead.setResource(fileName);
        htmlRead.setResource(url);
        
        System.out.println("-----  Read from a file  -----");        
        fileRead.getContent();
        System.out.println("-----  Read from a url  -----");
        htmlRead.getContent();
    }
}