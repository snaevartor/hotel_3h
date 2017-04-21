package hotel3h;

/**
 * @author Soley
 * 
 * The list model for the list of hotels in hotel_gui
 */
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;

public class HotelListaVinnsla extends DefaultListModel{
    ArrayList<Hotel> hotel;
    DefaultListModel listiRoom = new DefaultListModel();  //New Default list model
    int sort; //1 if we want to sort hotels, else 0
    
    public HotelListaVinnsla(ArrayList<Hotel> hl, int sort){
        //Add all elements from the ArrayList to the list
        hotel = hl;
        this.sort = sort;
        sortHotels();
        for(Hotel h: hotel){
            addElement(h.getName());
        }   
    }

    //sorts the hotels by price
    public void sortHotels(){
        if(sort==1){
            Collections.sort(hotel);
        }
    }
    
}
