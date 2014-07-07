create database schedule_db;
use schedule_db;

create table department (
	departId varchar(6) primary key,
	departName varchar(20) not null
);


create table account(
	accountId varchar(6) primary key,
	email varchar(20) not null,
	name varchar(20) not null,
	departId varchar(6),
	password varchar(20) not null,
	foreign key(departId) references department(departId)
);

create table project(
	projectId varchar(6) primary key,
	projectName varchar(20) not null,
	projectStart date not null,
	projectEnd date not null
);


create table account_project(
	accountId varchar(6),
	projectId varchar(6),
	primary key(accountId,projectId),
	foreign key(accountId) references account(accountId),
	foreign key(projectId) references project(projectId)
);

create table category (
	categoryId varchar(6) primary key,
	categoryName varchar(20) not null
);

create table event(
	eventId varchar(6) primary key,
	eventName varchar(20) not null,
	eventStart date not null,
	eventEnd date not null,
	categoryId varchar(6),
	accountId varchar(6),
	foreign key (categoryId) references category(categoryId),
	foreign key (accountId) references account(accountId)
);


insert into department values('001','Sales');

insert into account values('253269','admin@sample.com','admin','001','admin');

insert into project values('abc','schedule','2013-07-21','2015-09-25');

insert into account_project values('253269','abc'); 

insert into category values('01','Task');
insert into category values('02','Sports');
insert into category values('03','Study');
insert into category values('04','Amusement');

insert into event values('1','English','2014-06-07-16-30','2014-06-07-17-00','03','253269');