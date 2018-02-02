package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    private DbService service;

    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks(){
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    //http://localhost:8080/v1/task/getTasks

    @RequestMapping(method = RequestMethod.GET, value = "getTask", params = ("taskId"))
    @ResponseBody
    public TaskDto getTask(@RequestParam("taskId") String taskId){
        return new TaskDto((long)1, "test title", "test_content");
    }

    //http://localhost:8080/v1/task/getTask?taskId

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask", params = {"taskId"})
    public void deleteTask(@RequestParam("taskId") String taskId){

        //System.out.println("Delete Task(id=taskId): " + taskId);
    }

    //http://localhost:8080/v1/task/deleteTask?taskId="taskId"

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    @ResponseBody
    public TaskDto updateTask(@RequestBody TaskDto taskDto){
        taskDto = new TaskDto((long)1, "Edited test title", "Test content");
        return taskDto;
    }

    //

    @RequestMapping(method = RequestMethod.POST, value = "createTask" )
    @ResponseBody
    public TaskDto createTask (@RequestBody TaskDto taskDto){

        return new TaskDto((long)1, "Created Test line", "New test content");
    }
}

    //
