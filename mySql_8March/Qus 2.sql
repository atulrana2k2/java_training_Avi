use practise;
CREATE TABLE Person (
    PersonId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(255),
    LastName VARCHAR(255)
);
INSERT INTO Person (FirstName, LastName) VALUES
    ('John', 'Doe'),
    ('Jane', 'Smith'),
    ('Michael', 'Johnson'),
    ('Emily', 'Brown'),
    ('William', 'Davis'),
    ('Emma', 'Wilson'),
    ('Christopher', 'Martinez'),
    ('Olivia', 'Anderson'),
    ('James', 'Taylor'),
    ('Sophia', 'Thomas');
    
    select * from Person;
    
    CREATE TABLE Address (
    AddressId INT PRIMARY KEY AUTO_INCREMENT,
    PersonId int,
    City VARCHAR(255),
    State VARCHAR(255)
);

INSERT INTO Address ( PersonID,City, State) VALUES
    ( 2,'New York', 'NY'),
    ( 3,'Los Angeles', 'CA'),
    ( 7,'Chicago', 'IL'),
    ( 8,'chd', 'FL'),
    ( 9,'Houston', 'hp'),
    ( 12,'navi', 'pun'),
    ( 11,'Phoenix', 'AZ'),
    ( 15,'Philadelphia', 'uk'),
    ( 16,'San Antonio', 'TX'),
    ( 20,'delhi', 'CA');
    
    select * from Person;
    select * from Address;
drop table Address;
select FirstName, LastName, City, State from Person p left join  Address a on  p.PersonId = a.PersonId;
    
    