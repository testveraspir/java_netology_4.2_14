package ru.netology.comparator;

import ru.netology.domain.InformationTicket;

import java.util.Comparator;

public class TicketByTimeComparator implements Comparator<InformationTicket> {
    @Override
    public int compare(InformationTicket o1, InformationTicket o2) {
        return o1.getTimeTravel() - o2.getTimeTravel();
    }

}
