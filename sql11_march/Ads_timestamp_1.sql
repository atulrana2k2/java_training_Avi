use practise;
CREATE TABLE Playback(
				session_id INT PRIMARY KEY AUTO_INCREMENT,
                customer_id INT,
                start_time INT,
                end_time INT);
                
                
                INSERT INTO Playback (customer_id, start_time, end_time) VALUES
				(1,1,5),
				(1,15,23),
				(2,10,12),
				(2,17,28),
				(2,2,8);
                
                CREATE TABLE Ads(
				ad_id INT PRIMARY KEY AUTO_INCREMENT,
                customer_id INT,
                timestamp INT);
                
                INSERT INTO Ads (customer_id, timestamp) VALUES
											(1,5),
                                            (2,17),
                                            (2,20);
                                            
SELECT DISTINCT (session_id) 
FROM Playback p
JOIN Ads a on p.customer_id = a.customer_id
WHERE a.timestamp NOT BETWEEN p.start_time AND p.end_time;


                     

SELECT session_id
FROM Playback
WHERE session_id NOT IN (
    SELECT DISTINCT p.session_id
    FROM Playback p
    JOIN Ads a ON p.customer_id = a.customer_id
    WHERE a.timestamp BETWEEN p.start_time AND p.end_time
);        
                
                