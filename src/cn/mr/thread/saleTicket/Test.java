package cn.mr.thread.saleTicket;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(new Window1Thread(ticket)).start();
        new Thread(new Window2Thread(ticket)).start();
        new Thread(new Window3Thread(ticket)).start();
        new Thread(new Window4Thread(ticket)).start();
    }

}
