package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class reservation {
    private String customername;
    private int room_no;
    private int totalprice;
    private ArrayList<LocalDate[]> bookeddate;

    public reservation(String CUSTOMERNAME, int ROOM_NO, LocalDate START, LocalDate END, int Totalprice) {
        customername = CUSTOMERNAME;
        room_no = ROOM_NO;
        bookeddate = new ArrayList<>();
        bookeddate.add(new LocalDate[]{START, END});
        totalprice = Totalprice;
    }

    public String getCustomername() {
        return customername;
    }

    public int getRoom_no() {
        return room_no;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public ArrayList<LocalDate[]> getBookeddate() {
        return bookeddate;
    }

    public void addBookedDate(LocalDate start, LocalDate end) {
        bookeddate.add(new LocalDate[]{start, end});
    }

    

    public void setDataRes(LocalDate START, LocalDate END, int totalprice2) {
        bookeddate.replaceAll(operator -> new LocalDate[]{START, END});
        totalprice = totalprice2;
    }
}
