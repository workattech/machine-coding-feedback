package services;

import model.Slot;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> tickets;

    public TicketService() {
        this.tickets = new ArrayList<>();
    }

    public Ticket createTicket(String parkingLotId, Slot slot) {
        String ticketId = parkingLotId + "_" + slot.getFloorNo() + "_" + slot.getSlotNo();
        Ticket ticket = new Ticket(ticketId);
        tickets.add(ticket);
        return  ticket;
    }

    public int getFloorNoFromTicket(String ticketId) {
        String[] id = ticketId.split("_");
        return Integer.parseInt(id[1]);
    }

    public int getSlotNoFromTicket(String ticketId) {
        String[] id = ticketId.split("_");
        return Integer.parseInt(id[2]);
    }


}
