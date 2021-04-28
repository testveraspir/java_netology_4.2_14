package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Generated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformationTicket implements Comparable<InformationTicket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int timeTravel;

    @Override
    public int compareTo(InformationTicket o) {
        return price - o.price;
    }

}
