package hotel3h;

/**
 *
 * @author Soley
 */
import gui.hotel_gui;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Soley
 * 
 * Controls the List of hotels in hotel_gui
 */
public class HotelListaStyring implements ListSelectionListener{
    private hotel_gui hotelGluggi;
    ArrayList<Hotel> hotels; //ArrayList of Hotels
    Hotel hotel; //A selected hotel
    
    public HotelListaStyring(hotel_gui gluggi, ArrayList<Hotel> hl){
        //initializes
        hotelGluggi = gluggi;
        hotels = hl;
    }
    
    //Finds the selected Hotel from the list
    @Override
    public void valueChanged(ListSelectionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JList lSelect = (JList)e.getSource();
        int i = lSelect.getSelectedIndex();
        hotel = hotelGluggi.getHotel().get(i);
        hotelGluggi.setHotel(hotel);
    }
    
}
