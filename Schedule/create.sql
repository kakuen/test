
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


create table accountproject(
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
insert into department values('002','R&D');
insert into department values('003','Humanresourse');
insert into department values('004','Accounting');


insert into account values('201401','201401@sample.com','employee01','001','employee01');
insert into account values('201402','201402@sample.com','employee02','002','employee02');
insert into account values('201403','201403@sample.com','employee03','003','employee03');
insert into account values('201404','201404@sample.com','employee04','004','employee04');


insert into project values('p01','porject01','2014-07-21','2015-01-25');
insert into project values('p02','project02','2014-08-21','2015-06-25');
insert into project values('p03','project03','2014-09-21','2014-11-25');



insert into accountproject values('201401','p01'); 
insert into accountproject values('201402','p01'); 
insert into accountproject values('201403','p02'); 
insert into accountproject values('201404','p03'); 


insert into category values('01','Work');
insert into category values('02','Sports');
insert into category values('03','Study');
insert into category values('04','Entertainment');

insert into event values('e01','English','2014-07-07-16-30','2014-07-07-17-00','03','201401');
insert into event values('e02','Meeting','2014-07-17-10-30','2014-07-17-12-00','01','201401');
insert into event values('e03','Business trip','2014-07-20-10-30','2014-07-26-18-00','01','201401');
insert into event values('e04','Training','2014-07-10-09-30','2014-07-11-18-00','01','201401');







