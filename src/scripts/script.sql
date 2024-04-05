DROP TABLE Lister;
DROP TABLE Seeker;
DROP TABLE Users;
CREATE TABLE Users (
                       UserID VARCHAR(16) PRIMARY KEY,
                       Name VARCHAR(255) NOT NULL,
                       Gender VARCHAR(10) NOT NULL,
                       Bio VARCHAR(100),
                       Age INTEGER NOT NULL
);

INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES
    ('L123456', 'Devin Proothi', 'Male', 'UBC, Year 3, CS.', 24);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES
    ('S123456', 'Aryaan Habib', 'Male', 'UBC, Year 3, Forestry.', 36);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES
    ('L101010', 'Nabeel Ali', 'Female', 'UBC. Year 3. Psychology.', 34);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES
    ('S101010', 'Kartikeya Chaturvedi', 'Male', 'UBC. Year 4. Sauder', 24);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('S987654', 'Aaditya Desai', 'Male', 'UBC. Year 3. English.', 31);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('L765432', 'Sid Jain', 'Male', 'UBC. Year 6. International Relations.', 24);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('L345678', 'Rishav', 'Male', 'UBC. Year 5. International Relations.', 31);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('L012120', 'Aneyeant', 'Female', 'UBC. Year 1. International Relations.', 31);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('S765432', 'Anmol', 'Male', 'UBC. Year 3. International Relations.', 36);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('S012120', 'Jaimin', 'Male', 'UBC. Year 4. International Relations.', 34);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('L012128', 'Jai', 'Female', 'UBC. Year 4. International Relations.', 24);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('S012129', 'Man', 'Female', 'UBC. Year 4. International Relations.', 26);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('L876543', 'Alex Smith', 'Male', 'UBC. Year 2. Computer Science.', 20);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('L123789', 'Jessica Jones', 'Female', 'UBC. Year 1. Biology.', 18);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('L456123', 'Michael Chen', 'Male', 'UBC. Year 3. Economics.', 21);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('L789456', 'Laura Gibson', 'Female', 'UBC. Year 2. English Literature.', 19);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('S321654', 'Omar Farooq', 'Male', 'UBC. Year 3. Political Science.', 22);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('S654987', 'Priya Singh', 'Female', 'UBC. Year 1. Sociology.', 18);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('S987321', 'Ethan Wong', 'Male', 'UBC. Year 2. Mathematics.', 20);
INSERT INTO Users (UserID, Name, Gender, Bio, Age) VALUES ('S159753', 'Sophia Loren', 'Female', 'UBC. Year 3. Fine Arts.', 21);

DROP TABLE Res;
DROP TABLE Building;
DROP TABLE Floors;

CREATE TABLE Floors (
                        BuildingName VARCHAR(255) PRIMARY KEY,
                        NumberOfFloors INT NOT NULL
);

CREATE TABLE Building (
                          Address VARCHAR(255) PRIMARY KEY,
                          BuildingName VARCHAR(255) NOT NULL,
                          FOREIGN KEY (BuildingName) REFERENCES Floors(BuildingName)
);

CREATE TABLE Res (
                     ResID VARCHAR(16) PRIMARY KEY,
                     Address VARCHAR(255) NOT NULL,
                     Amenities VARCHAR(255) ,
                     NumberOfRooms INT,
                     Rent INT,
                     Type VARCHAR(16),
                     FOREIGN KEY (Address) REFERENCES Building(Address)
);

INSERT INTO Floors (BuildingName, NumberOfFloors) VALUES
    ('Marine Drive', 10);
INSERT INTO Floors (BuildingName, NumberOfFloors) VALUES
    ('Walter Gage', 20);
INSERT INTO Floors (BuildingName, NumberOfFloors) VALUES
    ('Ponderosa', 15);
INSERT INTO Floors (BuildingName, NumberOfFloors) VALUES
    ('Orchard Commons', 24);
INSERT INTO Floors (BuildingName, NumberOfFloors) VALUES
    ('Totem Park', 12);
INSERT INTO Floors (BuildingName, NumberOfFloors) VALUES
    ('Chaucer Hall1', 3);
INSERT INTO Floors (BuildingName, NumberOfFloors) VALUES
    ('Chaucer Hall2', 2);
INSERT INTO Floors (BuildingName, NumberOfFloors) VALUES
    ('Collison Woods', 5);
INSERT INTO Floors (BuildingName, NumberOfFloors) VALUES
    ('Private Home', 1);
INSERT INTO Floors (BuildingName, NumberOfFloors) VALUES
    ('Cambridge Block', 10);

INSERT INTO Building (Address, BuildingName) VALUES
    ('123 Main St', 'Marine Drive');
INSERT INTO Building (Address, BuildingName) VALUES
    ('456 Elm St', 'Orchard Commons');
INSERT INTO Building (Address, BuildingName) VALUES
    ('789 Oak St', 'Totem Park');
INSERT INTO Building (Address, BuildingName) VALUES
    ('101 Pine St', 'Ponderosa');
INSERT INTO Building (Address, BuildingName) VALUES
    ('202 Birch St', 'Walter Gage');
INSERT INTO Building (Address, BuildingName) VALUES
    ('2250 Wesbrook Mall', 'Chaucer Hall1');
INSERT INTO Building (Address, BuildingName) VALUES
    ('2280 Wesbrook Mall', 'Chaucer Hall2');
INSERT INTO Building (Address, BuildingName) VALUES
    ('231 Alma street', 'Collison Woods');
INSERT INTO Building (Address, BuildingName) VALUES
    ('144 West 14th Ave', 'Private Home');
INSERT INTO Building (Address, BuildingName) VALUES
    ('3525 West 10th Ave', 'Cambridge Block');


INSERT INTO Res (ResID, Address, Amenities, NumberOfRooms, Rent, Type) VALUES
    ('res01', '123 Main St', 'Pool, Gym, Parking', 1, 1000, 'On Campus');
INSERT INTO Res (ResID, Address, Amenities, NumberOfRooms, Rent, Type) VALUES
    ('res02', '456 Elm St', 'Gym, Parking', 2, 1200, 'On Campus');
INSERT INTO Res (ResID, Address, Amenities, NumberOfRooms, Rent, Type) VALUES
    ('res03', '789 Oak St', 'Pool, Parking', 4, 1500, 'On Campus');
INSERT INTO Res (ResID, Address, Amenities, NumberOfRooms, Rent, Type) VALUES
    ('res04', '101 Pine St', 'Gym', 1, 1300, 'On Campus');
INSERT INTO Res (ResID, Address, Amenities, NumberOfRooms, Rent, Type) VALUES
    ('res05', '202 Birch St', 'Parking', 3, 900, 'On Campus');
INSERT INTO Res (ResID, Address, Amenities, NumberOfRooms, Rent, Type) VALUES
    ('res06', '2250 Wesbrook Mall', 'Parking', 6, 1500,'Off Campus');
INSERT INTO Res (ResID, Address, Amenities, NumberOfRooms, Rent, Type) VALUES
    ('res07', '2280 Wesbrook Mall', 'Basketball Court', 1, 1000,'Off Campus');
INSERT INTO Res (ResID, Address, Amenities, NumberOfRooms, Rent, Type) VALUES
    ('res08', '231 Alma street', 'Pool', 2, 1200,'Off Campus');
INSERT INTO Res (ResID, Address, Amenities, NumberOfRooms, Rent, Type) VALUES
    ('res09', '144 West 14th Ave', 'Gym', 1, 1350,'Off Campus');
INSERT INTO Res (ResID, Address, Amenities, NumberOfRooms, Rent, Type) VALUES
    ('res10', '3525 West 10th Ave', 'Good Neighbourhood', 4, 900,'Off Campus');


CREATE TABLE Lister (
                        ListerID VARCHAR(16) PRIMARY KEY,
                        ResID VARCHAR(16),
                        ListingType VARCHAR(10),
                        FOREIGN KEY (ListerID) REFERENCES Users(UserID)
                            ON DELETE CASCADE,
                        FOREIGN KEY (ResID) REFERENCES Res(ResID)
                            ON DELETE CASCADE
);

CREATE TABLE Seeker (
                        SeekerID VARCHAR(16) PRIMARY KEY,
                        SeekingType VARCHAR(10),
                        FOREIGN KEY (SeekerID) REFERENCES Users(UserID)
                            ON DELETE CASCADE
);

INSERT INTO Lister (ListerID, ResID, ListingType) VALUES
    ('L123456', 'res01', 'On Campus');
INSERT INTO Lister (ListerID, ResID, ListingType) VALUES
    ('L101010', 'res02', 'On Campus');
INSERT INTO Lister (ListerID, ResID, ListingType) VALUES
    ('L765432', 'res03', 'On Campus');
INSERT INTO Lister (ListerID, ResID, ListingType) VALUES
    ('L345678', 'res04', 'On Campus');
INSERT INTO Lister (ListerID, ResID, ListingType) VALUES
    ('L012120', 'res05', 'On Campus');
INSERT INTO Lister (ListerID, ResID, ListingType) VALUES
    ('L012128', 'res06', 'Off Campus');
INSERT INTO Lister (ListerID, ResID, ListingType) VALUES
    ('L876543', 'res07', 'Off Campus');
INSERT INTO Lister (ListerID, ResID, ListingType) VALUES
    ('L123789', 'res08', 'Off Campus');
INSERT INTO Lister (ListerID, ResID, ListingType) VALUES
    ('L456123', 'res09', 'Off Campus');
INSERT INTO Lister (ListerID, ResID, ListingType) VALUES
    ('L789456', 'res10', 'Off Campus');

INSERT INTO Seeker (SeekerID, SeekingType) VALUES
    ('S123456', 'On Campus');
INSERT INTO Seeker (SeekerID, SeekingType) VALUES
    ('S101010', 'On Campus');
INSERT INTO Seeker (SeekerID, SeekingType) VALUES
    ('S987654','On Campus');
INSERT INTO Seeker (SeekerID, SeekingType) VALUES
    ('S765432',  'On Campus');
INSERT INTO Seeker (SeekerID, SeekingType) VALUES
    ('S012120',  'On Campus');
INSERT INTO Seeker (SeekerID, SeekingType) VALUES
    ('S012129',  'Off Campus');
INSERT INTO Seeker (SeekerID, SeekingType) VALUES
    ('S321654',  'Off Campus');
INSERT INTO Seeker (SeekerID, SeekingType) VALUES
    ('S654987',  'Off Campus');
INSERT INTO Seeker (SeekerID, SeekingType) VALUES
    ('S987321',  'Off Campus');
INSERT INTO Seeker (SeekerID, SeekingType) VALUES
    ('S159753',  'Off Campus');
