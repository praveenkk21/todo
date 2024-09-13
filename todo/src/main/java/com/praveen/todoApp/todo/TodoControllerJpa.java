package com.praveen.todoApp.todo;

import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoControllerJpa {

    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    private TodoRepository todoRepository;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername(model);

        List<Todo> todos = todoRepository.findByUsername(username);
        if(todos.isEmpty())
        {
            model.put("EmptyMessage","No Records Available");
        }
        model.addAttribute("Todo", todos);

        return "listtodos";
    }

    //GET, POST
//    @RequestMapping(value="add-todo", method = RequestMethod.GET)
//    public String showNewTodoPage(ModelMap model) {
//        String username = getLoggedInUsername(model);
//        Todo todo = new Todo(0, username, "", LocalDate.now(), false);
//        model.put("Todo", todo);
//        return "addtodo";
//    }

    @RequestMapping(value="add-todo",method = RequestMethod.GET)
    public String addToDos(Model map1, @RequestParam(name = "addLoggedUser", required = false, defaultValue = "false") boolean addLoggedUser) {
        if(addLoggedUser) {
            Todo todo1 = new Todo(0, (String) map1.getAttribute("username"), "D", LocalDate.now(), false);
            map1.addAttribute("Todo",todo1);
            map1.addAttribute("addLoggedUser", true);
            //map1.addAttribute("username",map1.getAttribute("username"));
        }
        else {
            Todo todo1 = new Todo(0, "", "D", LocalDate.now(), false);
            map1.addAttribute("Todo",todo1);
            map1.addAttribute("addLoggedUser", false);
        }

        return "addtodo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(HttpServletRequest request, ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "addtodo";
        }

        String username = getLoggedInUsername(model);
        todo.setUsername(todo.getUsername());
        //todo.getUsername();
        todoRepository.save(todo);
//		todoService.addTodo(username, todo.getDescription(),
//				todo.getTargetDate(), todo.isDone());
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        //Delete todo
        todoRepository.deleteById(id);
        return "redirect:list-todos";

    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        if (todo == null) {
            model.addAttribute("errorMessage", "Todo not found");
            return "error"; // Return an error page if the Todo is not found
        }
        model.addAttribute("Todo", todo);
        return "addtodo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "addtodo";
        }

        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}