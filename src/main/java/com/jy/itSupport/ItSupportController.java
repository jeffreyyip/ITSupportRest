package com.jy.itSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ticket")
public class ItSupportController {

    @Autowired
    TicketRepository repository;

    @GetMapping
    public List<Ticket> getTickets(){
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable String id){

        return repository.get(Long.parseLong(id));
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket){
        return repository.create(ticket);
    }

    @PutMapping("/{id}")
    public void updateTicket(@RequestBody Ticket ticket, @PathVariable(name="id") String id){
        ticket.setId(Long.parseLong(id));
        repository.update(ticket);

    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable String id){
        repository.remove(Long.parseLong(id));
    }
}
