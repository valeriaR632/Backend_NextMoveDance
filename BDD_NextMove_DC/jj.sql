--  Unir tabla 'Students' y 'Countries'
SELECT * FROM students;
SELECT * FROM countries;
SELECT * FROM courses;
SELECT * FROM courses_has_students;
SHOW TABLES;

SELECT *
FROM countries
INNER JOIN students
ON countries.idCountries = students.nationality;

-- Modificar la consulta para que aparezcan al menos 3 columnas con un alias.

SELECT countries.idCountries AS idPais,
countries.Name AS NombredelPais,
countries.Code AS CodigodelPais,
 students.idStudent AS idEstudiante,
 students.last_name AS ApellidodelEstudiante
FROM countries
INNER JOIN students
ON countries.idCountries = students.nationality;

-- Encontrar todos los estudiantes en un pais en especifico (Código 121).
 SELECT * FROM students
 WHERE nationality= "121";
 
  SELECT * FROM students
 WHERE nationality= "118";
 
 
 SELECT * FROM students
WHERE  nationality LIKE "%1%";
-- CONTAR todos los estudiantes en el curso Java-1.

SELECT COUNT(*) 
FROM courses_has_students
WHERE course_code = 'Java-1';





