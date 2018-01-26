package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks(){
       return new ArrayList<>();
    }
/*
    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    @ResponseBody
    public TaskDto getTask(String taskId){
        return new TaskDto((long)1, "test title", "test_content");
    }
    */

    @RequestMapping(method = RequestMethod.GET, value = "getTask", params = ("taskId"))
    @ResponseBody
    public TaskDto getTask(@RequestParam("taskId") String taskId){
        return new TaskDto((long)1, "test title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask", params = {"taskId"})
            public void deleteTask(@RequestParam("taskId") String taskId){
        System.out.println("Delete Task(id=taskId): " + taskId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    @ResponseBody
    public TaskDto updateTask(@RequestBody TaskDto taskDto){
        return new TaskDto((long)1, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask" )
    @ResponseBody
    public TaskDto createTask (@RequestBody TaskDto taskDto){
        return new TaskDto((long)1, "Ceated Test line", "New test content");
    }
}
