package com.in28minutes.todo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import java.util.UUID;
public class TodoService {

	public static List<Todo> todos= new ArrayList<Todo>();
	static {
		todos.add(new Todo("Learn Java", "category", "description", false));
		todos.add(new Todo("Learn Web Application Development", "category", "description", false));
		todos.add(new Todo("Learn Spring MVC", "category", "description", false));
		todos.add(new Todo("Learn Spring Rest Services","category","description",false));
	}
	public List<Todo> getAllTodo(){
		return todos;
	}
	
	public boolean isValidTodo(String todoName) {
		if(todoName.isEmpty())
			return false;
		return true;
	}
	
	public void Add(Todo todo){
		todos.add(todo);
	}
	
	public void Delete(UUID ID) {
		for(Todo item: todos){
			if(item.ID.equals(ID))
			{
				todos.remove(item);
				break;
			}
		}
	}
	public void Edit(Todo todo) {
		for(Todo item: todos) {
			if(item.ID.equals(todo.ID))
			{
				item.name = todo.name;
				item.Category =todo.Category;
				item.description = todo.description;
				System.out.println(todo.name+"/"+todo.Category+"/"+todo.description);
				break;
			}
		}
	}
	public void DoneTodo(UUID id) {
		for(Todo item: todos){
			if(item.ID.equals(id))
			{
				if(item.isDone==true)
					item.isDone=false;
				else
					item.isDone=true;
				break;
			}
		}
	}
}
