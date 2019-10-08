package eight;

public class TicketSell implements Runnable {

    private int ticket = 300;

    @Override
    public void run() {

        while (ticket > 0) {
            sell();
        }
    }

    private synchronized void sell() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票:" + (this.ticket--));
        }
    }
}
