package hotel3h;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelDatabaseManager {
	

	
	public  HotelDatabaseManager(){
		
		
	}
	
	 private static Connection connect() {
	        Connection conn = null;
	        try {
	            // db parameters
	            String url = "jdbc:sqlite:C://Users/Soley/SQLite/hoteltest9.db";
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	        
	  
	    }
	 
	 public ArrayList<Room> searchRooms(int hnr, int pets,
			 int washing, int kitchen, int minifridge, int tv,
			 int bath, int view, int noise, int smoke, int ac, 
			 int minPrice, int maxPrice, int minSize, int maxSize,
			 int bed1, int bed2, int baby){
		 
		 	
		 			
		 		ArrayList<Room> rooms = new ArrayList<>();
	        String sql ;
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
	 
	 public ArrayList<Hotel> searchHotels(int type,
			 int gym, int spa, int pool, int hottub, 
			 int wifi, int conference, int restaurant,
			 int bar, int inclusive, int breakfast,
			 int cancellation, int roomService, int wheelChair,
			 int elevator, int flyBus){
		 
		 	
		 			
		 		ArrayList<Hotel> hotels = new ArrayList<>();
	        String sql ;
        System.out.println("Komin í línu 94");
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
	System.out.println("Komin í línu 106");
                        
	        
	        try (Connection conn = connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	System.out.println("Komin í línu 112");     
        
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
	System.out.print("Komin í línu 125");
                    
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	   
	        return hotels;
	      
	    }
	    
	 
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