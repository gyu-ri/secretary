package com.nj.secretary.services.todolist.controller;

import com.nj.secretary.services.todolist.domain.Todolist;
import com.nj.secretary.services.todolist.service.TodolistService;
import com.nj.secretary.services.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/restTodolist/*")
public class TodolistRestController {

    @Autowired
    TodolistService todolistService;

    @PostMapping("addTodo")
    public String addTodo(@RequestBody Todolist todolist, HttpSession session) throws Exception {
        //Todolist todolist = new Todolist();

        User user = (User)session.getAttribute("user");
        todolist.setUserId(user.getUserId());
       // todolist.setTodolist(addTodo);
        todolist.setFinishStatus(0);
        System.out.println("addTodo restController 시작"+todolist);
        todolistService.addTodo(todolist);
        return "TodoList test";
    }

    @GetMapping("getTodo")
    public List getTodo(HttpSession session) throws Exception{
        User user = (User)session.getAttribute("user");
        List list = todolistService.getTodo(user.getUserId());
        return list;
    }

    @GetMapping("deleteTodo")
    public String deleteTodo(@RequestParam("todolistId") int todolistId) throws Exception {
        System.out.println("todolistId"+todolistId);
        int delete = todolistService.deleteTodo(todolistId);
        if (delete==0){
            return "failed";
        }else {
            return "success";
        }
    }

    @GetMapping("doneTodo")
    public String doneTodo(@RequestBody int finishStatus) throws Exception{
        todolistService.doneTodo(finishStatus);
        System.out.println("업데이트할거요"+finishStatus);
        return "todolist";
    }


}
