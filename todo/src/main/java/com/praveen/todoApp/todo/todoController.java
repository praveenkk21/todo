package com.praveen.todoApp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("username")
public class todoController {
    @Autowired
    public todoService todoService;

    @RequestMapping("list-todos")
    public String listAlltodos(ModelMap mode) {
        List<todo> todos = todoService.findByusername("mari");
        mode.addAttribute("todo", todos);
        return "listtodos";
    }

    @RequestMapping(value="add-todo",method = RequestMethod.GET)
    public String addToDos( Model map) {
        todo todo1=new todo(0,(String)map.getAttribute("username"),"D",false);
        map.addAttribute("todo",todo1);
        return "addtodo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addToDos2(Model map, @Valid todo todo2, BindingResult result) {
        if(result.hasErrors()){
            return "addtodo";
        }
            todoService.addToDo((String) map.getAttribute("username"), todo2.getcourse(), false);
            return "redirect:list-todos";
    }
}
