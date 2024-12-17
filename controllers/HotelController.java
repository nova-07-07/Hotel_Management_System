package controllers;

import java.time.LocalDate;
import models.customer;
import service.*;

public class HotelController { 

    public static  roomSer roomService = new roomSer();
    public static  customerSer customerService = new customerSer();
    public static  reservationSer reservationService = new reservationSer();

    public void addRoom(String roomType, int roomNumber, long perDayPrice) {
        roomService.addroom(roomNumber, roomType, perDayPrice);
    }

    public void addCustomer(String customerName, String idNumber) {
        customerService.addCustomer(customerName, idNumber);
    }

    public void addReservation(String customerName, int roomNo, LocalDate startDate, LocalDate endDate, int totalPrice) {
        boolean res = reservationService.addReservation(customerName, roomNo, startDate, endDate, totalPrice);
        if (res) {
            System.err.println("Reservation added successfully for customer " + customerName + " in room " + roomNo);
        }
    }

    public void removeCustomer(String name){
        customerService.deleteCustomer(name);
    }

    public void removeRoom(int roomNo){
        roomService.deleteroom(roomNo);
    }

    public void displayAllRooms() {
        roomService.displayAllRooms();
    }

    public void displayAllCustomer(){
        for (customer cu : customerService.getCustomerList().values()) {
            System.err.println("Customer Name: " + cu.getCustomerName() + " ID Number: " + cu.getIdNumber());
        }
    }

    public void removeReseveration(int i) {
        reservationService.removeReservation(i);
    }
}
