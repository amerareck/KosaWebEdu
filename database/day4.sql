-- ORACLE 전용 JOIN

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
WHERE EMP.deptno = DEPT.deptno(+); -- 상대방 테이블 조건에 (+) 추가.
-- DEPT TABLE에 NULL 행을 추가해주어, LEFT OUTER JOIN을 한 효과와 동일하게 한다.
-- 우측 테이블에 좌측 테이블 컬럼과 맞춰줄 친구가 없으면 NULL을 생성해서 맞춰주겠다.


-- ANSI
SELECT *
FROM EMP
RIGHT JOIN DEPT ON EMP.deptno = DEPT.deptno;


SELECT NVL(ename, '없음'),  dname
FROM EMP
RIGHT JOIN DEPT ON EMP.deptno = DEPT.deptno;

-- ORACLE
SELECT *
FROM EMP, DEPT
WHERE EMP.deptno(+) = DEPT.deptno; -- 반대로 주면 된다.


SELECT NVL(ename, '없음'),  dname
FROM EMP, DEPT 
WHERE EMP.deptno(+) = DEPT.deptno;

-- ANSI
SELECT *
FROM EMP
FULL JOIN DEPT ON EMP.deptno = DEPT.deptno;

SELECT ename, dname
FROM EMP
FULL JOIN DEPT ON EMP.deptno = DEPT.deptno;

SELECT NVL(ENAME, '없음'),  NVL(DNAME, '미정')
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

SELECT NVL(ENAME, '없음'),  NVL(DNAME, '미정')
FROM EMP, DEPT 
WHERE EMP.deptno(+) = DEPT.deptno
UNION
SELECT NVL(ENAME, '없음'),  NVL(DNAME, '미정')
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




-- MILLER보다 많은 급여를 받는 직원의 이름과 급여를 추출한다.
SELECT * FROM EMP;

SELECT SAL FROM EMP WHERE ENAME = 'MILLER';

SELECT ENAME, SAL
FROM EMP
WHERE SAL > 1300;

SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'MILLER');

-- 30번 부서의 직원들보다 급여를 많이 받는 직원의 정보를 추출한다.
SELECT * FROM EMP WHERE DEPTNO = 30;

SELECT SAL
FROM EMP
WHERE DEPTNO = 30;

-- 다중 행 서브쿼리는 단일 연산자 비교 불가.
SELECT *
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE DEPTNO = 30);

-- ALL : 제시된 쿼리의 모든 결과 값들을 비교 연산해주는 함수. 집합 비교 연산자.
-- && 연산처럼 집합의 모든 결과값이 참이어야 최종 참.
SELECT *
FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30);

SELECT *
FROM EMP
WHERE SAL > (950, 1250, 1500, 1600, 2850);

SELECT *
FROM EMP
WHERE SAL > ALL(950, 1250, 1500, 1600, 2850);

-- ANY : 제시된 쿼리의 결과 값을 비교 연산해주는 함수. 집합 비교 연산자.
-- || 연산처럼 집합의 요소 중 단 하나라도 참이면 최종 참.
SELECT *
FROM EMP
WHERE SAL > ANY(950, 1250, 1500, 1600, 2850);

SELECT *
FROM EMP
WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO=30);

SELECT *
FROM EMP
WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO=30)
AND DEPTNO <> 30; -- '<>' 다름 연산자. 여기선 DEPTNO != 30 이란 건데...