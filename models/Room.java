package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Room {
    private int room_no;
    private String type;
    private long perdayprice;
    private ArrayList<LocalDate[]> bookeddate;

    public Room(int newroom_no, String newtype, long newperdayprice) {
        room_no = newroom_no;
        type = newtype;
        perdayprice = newperdayprice;
        bookeddate = new ArrayList<>();
    }

    public int getRoom_no() {
        return room_no;
    }

    public String getType() {
        return type;
    }

    public long getPerdayprice() {
        return perdayprice;
    }

    public ArrayList<LocalDate[]> getBookeddate() {
        return bookeddate;
    }

    public void addBookedDate(LocalDate start, LocalDate end) {
        bookeddate.add(new LocalDate[]{start, end});
    }

    public void editroom(int newroomno, String newtype, long newperdayprice) {
        room_no = newroomno;
        type = newtype;
        perdayprice = newperdayprice;
    }
}
