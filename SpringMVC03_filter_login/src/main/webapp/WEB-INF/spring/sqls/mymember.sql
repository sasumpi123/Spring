drop sequence memberseq;
drop table mymember;

create sequence memberseq;
create table mymember(
	memberno number primary key,
	memberid varchar2(500) unique,
	memberpw varchar2(1000) not null,
	membername varchar2(1000) not null
);

insert into mymember values(memberseq.nextval, 'admin', '1234', '관리자');
select * from mymember;