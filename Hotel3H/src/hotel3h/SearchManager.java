package hotel3h;

import java.util.ArrayList;
/**
 * @author Soley
 * 
 * Manages the search
 */
public class SearchManager {
    //All of the conditions the search asks for
    int type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus,minPrice,maxPrice,minSize,maxSize,minBeds,areaCode;
    int aCode;
    int[] d1,d2;
    BookingManager bm = new BookingManager();
    
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
        minBeds = heild[20];
        areaCode = heild[21];
        d1 = new int[]{heild[22],heild[23],heild[24]};
        d2 = new int[]{heild[25],heild[26],heild[27]};
    }
    
    public ArrayList<Hotel> searchHotel(){
        //connect to HotelDatabaseManager
        HotelDatabaseManager hdm = new HotelDatabaseManager();
        //Searches in HotelDataBaseManager
        ArrayList <Hotel> h = hdm.searchHotels(type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus);
        searchForRooms(hdm,h);
        return h;
    }
    
    //searches for a hotel name instead of a hotel object
    public String[] searchHotelName(){
        //connect to HotelDatabaseManager
        HotelDatabaseManager hdm = new HotelDatabaseManager();
        //search for hotels
        int n = hdm.searchHotels(type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus).size();
        String[] s = new String[n];
        //get names from the searched hotels
        for(int i=0; i<n; i++){
            s[i] = hdm.getHotelStringInfo(i)[0];
        }
        return s;
    }
    
    //returns an int for a search for every room
    private int[] listForRoomSearch(int hnr, int minPrice, int maxPrice, int minSize, int maxSize){
        int[] i = {hnr,0,0,0,0,0,0,0,0,0,0,minPrice,maxPrice,minSize,maxSize,0,0,0};
        return i;
    }
    
    //returns rooms for a certain search
    private void searchForRooms(HotelDatabaseManager hdm, ArrayList<Hotel> h){
        Hotel[] hFylki = new Hotel[h.size()];
        int temp = 0;
        for(Hotel htemp: h){
            int[] i = listForRoomSearch(htemp.getNr(),minPrice,maxPrice,minSize,maxSize);
            //serch for rooms with minprice,maxprice,minsize and maxsize criteria
            ArrayList<Room> r = hdm.searchRooms(i[0],i[1],i[2],i[3],i[4],i[5],i[6],i[7],i[8],i[9],i[10],i[11],i[12],i[13],i[14],i[15],i[16],i[17]);
            if(r.isEmpty()){
                hFylki[temp] = htemp;
                temp++;
            }
        }
        //remove unwanted rooms
        for(int j=0;j<temp;j++){
            h.remove(hFylki[j]);
        }
        //search by number of people
        hFylki = searchCount(h);
        //remove unwanted hotels
        for(Hotel htemp:hFylki){
            h.remove(htemp);
        }
        //search by areacode
        hFylki = searchAreaCode(h);
        //remove unwanted hotels
        for(Hotel htemp:hFylki){
            h.remove(htemp);
        }
        //search by availability
        hFylki = searchAvailable(h);
        //remove unwanted hotels
        for(Hotel htemp:hFylki){
            h.remove(htemp);
        }
    }
    
    //search for hotels with the specified number of people
    private Hotel[] searchCount(ArrayList<Hotel> h){
        int temp=0;
        Hotel[] hFylki = new Hotel[h.size()];
        for(Hotel htemp: h){
            Room[] rFylki = new Room[htemp.getRooms().size()];
            int rTalning = 0;
            //if number of people for selected room is less then the minimum, add the room to the list
            for(Room r: htemp.getRooms()){
                if(r.getCount()<minBeds){
                    rFylki[rTalning]=r;
                    rTalning++;
                }
            }
            //remove unwanted rooms
            for(int j=0; j<rTalning; j++){
                htemp.getRooms().remove(rFylki[j]);
            }
            //add hotels with no rooms left to a list of hotels
            if(htemp.getRooms().isEmpty()){
                hFylki[temp] = htemp;
                temp++;
            }
        }
        //return a list of hotels with no rooms left
        return hFylki;
    }
    
    //filter out hotels not inside a specific region
    private Hotel[] searchAreaCode(ArrayList<Hotel> h){
        int temp = 0;
        Hotel[] hFylki= new Hotel[h.size()];
        //sets numbers for each region, checks if it is the same number as asked for by user
        //adds hotel to list if the region numbers don't match
        for(Hotel htemp:h){
            if(htemp.getAreacode()<300){
                aCode = 1;
            }
            else if(htemp.getAreacode()<400){
                aCode = 2;
            }
            else if(htemp.getAreacode()<500){
                aCode = 3;
            }
            else if(htemp.getAreacode()<680){
                aCode = 4;
            }
            else if(htemp.getAreacode()<780){
                aCode = 5;
            }
            else if (htemp.getAreacode()<900){
                aCode = 6;
            }
            else if (htemp.getAreacode()<903){
                aCode = 7;
            }
            else{
                aCode = 0;
            }
            //add to list if the region number for selected hotel doesn't match the
            //region number specified by user
            if(areaCode != aCode && areaCode!=0){
                hFylki[temp] = htemp;
                temp++;
            } 
        }
        //returns an array of hotels not inside the specified region
        return hFylki;
    }
    
    //filters out hotels with no rooms available
    public Hotel[] searchAvailable(ArrayList<Hotel> h){
        for(Hotel htemp: h){
            Room[] rFylki = new Room[htemp.getRooms().size()];
            int i = 0;
            //adds room to array if it is not available the specified day/days
            for(Room rtemp: htemp.getRooms()){
                if(!bm.isAvailable(htemp.getNr(), rtemp.getNr(), d1, d2)){
                    rFylki[i] = rtemp;
                    i++;
                }
            }
            //removes unwanted rooms
            for(Room r: rFylki){
                htemp.getRooms().remove(r);
            }
        }
        Hotel[] hFylki = new Hotel[h.size()];
        int j = 0;
        //adds hotels with no available rooms left to an array
        for(Hotel htemp: h){
            if(htemp.getRooms().isEmpty()){
                hFylki[j] = htemp;
                j++;
            }
        }
        //return an array of hotels with no available rooms
        return hFylki;
    }
    
    //leit að öllum hótelum, hvort sem þau hafa herbergi eða ekki
    public ArrayList<Hotel> searchAllHotels(){
        //connect to HotelDatabaseManager
        HotelDatabaseManager hdm = new HotelDatabaseManager();
        //Searches in HotelDataBaseManager
        ArrayList <Hotel> h = hdm.searchHotels(type,gym,spa,pool,hottub,wifi,conference,restaurant,bar,inclusive,breakfast,cancellation,roomservice,wheelchair,elevator,flybus);
        return h;
    }
}
