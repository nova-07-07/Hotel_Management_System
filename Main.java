import controllers.HotelController;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        HotelController controller = new HotelController();

        controller.addRoom("Single Room", 101, 3000);
        controller.addRoom("Double Room", 102, 5000);

        controller.addCustomer("Raj", "0076 8789 3975 8768");
        controller.addCustomer("Ashok", "0076 8789 3975 8768");
        controller.addCustomer("Anu", "0076 8789 3975 8768");

        

        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 7);

        //controller.addReservation("Ashok", 101, startDate, endDate, 15000);
        
        //controller.displayAllCustomer();
        //controller.displayAllRooms();

        //controller.removeCustomer("Raj");
        //controller.removeRoom(102);
        //controller.removeReseveration(1);
    }
}
