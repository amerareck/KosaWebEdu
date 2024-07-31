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

-- HAVING ���� �׷��Լ��� ���� ������ �ɾ��ִ� ����� �����Ѵ�.
-- GROUP BY - HAVING ���� �����ִ� ������ ���Ƶ� �����ϴ�.
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
    DEPTNO �μ���ȣ,
    SUM(SAL) ��
FROM EMP
WHERE DEPTNO IS NOT NULL
GROUP BY DEPTNO
ORDER BY �� DESC;

-- �׷� �Լ������� ������ �����ִ� �÷��� �������� ������ SELECT �� �κп� �� �÷��� ������ �� ����.
SELECT 
    DEPTNO �μ���ȣ,
    EMPNO ������ȣ,
    SAL,
    SUM(SAL) ��
FROM EMP
GROUP BY DEPTNO, EMPNO, SAL -- ���⼭ EMPNO, SAL�� �����ϸ� �� �� ���ٴ� ��. �׷��Լ� SUM�� EMPNO�� SAL�� ��� ó���ؾ� ���� ���� �� �� �����Ƿ�.
ORDER BY ������ȣ DESC;

-- ��, �׷� �Լ��� ���� ���� ����Ѵ�. (��ó�� �� ������ �׷���� ������ �������� �״ϱ�)
SELECT 
    DEPTNO �μ���ȣ,
    COUNT(EMPNO) ������,
    SUM(SAL) ��
FROM EMP
GROUP BY DEPTNO
ORDER BY �μ���ȣ;

SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO;
SELECT * FROM EMP JOIN DEPT USING(DEPTNO); -- ������ ���� ������ ����ִ� USING.

SELECT * FROM EMP CROSS JOIN DEPT; -- dept ���̺��� ��� row��� �����Ͽ� �����ϴ� cross join

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
    NVL(ename, '����'), 
    dname
FROM emp
JOIN dept ON emp.deptno = dept.deptno;

-- inner ����
select *
from emp
join dept on emp.deptno = dept.deptno;

-- left outer ����
select *
from emp
left join dept on emp.deptno = dept.deptno;

-- right outer ����
select *
from emp
right join dept on emp.deptno = dept.deptno;

-- full ���� : �ߺ� ���� �� �����, emp�� dept�� ������ �ٿ��� �־��ش�.
select *
from emp
full join dept on emp.deptno = dept.deptno;

select
    nvl(ename, '����'),
    nvl(dname, '����')
from emp
full join dept using(deptno);

select *
from emp
join salgrade on sal between losal and hisal;

select *
from emp
join dept on emp.deptno = dept.deptno
join salgrade on sal between losal and hisal;

-- from -> join -> where �������, Ȥ�� on�� where���� ���� ����Ǵ� �����ΰ�? ��! �׷��ٰ� �մϴ�.
-- �׸��� SQL���� ������ ���� ������ �����ϴ� ���� �ſ� �߿��ϴٰ� �մϴ�.
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