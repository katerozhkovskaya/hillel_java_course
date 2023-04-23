--create table heroes
CREATE TABLE heroes(
id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
name VARCHAR(255) NOT NULL,
gender VARCHAR(10),
eye_color VARCHAR(50),
race VARCHAR(50),
hair_color VARCHAR(50),
height DOUBLE PRECISION ,
publisher  VARCHAR(50),
skin_color VARCHAR(20),
alignment VARCHAR(20),
weight INTEGER
);

--migrate table heroes_info to heroes
INSERT INTO heroes (name, gender, eye_color, race, hair_color, height,
                    publisher, skin_color, alignment, weight)
SELECT name, gender, eye_color, race, hair_color, height,
       publisher, skin_color, alignment, weight
FROM heroes_info;

--Average height of heroes (excluding the height of those that are zero or less)
SELECT AVG(height) AS avg_height FROM heroes
WHERE height > 0;|

--The name of the tallest hero
SELECT name AS tallest_hero_name FROM heroes
WHERE height =( SELECT MAX(height) FROM heroes);

--The name of the heaviest hero
SELECT name AS heaviest_hero_name FROM heroes
WHERE weight =( SELECT MAX(weight) FROM heroes);

--The number of individuals in each gender group
SELECT gender,
COUNT(*) FROM heroes
WHERE NOT (gender = '-')
GROUP BY gender;

--The number of individuals in each alignment group
SELECT alignment,
COUNT(*) FROM heroes
WHERE NOT (alignment = '-')
GROUP BY alignment;

--The names of the top 5 most popular publishers
SELECT publisher AS top_5_publisher,
COUNT(*) FROM heroes
GROUP BY publisher
ORDER BY COUNT DESC, publisher ASC
LIMIT 5;

--3 names of the most common hair colors
SELECT hair_color AS top_3_hair_color,
COUNT(*) FROM heroes
WHERE NOT (hair_color = '-')
GROUP BY hair_color
ORDER BY COUNT(*) DESC, hair_color ASC
LIMIT 3;

--The most common eye color
SELECT eye_color AS the_most_common_eye_color,COUNT(*) FROM heroes
GROUP BY eye_color
ORDER BY count desc, eye_color asc
LIMIT 1;

--Create table publishers
CREATE TABLE publishers(
id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
name VARCHAR(50),
created_at TIMESTAMP DEFAULT NOW()
);

--Migrate distinct publishers from heroes table
INSERT INTO publishers(name)
SELECT DISTINCT publisher
FROM heroes;

--Add a field publisher_id to the heroes table as a foreign key referencing the id field in the publishers table
ALTER TABLE heroes
ADD COLUMN publisher_id INTEGER REFERENCES publishers(id);

UPDATE heroes
SET publisher_id = publishers.id
FROM publishers
WHERE heroes.publisher = publishers.name;

--Drop column publisher from heroes
ALTER TABLE heroes DROP COLUMN publisher;

--The names of the top 5 most popular publishers
SELECT publishers.name AS top_5_publisher
FROM publishers
WHERE publishers.id IN (
  SELECT heroes.publisher_id
  FROM heroes
  GROUP BY heroes.publisher_id
  ORDER BY COUNT(*) DESC
  LIMIT 5
);