select to_char(to_date('990510', 'yymmdd'), 'yyyymmdd') from dual;
select to_char(to_date('990510','rrmmdd'), 'yyyymmdd') from dual;

select to_char(to_date('190510', 'yymmdd'), 'yyyymmdd') from dual;
select to_char(to_date('190510', 'rrmmdd'), 'yyyymmdd') from dual;

-- error, �Ű����� 1�� �ѹ��ε�, �Ű����� 2�� ���ڿ��̶� Ÿ�� ����.
select ename, job, sal, nvl(comm, '�̤�') "��� �ϸ� �ɱ�?" from emp; 
-- �׷��Ƿ� ���ڿ��� �ٲ� �� �ִ� �Ű����� 1�� ���ڷ� �ٲ��ָ� �ȴ�.
select ename, job, sal, nvl(to_char(comm), '�̤�') "��� �ϸ� �ɱ�?" from emp; 
-- �Ű����� 1�� null�� �ƴϸ� �Ű����� 2��, null�̸� �Ű�����3�� ����϶�.
-- ���⼱ �Ű����� 2�� 3�� ����ϹǷ�, �� �Ű������� Ÿ�Ը� ���� ���ָ� �ȴ�. �� �� �ϳ��� Ÿ���� �ٸ��� �ȵȴ�.
select ename, job, sal, nvl2(comm, '����Ŀ�̼ǸԾ���.', '�̤̳�Ŀ�̼Ǿ��?') "��� �ϸ� �ɱ�?" from emp;

-- ������ fomatt�� �������� ������ ���ִ� trunc �Լ�. �׳� ���� �Լ� ������...
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
    MAX(sal) AS �ִ�,
    MIN(sal) AS �ּڰ�,
    SUM(sal) AS ����,
    ROUND(AVG(sal), 2) AS ���,
    COUNT(sal) AS �ο�
FROM emp;

SELECT
    MAX(comm) �ִ�,
    MIN(comm) �ּڰ�,
    SUM(comm) AS ����,
    ROUND(AVG(comm), 2) AS ���,
    COUNT(comm) AS �ο� -- null�� ������� �ʴ´�.
FROM emp;