package eight;

import java.util.HashMap;
import java.util.Map;

public class TicketSaler {

    private Map<Integer, Ticket> ticketMap = new HashMap<>();

    private Map<Integer, Object> lock = new HashMap<>();

    private void produce() {
        for (int i = 0; i < 300; i++) {
            Ticket ticket = new Ticket(i);
            ticketMap.put(i, ticket);
        }
    }

    private Ticket buy(int id) {
        return null;
    }

    private void onSale() {

    }


}
