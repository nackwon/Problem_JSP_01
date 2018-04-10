CREATE TABLE project(
    cnumber NUMBER(10) PRIMARY KEY,
    email VARCHAR2(50),
    koearn NUMBER(3),
    english NUMBER(3),
    math NUMBER(3),
    science NUMBER(3),
    history NUMBER(3),
    score NUMBER(3),
    tcode VARCHAR2(5),
    achievement VARCHAR2(5),
    regioncode VARCHAR2(5)
    );
   
SELECT * FROM project;

DROP TABLE project;