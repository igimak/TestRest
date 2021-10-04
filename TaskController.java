package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/challenge/submitTask", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity <TaskInputModel> createTask(@RequestBody TaskInputModel task) {
		try {
			TaskInputModel taskData = TaskService.createTask(task);
			return new ResponseEntity <>(taskData, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity < >(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public String handleHttpMediaTypeNotAcceptableException() {
	    return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
	}
	
	@GetMapping(value = "/challenge/getTask/{id}")
	public ResponseEntity <TaskInputModel> getTask(@PathVariable Long id) {
		try {
			TaskInputModel tim = TaskService.getTask(id);
			return new ResponseEntity < >(tim, HttpStatus.NOT_IMPLEMENTED);
		}
		catch(Exception e)
		{
			return new ResponseEntity < >(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "/challenge/removeTask/{id}")
	public ResponseEntity < String > deleteTask(@PathVariable Long id) {
		try
		{
			TaskService.deleteTask(id);
			return new ResponseEntity < >(HttpStatus.NOT_IMPLEMENTED);
		}
		catch(Exception e)
		{
			return new ResponseEntity < >(HttpStatus.BAD_REQUEST);
		}
	}
}
