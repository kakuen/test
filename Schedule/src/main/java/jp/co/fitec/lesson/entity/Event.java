package jp.co.fitec.lesson.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event implements Serializable {
	
	private static final long serialVersionUID = -3218481822178211563L;
	
	@Id
	private String eventId;
	
//				eventId varchar(6) primary key,
//				eventName varchar(20) not null,
//				eventStart date not null,
//				eventEnd date not null,
//				categoryId varchar(6),
//				accountId varchar(6),
		
}
