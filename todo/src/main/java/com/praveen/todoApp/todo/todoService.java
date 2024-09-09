package com.praveen.todoApp.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class todoService {
    private static List<todo> todos=new ArrayList<>();
    private static int count=0;

    static {
        todos.add(new todo(++count,"praveen","Aws",true));
        todos.add(new todo(++count,"mari","Azure",false));
        todos.add(new todo(++count,"muddu","devOps",true));
    }

    public List<todo> findByusername(String username){
        return todos;
    }

    public void addToDo(String name,String course, boolean done){
        todos.add(new todo(++count,name,course,done));
    }

}
