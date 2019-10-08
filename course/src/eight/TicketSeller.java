package eight;

public class TicketSeller {

    public static void main(String[] args) {
        TicketSell ticketSell = new TicketSell();

        Thread seller1 = new Thread(ticketSell);
        seller1.setName("窗口1");
        Thread seller2 = new Thread(ticketSell);
        seller2.setName("窗口2");
        Thread seller3 = new Thread(ticketSell);
        seller3.setName("窗口3");

        seller1.start();
        seller2.start();
        seller3.start();
    }
}
