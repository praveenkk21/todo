package com.praveen.todoApp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoController {
    @Autowired
    public TodoService todoService;

    @RequestMapping("list-todos")
    public String listAlltodos(ModelMap mode) {
        List<Todo> todos = todoService.findByUsername("mari");
        if(todos.isEmpty())
        {
            mode.put("EmptyMessage","No Records Available");
        }
        mode.addAttribute("Todo", todos);
        return "listtodos";
    }

    @RequestMapping(value="add-todo",method = RequestMethod.GET)
    public String addToDos( Model map) {
        Todo todo1=new Todo(0,(String)map.getAttribute("username"),"D", LocalDate.now(),false);
        map.addAttribute("Todo",todo1);
        return "addtodo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addToDos2(Model map, @Valid @ModelAttribute("Todo") Todo todo2, BindingResult result) {
        if(result.hasErrors()){
            return "addtodo";
        }
            todoService.addToDo((String) map.getAttribute("username"), todo2.getcourse(),todo2.getDate(), false);
            return "redirect:list-todos";
    }

    @RequestMapping(value="delete-todo", method = RequestMethod.GET)
    public String deleteTodos(ModelMap mode, @RequestParam int id) {

        List<Todo> todos = todoService.findByUsername("mari");
        todoService.deleteByID(id);
        if(todos.isEmpty())
        {
            mode.put("EmptyMessage","No Records Available");
        }
        mode.addAttribute("Todo", todos);
        return "listtodos";
    }


    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String updateTodosGet(ModelMap model, @RequestParam int id) {

        Todo todo = todoService.findById(id);
        if (todo == null) {
            model.addAttribute("errorMessage", "Todo not found");
            return "error"; // Return an error page if the Todo is not found
        }
        model.addAttribute("Todo", todo);
        return "addtodo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodospost(ModelMap model, @Valid @ModelAttribute("Todo") Todo todo2, BindingResult result) {
        if(result.hasErrors()){
            return "addtodo";
        }
        todoService.updateTodo(todo2);
        //todoService.addToDo((String) model.getAttribute("username"), todo2.getcourse(), false);
        return "redirect:list-todos";
    }
}
