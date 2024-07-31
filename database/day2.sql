select to_char(to_date('990510', 'yymmdd'), 'yyyymmdd') from dual;
select to_char(to_date('990510','rrmmdd'), 'yyyymmdd') from dual;

select to_char(to_date('190510', 'yymmdd'), 'yyyymmdd') from dual;
select to_char(to_date('190510', 'rrmmdd'), 'yyyymmdd') from dual;

-- error, 매개변수 1은 넘버인데, 매개변수 2는 문자열이라 타입 에러.
select ename, job, sal, nvl(comm, 'ㅜㅜ') "어떻게 하면 될까?" from emp; 
-- 그러므로 문자열로 바꿀 수 있는 매개변수 1을 문자로 바꿔주면 된다.
select ename, job, sal, nvl(to_char(comm), 'ㅜㅜ') "어떻게 하면 될까?" from emp; 
-- 매개변수 1이 null이 아니면 매개변수 2를, null이면 매개변수3을 출력하라.
-- 여기선 매개변수 2와 3을 출력하므로, 두 매개변수의 타입만 같이 해주면 된다. 둘 중 하나라도 타입이 다르면 안된다.
select ename, job, sal, nvl2(comm, 'ㅋㅋ커미션먹었다.', 'ㅜㅜ내커미션어디?') "어떻게 하면 될까?" from emp;

-- 지정한 fomatt을 기준으로 버림을 해주는 trunc 함수. 그냥 버림 함수 같은데...
select 
    round(sysdate), trunc(sysdate), 
    round(sysdate, 'yy'), trunc(sysdate, 'yy'), 
    round(sysdate,'mm'), trunc(sysdate, 'mm')
from dual;

select
    round(7777.5555, 1), round(7777.5555, 2),
    round(7777.5555, -1), round(7777.5555, -2),
    round(7733.5555, -1), round(7733.5555, -2)
from dual;

SELECT
    MAX(sal),
    MIN(sal),
    SUM(sal)
FROM emp;

SELECT
    MAX(sal) AS 최댓값,
    MIN(sal) AS 최솟값,
    SUM(sal) AS 총합,
    ROUND(AVG(sal), 2) AS 평균,
    COUNT(sal) AS 인원
FROM emp;

SELECT
    MAX(comm) 최댓값,
    MIN(comm) 최솟값,
    SUM(comm) AS 총합,
    ROUND(AVG(comm), 2) AS 평균,
    COUNT(comm) AS 인원 -- null은 계산하지 않는다.
FROM emp;