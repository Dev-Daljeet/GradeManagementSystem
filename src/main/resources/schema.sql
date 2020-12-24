CREATE TABLE student (id INT NOT NULL Primary Key AUTO_INCREMENT, name VARCHAR(100), studentId VARCHAR(100), exercises DECIMAL(5,2), assignment1 DECIMAL(5,2), assignment2 DECIMAL(5,2), 
                                                assignment3 DECIMAL(5,2), midterm DECIMAL(5,2), finalExam DECIMAL(5,2), averageGrade DECIMAL(5,2), letterGrade VARCHAR(5));

INSERT INTO student (name, studentId, exercises, assignment1, assignment2, assignment3, midterm, finalExam, averageGrade, letterGrade) VALUES
('Freddie Mercury','111', 70.00, 100.00, 100.00, 100.00, 80.05, 100.00, 84.01, 'A-'),
('Brain May','112', 80.00, 0, 100.00, 100.00, 80.05, 100.00, 78.01, 'B+'),
('John Deacon','113', 80.00, 0, 0, 0, 80.05, 100.00, 54.01, 'D'),
('Roger Meddows Taylor','114', 20.00, 100.00, 20.00, 50.00, 80.05, 100.00, 60.00, 'C'),
('MC Ride','115', 100.00, 100.00, 100.00, 100.00, 100.00, 100, 100.00, 'A+'),
('David Gilmour','116', 100.00, 0.00, 100.00, 100.00, 100.00, 100.00, 94.00, 'A+'),
('Zack Hill','117', 100.00, 80.00, 100.00, 100.00, 90.00, 100.00, 94.80, 'A+'),
('Andy Morin','118', 100.00, 80.00, 100.00, 100.00, 90.00, 100.00, 94.80, 'A+'),
('Thom Yorke','119', 0, 80.00, 100.00, 100.00, 80.00, 80.00, 76.80, 'B+'),
('Pink Floyd','120', 100.00, 80.00, 100.00, 100.00, 80.00, 80.00, 86.80, 'A');
