
insert into meeting values(meeting_seq.nextval, '�Ѹ�', '�Բ� ���� ����...', to_date('24/08/05 12:00', 'RR/MM/DD HH24:MI'));
insert into meeting values(meeting_seq.nextval, '��ũ', '�Բ� �ڹ� �����ؿ�', to_date('24/08/03 16:30', 'RR/MM/DD HH24:MI'));
insert into meeting values(meeting_seq.nextval, '¯��', '��ȭ �� ���~~ �𿩶�!!', to_date('24/08/10 10:00', 'RR/MM/DD HH24:MI'));


create table reply (
    id number(4) primary key,
    name varchar2(30),
    content varchar2(120),
    refid number(8)  references meeting (id) on delete cascade
);

create sequence reply_seq start with 1 increment by 1;

insert into reply values (reply_seq.nextval, '������', '������', 1);
insert into reply values (reply_seq.nextval, '��浿', '������', 1);
insert into reply values (reply_seq.nextval, '����', '����� �̰��� �ڹٴٷ� �ؿ�', 2);
insert into reply values (reply_seq.nextval, '��ũ', '����', 1);
insert into reply values (reply_seq.nextval, '�ȳ�', '�׷��� �̰��� �ڹٴ� ���ƿ�', 2);
select * from reply;    

commit;