SELECT ROWNUM, EMP.*
FROM EMP;

SELECT ROWNUM, EMP.*
FROM EMP
WHERE ROWNUM <= 3;

SELECT ROWNUM, EMP.*
FROM EMP
WHERE ROWNUM = 3;

SELECT ROWNUM, EMP.*
FROM EMP
WHERE sal > 2500;

CREATE TABLE IMSI (NAME VARCHAR2(10), BIRTHDAY DATE, AGE NUMBER(3));
INSERT INTO imsi (name, BIRTHDAY, AGE) VALUES ('둘리', SYSDATE, 10);
INSERT INTO imsi (name, BIRTHDAY, AGE) VALUES ('또치', '99/06/10', 11);
INSERT INTO imsi (name, BIRTHDAY, AGE) VALUES ('도우너', TO_DATE('2010년 10월 25일', 'YYYY"년" MM"월" DD"일"'),12);

INSERT ALL INTO IMSI (NAME, BIRTHDAY, AGE) VALUES ('둘리', SYSDATE, 10)
INTO IMSI (NAME, BIRTHDAY, AGE) VALUES ('또치', TO_DATE('1999-06-10', 'YYYY-MM-DD'), 11)
INTO IMSI (NAME, BIRTHDAY, AGE) VALUES ('도우너', TO_DATE('2010년 10월 25일', 'YYYY"년" MM"월" DD"일"'), 12); 
INSERT INTO imsi (name) values ('마이콜');
insert into imsi values('고길동', sysdate, 40);
SELECT * FROM imsi;

select age, name, to_char(birthday,'DD-MM-YYYY')
FROM imsi;

select age, name, to_char(birthday,'yyyy/mm/dd hh:mi:ss')
from imsi;

DELETE FROM imsi WHERE age is null;
SELECT * FROM imsi;
commit; -- delete 반영.