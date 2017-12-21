package cn.mr.paradigm;

public class PlateTest {

    public static void main(String[] args) {
        
        
        /*Plate<? extends Fruit> p1 = new Plate<Apple>(new Apple());
        // 不能存入任何元素
        p1.setItem(new Fruit()); // Error
        p1.setItem(new Apple()); // Error

        // 读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit11 = p1.getItem();
        Object newFruit21 = p1.getItem();
        Apple newFruit31 = p1.getItem(); // Error
*/        
        
        
        
        /*Plate<? super Fruit> p = new Plate<Fruit>(new Fruit());
        // 存入元素正常
        p.setItem(new Fruit());
        p.setItem(new Apple());

        // 读取出来的东西只能存放在Object类里。
        Apple newFruit3 = p.getItem(); // Error
        Fruit newFruit1 = p.getItem(); // Error
        Object newFruit2 = p.getItem();*/
        
    }
}
