package service;

import controllers.HotelController;
import java.time.LocalDate;
import models.Room;
import models.customer;
import repository.reservationRepo;

public class reservationSer {

    private reservationRepo reservationRepository = new reservationRepo();

    public boolean addReservation(String customerName, int roomNo, LocalDate start, LocalDate end, int totalPrice) {
        
        customer customer = null;
        for (customer cust : HotelController.customerService.getCustomerList().values()) {
            if (cust.getCustomerName().equals(customerName)) {
                customer = cust;
                break;
            }
        }

        if (customer == null) {
            System.out.println("Customer not found");
            return false;
        }

        Room room = HotelController.roomService.getRoomById(roomNo);
        if (room == null || !available(start, end, roomNo)) {
            System.out.println(roomNo +" Room not available");
            return false;
        }

        reservationRepository.addreservation(customerName, roomNo, start, end, totalPrice);

        room.addBookedDate(start, end);
        
        return true;
    }

    public boolean available(LocalDate start, LocalDate end, int roomNo) {
        Room room = HotelController.roomService.getRoomById(roomNo);
        if (room == null) {
            return false;
        }

        for (LocalDate[] pair : room.getBookeddate()) {
            LocalDate bookedStart = pair[0];
            LocalDate bookedEnd = pair[1];

            if ((start.isBefore(bookedEnd) && start.isAfter(bookedStart)) || 
                (end.isBefore(bookedEnd) && end.isAfter(bookedStart)) || 
                start.equals(bookedStart) || end.equals(bookedEnd)) {
                return false;
            }
        }
        return true;
    }

    public void removeReservation(int i) {
        reservationRepository.deleteRes(i);
    }
}
