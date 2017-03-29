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
    int type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus,minPrice,maxPrice,minSize,maxSize;
    
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
        minPrice = heild[16];
        maxPrice = heild[17];
        minSize = heild[18];
        maxSize = heild[19];
    }
    
    public ArrayList<Hotel> searchHotel(){
        HotelDatabaseManager hdm = new HotelDatabaseManager();
        //Searches in HotelDataBaseManager
        ArrayList <Hotel> h = hdm.searchHotels(type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus);
        searchForRooms(hdm,h);
        return h;
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
    
    public int[] listForRoomSearch(int hnr, int minPrice, int maxPrice, int minSize, int maxSize){
        int[] i = {hnr,0,0,0,0,0,0,0,0,0,0,minPrice,maxPrice,minSize,maxSize,0,0,0};
        return i;
    }
    
    public void searchForRooms(HotelDatabaseManager hdm, ArrayList<Hotel> h){
        Hotel[] hFylki = new Hotel[h.size()];
        int temp = 0;
        for(Hotel htemp: h){
            int[] i = listForRoomSearch(htemp.getNr(),minPrice,maxPrice,minSize,maxSize);
            ArrayList<Room> r = hdm.searchRooms(i[0],i[1],i[2],i[3],i[4],i[5],i[6],i[7],i[8],i[9],i[10],i[11],i[12],i[13],i[14],i[15],i[16],i[17]);
            if(r.isEmpty()){
                hFylki[temp] = htemp;
                System.out.println("Null");
                temp++;
            }
            else{
                System.out.println("OK");
            }
        }
        for(int j=0;j<temp;j++){
            h.remove(hFylki[j]);
        }
    }
    
}
