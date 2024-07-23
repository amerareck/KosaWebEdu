select * from tab; -- 모든 테이블 정보 출력
select * from emp; -- emp 테이블 정보 출력
desc emp; -- 테이블에 대한 컬럼의 정보 출력

-- sysdate는 오라클에서 기본으로 제공하는 숨겨진 컬럼 같은 것(?)
-- dual 테이블은 오라클에서 제공하는 더미 테이블에 해당한다. sysdate 같은 숨겨진 컬럼을 출력할 때 사용하면 좋다.
-- FROM 절을 생략하고 SQL을 실행하는 것을 오라클은 금지하고 있기 때문에, 이를 dual 테이블을 활용해서 우회 출력한다.
select sysdate from dual; -- 현재 시간정보 (시스템 정보)를 출력
select sysdate from emp; -- 현재 테이블의 row 갯수만큼 시간 정보를 출력
select * from dual; -- dummy 컬럼, 값은 존재하지 않는다. (가 맞는 표현이겠지?)

select ename, sysdate from emp;
select ename from emp; -- ename 열에 대한 정보 추출
select distinct ename from emp; -- ename 열에 대한 정보를 '중복값을 제거하고' 출력. 당장 결과값은 같지만 의미는 다르다.

select job from emp; -- 각 row에 대해 매칭되는 JOB을 모두 표기. (14 rows)
select distinct job from emp; -- 중복되는 값은 제거되고 표기. (5 rows)

-- emp 테이블에 대한 해당 컬럼을 모두 출력
select job, deptno from emp;
-- emp 테이블에 대한 해당 컬럼 중에서 중복되는 값을 제거하고 출력.
select distinct job, deptno from emp;

select 10+20 from emp;
select ename, sal from emp;
select ename, sal+100 from emp; -- select 절에는 연산식도 잘 반영해준다.
select ename, sal*1.1 as newsal from emp; -- alias를 통해 핸들링한 컬럼명에 별칭을 부여.
select ename, sal*1.2 as 계산된급여 from emp; -- 별칭은 한글도 잘 인식한다.
--select ename, sal*1.1 as 계산된 급여 from emp; -- 컬럼명에는 일반적으로 공백을 줄 수 없다. 공백은 언더바로 대체한다.
select ename, sal*1.3 as "계산된 급여" from emp; -- 더블 인용부호(쌍따옴표)를 사용하면, 공백이 적용된 별칭을 사용할 수 있다.
select ename as 직원명, sal*1.4 as "계산된 급여" from emp;
select ename 직원명, sal*1.4 "계산된 급여" from emp; -- as라는 예약어를 사용하지 않고도 사용할 순 있다. (구문에 따라 as가 강요되긴 함)
select ename 직원명, sal*1.5 newsal from emp; -- 더블 인용부호로 as를 표기하지 않으면, 기본적으로 대문자로 출력한다.
select ename 직원명, sal*1.5 "newsal" from emp;  -- 이렇게 소문자로 지정하고 싶다면, ""를 사용하여 표현해야 한다.

select * from emp where comm = null; -- null은 비교할 수 없다. null과의 비교는 무조건 false.
select * from emp where comm is null; -- null의 체크는 무조건 `is null`이라는 예약어를 사용해야 한다.
select * from emp where comm is not null; -- null이 아닌 경우는 간단하게 not을 더 작성해주면 된다.

select * from emp where ename = 'KING'; -- 이름이 KING인 녀석을 추출.
select * from emp where ename like '%S%'; -- 이름 문자에 S가 포함된 녀석을 추출. % : 0개 이상의 모든, _ : 임의의 문자 1개
select * from emp where ename like 'S%'; -- 이름 문자에 S로 시작하는 녀석을 추출.
select * from emp where ename like '%S'; -- 이름 문자에 S로 끝나는 녀석을 추출.
select * from emp where ename like '%A%'; -- 이름 문자 사이에 A가 포함된 녀석을 추출.
select * from emp where ename like '_A%'; -- 임의의 문자 1개와 A로 이어지는 문자를 추출. 

select * from emp where deptno = 10 or deptno = 30;
select * from emp where deptno in (10, 30); -- in 연산자는 비교할 대상을 괄호 안에 작성한다.

select * from emp order by sal; -- sal을 기준으로 오름차순 정렬
select * from emp order by sal desc; -- sal을 기준으로 내림차순 정렬

select * from emp order by hiredate; -- date형 타입에도 얼마든지 정렬이 가능하다.
select * from emp order by hiredate desc;

select * from emp where sal >= 2450;
select * from emp where sal >= 2450 and sal <= 3000;
select * from emp where sal between 2450 and 3000; -- sal이 2450 ~ 3000에 속하면.


select length('가나다') from dual; -- 3
select lengthb('가나다') from dual; -- 9 UTF-8, 한글은 3바이트.
select lengthb('한글') from dual; -- 6

select initcap(ename) from emp; -- 첫 문자열을 대문자로, 나머지는 소문자로 변환.
select initcap('aaa bbb ccc') from dual;

select to_char(sysdate, 'ddd') from dual; -- year를 뜻함.
select to_char(sysdate, 'dd') from dual; -- month를 뜻함.
select to_char(sysdate, 'd') from dual; -- week를 뜻함.

select to_char(sysdate,'q') from dual; -- 분기를 뜻함.
select to_char(hiredate) from emp;
select to_char(hiredate, 'yyyy') from emp; -- 연도만 출력해서.
select to_char(hiredate, 'year') from emp; -- 연도를 영어식 표기로 읽어서 리턴.
select to_char(hiredate,'yyyy')||'년' from emp; -- oracle 전용
select concat(to_char(hiredate,'yyyy'), '년') from emp; -- concat 사용
select * from emp where to_char(hiredate, 'yyyy') in (1987); -- 1987년에 입사한 사람 출력.
select * from emp where to_char(hiredate,'mm') in ('05'); -- 5월에 입사한 사람 출력.




