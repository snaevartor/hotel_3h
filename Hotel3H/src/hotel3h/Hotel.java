package hotel3h;

import java.util.ArrayList;

public class Hotel implements Comparable<Hotel>{
 

	int nr, type, gym, spa, pool, hottub, wifi, conference, restaurant, bar, inclusive, breakfast, cancellation, roomservice, wheelchair, elevator, flybus, stars, areacode;
	String name, address, website;
	ArrayList<Room> rooms;
	public Hotel(
                int nr,
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
                int roomservice,
                int wheelchair,
		int elevator,
                int flybus,
                int stars,
                int areacode, 
		String name,
                String address,
                String website,
                ArrayList<Room> rooms
        ){
            this.nr = nr;
            this.type = type;
            this.gym = gym;
            this.spa = spa;
            this.pool = pool;
            this.hottub = hottub;
            this.wifi = wifi;
            this.conference = conference;
            this.restaurant = restaurant;
            this.bar = bar;
            this.inclusive = inclusive;
            this.breakfast = breakfast;
            this.cancellation = cancellation;
            this.roomservice = roomservice;
            this.wheelchair = wheelchair;
            this.elevator = elevator;
            this.flybus = flybus;
            this.rooms = rooms;
            this.stars = stars;
            this.areacode = areacode;
            this.name = name;
            this.address = address;
            this.website = website;
        }

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getAreacode() {
		return areacode;
	}

	public void setAreacode(int areacode) {
		this.areacode = areacode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getGym() {
		return gym;
	}

	public void setGym(int gym) {
		this.gym = gym;
	}

	public int getSpa() {
		return spa;
	}

	public void setSpa(int spa) {
		this.spa = spa;
	}

	public int getPool() {
		return pool;
	}

	public void setPool(int pool) {
		this.pool = pool;
	}

	public int getHottub() {
		return hottub;
	}

	public void setHottub(int hottub) {
		this.hottub = hottub;
	}

	public int getWifi() {
		return wifi;
	}

	public void setWifi(int wifi) {
		this.wifi = wifi;
	}

	public int getConference() {
		return conference;
	}

	public void setConference(int conference) {
		this.conference = conference;
	}

	public int getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(int restaurant) {
		this.restaurant = restaurant;
	}

	public int getBar() {
		return bar;
	}

	public void setBar(int bar) {
		this.bar = bar;
	}

	public int getInclusive() {
		return inclusive;
	}

	public void setInclusive(int inclusive) {
		this.inclusive = inclusive;
	}

	public int getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(int breakfast) {
		this.breakfast = breakfast;
	}

	public int getCancellation() {
		return cancellation;
	}

	public void setCancellation(int cancellation) {
		this.cancellation = cancellation;
	}

	public int getRoomservice() {
		return roomservice;
	}

	public void setRoomservice(int roomservice) {
		this.roomservice = roomservice;
	}

	public int getWheelchair() {
		return wheelchair;
	}

	public void setWheelchair(int wheelchair) {
		this.wheelchair = wheelchair;
	}

	public int getElevator() {
		return elevator;
	}

	public void setElevator(int elevator) {
		this.elevator = elevator;
	}

	public int getFlybus() {
		return flybus;
	}

	public void setFlybus(int flybus) {
		this.flybus = flybus;
	}

	public ArrayList<Room> getRooms(){
		return rooms;
	}
	
	public void setRooms(ArrayList<Room> rooms){
		this.rooms = rooms;
	}
        
        public int getMinPrice(){
            int min = getRooms().get(0).getPrice();
            for(Room r: getRooms()){
                if(r.getPrice()<min){
                    min = r.getPrice();
                }
            }
            return min;
        }
        
        public int getMaxPrice(){
            int max = getRooms().get(0).getPrice();
            for(Room r: getRooms()){
                if(r.getPrice()>max){
                    max = r.getPrice();
                }
            }
            return max;
        }
	
        public int getMaxBeds(){
            int max = getRooms().get(0).getCount();
            for(Room r: getRooms()){
                if(r.getCount()>max){
                    max = r.getCount();
                }
            }
            return max;
        }
        
        public int getMinBeds(){
            int min = getRooms().get(0).getCount();
            for(Room r: getRooms()){
                if(r.getCount()<min){
                    min = r.getCount();
                }
            }
            return min;
        }
        
        public int getMinSize(){
            int min = getRooms().get(0).getSize();
            for(Room r: getRooms()){
                if(r.getSize()<min){
                    min = r.getSize();
                }
            }
            return min;
        }
        
        public int getMaxSize(){
            int max = getRooms().get(0).getSize();
            for(Room r: getRooms()){
                if(r.getSize()>max){
                    max = r.getSize();
                }
            }
            return max;
        }

    @Override
    public int compareTo(Hotel o) {
        if(this.getMinPrice()<o.getMinPrice()){
            return -1;
        }
        else{
            return 1;
        }
    }

}