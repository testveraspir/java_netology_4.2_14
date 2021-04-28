package ru.netology.repository;

import lombok.Generated;
import ru.netology.domain.InformationTicket;

@Generated
public class InformationTicketRepository {
    private InformationTicket[] informationTickets = new InformationTicket[0];

    public void save(InformationTicket item) {
        int length = informationTickets.length + 1;
        InformationTicket[] tmp = new InformationTicket[length];
        for (int i = 0; i < informationTickets.length; i++) {
            tmp[i] = informationTickets[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        informationTickets = tmp;
    }

    public InformationTicket[] searchAll() {
        return informationTickets;
    }

    public InformationTicket[] findById(int id) {
        InformationTicket result[] = new InformationTicket[1];
        int index = 0;
        for (InformationTicket item : informationTickets) {
            if (item.getId() == id) {
                result[index] = item;
                index++;
            }
        }
        return result;
    }

    public void removeById(int id) {
        int length = informationTickets.length - 1;
        InformationTicket[] tmp = new InformationTicket[length];
        int index = 0;
        for (InformationTicket item : informationTickets) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        informationTickets = tmp;
    }

    public InformationTicket[] removeAll() {
        InformationTicket[] result = new InformationTicket[0];
        informationTickets = result;
        return informationTickets;
    }
}
