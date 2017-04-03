PRAGMA foreign_keys = ON;

BEGIN TRANSACTION;

/* DROP TABLE IF EXISTS */
DROP TABLE IF EXISTS Available;
DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS RoomSearch;
DROP TABLE IF EXISTS HotelSearch;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Hotel;

CREATE TABLE Hotel (
	nr integer PRIMARY KEY AUTOINCREMENT,
	name varchar(50),
	address varchar(50),
	stars int,
	areacode int,
	website varchar(50)
);

CREATE TABLE HotelSearch (
	nr integer PRIMARY KEY REFERENCES Hotel(nr),
	type int,
	gym boolean,
	spa boolean,
	pool boolean,
	hottub boolean,
	wifi boolean,
	conference boolean,
	restaurant boolean,
	bar boolean,
	inclusive boolean,
	breakfast boolean,
	cancellation boolean,
	roomservice boolean,
	wheelchair boolean,
	elevator boolean,
	flybus boolean
);

CREATE TABLE Room (
	nr int,
	hotelnr integer REFERENCES Hotel(nr),
	price int,
	size int,
	bed1 int,
	bed2 int,
	baby boolean,
	PRIMARY KEY (nr, hotelnr)
);

CREATE TABLE RoomSearch (
	nr int,
	hnr integer,
	pets boolean,
	count int,
	washing boolean,
	kitchen boolean,
	minifridge boolean,
	tv boolean,
	bath boolean,
	view boolean,
	noise boolean,
	level int,
	nextleft int,
	nextright int,
	smoke boolean,
	ac boolean,
	FOREIGN KEY (nr,hnr) REFERENCES Room(nr, hotelnr)
);

CREATE TABLE Booking(
	nr integer PRIMARY KEY AUTOINCREMENT,
	name varchar(50),
	dateFrom int,
        dateTo int,
	cardnr int,
	roomnr int,
	hotelnr integer REFERENCES Hotel(nr)
);
CREATE TABLE Available(
	roomnr int,
	hotelnr integer REFERENCES Hotel(nr),
	date int,
	booked boolean,
	bookingnr integer PRIMARY KEY REFERENCES Booking(nr)
);

/*---HOTELS---*/
/*NULL, Name, Address, Stars, AreaCode, Website.*/

INSERT INTO Hotel VALUES (NULL,"Hilton Reykjavík Nordica", "Suðurlandsbraut 2",4,108, "www.hiltonreykjavik.com");
INSERT INTO Hotel VALUES (NULL,"Icelandair hótel Reykjavík Natura", "Nauthólsvegi 52",4,101, "www.icelandairhotels.com/en/hotels/natura");
INSERT INTO Hotel VALUES (NULL,"Hótel Klettur", "Mjölnisholti 12-14",4,101, "www.hotelklettur.is");
INSERT INTO Hotel VALUES (NULL,"Hótel Vellir", "Tjarnarvöllum 3",3,221, "www.hotelvellir.com");
INSERT INTO Hotel VALUES (NULL,"Hotel Ódinsvé", "Thorsgata 1, 101 Reykjavík, Iceland",4,101, "www.hotelodinsve.com");
INSERT INTO Hotel VALUES (NULL,"Reykjavik Residence Apartment Hotel", "Hverfisgata 45, 101 Reykjavík, Iceland",4,101, "www.reykjavikresidenceapthotel.is");
INSERT INTO Hotel VALUES (NULL,"Black Pearl Apartment Hotel", "Tryggvagata 18, 101 Reykjavík, Iceland",5,101, "www.blackpearl.is");
INSERT INTO Hotel VALUES (NULL,"Diamond Suites", "Vatnsnesvegur 12-14, 230 Keflavík, Iceland",5,230, "www.diamondsuites.is");
INSERT INTO Hotel VALUES (NULL,"Hótel Bifröst", "Hamragardar, 311 Bifrost, Iceland",2,311, "www.hotelbifrost.is");
INSERT INTO Hotel VALUES (NULL,"Kerlingarfjöll Mountain Resort", "Kerlingarfjöll, 801 Kerlingarfjoll, Iceland",1,801, "www.kfmountainresort.is");

/*---ROOM---*/

/*---hilton reykjavik nordica (4)---*/
INSERT INTO Room VALUES (101,1,25,400,2,0,1);
INSERT INTO Room VALUES (102,1,25,400,2,0,1);
INSERT INTO Room VALUES (103,1,25,400,2,0,1);
INSERT INTO Room VALUES (104,1,25,400,2,0,1);
INSERT INTO Room VALUES (201,1,20,300,0,1,1);
INSERT INTO Room VALUES (202,1,20,300,0,1,1);
INSERT INTO Room VALUES (203,1,20,300,0,1,1);
INSERT INTO Room VALUES (204,1,20,300,0,1,1);
INSERT INTO Room VALUES (301,1,40,560,2,1,1);
INSERT INTO Room VALUES (302,1,40,560,2,1,1);
INSERT INTO Room VALUES (303,1,40,560,2,1,1);
INSERT INTO Room VALUES (304,1,40,560,2,1,1);

/*---idelandair hotel reykjavik natura (4)---*/
INSERT INTO Room VALUES (101,2,30,400,2,0,0);
INSERT INTO Room VALUES (102,2,30,400,2,0,0);
INSERT INTO Room VALUES (103,2,30,400,2,0,1);
INSERT INTO Room VALUES (201,2,25,300,1,0,0);
INSERT INTO Room VALUES (202,2,25,300,1,0,0);
INSERT INTO Room VALUES (203,2,25,300,1,0,0);
INSERT INTO Room VALUES (204,2,25,300,1,0,0);
INSERT INTO Room VALUES (301,2,50,600,2,2,1);
INSERT INTO Room VALUES (302,2,50,600,2,2,1);
INSERT INTO Room VALUES (303,2,55,650,2,2,1);
INSERT INTO Room VALUES (304,2,60,700,2,2,0);

/*---hotel klettur (4)---*/
INSERT INTO Room VALUES (101,3,18,350,2,0,0);
INSERT INTO Room VALUES (102,3,20,350,2,1,0);
INSERT INTO Room VALUES (103,3,30,420,2,1,1);
INSERT INTO Room VALUES (104,3,30,420,2,1,1);
INSERT INTO Room VALUES (201,3,22,300,1,0,0);
INSERT INTO Room VALUES (202,3,25,340,2,0,1);
INSERT INTO Room VALUES (203,3,25,340,2,0,1);
INSERT INTO Room VALUES (204,3,25,340,2,0,1);
INSERT INTO Room VALUES (301,3,55,700,2,2,1);
INSERT INTO Room VALUES (302,3,55,700,2,2,1);
INSERT INTO Room VALUES (303,3,62,750,2,2,1);

/*---hotel vellir (3)---*/
INSERT INTO Room VALUES (101,4,16,240,1,0,0);
INSERT INTO Room VALUES (102,4,16,240,1,0,0);
INSERT INTO Room VALUES (103,4,18,260,2,0,0);
INSERT INTO Room VALUES (104,4,20,280,2,0,1);
INSERT INTO Room VALUES (201,4,24,300,2,0,1);
INSERT INTO Room VALUES (202,4,24,320,2,0,1);
INSERT INTO Room VALUES (203,4,26,340,2,0,1);
INSERT INTO Room VALUES (204,4,26,340,2,1,1);
INSERT INTO Room VALUES (301,4,34,440,2,1,0);
INSERT INTO Room VALUES (302,4,34,440,2,2,1);
INSERT INTO Room VALUES (303,4,40,500,2,2,1);
INSERT INTO Room VALUES (401,4,46,600,2,2,1);

/*---hotel odinsve (4)---*/
INSERT INTO Room VALUES (101,5,26,300,1,0,0);
INSERT INTO Room VALUES (102,5,26,300,1,1,0);
INSERT INTO Room VALUES (103,5,26,300,2,1,0);
INSERT INTO Room VALUES (104,5,26,300,2,1,1);
INSERT INTO Room VALUES (201,5,21,400,2,0,1);
INSERT INTO Room VALUES (202,5,21,400,2,0,1);
INSERT INTO Room VALUES (203,5,21,400,2,1,1);
INSERT INTO Room VALUES (204,5,21,400,2,1,1);
INSERT INTO Room VALUES (301,5,38,560,2,2,1);
INSERT INTO Room VALUES (302,5,38,560,2,2,1);
INSERT INTO Room VALUES (401,5,38,560,2,2,1);
INSERT INTO Room VALUES (402,5,38,560,2,2,1);

/*---reykjavik residence apartment hotel (4)---*/
INSERT INTO Room VALUES (101,6,26,420,2,0,0);
INSERT INTO Room VALUES (102,6,26,420,2,0,0);
INSERT INTO Room VALUES (103,6,30,430,2,0,1);
INSERT INTO Room VALUES (104,6,32,440,2,1,1);
INSERT INTO Room VALUES (201,6,40,500,2,1,1);
INSERT INTO Room VALUES (202,6,40,500,2,1,1);
INSERT INTO Room VALUES (203,6,40,500,2,1,1);
INSERT INTO Room VALUES (301,6,46,550,2,2,1);
INSERT INTO Room VALUES (302,6,46,550,2,2,1);
INSERT INTO Room VALUES (303,6,55,620,2,2,1);

/*---black pearl (5)---*/
INSERT INTO Room VALUES (101,7,30,400,2,1,1);
INSERT INTO Room VALUES (102,7,30,400,2,1,1);
INSERT INTO Room VALUES (103,7,30,400,2,1,1);
INSERT INTO Room VALUES (104,7,30,400,2,1,1);
INSERT INTO Room VALUES (201,7,35,500,2,1,1);
INSERT INTO Room VALUES (202,7,35,500,2,1,1);
INSERT INTO Room VALUES (203,7,40,560,2,1,1);
INSERT INTO Room VALUES (204,7,40,560,2,1,1);
INSERT INTO Room VALUES (301,7,60,720,2,2,1);
INSERT INTO Room VALUES (302,7,60,720,2,2,1);
INSERT INTO Room VALUES (303,7,72,800,2,2,1);
INSERT INTO Room VALUES (304,7,72,800,2,2,1);
INSERT INTO Room VALUES (305,7,72,800,2,2,1);
INSERT INTO Room VALUES (306,7,72,800,2,2,1);

/*---diamond suites (5)---*/
INSERT INTO Room VALUES (101,8,37,500,2,1,1);
INSERT INTO Room VALUES (102,8,37,500,2,1,1);
INSERT INTO Room VALUES (103,8,37,500,2,1,1);
INSERT INTO Room VALUES (104,8,37,500,2,1,1);
INSERT INTO Room VALUES (201,8,40,550,2,1,1);
INSERT INTO Room VALUES (202,8,40,550,2,1,1);
INSERT INTO Room VALUES (203,8,40,550,2,1,1);
INSERT INTO Room VALUES (204,8,40,550,2,1,1);
INSERT INTO Room VALUES (301,8,52,620,2,2,1);
INSERT INTO Room VALUES (302,8,52,620,2,2,1);
INSERT INTO Room VALUES (303,8,52,620,2,2,1);
INSERT INTO Room VALUES (304,8,52,620,2,2,1);
INSERT INTO Room VALUES (401,8,74,840,2,2,1);
INSERT INTO Room VALUES (402,8,74,840,2,2,1);
INSERT INTO Room VALUES (403,8,74,840,2,2,1);
INSERT INTO Room VALUES (404,8,74,840,2,2,1);

/*---hotel bifrost (2)---*/
INSERT INTO Room VALUES (101,9,12,200,1,0,0);
INSERT INTO Room VALUES (102,9,12,200,1,0,0);
INSERT INTO Room VALUES (103,9,12,200,1,0,0);
INSERT INTO Room VALUES (201,9,15,240,1,0,0);
INSERT INTO Room VALUES (202,9,16,240,2,0,1);
INSERT INTO Room VALUES (203,9,16,240,2,0,1);
INSERT INTO Room VALUES (301,9,18,300,2,0,1);
INSERT INTO Room VALUES (302,9,18,300,2,0,1);
INSERT INTO Room VALUES (303,9,20,320,2,1,1);

/*---kerlingarfjoll mountain resort (1)---*/
INSERT INTO Room VALUES (101,10,12,160,1,0,0);
INSERT INTO Room VALUES (102,10,12,160,1,0,0);
INSERT INTO Room VALUES (201,10,16,180,1,0,0);
INSERT INTO Room VALUES (202,10,18,180,2,0,0);
INSERT INTO Room VALUES (301,10,20,200,2,0,0);
INSERT INTO Room VALUES (302,10,20,200,2,1,0);
INSERT INTO Room VALUES (303,10,22,240,2,1,1);

/*---HOTELSEARCH---*/

INSERT INTO HotelSearch VALUES (1,2,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1);
INSERT INTO HotelSearch VALUES (2,1,1,0,0,1,1,1,1,1,0,1,0,1,1,1,1); 
INSERT INTO HotelSearch VALUES (3,1,0,1,0,0,1,1,1,1,0,1,0,1,1,1,1);
INSERT INTO HotelSearch VALUES (4,1,1,0,0,1,1,1,1,1,0,1,0,1,1,1,0);
INSERT INTO HotelSearch VALUES (5,1,1,0,0,1,1,1,1,1,0,1,0,1,1,1,1);
INSERT INTO HotelSearch VALUES (6,1,0,0,1,0,1,0,1,1,0,1,0,1,1,1,0);
INSERT INTO HotelSearch VALUES (7,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1);
INSERT INTO HotelSearch VALUES (8,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1);
INSERT INTO HotelSearch VALUES (9,1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,1);
INSERT INTO HotelSearch VALUES(10,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

/*---ROOMSEARCH---*/

/*---hilton reykjavik nordica (4)---*/
INSERT INTO RoomSearch VALUES (101,1,0,2,0,0,1,1,1,1,1,1,NULL,102,0,1);
INSERT INTO RoomSearch VALUES (102,1,0,2,0,0,1,1,1,1,1,1,101,103,0,1);
INSERT INTO RoomSearch VALUES (103,1,0,2,0,0,1,1,1,1,1,1,102,104,0,1);
INSERT INTO RoomSearch VALUES (104,1,0,2,0,0,1,1,1,1,1,1,103,NULL,0,1);
INSERT INTO RoomSearch VALUES (201,1,0,2,0,0,1,1,1,1,1,2,NULL,202,0,1);
INSERT INTO RoomSearch VALUES (202,1,0,2,0,0,1,1,1,1,1,2,201,203,0,1);
INSERT INTO RoomSearch VALUES (203,1,0,2,0,0,1,1,1,1,1,2,202,204,0,1);
INSERT INTO RoomSearch VALUES (204,1,0,2,0,0,1,1,1,1,1,2,203,NULL,0,1);
INSERT INTO RoomSearch VALUES (301,1,0,2,0,0,1,1,1,1,1,3,NULL,302,0,1);
INSERT INTO RoomSearch VALUES (302,1,0,2,0,0,1,1,1,1,1,3,301,303,0,1);
INSERT INTO RoomSearch VALUES (303,1,0,2,0,0,1,1,1,1,1,3,302,304,0,1);
INSERT INTO RoomSearch VALUES (304,1,0,2,0,0,1,1,1,1,1,3,303,NULL,0,1);

/*---idelandair hotel reykjavik natura (4)---*/
INSERT INTO RoomSearch VALUES (101,2,0,2,0,0,0,1,1,0,1,1,NULL,102,0,1);
INSERT INTO RoomSearch VALUES (102,2,0,2,0,0,0,1,1,0,1,1,101,103,0,1);
INSERT INTO RoomSearch VALUES (103,2,0,2,0,0,0,1,1,0,1,1,102,NULL,0,1);
INSERT INTO RoomSearch VALUES (201,2,0,2,0,0,1,1,1,0,1,2,NULL,202,0,1);
INSERT INTO RoomSearch VALUES (202,2,0,2,0,0,1,1,1,0,1,2,201,203,0,1);
INSERT INTO RoomSearch VALUES (203,2,0,2,0,0,1,1,1,0,1,2,202,204,0,1);
INSERT INTO RoomSearch VALUES (204,2,0,2,0,0,1,1,1,0,1,2,203,NULL,0,1);
INSERT INTO RoomSearch VALUES (301,2,0,2,0,1,1,1,1,0,1,3,NULL,302,0,1);
INSERT INTO RoomSearch VALUES (302,2,0,2,0,1,1,1,1,0,1,3,301,303,0,1);
INSERT INTO RoomSearch VALUES (303,2,1,3,1,1,1,1,1,1,1,3,302,304,1,1);
INSERT INTO RoomSearch VALUES (304,2,1,3,1,1,1,1,1,1,1,3,303,NULL,1,1);

/*---hotel klettur (4)---*/
INSERT INTO RoomSearch VALUES (101,3,0,2,0,0,0,0,0,0,0,1,NULL,102,0,1);
INSERT INTO RoomSearch VALUES (102,3,0,3,0,1,1,1,1,0,0,1,101,103,0,1);
INSERT INTO RoomSearch VALUES (103,3,0,3,0,1,1,1,1,0,1,1,102,104,0,1);
INSERT INTO RoomSearch VALUES (104,3,0,3,0,1,1,1,1,0,1,1,103,NULL,0,1);
INSERT INTO RoomSearch VALUES (201,3,0,1,0,1,1,1,1,0,1,2,NULL,202,0,1);
INSERT INTO RoomSearch VALUES (202,3,0,2,0,1,1,1,1,0,1,2,201,203,0,1);
INSERT INTO RoomSearch VALUES (203,3,0,2,0,1,1,1,1,0,1,2,202,204,0,1);
INSERT INTO RoomSearch VALUES (204,3,0,2,0,1,1,1,1,0,1,2,203,NULL,0,1);
INSERT INTO RoomSearch VALUES (301,3,0,5,1,1,1,1,1,1,1,3,NULL,302,0,1);
INSERT INTO RoomSearch VALUES (302,3,0,5,1,1,1,1,1,1,1,3,301,303,0,1);
INSERT INTO RoomSearch VALUES (303,3,0,5,1,1,1,1,1,1,1,3,302,NULL,0,1);

/*---hotel vellir (3)---*/
INSERT INTO RoomSearch VALUES (101,4,0,1,0,0,0,0,1,0,1,1,NULL,102,1,0);
INSERT INTO RoomSearch VALUES (102,4,0,1,0,0,0,1,1,0,1,1,101,103,1,0);
INSERT INTO RoomSearch VALUES (103,4,0,2,0,1,0,1,1,0,1,1,102,104,1,0);
INSERT INTO RoomSearch VALUES (104,4,0,3,0,1,0,1,1,0,1,1,103,NULL,0,1);
INSERT INTO RoomSearch VALUES (201,4,0,3,0,1,0,1,1,0,1,2,NULL,202,0,1);
INSERT INTO RoomSearch VALUES (202,4,0,3,0,1,0,1,1,0,1,2,201,203,0,1);
INSERT INTO RoomSearch VALUES (203,4,0,3,0,1,0,1,1,0,1,2,202,204,0,1);
INSERT INTO RoomSearch VALUES (204,4,0,4,0,1,1,1,1,0,1,2,203,NULL,0,1);
INSERT INTO RoomSearch VALUES (301,4,0,3,0,1,1,1,1,0,1,3,NULL,302,0,1);
INSERT INTO RoomSearch VALUES (302,4,0,5,1,1,1,1,1,1,1,3,301,303,0,1);
INSERT INTO RoomSearch VALUES (303,4,0,5,1,1,1,1,1,1,1,3,302,NULL,1,1);
INSERT INTO RoomSearch VALUES (401,4,0,5,1,1,1,1,1,1,1,4,NULL,NULL,1,1);

/*---hotel odinsve (4)---*/
INSERT INTO RoomSearch VALUES (101,5,1,1,0,1,0,1,0,0,1,1,NULL,102,1,1);
INSERT INTO RoomSearch VALUES (102,5,1,2,0,1,0,1,0,0,1,1,101,103,1,1);
INSERT INTO RoomSearch VALUES (103,5,1,3,0,1,0,1,0,0,1,1,102,104,1,1);
INSERT INTO RoomSearch VALUES (104,5,1,4,0,1,0,1,0,0,1,1,103,NULL,1,1);
INSERT INTO RoomSearch VALUES (201,5,1,3,1,1,1,1,1,0,1,2,NULL,202,1,1);
INSERT INTO RoomSearch VALUES (202,5,1,3,1,1,1,1,1,0,1,2,201,203,1,1);
INSERT INTO RoomSearch VALUES (203,5,1,4,1,1,1,1,1,0,1,2,202,204,1,1);
INSERT INTO RoomSearch VALUES (204,5,1,4,1,1,1,1,1,0,1,2,203,NULL,1,1);
INSERT INTO RoomSearch VALUES (301,5,0,5,1,1,1,1,1,1,1,3,NULL,302,1,1);
INSERT INTO RoomSearch VALUES (302,5,0,5,1,1,1,1,1,1,1,3,303,NULL,1,1);
INSERT INTO RoomSearch VALUES (401,5,1,5,1,1,1,1,1,1,1,4,NULL,402,1,1);
INSERT INTO RoomSearch VALUES (402,5,0,5,1,1,1,1,1,1,1,4,401,NULL,1,1);

/*---reykjavik residence apartment hotel (4)---*/
INSERT INTO RoomSearch VALUES (101,6,0,2,0,1,1,1,1,0,1,1,NULL,102,0,1);
INSERT INTO RoomSearch VALUES (102,6,0,2,0,1,1,1,1,0,1,1,101,103,0,1);
INSERT INTO RoomSearch VALUES (103,6,0,3,0,1,1,1,1,0,1,1,102,104,0,1);
INSERT INTO RoomSearch VALUES (104,6,0,4,0,1,1,1,1,0,1,1,103,NULL,0,1);
INSERT INTO RoomSearch VALUES (201,6,0,4,0,1,1,1,1,0,1,2,NULL,202,0,1);
INSERT INTO RoomSearch VALUES (202,6,0,4,0,1,1,1,1,0,1,2,201,203,0,1);
INSERT INTO RoomSearch VALUES (203,6,0,4,0,1,1,1,1,0,1,2,202,NULL,0,1);
INSERT INTO RoomSearch VALUES (301,6,0,5,0,1,1,1,1,1,1,3,NULL,302,0,1);
INSERT INTO RoomSearch VALUES (302,6,0,5,0,1,1,1,1,1,1,3,301,303,0,1);
INSERT INTO RoomSearch VALUES (303,6,0,5,1,1,1,1,1,1,1,3,302,NULL,0,1);

/*---black pearl (5)---*/
INSERT INTO RoomSearch VALUES (101,7,1,4,1,1,1,1,1,0,1,1,NULL,102,0,1);
INSERT INTO RoomSearch VALUES (102,7,1,4,1,1,1,1,1,0,1,1,101,103,0,1);
INSERT INTO RoomSearch VALUES (103,7,1,4,1,1,1,1,1,0,1,1,102,104,0,1);
INSERT INTO RoomSearch VALUES (104,7,1,4,1,1,1,1,1,0,1,1,103,NULL,0,1);
INSERT INTO RoomSearch VALUES (201,7,1,4,1,1,1,1,1,0,1,2,NULL,202,1,1);
INSERT INTO RoomSearch VALUES (202,7,1,4,1,1,1,1,1,0,1,2,201,203,1,1);
INSERT INTO RoomSearch VALUES (203,7,1,4,1,1,1,1,1,0,1,2,202,204,1,1);
INSERT INTO RoomSearch VALUES (204,7,1,4,1,1,1,1,1,0,1,2,203,NULL,1,1);
INSERT INTO RoomSearch VALUES (301,7,1,5,1,1,1,1,1,1,1,3,NULL,302,1,1);
INSERT INTO RoomSearch VALUES (302,7,1,5,1,1,1,1,1,1,1,3,301,303,1,1);
INSERT INTO RoomSearch VALUES (303,7,1,5,1,1,1,1,1,1,1,3,302,304,1,1);
INSERT INTO RoomSearch VALUES (304,7,1,5,1,1,1,1,1,1,1,3,303,305,1,1);
INSERT INTO RoomSearch VALUES (305,7,1,5,1,1,1,1,1,1,1,3,304,306,1,1);
INSERT INTO RoomSearch VALUES (306,7,1,5,1,1,1,1,1,1,1,3,305,NULL,1,1);

/*---diamond suites (5)---*/
INSERT INTO RoomSearch VALUES (101,8,1,4,0,1,1,1,1,0,1,1,NULL,102,0,1);
INSERT INTO RoomSearch VALUES (102,8,0,4,0,0,1,1,1,0,1,1,101,103,0,1);
INSERT INTO RoomSearch VALUES (103,8,1,4,1,1,1,1,1,0,1,1,102,104,0,1);
INSERT INTO RoomSearch VALUES (104,8,0,4,1,0,1,1,1,0,1,1,103,NULL,0,1);
INSERT INTO RoomSearch VALUES (201,8,1,4,0,1,1,1,1,0,1,2,NULL,202,0,1);
INSERT INTO RoomSearch VALUES (202,8,0,4,0,0,1,1,1,0,1,2,201,203,0,1);
INSERT INTO RoomSearch VALUES (203,8,1,4,1,0,1,1,1,0,1,2,202,204,0,1);
INSERT INTO RoomSearch VALUES (204,8,0,4,1,1,1,1,1,0,1,2,203,NULL,0,1);
INSERT INTO RoomSearch VALUES (301,8,1,5,0,1,1,1,1,1,1,3,NULL,302,0,1);
INSERT INTO RoomSearch VALUES (302,8,0,5,0,1,1,1,1,1,1,3,301,303,0,1);
INSERT INTO RoomSearch VALUES (303,8,1,5,1,1,1,1,1,1,1,3,302,304,0,1);
INSERT INTO RoomSearch VALUES (304,8,0,5,1,1,1,1,1,1,1,3,303,NULL,0,1);
INSERT INTO RoomSearch VALUES (401,8,1,5,0,1,1,1,1,1,1,4,NULL,402,0,1);
INSERT INTO RoomSearch VALUES (402,8,0,5,0,1,1,1,1,1,1,4,401,403,0,1);
INSERT INTO RoomSearch VALUES (403,8,1,5,1,1,1,1,1,1,1,4,402,404,0,1);
INSERT INTO RoomSearch VALUES (404,8,0,5,1,1,1,1,1,1,1,4,403,NULL,0,1);

/*---hotel bifrost (2)---*/
INSERT INTO RoomSearch VALUES (101,9,0,1,0,0,0,0,0,0,0,1,NULL,102,0,0);
INSERT INTO RoomSearch VALUES (102,9,0,1,0,0,0,0,0,0,0,1,101,103,0,0);
INSERT INTO RoomSearch VALUES (103,9,0,1,0,0,0,0,0,0,0,1,102,NULL,0,0);
INSERT INTO RoomSearch VALUES (201,9,1,1,0,0,0,0,1,0,0,2,NULL,202,0,0);
INSERT INTO RoomSearch VALUES (202,9,1,3,0,0,0,1,1,0,0,2,201,203,0,0);
INSERT INTO RoomSearch VALUES (203,9,1,3,1,0,0,0,1,0,0,2,202,NULL,0,0);
INSERT INTO RoomSearch VALUES (301,9,1,3,1,0,0,1,1,0,1,3,NULL,302,0,0);
INSERT INTO RoomSearch VALUES (302,9,1,3,0,1,0,0,1,1,0,3,301,303,0,1);
INSERT INTO RoomSearch VALUES (303,9,1,4,1,1,1,1,1,1,1,3,302,NULL,0,1);

/*---kerlingarfjoll mountain resort (1)---*/
INSERT INTO RoomSearch VALUES (101,10,1,1,0,0,0,0,0,0,0,1,NULL,102,1,0);
INSERT INTO RoomSearch VALUES (102,10,1,1,0,0,0,0,0,0,0,1,101,NULL,1,0);
INSERT INTO RoomSearch VALUES (201,10,1,1,0,0,0,0,0,0,0,2,NULL,202,1,0);
INSERT INTO RoomSearch VALUES (202,10,1,2,0,0,0,0,0,1,0,2,201,NULL,1,0);
INSERT INTO RoomSearch VALUES (301,10,0,2,0,0,0,0,0,1,0,3,NULL,302,1,0);
INSERT INTO RoomSearch VALUES (302,10,0,3,0,0,0,0,1,1,0,3,301,303,1,0);
INSERT INTO RoomSearch VALUES (303,10,0,4,0,0,0,1,1,1,0,3,302,NULL,1,0);

/*---BOOKING---*/

/*---hilton reykjavik nordica (4)---*/
INSERT INTO Booking VALUES(NULL,"Jón Jónsson",240617,NULL,101,1);
INSERT INTO Booking VALUES(NULL,"Jón Sveinsson",250617,NULL,101,1);
INSERT INTO Booking VALUES(NULL,"Heimir Jónsson",260617,NULL,101,1);
INSERT INTO Booking VALUES(NULL,"Haraldur Jónsson",270617,NULL,101,1);
INSERT INTO Booking VALUES(NULL,"Sveinn Karlsson",200617,NULL,302,1);
INSERT INTO Booking VALUES(NULL,"Karl Karlsson",210617,NULL,302,1);

/*---idelandair hotel reykjavik natura (4)---*/
INSERT INTO Booking VALUES(NULL,"Daði Grímsson",270917,NULL,102,2);
INSERT INTO Booking VALUES(NULL,"John Smith",200717,NULL,203,2);
INSERT INTO Booking VALUES(NULL,"Grant Wells",210318,NULL,304,2);

/*---hotel klettur (4)---*/
INSERT INTO Booking VALUES(NULL,"Dan Rather",260817,NULL,101,3);
INSERT INTO Booking VALUES(NULL,"Jim Piddock",300118,NULL,102,3);
INSERT INTO Booking VALUES(NULL,"Greinir Jónsson",240518,NULL,103,3);
INSERT INTO Booking VALUES(NULL,"Blake Edwards",260917,NULL,202,3);

/*---hotel vellir (3)---*/
INSERT INTO Booking VALUES(NULL,"Nína Völudóttir",250318,NULL,204,4);
INSERT INTO Booking VALUES(NULL,"Raymon Carver",260618,NULL,302,4);
INSERT INTO Booking VALUES(NULL,"Jane Doe",270918,NULL,303,4);

/*---hotel odinsve (4)---*/
INSERT INTO Booking VALUES(NULL,"Jónína Jóns",011217,NULL,302,5);
INSERT INTO Booking VALUES(NULL,"Lee Mack",101118,NULL,203,5);

/*---reykjavik residence apartment hotel (4)---*/
INSERT INTO Booking VALUES(NULL,"Ken Curry",280419,NULL,101,6);
INSERT INTO Booking VALUES(NULL,"Sadie Cobb",130217,NULL,104,6);
INSERT INTO Booking VALUES(NULL,"Lloyd Butler",170717,NULL,203,6);
INSERT INTO Booking VALUES(NULL,"Dolores Fletcher",191020,NULL,303,6);

/*---black pearl (5)---*/
INSERT INTO Booking VALUES(NULL,"Joann Campbell",020518,NULL,304,7);
INSERT INTO Booking VALUES(NULL,"Randall Hunter",230617,NULL,305,7);

/*---diamond suites (5)---*/
INSERT INTO Booking VALUES(NULL,"Gregory Wallace",220518,NULL,101,8);
INSERT INTO Booking VALUES(NULL,"Sergio Gutierrez",250319,NULL,202,8);
INSERT INTO Booking VALUES(NULL,"Greg Stone",291117,NULL,302,8);
INSERT INTO Booking VALUES(NULL,"Glenda Lewis",071021,NULL,401,8);

/*---hotel bifrost (2)---*/
INSERT INTO Booking VALUES(NULL,"Annika Halstead",210218,NULL,101,9);
INSERT INTO Booking VALUES(NULL,"Toshiko Nomura",060817,NULL,203,9);
INSERT INTO Booking VALUES(NULL,"Benita Donahue",090919,NULL,301,9);

/*---kerlingarfjoll mountain resort (1)---*/
INSERT INTO Booking VALUES(NULL,"Matthew Zielinski",160621,NULL,201,10);

/*---AVAILABLE---*/

/*---hilton reykjavik nordica (4)---*/
INSERT INTO Available VALUES(101,1,240617,1,1);
INSERT INTO Available VALUES(101,1,250617,1,2);
INSERT INTO Available VALUES(101,1,260617,1,3);
INSERT INTO Available VALUES(101,1,270617,1,4);
INSERT INTO Available VALUES(302,1,200617,1,5);
INSERT INTO Available VALUES(302,1,210617,1,6);

/*---idelandair hotel reykjavik natura (4)---*/
INSERT INTO Available VALUES(102,2,270917,1,7);
INSERT INTO Available VALUES(203,2,200717,1,8);
INSERT INTO Available VALUES(304,2,210318,1,9);

/*---hotel klettur (4)---*/
INSERT INTO Available VALUES(101,3,260817,1,10);
INSERT INTO Available VALUES(102,3,300118,1,11);
INSERT INTO Available VALUES(103,3,240518,1,12);
INSERT INTO Available VALUES(202,3,260917,1,13);

/*---hotel vellir (3)---*/
INSERT INTO Available VALUES(204,4,250318,1,14);
INSERT INTO Available VALUES(302,4,260618,1,15);
INSERT INTO Available VALUES(303,4,270918,1,16);

/*---hotel odinsve (4)---*/
INSERT INTO Available VALUES(302,5,011217,1,17);
INSERT INTO Available VALUES(203,5,101118,1,18);

/*---reykjavik residence apartment hotel (4)---*/
INSERT INTO Available VALUES(101,6,280419,1,19);
INSERT INTO Available VALUES(104,6,130217,1,20);
INSERT INTO Available VALUES(101,6,170717,1,21);
INSERT INTO Available VALUES(104,6,191020,1,22);

/*---black pearl (5)---*/
INSERT INTO Available VALUES(304,7,020518,1,23);
INSERT INTO Available VALUES(305,7,230617,1,24);

/*---diamond suites (5)---*/
INSERT INTO Available VALUES(101,8,220518,1,25);
INSERT INTO Available VALUES(202,8,250319,1,26);
INSERT INTO Available VALUES(302,8,291117,1,27);
INSERT INTO Available VALUES(401,8,071021,1,28);

/*---hotel bifrost (2)---*/
INSERT INTO Available VALUES(101,9,210218,1,29);
INSERT INTO Available VALUES(203,9,060817,1,30);
INSERT INTO Available VALUES(301,9,090919,1,31);

/*---kerlingarfjoll mountain resort (1)---*/
INSERT INTO Available VALUES(201,10,160621,1,32);

END TRANSACTION;