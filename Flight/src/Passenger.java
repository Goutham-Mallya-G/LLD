public class Passenger {
    static private int gen = 1;
    private int id;
    private String name;
    private int age;
    private int ticketCount;

    public Passenger(String name, int age, int ticketCount) {
        this.id = gen++;
        this.name = name;
        this.age = age;
        this.ticketCount = ticketCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
