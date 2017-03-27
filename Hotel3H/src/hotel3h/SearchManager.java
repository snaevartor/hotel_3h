/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel3h;

import gui.hotel_gui;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Soley
 */
public class SearchManager {
    //All of the conditions the search asks for
    int type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus;
    
    public SearchManager(int[] heild){
        //Set all values
        type = heild[0];
        gym = heild[1];
        spa = heild[2];
        pool = heild[3];
        hottub = heild[4];
        wifi = heild[5];
        conference = heild[6];
        restaurant = heild[7];
        bar = heild[8];
        inclusive = heild[9];
        breakfast = heild[10];
        cancellation = heild[11];
        roomservice = heild[12];
        wheelchair = heild[13];
        elevator = heild[14];
        flybus = heild[15];
    }
    
    public ArrayList<Hotel> searchHotel(){
        HotelDatabaseManager hdm = new HotelDatabaseManager();
        //Searches is HotelDataBaseManager
        return hdm.searchHotels(type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus);      
    }
    
    public String[] searchHotelName(){
        HotelDatabaseManager hdm = new HotelDatabaseManager();
        int n = hdm.searchHotels(type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus).size();
        String[] s = new String[n];
        for(int i=0; i<n; i++){
            s[i] = hdm.getHotelStringInfo(i)[0];
        }
        return s;
    }
    
}
