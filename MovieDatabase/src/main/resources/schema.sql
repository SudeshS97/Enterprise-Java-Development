CREATE TABLE Review (
id LONG PRIMARY KEY AUTO_INCREMENT, 
	name VARCHAR(255), 
	review VARCHAR(255), 
	user_rating INT, 
	streaming_service VARCHAR(255), 
	date_time VARCHAR(255)
);