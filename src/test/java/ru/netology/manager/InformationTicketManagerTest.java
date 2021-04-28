package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.comparator.TicketByTimeComparator;
import ru.netology.domain.InformationTicket;
import ru.netology.repository.InformationTicketRepository;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class InformationTicketManagerTest {
    @Mock
    private InformationTicketRepository repository;
    @InjectMocks
    InformationTicket ticket1 = new InformationTicket(1, 1000, "ABC", "ABD", 100);
    InformationTicket ticket2 = new InformationTicket(2, 200, "ABC", "ABD", 50);
    InformationTicket ticket3 = new InformationTicket(3, 500, "ABC", "ABD", 10);
    InformationTicket ticket4 = new InformationTicket(4, 150, "ABC", "ABL", 22);
    InformationTicket ticket5 = new InformationTicket(4, 150, "ABC", "ABD", 50);

    @Test
    public void searchOneTicket() {
        InformationTicketManager manager = new InformationTicketManager(repository);
        InformationTicket[] returned = new InformationTicket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        doReturn(returned).when(repository).searchAll();
        Comparator<InformationTicket> comparator = new TicketByTimeComparator();
        InformationTicket[] actual = manager.findAll("ABC", "ABL", comparator);
        Arrays.sort(actual);
        Arrays.sort(actual, comparator);
        InformationTicket[] expected = new InformationTicket[]{ticket4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSortByPriceAndSortTimeTravelTickets() {
        InformationTicketManager manager = new InformationTicketManager(repository);
        InformationTicket[] returned = new InformationTicket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        doReturn(returned).when(repository).searchAll();
        Comparator<InformationTicket> comparator = new TicketByTimeComparator();
        InformationTicket[] actual = manager.findAll("ABC", "ABD", comparator);
        Arrays.sort(actual);
        Arrays.sort(actual, comparator);
        InformationTicket[] expected = new InformationTicket[]{ticket3, ticket5, ticket2, ticket1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortNoExistsTicket() {
        InformationTicketManager manager = new InformationTicketManager(repository);
        InformationTicket[] returned = new InformationTicket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        doReturn(returned).when(repository).searchAll();
        Comparator<InformationTicket> comparator = new TicketByTimeComparator();
        InformationTicket[] actual = manager.findAll("ABL", "ABD", comparator);
        Arrays.sort(actual, comparator);
        InformationTicket[] expected = new InformationTicket[]{};
        assertArrayEquals(expected, actual);
    }
}

