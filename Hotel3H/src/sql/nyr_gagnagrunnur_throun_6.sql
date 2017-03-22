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
	date int,
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
/*---Roomnumber, (int) Hotelnumber (references Hotel(nr) (integer), Price (int), Size (int), Bed1 (int), Bed2 (int), Baby (boolean)---*/

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
INSERT INTO Room VALUES (104,2,30,400,2,0,1);
INSERT INTO Room VALUES (201,2,25,300,1,0,0);
INSERT INTO Room VALUES (202,2,25,300,1,0,0);
INSERT INTO Room VALUES (203,2,25,300,1,0,0);
INSERT INTO Room VALUES (204,2,25,300,1,0,0);
INSERT INTO Room VALUES (301,2,50,600,2,2,1);
INSERT INTO Room VALUES (302,2,50,600,2,2,1);
INSERT INTO Room VALUES (303,2,55,650,2,2,1);
INSERT INTO Room VALUES (304,2,60,700,2,2,0);

/*---hotel klettur (4)---*/
INSERT INTO Room VALUES (101,3,20,350,2,0,0);
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
INSERT INTO Room VALUES (304,3,70,800,2,2,0);

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
INSERT INTO Room VALUES (304,4,46,600,2,2,1);

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
INSERT INTO Room VALUES (303,5,38,560,2,2,1);
INSERT INTO Room VALUES (304,5,38,560,2,2,1);

/*---roomnr, hotelnr,     price, size, bed1, bed2, baby---*/
/*---int,    integer(nr), int,   int,  int,  int,  boolean (0/1)---*/

/*---reykjavik residence apartment hotel (4)---*/
INSERT INTO Room VALUES (101,6,26,420,2,0,0);
INSERT INTO Room VALUES (102,6,26,420,2,0,0);
INSERT INTO Room VALUES (103,6,30,430,2,0,1);
INSERT INTO Room VALUES (104,6,32,440,2,1,1);
INSERT INTO Room VALUES (201,6,40,500,2,1,1);
INSERT INTO Room VALUES (202,6,40,500,2,1,1);
INSERT INTO Room VALUES (203,6,40,500,2,1,1);
INSERT INTO Room VALUES (204,6,40,500,2,1,1);
INSERT INTO Room VALUES (301,6,46,550,2,2,1);
INSERT INTO Room VALUES (302,6,46,550,2,2,1);
INSERT INTO Room VALUES (303,6,55,620,2,2,1);
INSERT INTO Room VALUES (304,6,55,620,2,2,1);

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

/*---(continue adding data from here)---*/

/*---CREATE TABLE RoomSearch (
	nr int, hnr integer, pets boolean, count int, washing boolean, kitchen boolean, minifridge boolean, tv boolean, bath boolean, view boolean, noise boolean, level int, nextleft int, nextright int, smoke boolean, ac boolean,
	FOREIGN KEY (nr,hnr) REFERENCES Room(nr, hotelnr)
);---*/

/*---
	nr int, hnr integer, pets boolean, count int, washing boolean, kitchen boolean, minifridge boolean, tv boolean, bath boolean, view boolean, noise boolean, level int, nextleft int, nextright int, smoke boolean, ac boolean,
	int, integer, boolean, 					 int, boolean, boolean, boolean, boolean,
);---*/

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

/*---BOOKING---*/

INSERT INTO Booking VALUES(NULL,"Jón Jónsson",240617,NULL,101,1);
INSERT INTO Booking VALUES(NULL,"Jón Jónsson",250617,NULL,101,1);
INSERT INTO Booking VALUES(NULL,"Jón Jónsson",260617,NULL,101,1);
INSERT INTO Booking VALUES(NULL,"Jón Jónsson",270617,NULL,101,1);
INSERT INTO Booking VALUES(NULL,"Karl Karlsson",200617,NULL,302,1);
INSERT INTO Booking VALUES(NULL,"Karl Karlsson",210617,NULL,302,1);

/*---AVAILABLE---*/

INSERT INTO Available VALUES(101,1,240617,1,1);
INSERT INTO Available VALUES(101,1,250617,1,2);
INSERT INTO Available VALUES(101,1,260617,1,3);
INSERT INTO Available VALUES(101,1,270617,1,4);
INSERT INTO Available VALUES(302,1,200617,1,5);
INSERT INTO Available VALUES(302,1,210617,1,6);

END TRANSACTION;