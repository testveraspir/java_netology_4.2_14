package ru.netology.manager;

import ru.netology.domain.InformationTicket;
import ru.netology.repository.InformationTicketRepository;

import java.util.Arrays;

public class InformationTicketManager {
    private InformationTicketRepository repository;

    public InformationTicketManager(InformationTicketRepository repository) {
        this.repository = repository;
    }

    public InformationTicket[] findAll(String from, String to) {
        InformationTicket[] tickets = repository.searchAll();
        int count = 0;
        for (InformationTicket ticket : tickets) {
            if (from.equalsIgnoreCase(ticket.getDepartureAirport()) && to.equalsIgnoreCase(ticket.getArrivalAirport()))
                count++;
        }
        InformationTicket[] result = new InformationTicket[count];
        int index = 0;
        for (InformationTicket ticket : tickets) {
            if (from.equalsIgnoreCase(ticket.getDepartureAirport()) && to.equalsIgnoreCase(ticket.getArrivalAirport())) {
                result[index] = ticket;
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
