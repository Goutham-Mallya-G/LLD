import java.util.*;

public class App {

    static int limit = 6/3;
    static int racLimit = 2;
    static int waitingLimit = 2;

    private static int lowerNumber = 1;
    private static int middleNumber = 2;
    private static int upperNumber = 3;

    static ArrayList<Passenger> confirmedList = new ArrayList<>();

    static ArrayList<Passenger> upperList = new ArrayList<>();
    static ArrayList<Passenger> middleList = new ArrayList<>();
    static ArrayList<Passenger> lowerList = new ArrayList<>();


    static Queue<Passenger> racQueue = new LinkedList<>();
    static Queue<Passenger> waitingQueue = new LinkedList<>();

    static Map<Integer , String> cancelledMap = new HashMap<>();

    private boolean updateRac(Passenger p){
        if(racQueue.size() < racLimit){
            p.setSeatType("Rac");
            racQueue.add(p);
            return true;
        }
        return false;
    }

    private boolean updateWaiting(Passenger p){
        if(waitingQueue.size()<waitingLimit){
            p.setSeatType("Waiting list");
            waitingQueue.add(p);
            return true;
        }
        return false;
    }

    private boolean isPreferedAvailable(Passenger p){
        Iterator<Map.Entry<Integer , String>> it = cancelledMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer , String > entry  = it.next();
            if (entry.getValue().equals(p.getBerthPreference())){
                p.setAlloted(entry.getKey());
                p.setSeatType("Confirmed");
                p.setSeatAlloted(p.getBerthPreference());
                it.remove();
                return true;
            }
        }
        if(p.getBerthPreference().equals("UPPER")){
            if(upperList.size()<limit){
                p.setSeatType("Confirmed");
                p.setAlloted(upperNumber);
                p.setSeatAlloted("UPPER");
                upperNumber += 3;
                upperList.add(p);
                return true;
            }
        }else if(p.getBerthPreference().equals("MIDDLE")){
            if(middleList.size()<limit){
                p.setSeatType("Confirmed");
                p.setAlloted(middleNumber);
                p.setSeatAlloted("MIDDLE");
                middleNumber += 3;
                middleList.add(p);
                return true;
            }
        }
        else if(p.getBerthPreference().equals("LOWER")){
            if(lowerList.size() < limit){
                p.setSeatType("Confirmed");
                p.setAlloted(lowerNumber);
                p.setSeatAlloted("LOWER");
                lowerNumber += 3;
                lowerList.add(p);
                return true;
            }
        }
        return false;

    }

    public void bookTicket(Passenger p){
        if(p.getAge() >= 60 || p.getChildren()){
            if(lowerList.size() < limit){
                p.setBerthPreference("LOWER");
            }
        }
        if(upperList.size() == limit && middleList.size() == limit && lowerList.size() == limit){
            if(updateRac(p)){
                System.out.println("Ticket booked in Rac, Ticket id = " + p.getId());
            }else if(updateWaiting(p)){
                System.out.println("Ticket added in waiting list = " +p.getId());
            }else{
                p.setId(p.getId()-1);
                System.out.println("Ticket is not available");
            }
        }
        else if(isPreferedAvailable(p)){
            System.out.println();
            System.out.println("Ticket booked successfully");
            System.out.println("Berth Allocated : " + p.getSeatAlloted());
            System.out.println("Seat number : " + p.getAlloted());
            confirmedList.add(p);
        }else{
            p.setId(p.getId()-1);
            System.out.println("Preferred seat is not available please see the available seats");
        }
    }

    private void addRacToConfirm(){
        Passenger p = racQueue.poll();
        if(p != null) {
            for (Map.Entry<Integer, String> entry : cancelledMap.entrySet()) {
                if (entry.getKey() != null) {
                    p.setSeatAlloted(entry.getValue());
                    p.setSeatType("Rac");
                    p.setAlloted(entry.getKey());
                    confirmedList.add(p);
                    cancelledMap.remove(entry.getKey());
                    return;
                }
            }
        }
    }

    private void addWaitingtoRac(){
        racQueue.poll();
        Passenger p = waitingQueue.poll();
        if(p != null && racQueue.size() < racLimit) {
            p.setSeatType("Rac");
            racQueue.add(p);
        }
    }

    private void cancel(Passenger p){
        if(p.getSeatType().equals("Confirmed")){

            int seatNumber = p.getAlloted();
            String berthType = p.getSeatAlloted();

            cancelledMap.put(seatNumber , berthType);
            addRacToConfirm();
            addWaitingtoRac();
            confirmedList.remove(p);
            upperList.remove(p);
            middleList.remove(p);
            lowerList.remove(p);

        }else if(p.getSeatType().equals("Rac")){
            addWaitingtoRac();
        }else{
            waitingQueue.poll();
        }
    }

    public void cancelTicket(int ticketId){
        for(Passenger p : confirmedList){
            if(p.getId() == ticketId){
                cancel(p);
                return;
            }
        }

        for(Passenger p : racQueue){
            if(p.getId() == ticketId){
                cancel(p);
                return;
            }
        }
        for(Passenger p : waitingQueue){
            if(p.getId() == ticketId){
                cancel(p);
                return;
            }
        }
    }

    public void printAllConfirmed(){
        System.out.println("passenger id           passenger name           passenger age           passenger gender           passenger seatAlloted Type           passenger seat alloted");
        for(Passenger p : confirmedList){
            System.out.println(p.getId() +"           "+p.getName() + "           " + p.getAge() + "           "+ "              " + p.getGender() + "              " + p.getSeatAlloted() + "                 " + p.getSeatType() + "           " + p.getAlloted());
        }
        System.out.println("Rac list");
        for(Passenger p : racQueue){
            System.out.println(p.getId() +"           "+p.getName() + "           " + p.getAge() + "           "+ "              " + p.getGender() + "           " + p.getBerthPreference());
        }
        System.out.println("Waiting List");
        for(Passenger p : waitingQueue){
            System.out.println(p.getId() +"           "+p.getName() + "           " + p.getAge() + "           "+ "              " + p.getGender() + "           " + p.getBerthPreference());
        }
    }

    public void printAllAvailable(){
        System.out.println("Upper" + (limit - upperList.size()));
        System.out.println("Middle" + (limit - middleList.size()));
        System.out.println("Lower" + (limit - lowerList.size()));
    }
}
