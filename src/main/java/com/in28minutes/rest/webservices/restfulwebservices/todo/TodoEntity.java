package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.data.annotation.Id;


import java.util.Date;

public class TodoEntity {

	@Id
	private String id;

	private String username;
	private String description;
	private Date targetDate;
	private boolean isDone;

	protected TodoEntity() {

	}

	public TodoEntity(String username, String description, Date targetDate, boolean isDone) {
		super();
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoEntity other = (TodoEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
