package hotel3h;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Snaevar
 */
public class HotelDatabaseManagerTest {
    
    public HotelDatabaseManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of searchRooms method, of class HotelDatabaseManager.
     */
    @Test
    public void testSearchRooms() {
        System.out.println("searchRooms");
        int hnr = 1;
        int pets = 0;
        int washing = 0;
        int kitchen = 0;
        int minifridge = 0;
        int tv = 0;
        int bath = 0;
        int view = 0;
        int noise = 0;
        int smoke = 0;
        int ac = 0;
        int minPrice = 0;
        int maxPrice = 0;
        int minSize = 0;
        int maxSize = 0;
        int bed1 = 0;
        int bed2 = 0;
        int baby = 0;
        HotelDatabaseManager instance = new HotelDatabaseManager();
        ArrayList<Room> expResult = new ArrayList<>();
//        ArrayList<Room> expResult = null;
        ArrayList<Room> result = instance.searchRooms(hnr, pets, washing, kitchen, minifridge, tv, bath, view, noise, smoke, ac, minPrice, maxPrice, minSize, maxSize, bed1, bed2, baby);
        assertEquals(expResult, result);
    }
    
    /**
     * Test 2 of searchRooms method, of class HotelDatabaseManager.
     */
    @Test
    public void testSearchRooms2() {
        System.out.println("searchRooms2");
        int hnr = 1;
        int pets = 0;
        int washing = 0;
        int kitchen = 0;
        int minifridge = 0;
        int tv = 0;
        int bath = 0;
        int view = 0;
        int noise = 0;
        int smoke = 0;
        int ac = 0;
        int minPrice = 0;
        int maxPrice = 50;
        int minSize = 0;
        int maxSize = 0;
        int bed1 = 1;
        int bed2 = 0;
        int baby = 0;
        HotelDatabaseManager instance = new HotelDatabaseManager();
        ArrayList<Room> expResult = new ArrayList<>();
//        ArrayList<Room> expResult = null;
        ArrayList<Room> result = instance.searchRooms(hnr, pets, washing, kitchen, minifridge, tv, bath, view, noise, smoke, ac, minPrice, maxPrice, minSize, maxSize, bed1, bed2, baby);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of searchHotels method, of class HotelDatabaseManager.
     */
    @Test
    public void testSearchHotels() {
        System.out.println("searchHotels");
        int type = 0;
        int gym = 0;
        int spa = 0;
        int pool = 0;
        int hottub = 0;
        int wifi = 0;
        int conference = 0;
        int restaurant = 0;
        int bar = 0;
        int inclusive = 0;
        int breakfast = 0;
        int cancellation = 0;
        int roomService = 0;
        int wheelChair = 0;
        int elevator = 0;
        int flyBus = 0;
        HotelDatabaseManager instance = new HotelDatabaseManager();

        boolean expResult = false;
        ArrayList<Hotel> testResult = instance.searchHotels(type, gym, spa, pool, hottub, wifi, conference, restaurant, bar, inclusive, breakfast, cancellation, roomService, wheelChair, elevator, flyBus);        
        boolean result = testResult.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHotelStringInfo method, of class HotelDatabaseManager.
     */
    @Test
    public void testGetHotelStringInfo() {
        System.out.println("getHotelStringInfo");
        int nr = 1;
        //Equivalence classes note: 0 does not refer to any hotel in database, starts counting from 1.
        HotelDatabaseManager instance = new HotelDatabaseManager();
        //Reference: INSERT INTO Hotel VALUES (NULL,"Hilton Reykjavík Nordica", "Suðurlandsbraut 2",4,108, "www.hiltonreykjavik.com");
//        String[] expResult = {null, null, null};
        String[] expResult = {"Hilton Reykjavík Nordica","Suðurlandsbraut 2","www.hiltonreykjavik.com"};
        String[] result = instance.getHotelStringInfo(nr);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getHotelIntInfo method, of class HotelDatabaseManager.
     */
    @Test
    public void testGetHotelIntInfo() {
        System.out.println("getHotelIntInfo");
        int nr = 1;
        HotelDatabaseManager instance = new HotelDatabaseManager();
        int[] expResult = {4,108};
        int[] result = instance.getHotelIntInfo(nr);
        assertArrayEquals(expResult, result);
    }
    
}
