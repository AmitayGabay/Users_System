CREATE TABLE user(
id int NOT NULL AUTO_INCREMENT,
first_name varchar NOT NULL,
last_name varchar NOT NULL,
email varchar NOT NULL,
age int DEFAULT 0 NOT NULL,
address varchar,
joining_date date DEFAULT current_date NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO user (first_name, last_name, email, age, address, joining_date)
VALUES('a', 'aa', 'a@gmail.com', 10, 'aen eliezer 45, netanya', current_date ),
('b', 'bb', 'b@gmail.com', 20, 'ben eliezer 45, netanya', current_date),
('c', 'cc', 'c@gmail.com', 30, 'cen eliezer 45, netanya', current_date),
('d', 'dd', 'd@gmail.com', 40, 'den eliezer 45, netanya', current_date),
('e', 'ee', 'e@gmail.com', 50, 'een eliezer 45, netanya', current_date),
('f', 'ff', 'f@gmail.com', 60, 'fen eliezer 45, netanya', current_date),
('g', 'gg', 'g@gmail.com', 70, 'gen eliezer 45, netanya', current_date),
('h', 'hh', 'h@gmail.com', 80, 'hen eliezer 45, netanya', current_date),
('i', 'ii', 'i@gmail.com', 90, 'ien eliezer 45, netanya', current_date),
('j', 'jj', 'j@gmail.com', 100, 'jen eliezer 45, netanya', current_date);

