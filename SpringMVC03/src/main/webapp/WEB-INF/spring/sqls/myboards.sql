drop sequence mynoseq;
drop table myboard;

create sequence mynoseq;
create table myboard(
	myno number primary key,
	myname varchar2(1000) not null,
	mytitle varchar2(2000) not null,
	mycontent varchar2(4000) not null,
	mydate date not null
);

insert into myboard
values(mynoseq.nextval, '관리자', '스프MVC TEST', 'Spring MVC 참 쉽다..', SYSDATE);
select * from myboard order by myno desc;
