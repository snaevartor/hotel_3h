/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel3h;

/**
 *
 * @author opnob
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BookingManager {	
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:src/sql/hotel.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
//            System.out.println("Connection to SQLite has been established.");        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;        
    }
    //Tekur inn nafn 
    public int book(String name, int date1, int date2, int cardnr, int roomnr, int hotelnr) throws SQLException{    
        String sql1 = "INSERT INTO Booking VALUES (NULL,\'" + name + "\'," + date1 + "," + date2 + "," +cardnr + ","
                + roomnr + ",0," + hotelnr + ");";
	String sql2 = "SELECT nr FROM Booking ORDER BY nr DESC LIMIT 1;";
        int nr = 0;
        try (Connection conn = connect();
            Statement stmt  = conn.createStatement();
            Statement stmt2 = conn.createStatement();
        ){
            stmt.executeUpdate(sql1);
            ResultSet rs = stmt2.executeQuery(sql2);
            nr = rs.getInt("nr");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return nr;
    }
    
    public int getSqlDate(int[] date){
        String num = "" + check(date[0]) + check(date[1]) + date[2];
        return Integer.parseInt(num);
    }

    
    private String check(int i){
        if (i < 10) return "0" + i;
        else return Integer.toString(i);
    }
    
    private int getIntDate(int[] date){

        String num = date[2] + check(date[1]) + check(date[0]);
        return Integer.parseInt(num);
    }
	
    private int getIntDate(int date){
        String tmp = Integer.toString(date);
        if (tmp.length() != 6) tmp = "0" + tmp;
        String ret = tmp.substring(4) + tmp.substring(2, 4) + tmp.substring(0, 2);
        return Integer.parseInt(ret);
    }

    private boolean isOverlapping(int date1, int date2, int dateFrom, int dateTo){
        if((date1 > dateFrom && date1 < dateTo) || (date2 > dateFrom && date1 < dateTo))
            return true;
        if((dateFrom > date1 && dateFrom < date2) || (dateTo > date1 && dateTo < date2))
            return true;	
        return false;		
    }
    //Gáir hvort ákveðið herbergi sé laust á milli tveggja dagsetninga, skilar true ef svo er, false annars
    public boolean isAvailable(int hotelnr, int roomnr, int[] dateFromArray, int[] dateToArray){
        String sql = "SELECT * FROM BOOKING WHERE hotelnr = " + hotelnr + " AND roomnr = " + roomnr;
        int dateFrom = getIntDate(dateFromArray);
        int dateTo = getIntDate(dateToArray);
        try (Connection conn = connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){		 
            while (rs.next()) {
                int date1 = getIntDate(rs.getInt("dateFrom"));
                int date2 = getIntDate(rs.getInt("dateTo"));
                if(isOverlapping(date1, date2, dateFrom, dateTo))
                    return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

	public String getBookingStringInfo(int nr){
            String sql1 = "SELECT * FROM Booking WHERE nr = " + nr;
            String name = "";
            try (Connection conn = connect();
            Statement stmt  = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql1)){
		 
           name = rs.getString("name");
          
            
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
            return name;
        }
        
        
        public Booking getBooking(int nr){
            String sql1 = "SELECT * FROM Booking WHERE nr = " + nr;
            HotelDatabaseManager hdbm = new HotelDatabaseManager();
            int dateFrom = 0, dateTo = 0, cardnr = 0, phonenr = 0, roomnr = 0, hotelnr = 0, cancel = 0;
            Hotel h;
            Room r;
            String name = "", address= "", email = "", hotelName, hotelAddress, hotelWebsite;
            try (Connection conn = connect();
            Statement stmt  = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql1)){
                
           name = rs.getString("name");
           address = rs.getString("address");
           email = rs.getString("email");
           dateFrom = rs.getInt("dateFrom");
           dateTo = rs.getInt("dateTo");
           cardnr = rs.getInt("cardnr");
           phonenr = rs.getInt("phonenr");
           roomnr = rs.getInt("roomnr");
           cancel = rs.getInt("cancel");
           hotelnr = rs.getInt("hotelnr");
          
            
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
         r = hdbm.getRoomObject(hotelnr, roomnr);
         h = hdbm.getHotelObject(hotelnr);
     
            Booking b = new Booking(name, address, email, phonenr, cardnr, h, r, dateFrom, dateTo);
           return b;
        }
        
        public String[] getHotelStringInfo(int nr){
             String sql1 = "SELECT * FROM Hotel WHERE nr = " + nr;
             String[] info = new String[3];
              try (Connection conn = connect();
                    Statement stmt  = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql1)){
                  info[0] = rs.getString("name");
                  info[1] = rs.getString("address");
                  info[2] = rs.getString("website");
              } catch (SQLException e) {
                 System.out.println(e.getMessage());
        }
              
              return info;
        }
		 

	
    public void cancel(int bookingnr){
        String sql1 = "DELETE FROM Booking WHERE nr = " + bookingnr + ";";
        try (Connection conn = connect();
        Statement stmt  = conn.createStatement();){	 

            stmt.executeUpdate(sql1);
			
			
} catch (SQLException e) {
System.out.println(e.getMessage());
}

}
	
}

    
