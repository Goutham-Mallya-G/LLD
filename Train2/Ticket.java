package Process;

public class Ticket {
    private static int gen = 1;
    private int id;
    private char source;
    private char destination;
    private int passenger;
    private int intitialBook;

    public Ticket(char source, char destination, int passenger) {
        this.id = gen++;
        this.source = source;
        this.destination = destination;
        this.passenger = passenger;
        this.intitialBook = passenger;
    }

    public int getId() {
        return id;
    }

    public char getSource() {
        return source;
    }

    public char getDestination() {
        return destination;
    }

    public int getPassenger() {
        return passenger;
    }

    public int getIntitialBook() {
        return intitialBook;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }
}
