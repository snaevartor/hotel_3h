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
    
    //TODO: More tests involving invalid inputs (for example, trying to process an incorrect class / list type)
    //and empty lists. Create more diverse tests and ensure that the tests make sense.
    
    //TODO: Incorporate testing of sorting functionality via HotelListaVinnsla.java class.
    //Question of whether to add said test via function calls in this class
    //or whether to create a test class for HotelListaVinnsla.java
    
    //TODO: Create mock objects and documentation for the unit tests.

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
        SearchManager instance = new SearchManager(searchManagerArray);

        String[] expResult = {"Hilton Reykjavík Nordica","Kerlingarfjöll Mountain Resort"};
        ArrayList<Hotel> testResult = instance.searchHotel();
        String[] result = {testResult.get(0).getName(),testResult.get(9).getName()};
        
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

        //Searches for room size
        //TODO: May need to set different conditions / inputs
        SearchManager instance = new SearchManager(searchManagerArray);
        
        String[] expResult = {null,"Hilton Reykjavík Nordica","Icelandair hótel Reykjavík Natura","Hótel Klettur","Hótel Vellir","Hotel Ódinsvé","Reykjavik Residence Apartment Hotel","Black Pearl Apartment Hotel","Diamond Suites","Hótel Bifröst"};        
        String[] result = instance.searchHotelName();        

        assertArrayEquals(expResult, result);
    }
    
}
