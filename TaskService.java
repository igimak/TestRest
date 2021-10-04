package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	//this is the createTask model which is used when POST method is called
    public static TaskInputModel createTask(final TaskInputModel task) {

    	TaskInputModel newTask = new TaskInputModel();
        BeanUtils.copyProperties(task, newTask);
        //if we want to store in some database then
        //we have to write something like customerRepository.save(t);
        
        //for now the method just returns the object that was passed via POST
        return newTask;
    }
    
    //this is getList method to retrieve all objects of type TaskInputModel
    public List getTasks() {
    	List<TaskInputModel> tasks = new ArrayList<>();
    	//for now we don't have database to read from
    	//if we have a database then we should have something like taskRepository.findAll().forEach(tasks::add)
    	//
    	
    	List taskList = new ArrayList<>();
    	for(TaskInputModel tm : tasks) {
    		TaskInputModel tim = new TaskInputModel();
    		BeanUtils.copyProperties(tm, tim);
    		taskList.add(tim);
    	}
    	return taskList;
    }
    
    //this is get method which returns the object by the given id
    public static TaskInputModel getTask(Long id) {
    	//we don't have database, so for now we can't get the object like this
    	//but if we have database, there we should have something like Optional task = taskRepository.findById(id);
        TaskInputModel taskData = new TaskInputModel();
        //BeanUtils.copyProperties(task.get(), taskData);
        return taskData;
    }
    
    //this is delete method
    public static void deleteTask(Long id) {
        //taskRepository.deleteById(id);
    }
}
