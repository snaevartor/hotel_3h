package hotel3h;

/**
 *
 * @author Soley
 */
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
/**
 *
 * @author Soley
 */
public class HotelListaVinnsla extends DefaultListModel{
    ArrayList<Hotel> hotel;
    DefaultListModel listiRoom = new DefaultListModel();  //New Default list model
    int sort;
    
    public HotelListaVinnsla(ArrayList<Hotel> hl, int sort){
        //Add all elements from the ArrayList to the list
        hotel = hl;
        this.sort = sort;
        sortHotels();
        for(Hotel h: hotel){
            addElement(h.getName());
        }   
    }
    //Adds one element to the list
/*    public void addtoList(Hotel hl){
        addElement(hl.getName());
    }
*/    
    public void sortHotels(){
        if(sort==1){
            Collections.sort(hotel);
        }
    }
    
}
