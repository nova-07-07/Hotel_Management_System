package repository;

import java.time.LocalDate;
import java.util.HashMap;
import models.reservation;

public class reservationRepo {
    private HashMap<Integer, reservation> reservationlist = new HashMap<>();
    private int count = 1;

    public void addreservation(String CUSTOMERNAME, int ROOM_NO, LocalDate START, LocalDate END, int Totalprice) {
        reservation res = new reservation(CUSTOMERNAME, ROOM_NO, START, END, Totalprice);
        reservationlist.put(count, res);
        count++;
    }

    public HashMap<Integer, reservation> getreservationlist() {
        return reservationlist;
    }

    public void deleteRes( int i) {
        reservationlist.remove(i);
        System.out.println("Reservation deleted successfully");
    }

    public void displayAllRes() {
        for (reservation res : reservationlist.values()) {
            System.out.println("Customer Name: " + res.getCustomername() + " Room No: " + res.getRoom_no() + " Start Date: " + res.getBookeddate().get(1)[0] + " End Date: " + res.getBookeddate().get(1)[1] + " Total Price: " + res.getTotalprice());
        }
    }

    public reservation getResById(int id) {
        return reservationlist.get(id);
    }

    public void updateRes(int id, LocalDate START, LocalDate END, int Totalprice) {
        reservationlist.get(id).setDataRes( START, END, Totalprice);
    }
}
