
insert into meeting values(meeting_seq.nextval, '둘리', '함께 점심 먹자...', to_date('24/08/05 12:00', 'RR/MM/DD HH24:MI'));
insert into meeting values(meeting_seq.nextval, '듀크', '함께 자바 공부해요', to_date('24/08/03 16:30', 'RR/MM/DD HH24:MI'));
insert into meeting values(meeting_seq.nextval, '짱구', '영화 볼 사람~~ 모여라!!', to_date('24/08/10 10:00', 'RR/MM/DD HH24:MI'));


create table reply (
    id number(4) primary key,
    name varchar2(30),
    content varchar2(120),
    refid number(8)  references meeting (id) on delete cascade
);

create sequence reply_seq start with 1 increment by 1;

insert into reply values (reply_seq.nextval, '유니코', '탕수육', 1);
insert into reply values (reply_seq.nextval, '고길동', '떡볶이', 1);
insert into reply values (reply_seq.nextval, '엘사', '교재는 이것이 자바다로 해요', 2);
insert into reply values (reply_seq.nextval, '듀크', '갈비', 1);
insert into reply values (reply_seq.nextval, '안나', '그래요 이것이 자바다 좋아용', 2);
select * from reply;    

commit;