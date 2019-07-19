package com.jy.itSupport;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class TicketRepository {
    private static AtomicLong idGenerator = new AtomicLong();
    private static Map<Long, Ticket> tickets = new HashMap<>();

    public List<Ticket> getAll(){
        return new ArrayList<Ticket>(tickets.values());
    }

    public Ticket get(long id){
        return tickets.get(id);
    }

    public Ticket create(Ticket ticket){
        ticket.setId(idGenerator.getAndIncrement());
        tickets.putIfAbsent(ticket.getId(), ticket);
        return ticket;
    }

    public void update( Ticket ticket){
        tickets.computeIfPresent(ticket.getId(), (key, value) -> ticket );
    }


    public void remove(long id){
        tickets.remove(id);
    }
}
