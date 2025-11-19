public class Passenger {
    private static int gen = 1;
    private int id;
    private String name;
    private int age;
    private String gender;
    private String berthPreference;
    private int alloted;
    private String seatType;
    private String seatAlloted;
    private boolean children;

    public Passenger(String name, int age, String gender, String berthPreference) {
        this.id = gen++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.alloted = -1;
        this.seatType = "";
        this.seatAlloted = "";
        this.children = false;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public boolean getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAlloted() {
        return alloted;
    }

    public String getSeatAlloted() {
        return seatAlloted;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAlloted(int alloted) {
        this.alloted = alloted;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setSeatAlloted(String seatAlloted) {
        this.seatAlloted = seatAlloted;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }
}
