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
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
/**
 *
 * @author Soley
 */
public class HotelListaVinnsla extends DefaultListModel{
    DefaultListModel listiRoom = new DefaultListModel();  //New Default list model
    
    public HotelListaVinnsla(ArrayList<Hotel> hotel){
        //Add all elements from the ArrayList to the list
        for(Hotel h: hotel){
            addElement(h.getName());
        }
    }
    
    //Adds one element to the list
    public void addtoList(Hotel hl){
        addElement(hl.getName());
    }
}
