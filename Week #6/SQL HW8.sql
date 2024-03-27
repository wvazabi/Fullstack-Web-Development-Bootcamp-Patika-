SELECT * FROM employee;

UPDATE employee 
SET first_name = 'ENES KAYA' 
WHERE id = 2
RETURNING *;

UPDATE employee
SET birthday = '1996-01-17'
WHERE id = 2
RETURNING *;

DELETE FROM employee 
WHERE id = 2;
