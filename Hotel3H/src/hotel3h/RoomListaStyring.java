package hotel3h;

import gui.hotelView;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 * @author Soley
 * 
 * Controls the list of rooms in hotelView
 */
public class RoomListaStyring  implements ListSelectionListener{
    private hotelView hotelGluggi;
    ArrayList<Room> rooms; //ArrayList of Rooms
    Room herb; //Selected Room
    int last = 0;
    
    public RoomListaStyring(hotelView gluggi, ArrayList<Room> room){
        //initializes
        hotelGluggi = gluggi;
        rooms = room;
    }

    //Finds the selected Room.
    @Override
    public void valueChanged(ListSelectionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JList lSelect = (JList)e.getSource();
        int i = lSelect.getSelectedIndex();
        herb = hotelGluggi.getRooms().get(i);
        hotelGluggi.setValinn(herb);
        if(hotelGluggi.getSelected() == 0){
            last = i;
        }
    }
}