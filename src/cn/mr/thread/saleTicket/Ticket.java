package cn.mr.thread.saleTicket;

public class Ticket {

    static int num = 100;

    public synchronized void sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "卖了第" + num + "张票");
            num--;
        }
    }

    public void sleep() {
        int time = (int) (Math.random() * 200);
        try {
            Thread.currentThread();
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
