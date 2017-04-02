package hotel3h;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
* Class: HotelDatabaseManagerMock
* Usage: Create and operate on Hotel objects. (Mock version).
* @author Helgi
* @author Omar
* @author Snaevar
*/

public class HotelDatabaseManagerMock {
	
    /**
    * Constructor for HotelDatabaseManager
    */
    public  HotelDatabaseManagerMock(){ }

    /**
    * Private method for establishing a connection with the database.
    */
    private static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:src/sql/hoteltest11.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;          
    }

    /**
    * Private method for getting a list of rooms belonging to a specific hotel.
    */
    private ArrayList<RoomMock> getRooms(int hnr){
        String sql = "SELECT * FROM RoomSearch, Room WHERE RoomSearch.nr = Room.nr AND hotelnr = hnr AND hnr = " + hnr;
        ArrayList<RoomMock> rooms = new ArrayList<>();	
        try (Connection conn = connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){	     
            while (rs.next()) {
            	RoomMock r = new RoomMock(rs.getInt("nr"), rs.getInt("hnr"), rs.getInt("pets"), 
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
    * Filter rooms based on specified search criteria.
    */
    public ArrayList<RoomMock> searchRooms(
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
        
                ArrayList<RoomMock> rooms = new ArrayList<>();
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
	        RoomMock r = new RoomMock(rs.getInt("nr"), rs.getInt("hnr"), rs.getInt("pets"), 
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
    public ArrayList<HotelMock> searchHotels(
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
        
                ArrayList<HotelMock> hotels = new ArrayList<>();
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
                    HotelMock h = new HotelMock(rs.getInt("nr"), rs.getInt("type"), rs.getInt("gym"), rs.getInt("spa"), 
                        rs.getInt("pool"), rs.getInt("hottub"), rs.getInt("wifi"), rs.getInt("conference"), 
                        rs.getInt("restaurant"), rs.getInt("bar"), rs.getInt("inclusive"), rs.getInt("breakfast"), 
                        rs.getInt("cancellation"), rs.getInt("roomservice"), rs.getInt("wheelchair"), 
                        rs.getInt("elevator"), rs.getInt("flybus"), rs.getInt("stars"), rs.getInt("areacode"),
                        rs.getString("name"), rs.getString("address"), rs.getString("website"),
                        getRooms(rs.getInt("nr")));
                    hotels.add(h);
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        return hotels; 
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
	
}