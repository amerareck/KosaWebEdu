select * from tab; -- ��� ���̺� ���� ���
select * from emp; -- emp ���̺� ���� ���
desc emp; -- ���̺� ���� �÷��� ���� ���

-- sysdate�� ����Ŭ���� �⺻���� �����ϴ� ������ �÷� ���� ��(?)
-- dual ���̺��� ����Ŭ���� �����ϴ� ���� ���̺� �ش��Ѵ�. sysdate ���� ������ �÷��� ����� �� ����ϸ� ����.
-- FROM ���� �����ϰ� SQL�� �����ϴ� ���� ����Ŭ�� �����ϰ� �ֱ� ������, �̸� dual ���̺��� Ȱ���ؼ� ��ȸ ����Ѵ�.
select sysdate from dual; -- ���� �ð����� (�ý��� ����)�� ���
select sysdate from emp; -- ���� ���̺��� row ������ŭ �ð� ������ ���
select * from dual; -- dummy �÷�, ���� �������� �ʴ´�. (�� �´� ǥ���̰���?)

select ename, sysdate from emp;
select ename from emp; -- ename ���� ���� ���� ����
select distinct ename from emp; -- ename ���� ���� ������ '�ߺ����� �����ϰ�' ���. ���� ������� ������ �ǹ̴� �ٸ���.

select job from emp; -- �� row�� ���� ��Ī�Ǵ� JOB�� ��� ǥ��. (14 rows)
select distinct job from emp; -- �ߺ��Ǵ� ���� ���ŵǰ� ǥ��. (5 rows)

-- emp ���̺� ���� �ش� �÷��� ��� ���
select job, deptno from emp;
-- emp ���̺� ���� �ش� �÷� �߿��� �ߺ��Ǵ� ���� �����ϰ� ���.
select distinct job, deptno from emp;

select 10+20 from emp;
select ename, sal from emp;
select ename, sal+100 from emp; -- select ������ ����ĵ� �� �ݿ����ش�.
select ename, sal*1.1 as newsal from emp; -- alias�� ���� �ڵ鸵�� �÷��� ��Ī�� �ο�.
select ename, sal*1.2 as ���ȱ޿� from emp; -- ��Ī�� �ѱ۵� �� �ν��Ѵ�.
--select ename, sal*1.1 as ���� �޿� from emp; -- �÷����� �Ϲ������� ������ �� �� ����. ������ ����ٷ� ��ü�Ѵ�.
select ename, sal*1.3 as "���� �޿�" from emp; -- ���� �ο��ȣ(�ֵ���ǥ)�� ����ϸ�, ������ ����� ��Ī�� ����� �� �ִ�.
select ename as ������, sal*1.4 as "���� �޿�" from emp;
select ename ������, sal*1.4 "���� �޿�" from emp; -- as��� ���� ������� �ʰ� ����� �� �ִ�. (������ ���� as�� ����Ǳ� ��)
select ename ������, sal*1.5 newsal from emp; -- ���� �ο��ȣ�� as�� ǥ������ ������, �⺻������ �빮�ڷ� ����Ѵ�.
select ename ������, sal*1.5 "newsal" from emp;  -- �̷��� �ҹ��ڷ� �����ϰ� �ʹٸ�, ""�� ����Ͽ� ǥ���ؾ� �Ѵ�.

select * from emp where comm = null; -- null�� ���� �� ����. null���� �񱳴� ������ false.
select * from emp where comm is null; -- null�� üũ�� ������ `is null`�̶�� ���� ����ؾ� �Ѵ�.
select * from emp where comm is not null; -- null�� �ƴ� ���� �����ϰ� not�� �� �ۼ����ָ� �ȴ�.

select * from emp where ename = 'KING'; -- �̸��� KING�� �༮�� ����.
select * from emp where ename like '%S%'; -- �̸� ���ڿ� S�� ���Ե� �༮�� ����. % : 0�� �̻��� ���, _ : ������ ���� 1��
select * from emp where ename like 'S%'; -- �̸� ���ڿ� S�� �����ϴ� �༮�� ����.
select * from emp where ename like '%S'; -- �̸� ���ڿ� S�� ������ �༮�� ����.
select * from emp where ename like '%A%'; -- �̸� ���� ���̿� A�� ���Ե� �༮�� ����.
select * from emp where ename like '_A%'; -- ������ ���� 1���� A�� �̾����� ���ڸ� ����. 

select * from emp where deptno = 10 or deptno = 30;
select * from emp where deptno in (10, 30); -- in �����ڴ� ���� ����� ��ȣ �ȿ� �ۼ��Ѵ�.

select * from emp order by sal; -- sal�� �������� �������� ����
select * from emp order by sal desc; -- sal�� �������� �������� ����

select * from emp order by hiredate; -- date�� Ÿ�Կ��� �󸶵��� ������ �����ϴ�.
select * from emp order by hiredate desc;

select * from emp where sal >= 2450;
select * from emp where sal >= 2450 and sal <= 3000;
select * from emp where sal between 2450 and 3000; -- sal�� 2450 ~ 3000�� ���ϸ�.


select length('������') from dual; -- 3
select lengthb('������') from dual; -- 9 UTF-8, �ѱ��� 3����Ʈ.
select lengthb('�ѱ�') from dual; -- 6

select initcap(ename) from emp; -- ù ���ڿ��� �빮�ڷ�, �������� �ҹ��ڷ� ��ȯ.
select initcap('aaa bbb ccc') from dual;

select to_char(sysdate, 'ddd') from dual; -- year�� ����.
select to_char(sysdate, 'dd') from dual; -- month�� ����.
select to_char(sysdate, 'd') from dual; -- week�� ����.

select to_char(sysdate,'q') from dual; -- �б⸦ ����.
select to_char(hiredate) from emp;
select to_char(hiredate, 'yyyy') from emp; -- ������ ����ؼ�.
select to_char(hiredate, 'year') from emp; -- ������ ����� ǥ��� �о ����.
select to_char(hiredate,'yyyy')||'��' from emp; -- oracle ����
select concat(to_char(hiredate,'yyyy'), '��') from emp; -- concat ���
select * from emp where to_char(hiredate, 'yyyy') in (1987); -- 1987�⿡ �Ի��� ��� ���.
select * from emp where to_char(hiredate,'mm') in ('05'); -- 5���� �Ի��� ��� ���.




