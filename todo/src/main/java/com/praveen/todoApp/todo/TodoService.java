package com.praveen.todoApp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList<>();
    private static int count=0;

    //private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    static {
        todos.add(new Todo(++count,"praveen","Aws",LocalDate.now(),true));
        todos.add(new Todo(++count,"mari","Azure",null,false));
        todos.add(new Todo(++count,"muddu","devOps",null,true));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }

    public void addToDo(String name, String course, LocalDate date, boolean done){
        todos.add(new Todo(++count,name,course,date, done));
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

    public void updateTodo(@Valid Todo updatedTodo) {
        Todo existingTodo = findById(updatedTodo.getId());
        if (existingTodo != null) {
            //existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setcourse(updatedTodo.getcourse());
            existingTodo.setDate(updatedTodo.getDate());
            // Any other fields that need updating can be added here
        }
    }
}
