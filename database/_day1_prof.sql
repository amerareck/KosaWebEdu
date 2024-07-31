select * from tab;
select * from course1;
select * from emp;
desc emp;
desc dept;
desc salgrade;

select * from tab;

select * from emp;

desc emp;

select * from dual;

select sysdate from dual;

select sysdate from emp;

select ename, sysdate from emp;

select ename from emp;

select distinct ename from emp;

select job from emp;

select distinct job from emp;

select job, deptno from emp;

select distinct job, deptno from emp;

select 10+20 from emp;

select ename, sal from emp;

select ename, sal*1.1 from emp;

select ename, sal*1.1 as newsal from emp;

select ename, sal*1.1 as 계산된급여 from emp;

select ename, sal*1.1 as "계산된 급여" from emp;

select ename as 직원명, sal*1.1 as "계산된 급여" from emp;

select ename 직원명, sal*1.1 "계산된 급여" from emp;

select * from emp where comm = null;  --  null = null

select * from emp where comm is null;

select * from emp where comm is not null;

select * from emp where comm > null; -- null 과의 비교는 무조건 false 로 처리

select * from emp where ename = 'KING';

select * from emp where ename = 'king';

select * from emp where ename like '%S%';   -- % : 0개 이상의 모든, _ : 임의의 문자 1개
select * from emp where ename like 'S%';
select * from emp where ename like '%S';
select * from emp where ename like '%A%';
select * from emp where ename like '_A%';
select * from emp where ename like '__A%';
select * from emp where ename not like '%A%';

select * from emp where deptno = 10 or deptno = 30;
select * from emp where deptno = 10 or deptno = 30 or deptno = 20 ;
select * from emp where deptno in (10, 20, 30);

select * from emp order by sal;
select * from emp order by sal desc;

select * from emp order by hiredate;
select * from emp order by hiredate desc;

select * from emp where sal >= 2450;
select * from emp where sal >= 2450 and sal <= 3000;
select * from emp where sal between 2450 and 3000;

select length('가나다') from dual;
select lengthb('가나다') from dual;
select lengthb('한글') from dual;

select initcap(ename) from emp;
select initcap('aaa bbb ccc') from dual;

select to_char(sysdate, 'DDD') from dual;
select to_char(sysdate, 'DD') from dual;
select to_char(sysdate, 'D') from dual;

select to_char(sysdate, 'Q') from dual;

select hiredate from emp;
select to_char(hiredate, 'yyyy')||'년' from emp;
select concat(to_char(hiredate, 'yyyy'),'년') from emp;
select * from emp where to_char(hiredate, 'yyyy') = '1987';

select * from emp where to_char(hiredate, 'mm') = '05';

select to_char(to_date('990510', 'yymmdd'), 'yyyymmdd') from dual;
select to_char(to_date('990510', 'rrmmdd'), 'yyyymmdd') from dual;

select to_char(to_date('190510', 'yymmdd'), 'yyyymmdd') from dual;
select to_char(to_date('190510', 'rrmmdd'), 'yyyymmdd') from dual;

select ename, job, sal, comm from emp;
select ename, job, sal, nvl(comm, 0) from emp;
select ename, job, sal, nvl(to_char(comm), 'ㅜㅜ') "어떻게 하면 될까?"from emp;

select ename, job, sal, nvl2(comm, 'ㅋㅋ', 'ㅜㅜ') from emp;



SELECT comm, comm+100, NVL(comm, 0)+100
FROM emp;



SELECT sal, comm, NVL2(comm, comm+sal, 0+sal)
FROM emp;




SELECT ename, hiredate, 
              DECODE(TO_CHAR(hiredate, 'yy'), '80', '둘리반', '81', '또치반', '82', '도우너반', '87', '희동이반')
FROM emp;




SELECT ename, sal,
    CASE 
        WHEN sal > 3000 THEN 10000
        WHEN sal > 1000 THEN 7000      
        ELSE 5000
        END AS "회비"
FROM emp;



SELECT ename, sal,
    CONCAT(TO_CHAR(CASE 
        WHEN sal > 3000 THEN 10000
        WHEN sal > 1000 THEN 7000      
        ELSE 5000
        END, '999,999'), '원') AS "회비"
FROM emp;

SELECT ROUND(sysdate), TRUNC(sysdate)
              , ROUND(sysdate, 'yy'), TRUNC(sysdate, 'yy')
              , ROUND(sysdate, 'mm'), TRUNC(sysdate, 'mm')
FROM dual;


SELECT ROUND(7777.5555, 1), ROUND(7777.5555, 2), 
              ROUND(7777.5555, -1), ROUND(7777.5555, -2),
              ROUND(7733.5555, -1), ROUND(7733.5555, -2)
FROM dual;

SELECT MAX(sal), MIN(sal), SUM(sal) 
FROM emp;

SELECT MAX(sal) 최댓값, MIN(sal) 최솟값, SUM(sal) 총합, ROUND(AVG(sal), 2) 평균, COUNT(sal) 인원
FROM emp;

SELECT COUNT(sal), COUNT(comm), COUNT(*)
FROM emp;

SELECT MAX(comm) 최댓값, MIN(comm) 최솟값, SUM(comm) 총합, ROUND(AVG(comm), 2) 평균, COUNT(comm) 인원
FROM emp;

SELECT deptno, SUM(sal) 
FROM emp
GROUP BY deptno;

SELECT deptno, SUM(sal) 
FROM emp
WHERE deptno is not null
GROUP BY deptno;

SELECT deptno, SUM(sal) 
FROM emp
WHERE deptno is not null
GROUP BY deptno
HAVING SUM(sal) > 9000;

SELECT deptno, SUM(sal) 
FROM emp
WHERE deptno is not null
GROUP BY deptno
HAVING SUM(sal) > 9000
ORDER BY SUM(sal) DESC;

SELECT deptno 부서번호, SUM(sal) 합
FROM emp
WHERE deptno is not null
GROUP BY deptno
ORDER BY 합 DESC;

SELECT empno, deptno 부서번호, SUM(sal) 합
FROM emp
GROUP BY deptno
ORDER BY 합 DESC;

SELECT COUNT(empno), deptno 부서번호, SUM(sal) 합
FROM emp
GROUP BY deptno
ORDER BY 합 DESC;



select to_char(hiredate,'YYYY')||'년' as 입사년도, count(*) || '명' as "입사 인원수"
from emp 
group by to_char(hiredate,'YYYY')
order by count(*) desc;


-- JOIN

SELECT *
FROM emp;

SELECT *
FROM dept;

SELECT *
FROM EMP
CROSS JOIN DEPT;

SELECT *
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno;

SELECT *
FROM EMP
JOIN DEPT USING(deptno);






SELECT ename, hiredate, dname
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno;



SELECT ename, EMP.deptno, dname
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno;


SELECT ename, DEPT.deptno, dname
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno;




SELECT ename, deptno, dname
FROM EMP
JOIN DEPT USING(deptno);


SELECT ename, dname
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno;


SELECT *
FROM EMP
LEFT OUTER JOIN DEPT ON EMP.deptno = DEPT.deptno;


SELECT ename, dname
FROM EMP
LEFT JOIN DEPT ON EMP.deptno = DEPT.deptno;




SELECT ename,  NVL(dname, '미정')
FROM EMP
LEFT JOIN DEPT ON EMP.deptno = DEPT.deptno;


SELECT *
FROM EMP
RIGHT JOIN DEPT ON EMP.deptno = DEPT.deptno;


SELECT NVL(ename, '없음'),  dname
FROM EMP
RIGHT JOIN DEPT ON EMP.deptno = DEPT.deptno;


SELECT *
FROM EMP
FULL JOIN DEPT ON EMP.deptno = DEPT.deptno;



SELECT ename, dname
FROM EMP
FULL JOIN DEPT ON EMP.deptno = DEPT.deptno;




SELECT NVL(ENAME, '없음'),  NVL(DNAME, '미정')
FROM EMP
FULL JOIN DEPT ON EMP.deptno = DEPT.deptno;



SELECT * 
FROM SALGRADE;


SELECT *
FROM EMP
JOIN SALGRADE ON sal BETWEEN losal AND hisal;


SELECT ename, sal, grade
FROM EMP
JOIN SALGRADE ON sal BETWEEN losal AND hisal;



SELECT *
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno
JOIN SALGRADE ON sal BETWEEN losal AND hisal;


SELECT *
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno
JOIN SALGRADE ON sal BETWEEN losal AND hisal
WHERE ename = 'MILLER';



SELECT ename, sal, grade, dname, loc
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno
JOIN SALGRADE ON sal BETWEEN losal AND hisal;


SELECT ename, sal, grade, dname, loc
FROM EMP
LEFT JOIN DEPT ON EMP.deptno = DEPT.deptno
JOIN SALGRADE ON sal BETWEEN losal AND hisal;


SELECT ename, sal, grade, dname, loc
FROM EMP
FULL JOIN DEPT ON EMP.deptno = DEPT.deptno
LEFT JOIN SALGRADE ON sal BETWEEN losal AND hisal;

SELECT ename, sal, grade, dname, loc
FROM EMP
FULL JOIN DEPT ON EMP.deptno = DEPT.deptno
RIGHT JOIN SALGRADE ON sal BETWEEN losal AND hisal;


SELECT ename, sal, grade, dname, loc
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno
JOIN SALGRADE ON sal BETWEEN losal AND hisal
WHERE EMP.deptno = 20;


SELECT ename, sal, grade, dname
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno
JOIN SALGRADE ON sal BETWEEN losal AND hisal
WHERE loc = 'DALLAS'


