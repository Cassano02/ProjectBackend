DROP DATABASE IF EXISTS FinalExam;
CREATE DATABASE IF NOT EXISTS FinalExam;

USE FinalExam;

-- tao bang tuyen bay
DROP TABLE IF EXISTS TuyenBay;
CREATE TABLE IF NOT EXISTS TuyenBay(
	id INT AUTO_INCREMENT PRIMARY KEY,
    fromCity NVARCHAR(100),
    toCity NVARCHAR(100),
    price double
);

-- tao bang Staff
DROP TABLE IF EXISTS Staff;
CREATE TABLE IF NOT EXISTS Staff(
	id INT AUTO_INCREMENT PRIMARY KEY,
    first_name	NVARCHAR(50),
    last_name	NVARCHAR(50),
    gioiTinh ENUM('Male','Female','Undefined'),
    userName VARCHAR(50),
    `password` VARCHAR(100),
    `role` ENUM('ADMIN','PILOT')
);
-- tao bang quan tri vien
DROP TABLE IF EXISTS QuanTri;
CREATE TABLE IF NOT EXISTS QuanTri(
	id INT,
    namKN INT
    -- FOREIGN KEY (id) REFERENCES Staff(id)
);

DROP TABLE IF EXISTS PhiCong;
CREATE TABLE IF NOT EXISTS PhiCong(
	id INT,
    gioBay INT
    -- FOREIGN KEY (id) REFERENCES Staff(id)
);

-- tao bang chuyen bay
DROP TABLE IF EXISTS ChuyenBay;
CREATE TABLE IF NOT EXISTS ChuyenBay(
	id int auto_increment PRIMARY KEY,
    typePlane ENUM('AIRBUS','BOEING','COMAC'),
    startTime DATETIME,
    endTime DATETIME,
    tuyenBay_id INT,
    phiCong_id INT
);

-- tao bang hanh khach 
-- DROP TABLE IF EXISTS HanhKhach;
-- CREATE TABLE IF NOT EXISTS HanhKhach(
-- 	id int AUTO_INCREMENT PRIMARY KEY,
--     first_name	NVARCHAR(50),
--     last_name	NVARCHAR(50),
--     ngaySinh DATETIME,
--     gioiTinh ENUM('Male','Female','Undefined'),
--     flight_id INT
-- );


INSERT INTO TuyenBay(fromCity,toCity,price) VALUES
(N'Hà Nội', N'TP Hồ Chí Minh', 8000000),
(N'Vinh',N'TP Hồ Chí Minh', 6500000),
(N'Hà Nội',N'Phú Quốc',8750000),
(N'Vinh', N'Phú Quốc',7500000),
(N'Hải Phòng',N'Vinh',6900000),
(N'Hải Phòng', N'TP Hồ Chí Minh',9000000),
(N'Hà Nội', N'Đà Nẵng', 10000000),
(N'TP Hồ Chí Minh', N'Đà Nẵng', 7300000),
(N'TP Hồ Chí Minh', N'Phú Quốc', 6500000),
(N'Phú Quốc', N'Đà Nẵng', 8500000);

INSERT INTO Staff(first_name,last_name,gioiTinh,userName,`password`,`role`) VALUES 
(N'Phạm Thái',N'Bảo','Male','baothai','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','PILOT'),
(N'Phan Thiên',N'Quân','Male','quanphan','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','PILOT'),
(N'Nguyễn Quỳnh',N'Mai','Female','maiquynh','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','ADMIN'),
(N'Trần Tuấn',N'Trung','Female','trungtran','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','PILOT'),
(N'Nguyễn Đình',N'Quang','Male','quangnguyen','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','PILOT'),
(N'Mai Văn',N'An','Male','anmaivan','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','ADMIN'),
(N'Nguyễn Trung',N'Nghĩa','Male','nghianguyen','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','PILOT'),
(N'Hoàng Quang',N'Khải','Male','khaihoang','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','PILOT'),
(N'Tống Quang',N'Trung','Male','trungtong','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','PILOT'),
(N'Mai Dã',N'Quỳnh','Female','quynhmai','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','ADMIN'),
(N'Nguyễn Quang',N'Khang','Male','khangnguyen','$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','PILOT');


INSERT INTO PhiCong(id,gioBay) VALUES
(2,1000),
(1,1400),
(5,2000),
(4,1450),
(7,1890),
(8,1700),
(9,1200),
(11,3200);

INSERT INTO QuanTri(id,namKN) VALUES
(3,5),
(6,3),
(10,5);

INSERT INTO ChuyenBay(typePlane,startTime,endTime,tuyenBay_id,phiCong_id) VALUES
('AIRBUS','2022-12-10 16:00:00','2022-12-10 18:30:00',2,1),
('BOEING','2022-11-29 21:00:00','2022-11-30 00:00:00',3,4),
('COMAC','2022-08-29 10:00:00','2022-08-29 13:00:00',1,2),
('AIRBUS','2022-10-10 07:30:00','2022-10-10 09:00:00',4,7),
('BOEING','2022-09-19 14:20:00','2022-09-19 15:30:00',9,8),
('BOEING','2022-07-30 21:30:00','2022-07-30 22:45:00',6,5),
('AIRBUS','2022-10-01 23:00:00','2022-10-02 02:10:00',7,2),
('COMAC','2022-12-15 08:00:00','2022-12-15 10:00:00',5,5),
('AIRBUS','2022-12-02 10:00:00','2022-12-02 11:35:00',8,7),
('BOEING','2022-10-25 18:00:00','2022-10-25 19:45:00',10,8);

            
-- SELECT * FROM QuanTri;
-- SELECT * FROM PhiCong;
-- SELECT * FROM Staff;
-- SELECT * FROM TuyenBay;
-- SELECT * FROM ChuyenBay; 

-- SELECT `code` FROM TuyenBay WHERE id = (SELECT MAX(id) FROM TuyenBay);
-- select count('code') as id from TuyenBay;
-- DELETE FROM Staff WHERE id IN (7,8);
-- DELETE FROM PhiCong WHERE id IN (7,8);
-- SELECT id, concat(first_name, ' ', last_name)
-- from phicong inner join staff USING(id);