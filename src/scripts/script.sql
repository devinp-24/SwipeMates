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
