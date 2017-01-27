DROP TABLE IF EXISTS Hotels;

CREATE TABLE Hotels(
   ID INTEGER PRIMARY KEY AUTOINCREMENT
  ,Name VARCHAR (20) NOT NULL
  ,Type VARCHAR(20) NOT NULL
  ,Stars INTEGER NOT NULL
  ,Country VARCHAR(20) NOT NULL
  ,City VARCHAR(20) NOT NULL
  ,Rooms INTEGER NOT NULL
  ,HasPool BOOLEAN NOT NULL
);

INSERT INTO Hotels(Name, Type, Stars, Country, City, Rooms, HasPool) VALUES ("The Bayou Bed & Breakfast", "Hostel", 3, "United States", "Georgia", 12, 1);
INSERT INTO Hotels(Name, Type, Stars, Country, City, Rooms, HasPool) VALUES ("Ice Hotel", "Luxury Hotel", 5, "Sweden", "Oslo", 32, 1);
INSERT INTO Hotels(Name, Type, Stars, Country, City, Rooms, HasPool) VALUES ("Missed Flights Mortuary", "Capsule hotel", 2, "Hong Kong", "Hong Kong", 50, 0);
INSERT INTO Hotels(Name, Type, Stars, Country, City, Rooms, HasPool) VALUES ("Alcott Summer Houses", "Summer House Rental", 4, "United Kingdom", "Bexhall", 14, 0);
INSERT INTO Hotels(Name, Type, Stars, Country, City, Rooms, HasPool) VALUES ("Renholm", "Hotel", 3, "United States", "Boston", 38, 1);