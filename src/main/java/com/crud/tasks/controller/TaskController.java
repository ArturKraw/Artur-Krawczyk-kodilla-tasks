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

    @RequestMapping(method = RequestMethod.GET, value = "getTasks", params = {"taskId"})
    @ResponseBody
    public TaskDto getTask(@RequestParam("taskId") String taskId){
        return new TaskDto((long)1, "test title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
        public void deleteTask(String taskId){
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask", params = {"taskDto"})
    @ResponseBody
    public TaskDto updateTask(@RequestParam("taskDto") TaskDto taskDto){
        return new TaskDto((long)1, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask", params = {"taskDto"} )
    @ResponseBody
    public void createTask (@RequestParam("taskDto")TaskDto taskDto){
    }
}
