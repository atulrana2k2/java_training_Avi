CREATE TABLE NPV(
				id INT,
                year INT,
                npv INT,
                PRIMARY KEY (id, year) -- composite key
                );
                
INSERT INTO NPV (id, year, npv) VALUES
    (1, 2018, 100),
    (7, 2020, 30),
    (13, 2019, 40),
    (1, 2019, 113),
    (2, 2008, 121),
    (3, 2009, 12),
    (11, 2020, 99),
    (7, 2019, 0);
    
    CREATE TABLE Queries(
					id INT,
                    year INT,
                    PRIMARY KEY (id, year)
                    );


INSERT INTO Queries (id, year) VALUES
    (1, 2019),
    (2, 2008),
    (3, 2009),
    (7, 2018),
    (7, 2019),
    (7, 2020),
    (13, 2019);
    
    
  SELECT 
    id, year, COALESCE(n.npv, 0)
FROM
    Queries q
        LEFT JOIN
    NPV n USING (id , year)
ORDER BY id , year
    