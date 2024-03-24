--SELECT title FROM film;
--SELECT first_name, last_name FROM actor;
--SELECT * FROM
--film WHERE replacement_cost = 14.99;
--SELECT first_name, last_name FROM actor 
--WHERE first_name = 'Penelope' OR first_name = 'Bob';
SELECT title, length FROM film
WHERE NOT length > 100;
