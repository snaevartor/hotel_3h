package hotel3h;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
* Class: HotelDatabaseManager
* Usage: Create and operate on Hotel objects.
* @author Helgi
* @author Omar
*/

public class HotelDatabaseManager {
	
    /**
    * Constructor for HotelDatabaseManager
    */
    public  HotelDatabaseManager(){ 
		
	}
	

    /**
    * Private method for establishing a connection with the database.
    */
    private static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:src/sql/hotel.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;          
    }

  
 

    /**
    * Filter rooms based on specified search criteria.
    */
    public ArrayList<Room> searchRooms(
            int hnr,
            int pets,
            int washing,
            int kitchen,
            int minifridge,
            int tv,
            int bath,
            int view,
            int noise,
            int smoke,
            int ac,
            int minPrice,
            int maxPrice,
            int minSize,
            int maxSize,
            int bed1,
            int bed2,
            int baby){
        
                ArrayList<Room> rooms = new ArrayList<>();
                String sql;
                sql = "SELECT * FROM RoomSearch, Room WHERE Room.nr = Roomsearch.nr AND"
      		+ " hotelnr = hnr AND hnr = " + hnr + 
       		" AND pets >= " + pets + " AND washing >= " + washing +
       		" AND kitchen >= " + kitchen + " AND minifridge >= " + minifridge +
     		" AND tv >= " + tv + " AND bath >= " + bath +
    		" AND view >= " + view + " AND noise >= " + noise +
       		" AND smoke >= " + smoke + " AND ac >= " + ac + " AND price >= " + minPrice + 
       		" AND price <= " + maxPrice + " AND size >= " + minSize + " AND size <= " + maxSize +
       		" AND bed1 >= " + bed2 + " AND bed2 >= " + bed2 + " AND baby >= " + baby;
	
	    try (Connection conn = connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){     
	    while (rs.next()) {
	        Room r = new Room(rs.getInt("nr"), rs.getInt("hnr"), rs.getInt("pets"), 
                    rs.getInt("washing"), rs.getInt("kitchen"), rs.getInt("minifridge"),
                    rs.getInt("tv"), rs.getInt("bath"), rs.getInt("view"), rs.getInt("view"),
                    rs.getInt("noise"), rs.getInt("smoke"), rs.getInt("ac"), rs.getInt("price"), 
                    rs.getInt("size"), rs.getInt("bed1"), rs.getInt("bed2"), rs.getInt("baby"));
	            rooms.add(r);
            }	
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
        return rooms;
    }

    /**
    * Filter hotels based on specified search criteria.
    */
    public ArrayList<Hotel> searchHotels(
            int type,
            int gym,
            int spa,
            int pool,
            int hottub,
            int wifi,
            int conference,
            int restaurant,
            int bar,
            int inclusive,
            int breakfast,
            int cancellation,
            int roomService,
            int wheelChair,
            int elevator,
            int flyBus){
         ArrayList<Hotel> hotels = new ArrayList<>();
                String sql;
                sql = "SELECT * FROM HotelSearch, Hotel WHERE HotelSearch.nr = Hotel.nr AND "
                + "gym >= " + gym + " AND spa >= " + spa +
                " AND pool >= " + pool + " AND hottub >= " + hottub +
                " AND wifi >= " + wifi + " AND conference >= " + conference +
                " AND restaurant >= " + restaurant + " AND bar >= " + bar +
                " AND inclusive >= " + inclusive + " AND breakfast >= " + breakfast +
                " AND cancellation >= " + cancellation + " AND roomService >= " + roomService +
                " AND wheelChair >= " + wheelChair + " AND elevator >= " + elevator +
                " AND flyBus >= " + flyBus;
                
                if (type != 0)
                sql += " AND type = " + type;
                        try (Connection conn = connect();
		             Statement stmt  = conn.createStatement();
		             ResultSet rs    = stmt.executeQuery(sql)){

	            while (rs.next()) {
	                		Hotel h = new Hotel(rs.getInt("nr"), rs.getInt("type"), rs.getInt("gym"), rs.getInt("spa"), 
	                				rs.getInt("pool"), rs.getInt("hottub"), rs.getInt("wifi"), rs.getInt("conference"), 
	                				rs.getInt("restaurant"), rs.getInt("bar"), rs.getInt("inclusive"), rs.getInt("breakfast"), 
	                				rs.getInt("cancellation"), rs.getInt("roomservice"), rs.getInt("wheelchair"), 
	                				rs.getInt("elevator"), rs.getInt("flybus"), rs.getInt("stars"), rs.getInt("areacode"),
	                				rs.getString("name"), rs.getString("address"), rs.getString("website"),
	                				getRooms(rs.getInt("nr")));
	                		
	                		hotels.add(h);
	            }
//	System.out.print("Komin í línu 125");
                    
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	   
	        return hotels;
	      
	    }
	    
	   /**
    * Private method for getting a list of rooms belonging to a specific hotel.
    */
   
	 	private ArrayList<Room> getRooms(int hnr){
	 		
		    String sql = "SELECT * FROM RoomSearch, Room WHERE RoomSearch.nr = Room.nr AND hotelnr = hnr AND hnr = " + hnr;
		    ArrayList<Room> rooms = new ArrayList<>();
		
		        
		        try (Connection conn = connect();
		             Statement stmt  = conn.createStatement();
		             ResultSet rs    = stmt.executeQuery(sql)){
		     
		            while (rs.next()) {
		            	  Room r = new Room(rs.getInt("nr"), rs.getInt("hnr"), rs.getInt("pets"), 
	                				rs.getInt("washing"), rs.getInt("kitchen"), rs.getInt("minifridge"),
	                				rs.getInt("tv"), rs.getInt("bath"), rs.getInt("view"), rs.getInt("view"),
	                				rs.getInt("noise"), rs.getInt("smoke"), rs.getInt("ac"), rs.getInt("price"), 
	                				rs.getInt("size"), rs.getInt("bed1"), rs.getInt("bed2"), rs.getInt("baby"));
	                rooms.add(r);
		            }
		
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		   
		        return rooms;
		      
		    
	 	}
               
                    public Room getRoomObject(int hnr, int rnr){
                     String sql = "SELECT * FROM RoomSearch, Room WHERE RoomSearch.nr = Room.nr AND Room.nr = " + rnr + " AND hotelnr = hnr AND hnr = " + hnr;
		   
                     Room r = null;
		        
		        try (Connection conn = connect();
		             Statement stmt  = conn.createStatement();
		             ResultSet rs    = stmt.executeQuery(sql)){
		     
		         
		            	  r = new Room(rs.getInt("nr"), rs.getInt("hnr"), rs.getInt("pets"), 
	                				rs.getInt("washing"), rs.getInt("kitchen"), rs.getInt("minifridge"),
	                				rs.getInt("tv"), rs.getInt("bath"), rs.getInt("view"), rs.getInt("view"),
	                				rs.getInt("noise"), rs.getInt("smoke"), rs.getInt("ac"), rs.getInt("price"), 
	                				rs.getInt("size"), rs.getInt("bed1"), rs.getInt("bed2"), rs.getInt("baby"));
	              
		            
		
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		   
		        return r;
                    }
                     public Hotel getHotelObject(int hnr){
                     String sql = "SELECT * FROM HotelSearch, Hotel WHERE Hotel.nr = HotelSearch.nr AND Hotel.nr = " + hnr;
		   
                     Hotel h = null;
		        
		        try (Connection conn = connect();
		             Statement stmt  = conn.createStatement();
		             ResultSet rs    = stmt.executeQuery(sql)){
		     
		         
                             h = new Hotel(rs.getInt("nr"), rs.getInt("type"), rs.getInt("gym"), rs.getInt("spa"), 
	                				rs.getInt("pool"), rs.getInt("hottub"), rs.getInt("wifi"), rs.getInt("conference"), 
	                				rs.getInt("restaurant"), rs.getInt("bar"), rs.getInt("inclusive"), rs.getInt("breakfast"), 
	                				rs.getInt("cancellation"), rs.getInt("roomservice"), rs.getInt("wheelchair"), 
	                				rs.getInt("elevator"), rs.getInt("flybus"), rs.getInt("stars"), rs.getInt("areacode"),
	                				rs.getString("name"), rs.getString("address"), rs.getString("website"),
	                				getRooms(rs.getInt("nr")));
	              
		            
		
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		   
		        return h;
                    }
		

               

    /**
    * Get string information for a hotel (specified by integer).
    */
    public String[] getHotelStringInfo(int nr){
        String sql = "SELECT * FROM Hotel WHERE nr = " + nr;
        String[] hotelStringInfo = new String[3];		   
        try (Connection conn = connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){	     
            while (rs.next()) {
		hotelStringInfo[0] = rs.getString("name");
            	hotelStringInfo[1] = rs.getString("address");
            	hotelStringInfo[2] = rs.getString("website");
            }		
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotelStringInfo;		      
    }

    /**
    * Get int information for a hotel (specified by integer).
    */
    public int[] getHotelIntInfo(int nr){
        String sql = "SELECT * FROM Hotel WHERE nr = " + nr;
            int[] hotelIntInfo = new int[2];		   
            try (Connection conn = connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){	     
            while (rs.next()) {
            	hotelIntInfo[0] = rs.getInt("stars");
            	hotelIntInfo[1] = rs.getInt("areacode");      
            }
		
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
        return hotelIntInfo;      
    }
    /**
     * Add a hotel to the database
     */
    public void addHotel(Hotel h){
        String sql1 = "INSERT INTO Hotel VALUES(" + h.getNr() + "," + h.getName() + "," + h.getAddress() + "," + h.getStars() + "," + h.getAreacode() + "," + h.getWebsite() + ");";
        String sql2 = "INSERT INTO HotelSearch VALUES(" + h.getNr() + "," + h.getType() + "," + h.getGym() + "," + h.getSpa() + "," + h.getPool() + "," + h.getHottub() + "," + h.getWifi() + "," + h.getConference() + "," + h.getRestaurant() + "," + h.getBar() + "," + h.getInclusive() + "," + h.getBreakfast() + "," + h.getCancellation() + "," + h.getRoomservice() + "," + h.getWheelchair() + "," + h.getElevator() + "," + h.getFlybus() + ");";
        try(Connection conn = connect();
                Statement stmt1 = conn.createStatement();
                ResultSet rs = stmt1.executeQuery(sql1)){
        } catch(SQLException e){
            System.out.println("OK");
        }
        try(Connection conn = connect();
                Statement stmt2 = conn.createStatement();
                ResultSet rs = stmt2.executeQuery(sql2)){
        } catch(SQLException e){
            System.out.println("OK2");
        }
    }
    /**
     * Edit a hotel's information in the database
     */
    public void editHotel(String name, String address, String website, int stars, int areacode, int nr, int type, int gym, int spa, int pool, int hottub, int wifi, int conference, int restaurant, int bar, int inclusive, int breakfast, int cancellation, int roomservice, int wheelchair, int elevator, int flybus){
        String sql1 = "UPDATE Hotel SET name = " + name +  ", address = " + address + ", stars = " + stars + ", areacode = " 
                + areacode + ", website = " + website + " WHERE nr = " + nr + ";";
        String sql2 = "UPDATE HotelSearch SET type = " + type + ", gym = " + gym + ", spa = " + spa + ", pool = " 
                + pool + ", hottub = " + hottub + ", wifi = " + wifi + ", conference = " + conference + ", restaurant = " 
                + restaurant + ", bar = " + bar + ", inclusive = " + inclusive + ", breakfast = " + breakfast + ", cancellation = " 
                + cancellation + ", roomservice = " + roomservice + ", wheelchair = " + wheelchair + ", elevator = " 
                + elevator + ", flybus = " + flybus + " WHERE nr = " + nr + ";";
        try(Connection conn = connect();
        Statement stmt1 = conn.createStatement();
        ResultSet rs = stmt1.executeQuery(sql1)){
        } catch(SQLException e){
            System.out.println("OK");
        }
        try(Connection conn = connect();
                Statement stmt2 = conn.createStatement();
                ResultSet rs = stmt2.executeQuery(sql2)){
        } catch(SQLException e){
            System.out.println("OK2");
        }
    }
    
    /**
     * Edit information of a room in the database
     */
    public void editRoom(int nr, int hotelnr, int size, int price, int bed1, int bed2, int baby, int pets, int count, int washing, int kitchen, int minifridge, int tv, int bath, int view, int noise, int smoke, int ac){
        String sql1 = "UPDATE Room SET size = " + size + ", price = " + price + ", bed1 = " + bed1 + ", bed 2 = "
                + bed2 + ", baby = " + baby + " WHERE  nr = " + nr + " AND hotelnr = " + hotelnr + ";";
        String sql2 = "UPDATE RoomSearch SET pets = " + pets + ", count = " + count + ", washing = " + washing + ", kitchen = "
                + kitchen + ", minifridge = " + minifridge + ", tv = " + tv + ", bath = " + bath + ", view = " + view + ", noise = "
                + noise + ", smoke = " + smoke + ", ac = " + ac + " WHERE nr = " + nr + " AND hotelnr = " + hotelnr + ";";
        try(Connection conn = connect();
                Statement stmt1 = conn.createStatement();
                ResultSet rs = stmt1.executeQuery(sql1)){
        } catch(SQLException e){
            System.out.println("OK");
        }
        try(Connection conn = connect();
                Statement stmt2 = conn.createStatement();
                ResultSet rs = stmt2.executeQuery(sql2)){
        } catch(SQLException e){
            System.out.println("OK2");
        }
    }
	
}
