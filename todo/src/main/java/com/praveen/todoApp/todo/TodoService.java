package com.praveen.todoApp.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList<>();
    private static int count=0;

    static {
        todos.add(new Todo(++count,"praveen","Aws",true));
        todos.add(new Todo(++count,"mari","Azure",false));
        todos.add(new Todo(++count,"muddu","devOps",true));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }

    public void addToDo(String name,String course, boolean done){
        todos.add(new Todo(++count,name,course,done));
    }

    public void deleteByID(int id) {
        todos.removeIf(Todo -> Todo.getId() == id);
        //return todos;
    }

    public Todo findById(int id) {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElse(null); // Return null if no Todo is found
    }

    public void updateTodo(Todo updatedTodo) {
        Todo existingTodo = findById(updatedTodo.getId());
        if (existingTodo != null) {
            //existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setcourse(updatedTodo.getcourse());
            //existingTodo.setDueDate(updatedTodo.getDueDate());
            // Any other fields that need updating can be added here
        }
    }
}
