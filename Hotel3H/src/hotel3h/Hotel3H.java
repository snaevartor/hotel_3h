/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel3h;
import java.sql.*;

/**
 *
 * @author Snaevar
 */
public class Hotel3H {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hotel 3H - Java/SQL Interface");
        Connection c = null;
        Statement stmt = null;
        try {
            //c.setAutoCommit(false);
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/sql/hotel3h.db");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Hotels;" );
            
            System.out.println("ID - Name - Type - Stars - Country - City - Rooms - HasPool");
            
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String type = rs.getString("Type");
                int stars = rs.getInt("Stars");
                String country = rs.getString("Country");
                String city = rs.getString("City");
                int rooms = rs.getInt("Rooms");
                boolean haspool = rs.getBoolean("HasPool");
                System.out.println(id + " | " + name + " | " + type + " | " + stars + " | " + country + " | " + city + " | " + rooms + " | " + haspool);
            }
            
            rs.close();
            stmt.close();
            c.close(); 
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    System.out.println("Opened database successfully");
    }
    
}
