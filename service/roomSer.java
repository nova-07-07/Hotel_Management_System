package service;

import models.Room;
import repository.roomRepo;

import java.time.LocalDate;
import java.util.ArrayList;

public class roomSer {
    private roomRepo repo = new roomRepo();

    public void addroom(int room_no, String type, long perdayprice) {
        repo.addroom(room_no, type, perdayprice);
    }

    public boolean available(LocalDate start, LocalDate end, int room_no) {
        Room room = repo.getroombyid(room_no);
        if (room == null) {
            return false;
        }

        ArrayList<LocalDate[]> bookedDates = room.getBookeddate();
        for (LocalDate[] pair : bookedDates) {
            LocalDate startDate = pair[0];
            LocalDate endDate = pair[1];

            if ((start.isBefore(endDate) && start.isAfter(startDate)) || 
                (end.isBefore(endDate) && end.isAfter(startDate)) || 
                start.equals(startDate) || end.equals(endDate)) {
                return false;
            }
        }
        return true;
    }

    public Room getRoomById(int roomNo) {
        return repo.getroombyid(roomNo);
    }


    public void displayAllRooms() {
        repo.listofroom();
    }

    public void deleteroom(int roomNo) {
        repo.deleteroom(roomNo);
    }
}
