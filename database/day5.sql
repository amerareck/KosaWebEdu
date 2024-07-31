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
INSERT INTO imsi (name, BIRTHDAY, AGE) VALUES ('�Ѹ�', SYSDATE, 10);
INSERT INTO imsi (name, BIRTHDAY, AGE) VALUES ('��ġ', '99/06/10', 11);
INSERT INTO imsi (name, BIRTHDAY, AGE) VALUES ('�����', TO_DATE('2010�� 10�� 25��', 'YYYY"��" MM"��" DD"��"'),12);

INSERT ALL INTO IMSI (NAME, BIRTHDAY, AGE) VALUES ('�Ѹ�', SYSDATE, 10)
INTO IMSI (NAME, BIRTHDAY, AGE) VALUES ('��ġ', TO_DATE('1999-06-10', 'YYYY-MM-DD'), 11)
INTO IMSI (NAME, BIRTHDAY, AGE) VALUES ('�����', TO_DATE('2010�� 10�� 25��', 'YYYY"��" MM"��" DD"��"'), 12); 
INSERT INTO imsi (name) values ('������');
insert into imsi values('��浿', sysdate, 40);
SELECT * FROM imsi;

select age, name, to_char(birthday,'DD-MM-YYYY')
FROM imsi;

select age, name, to_char(birthday,'yyyy/mm/dd hh:mi:ss')
from imsi;

DELETE FROM imsi WHERE age is null;
SELECT * FROM imsi;
commit; -- delete �ݿ�.