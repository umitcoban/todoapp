package com.in28minutes.todo;

import java.util.Objects;
import java.util.UUID;

public class Todo {

	String name;
	String category;
	String description;
	UUID id;
	Boolean isDone;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public Todo(String _name,String _category,String _description ,Boolean _isDone) {
		super();
		this.name = _name;
		this.Category= _category;
		this.ID = ID.randomUUID();
		this.description=_description;
		this.isDone = _isDone;
	}
	
	public Todo() {
		super();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return String.format("Todo [name=%s, Category=%s, description=%s, ID=%s, isDone=%s]", name, Category,
				description, ID, isDone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(name, other.name);
	}
	
}
