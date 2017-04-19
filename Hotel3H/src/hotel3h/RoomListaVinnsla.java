package hotel3h;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Soley
 */
public class RoomListaVinnsla extends DefaultListModel{
    DefaultListModel listiRoom = new DefaultListModel();//New DefaultListModel
    
    public RoomListaVinnsla(ArrayList<Room> herb){
        //Adds all Rooms from the ArrayList to the List
        for(Room rm: herb){
            addElement(rm.getPrice() + " USD, " + rm.getCount() + " people, " + rm.getBed1() + " single beds, " + rm.getBed2() + " double beds, " + rm.getSize() + " square meters.");
        }
    }
    
}
