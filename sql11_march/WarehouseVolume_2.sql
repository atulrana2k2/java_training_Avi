CREATE TABLE Products (
				product_id INT PRIMARY KEY,
				product_name VARCHAR(255),
                width INT,
                length INT,
                height INT
               );
               
               INSERT INTO Products ()
VALUES
    (1, 'LC-TV', 5, 50, 40),
    (2, 'LC-KeyChain', 5, 5, 5),
    (3, 'LC-Phone', 2, 10, 10),
    (4, 'LC-T-Shirt', 4, 10, 20);
    
    
    select * from Products;
    
    CREATE TABLE Warehouse(
					name VARCHAR(255),
                    product_id INT,
					units INT,
					PRIMARY KEY (name, product_id), -- composite key
					FOREIGN KEY (product_id) REFERENCES Products(product_id) -- foreign key constraint
                    );
                    
INSERT INTO Warehouse (name, product_id, units) VALUES
										('LCHouse1',1, 1),
                                        ('LCHouse1',2, 10),
                                        ('LCHouse1',3, 5),
                                        ('LCHouse2',1, 2),
                                        ('LCHouse2',2, 2),
                                        ('LCHouse3',4, 1);
                                        
		select * from warehouse;
                                        
                                        
									
                                    
SELECT w.name AS warehouse_name, SUM(p.Width * p.Length * p.Height * w.units) AS volume
FROM Warehouse w
JOIN Products p ON w.product_id = p.product_id
GROUP BY w.name;
			
                                        
                                        
                    
                    