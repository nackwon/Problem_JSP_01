CREATE TABLE project(
    cnumber NUMBER(10) PRIMARY KEY,
    email VARCHAR2(50),
    koearn NUMBER(5),
    english NUMBER(5),
    math NUMBER(5),
    science NUMBER(5),
    history NUMBER(5),
    score NUMBER(5),
    tcode VARCHAR2(10),
    achievement VARCHAR2(5),
    regioncode VARCHAR2(5)
    );
   
SELECT * FROM project;
SELECT count(*) FROM PROJECT;
DROP TABLE project;

SELECT count(*) 
FROM project 
WHERE regioncode = 'B'
AND (korean + );
