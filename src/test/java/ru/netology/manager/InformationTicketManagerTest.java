package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.InformationTicket;
import ru.netology.repository.InformationTicketRepository;

import java.util.Arrays;

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

    @Test
    public void searchOneTicket() {
        InformationTicketManager manager = new InformationTicketManager(repository);
        InformationTicket[] returned = new InformationTicket[]{ticket1, ticket2, ticket3, ticket4};
        doReturn(returned).when(repository).searchAll();
        InformationTicket[] actual = manager.findAll("ABC", "ABL");
        Arrays.sort(actual);
        InformationTicket[] expected = new InformationTicket[]{ticket4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByTickets() {
        InformationTicketManager manager = new InformationTicketManager(repository);
        InformationTicket[] returned = new InformationTicket[]{ticket1, ticket2, ticket3, ticket4};
        doReturn(returned).when(repository).searchAll();
        InformationTicket[] actual = manager.findAll("ABC", "ABD");
        Arrays.sort(actual);
        InformationTicket[] expected = new InformationTicket[]{ticket2, ticket3, ticket1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortNoExistsTicket() {
        InformationTicketManager manager = new InformationTicketManager(repository);
        InformationTicket[] returned = new InformationTicket[]{ticket1, ticket2, ticket3, ticket4};
        doReturn(returned).when(repository).searchAll();
        InformationTicket[] actual = manager.findAll("ABL", "ABD");
        Arrays.sort(actual);
        InformationTicket[] expected = new InformationTicket[]{};
        assertArrayEquals(expected, actual);
    }

}