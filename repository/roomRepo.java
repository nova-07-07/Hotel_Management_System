package repository;

import models.Room;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class roomRepo {
    private HashMap<Integer, Room> roomlist = new HashMap<>();

    public void addroom(int room_no, String type, long perdayprise) {
        Room room = new Room(room_no, type, perdayprise);
        roomlist.put(room_no, room);
    }

    public Room getroombyid(int room_no) {
        return roomlist.get(room_no);
    }

    public void listofroom() {
        System.out.println();
        for (Integer key : roomlist.keySet()) {
            System.out.println(key + " | " + roomlist.get(key).getType() + " | " + roomlist.get(key).getPerdayprice());
        }
    }

    public void deleteroom(int room_no) {
        System.out.println();
        if (roomlist.containsKey(room_no)) {
            System.out.println("Room No : " + room_no + " is deleted");
            roomlist.remove(room_no);
        } else {
            System.out.println("This Room No is not here");
        }
    }

    public void updateroom(int update_room_no, int room_no, String newtype, long newperdayprice) {
        System.out.println();
        if (!roomlist.containsKey(update_room_no)) {
            System.out.println("This Room No " + room_no + " is not here");
        } else {
            System.out.print("Room No :" + update_room_no + " update to ");
            roomlist.remove(update_room_no);
            roomlist.put(room_no, new Room(room_no, newtype, newperdayprice));
            System.out.println("Room No :" + room_no + " | Type : " + newtype + " | perdayprice : " + newperdayprice);
        }
    }

    public ArrayList<LocalDate[]> list_of_room_in_this_date() {
        ArrayList<LocalDate[]> allBookedDates = new ArrayList<>();
        for (Room room : roomlist.values()) {
            allBookedDates.addAll(room.getBookeddate());
        }
        return allBookedDates;
    }
}
