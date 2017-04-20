package hotel3h;

/**
 *
 * @author Helgi
 */

import hotel3h.Room;

public class Booking {

	    private String name, address, email;
	    private int phonenr, cardnr;
            private Hotel h;
            private Room r;
	    private int dateFrom, dateTo;
	  
	    public Booking(String name, String address, String email, int phonenr, int cardnr, Hotel h, Room r, int dateFrom,
				int dateTo) {
			this.name = name;
			this.address = address;
			this.email = email;
			this.phonenr = phonenr;
			this.cardnr = cardnr;
                        this.h = h;
			this.r = r;
			this.dateFrom = dateFrom;
			this.dateTo = dateTo;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getPhonenr() {
			return phonenr;
		}
		public void setPhonenr(int phonenr) {
			this.phonenr = phonenr;
		}
		public int getCardnr() {
			return cardnr;
		}
		public void setCardnr(int cardnr) {
			this.cardnr = cardnr;
		}
		public Room getRoom() {
			return r;
		}
		public void setRoom(Room r) {
			this.r = r;
		}
                public Hotel getHotel(){
                    return h;
                }
                public void setHotel(Hotel h){
                    this.h = h;
                }
		public int getDateFrom() {
			return dateFrom;
		}
		public void setDateFrom(int dateFrom) {
			this.dateFrom = dateFrom;
		}
		public int getDateTo() {
			return dateTo;
		}
		public void setDateTo(int dateTo) {
			this.dateTo = dateTo;
		}

}

