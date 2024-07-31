-- ORACLE ���� JOIN

SELECT *
FROM emp;

SELECT *
FROM dept;

SELECT *
FROM EMP
CROSS JOIN DEPT;

SELECT *
FROM EMP
JOIN DEPT USING(deptno);

-- ORACLE
SELECT *
FROM EMP, DEPT
WHERE EMP.DEPTN = DEPT.DEPTMO;

-- ANSI
SELECT ename, hiredate, dname
FROM EMP
JOIN DEPT ON EMP.deptno = DEPT.deptno;

-- ORACLE
SELECT ename, EMP.deptno, dname
FROM EMP, DEPT
WHERE EMP.deptno = DEPT.deptno;

SELECT ename, DEPT.deptno, dname
FROM EMP, DEPT
WHERE EMP.deptno = DEPT.deptno;

SELECT ename, dname
FROM EMP, DEPT
WHERE EMP.deptno = DEPT.deptno;



-- ANSI
SELECT *
FROM EMP
LEFT OUTER JOIN DEPT ON EMP.deptno = DEPT.deptno;

SELECT ename, dname
FROM EMP
LEFT JOIN DEPT ON EMP.deptno = DEPT.deptno;

-- ORACLE
SELECT *
FROM EMP, DEPT
WHERE EMP.deptno = DEPT.deptno(+); -- ���� ���̺� ���ǿ� (+) �߰�.
-- DEPT TABLE�� NULL ���� �߰����־�, LEFT OUTER JOIN�� �� ȿ���� �����ϰ� �Ѵ�.
-- ���� ���̺� ���� ���̺� �÷��� ������ ģ���� ������ NULL�� �����ؼ� �����ְڴ�.


-- ANSI
SELECT *
FROM EMP
RIGHT JOIN DEPT ON EMP.deptno = DEPT.deptno;


SELECT NVL(ename, '����'),  dname
FROM EMP
RIGHT JOIN DEPT ON EMP.deptno = DEPT.deptno;

-- ORACLE
SELECT *
FROM EMP, DEPT
WHERE EMP.deptno(+) = DEPT.deptno; -- �ݴ�� �ָ� �ȴ�.


SELECT NVL(ename, '����'),  dname
FROM EMP, DEPT 
WHERE EMP.deptno(+) = DEPT.deptno;

-- ANSI
SELECT *
FROM EMP
FULL JOIN DEPT ON EMP.deptno = DEPT.deptno;

SELECT ename, dname
FROM EMP
FULL JOIN DEPT ON EMP.deptno = DEPT.deptno;

SELECT NVL(ENAME, '����'),  NVL(DNAME, '����')
FROM EMP
FULL JOIN DEPT ON EMP.deptno = DEPT.deptno;

-- ORACLE
SELECT *
FROM EMP, DEPT
WHERE EMP.deptno(+) = DEPT.deptno
UNION
SELECT *
FROM EMP, DEPT
WHERE EMP.deptno = DEPT.deptno(+);

SELECT ename, dname
FROM EMP, DEPT 
WHERE EMP.deptno(+) = DEPT.deptno
UNION
SELECT ename, dname
FROM EMP, DEPT 
WHERE EMP.deptno = DEPT.deptno(+);

SELECT NVL(ENAME, '����'),  NVL(DNAME, '����')
FROM EMP, DEPT 
WHERE EMP.deptno(+) = DEPT.deptno
UNION
SELECT NVL(ENAME, '����'),  NVL(DNAME, '����')
FROM EMP, DEPT 
WHERE EMP.deptno = DEPT.deptno(+);

SELECT * 
FROM SALGRADE;

-- ANSI
SELECT *
FROM EMP
JOIN SALGRADE ON sal BETWEEN losal AND hisal;

SELECT ename, sal, grade
FROM EMP
JOIN SALGRADE ON sal BETWEEN losal AND hisal;

-- ORACLE
SELECT *
FROM EMP, SALGRADE
WHERE sal BETWEEN losal AND hisal;

SELECT ename, sal, grade
FROM EMP, SALGRADE 
WHERE sal BETWEEN losal AND hisal;

-- ANSI
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


-- ORACLE
SELECT *
FROM EMP, DEPT, SALGRADE
WHERE EMP.deptno = DEPT.deptno
AND sal BETWEEN losal AND hisal;

SELECT *
FROM EMP e, DEPT d, SALGRADE s
WHERE e.deptno = d.deptno
AND e.sal BETWEEN s.losal AND s.hisal
AND e.ename = 'MILLER';

SELECT ename, sal, grade, dname, loc
FROM EMP, DEPT, SALGRADE
WHERE 
    EMP.deptno = DEPT.deptno
    AND sal BETWEEN losal AND hisal;




-- MILLER���� ���� �޿��� �޴� ������ �̸��� �޿��� �����Ѵ�.
SELECT * FROM EMP;

SELECT SAL FROM EMP WHERE ENAME = 'MILLER';

SELECT ENAME, SAL
FROM EMP
WHERE SAL > 1300;

SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'MILLER');

-- 30�� �μ��� �����麸�� �޿��� ���� �޴� ������ ������ �����Ѵ�.
SELECT * FROM EMP WHERE DEPTNO = 30;

SELECT SAL
FROM EMP
WHERE DEPTNO = 30;

-- ���� �� ���������� ���� ������ �� �Ұ�.
SELECT *
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE DEPTNO = 30);

-- ALL : ���õ� ������ ��� ��� ������ �� �������ִ� �Լ�. ���� �� ������.
-- && ����ó�� ������ ��� ������� ���̾�� ���� ��.
SELECT *
FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30);

SELECT *
FROM EMP
WHERE SAL > (950, 1250, 1500, 1600, 2850);

SELECT *
FROM EMP
WHERE SAL > ALL(950, 1250, 1500, 1600, 2850);

-- ANY : ���õ� ������ ��� ���� �� �������ִ� �Լ�. ���� �� ������.
-- || ����ó�� ������ ��� �� �� �ϳ��� ���̸� ���� ��.
SELECT *
FROM EMP
WHERE SAL > ANY(950, 1250, 1500, 1600, 2850);

SELECT *
FROM EMP
WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO=30);

SELECT *
FROM EMP
WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO=30)
AND DEPTNO <> 30; -- '<>' �ٸ� ������. ���⼱ DEPTNO != 30 �̶� �ǵ�...