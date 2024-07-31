SELECT 
    deptno,
    SUM(sal)
FROM emp
GROUP BY deptno;

SELECT
    DEPTNO,
    SUM(SAL)
FROM EMP
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO;

-- HAVING 절은 그룹함수에 대한 조건을 걸어주는 기능을 수행한다.
-- GROUP BY - HAVING 절은 묶여있는 존재라고 보아도 무방하다.
SELECT
    DEPTNO,
    SUM(SAL)
FROM EMP
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO
HAVING SUM(SAL) > 9000;

SELECT
    DEPTNO,
    SUM(SAL)
FROM EMP
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO
HAVING SUM(SAL) > 9000
ORDER BY SUM(SAL) DESC;

SELECT 
    DEPTNO 부서번호,
    SUM(SAL) 합
FROM EMP
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO
ORDER BY 합 DESC;

-- 그룹 함수에서는 기준을 세워주는 컬럼을 지정하지 않으면 SELECT 절 부분에 그 컬럼을 선언할 수 없다.
SELECT 
    DEPTNO 부서번호,
    EMPNO 직원번호,
    SAL,
    SUM(SAL) 합
FROM EMP
GROUP BY DEPTNO, EMPNO, SAL -- 여기서 EMPNO, SAL을 생략하면 올 수 없다는 뜻. 그룹함수 SUM이 EMPNO와 SAL을 어떻게 처리해야 할지 구분 할 수 없으므로.
ORDER BY 직원번호 DESC;

-- 단, 그룹 함수가 오는 것은 허용한다. (어처피 그 기준은 그룹바이 절에서 지정해줄 테니까)
SELECT 
    DEPTNO 부서번호,
    COUNT(EMPNO) 직원수,
    SUM(SAL) 합
FROM EMP
GROUP BY DEPTNO
ORDER BY 부서번호;

SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO;
SELECT * FROM EMP JOIN DEPT USING(DEPTNO); -- 조인할 때의 기준을 잡아주는 USING.

SELECT * FROM EMP CROSS JOIN DEPT; -- dept 테이블의 모든 row들과 결합하여 리턴하는 cross join

SELECT ename, hiredate, dname
FROM emp
JOIN dept ON emp.deptno = dept.deptno;

select ename, emp.deptno, dname
from emp
join dept on emp.deptno = dept.deptno;

select *
from emp, dept
where emp.deptno = dept.deptno;

select *
from emp
left outer join dept on emp.deptno = dept.deptno;

select *
from emp
left join dept using(deptno);

SELECT 
    NVL(ename, '없음'), 
    dname
FROM emp
JOIN dept ON emp.deptno = dept.deptno;

-- inner 조인
select *
from emp
join dept on emp.deptno = dept.deptno;

-- left outer 조인
select *
from emp
left join dept on emp.deptno = dept.deptno;

-- right outer 조인
select *
from emp
right join dept on emp.deptno = dept.deptno;

-- full 조인 : 중복 정보 다 덜어내고, emp와 dept의 정보도 붙여서 넣어준다.
select *
from emp
full join dept on emp.deptno = dept.deptno;

select
    nvl(ename, '없음'),
    nvl(dname, '없음')
from emp
full join dept using(deptno);

select *
from emp
join salgrade on sal between losal and hisal;

select *
from emp
join dept on emp.deptno = dept.deptno
join salgrade on sal between losal and hisal;

-- from -> join -> where 순서라면, 혹시 on이 where보다 먼저 적용되는 조건인가? 넵! 그렇다고 합니다.
-- 그리고 SQL에서 논리적인 실행 순서를 이해하는 것이 매우 중요하다고 합니다.
select *
from emp
join dept on emp.deptno = dept.deptno
join salgrade on sal between losal and hisal
where ename = 'MILLER';

SELECT ename, sal, grade, dname, loc
FROM emp
FULL JOIN dept ON emp.deptno = dept.deptno;

SELECT ename, sal, grade, dname, loc
FROM emp
FULL JOIN dept ON emp.deptno = dept.deptno
LEFT JOIN salgrade ON sal BETWEEN losal AND hisal;

SELECT ename, sal, grade, dname, loc
FROM emp
FULL JOIN dept ON emp.deptno = dept.deptno
RIGHT JOIN salgrade ON sal BETWEEN losal AND hisal;

SELECT ename, sal, grade, dname, loc
FROM salgrade