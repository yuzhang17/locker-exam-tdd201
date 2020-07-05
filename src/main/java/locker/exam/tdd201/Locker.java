package locker.exam.tdd201;

import java.util.HashMap;

public class Locker {
    private int size;
    private TypeEnum type;
    private HashMap<Ticket, Bag> bagRepository = new HashMap<>();
    public Locker(int size, TypeEnum type) {
        this.size = size;
        this.type = type;
    }

    public Ticket store(Bag bag) {
        if (bagRepository.size() >= size) {
            throw new LockerIsFullException();
        }
        Ticket t = new Ticket(TypeEnum.SMALL);
        bagRepository.put(t, bag);
        return t;
    }

    public Bag pickUp(Ticket ticket) {
        if (!ticket.getType().equals(type)) {
            throw new TicketTypeException();
        }
        if (!bagRepository.containsKey(ticket)) {
            throw new TicketInvalidException();
        }
        return bagRepository.get(ticket);
    }
}
