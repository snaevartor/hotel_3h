package hotel3h;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit Test class for SearchManager
 *
 * @author Snaevar
 */
public class SearchManagerTest {
    
    public SearchManagerTest() {
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
     * Test of searchHotel method, of class SearchManager.
     */
    @Test
    public void testSearchHotel() {
        System.out.println("searchHotel");
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
        //HotelGUI search values
        int minPrice = 0;
        int maxPrice = 1000000;
        int minSize = 0;
        int maxSize = 1000000;
        int minBeds = 0;
        
        int[] searchManagerArray = {type, gym, spa, pool, hottub, wifi, conference, restaurant, bar, inclusive, breakfast, cancellation, roomService, wheelChair, elevator, flyBus, minPrice, maxPrice, minSize, maxSize, minBeds};
        
        HotelDatabaseManager hotelInstance = new HotelDatabaseManager();
        ArrayList<Hotel> hotelList = hotelInstance.searchHotels(type, gym, spa, pool, hottub, wifi, conference, restaurant, bar, inclusive, breakfast, cancellation, roomService, wheelChair, elevator, flyBus);
//        ArrayList<Hotel> hotelList = Hotel();
//        SearchManager instance = null;
        SearchManager instance = new SearchManager(searchManagerArray);

//        ArrayList<Hotel> expResult = null;
        String[] expResult = {"Hilton Reykjavík Nordica","Kerlingarfjöll Mountain Resort"};
        ArrayList<Hotel> testResult = instance.searchHotel();
        String[] result = {testResult.get(0).getName(),testResult.get(9).getName()};
        
//        System.out.println(expResult);
//        System.out.println(testResult);
//        System.out.println(testResult.get(0).getName());
//        System.out.println(testResult.get(9).getName());
//        assertEquals(expResult, result);
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of searchHotelName method, of class SearchManager.
     */
    @Test
    public void testSearchHotelName() {
        System.out.println("searchHotelName");

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
        //HotelGUI search values
        int minPrice = 0;
        int maxPrice = 1000000;
        int minSize = 0;
        int maxSize = 1000000;
        int minBeds = 0;
        
        int[] searchManagerArray = {type, gym, spa, pool, hottub, wifi, conference, restaurant, bar, inclusive, breakfast, cancellation, roomService, wheelChair, elevator, flyBus, minPrice, maxPrice, minSize, maxSize, minBeds};

        //TODO: May need to set different conditions / inputs
        SearchManager instance = new SearchManager(searchManagerArray);
        
        String[] expResult = {null,"Hilton Reykjavík Nordica","Icelandair hótel Reykjavík Natura","Hótel Klettur","Hótel Vellir","Hotel Ódinsvé","Reykjavik Residence Apartment Hotel","Black Pearl Apartment Hotel","Diamond Suites","Hótel Bifröst"};        
        String[] result = instance.searchHotelName();        

        assertArrayEquals(expResult, result);
        //searches for room size
    }

//    /**
//     * Test of listForRoomSearch method, of class SearchManager.
//     */
//    @Test
//    public void testListForRoomSearch() {
//        System.out.println("listForRoomSearch");
//        int hnr = 0;
//        int minPrice = 0;
//        int maxPrice = 0;
//        int minSize = 0;
//        int maxSize = 0;
//        SearchManager instance = null;
//        int[] expResult = null;
//        int[] result = instance.listForRoomSearch(hnr, minPrice, maxPrice, minSize, maxSize);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
//    /**
//     * Test of searchForRooms method, of class SearchManager.
//     */
//    @Test
//    public void testSearchForRooms() {
//        System.out.println("searchForRooms");
//        HotelDatabaseManager hdm = null;
//        ArrayList<Hotel> h = null;
//        SearchManager instance = null;
//        instance.searchForRooms(hdm, h);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
