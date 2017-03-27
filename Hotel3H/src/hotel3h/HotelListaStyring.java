/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Soley
 */
public class HotelListaStyring implements ListSelectionListener{
    private hotel_gui hotelGluggi;
    ArrayList<Hotel> hotels; //ArrayList of Hotels
    Hotel hotel; //A selected hotel
    
    public HotelListaStyring(hotel_gui gluggi, ArrayList<Hotel> hl){
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
