package cn.mr.thread.saleTicket;

public class Window2Thread implements Runnable {

    private Ticket ticket;

    public Window2Thread(Ticket ticket) {
        this.ticket = ticket;
    }

    public void run() {

        while (Ticket.num > 0) {
            ticket.sale();
            ticket.sleep();
        }

    }
}
