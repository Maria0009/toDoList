package com.overone.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import com.overone.model.Todo;
import com.overone.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@Controller
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/list-todos")
    public String showTodos(ModelMap model) {
        String name = getLoggedInUserName();
        model.put("todos", todoService.getTodosByUser(name));
        return "list-todos";
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    @GetMapping("/add-todo")
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam long id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @GetMapping("/update-todo")
    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
        Todo todo = todoService.getTodoById(id).get();
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("/update-todo")
    public String updateTodo(@Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUserName(getLoggedInUserName());
        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @PostMapping("/add-todo")
    public String addTodo(@Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUserName(getLoggedInUserName());
        todoService.saveTodo(todo);
        return "redirect:/list-todos";
    }
}