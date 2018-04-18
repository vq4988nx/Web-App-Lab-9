package com.jeff.hellowdb.controller;

import com.jeff.hellowdb.model.Task;
import com.jeff.hellowdb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TaskController {

//This task object will interact with the database
    private final TaskRepository tasks;

    @Autowired
    public TaskController(TaskRepository tasks) {
        this.tasks = tasks;
    }

//This will always direct to the home page
    @RequestMapping("/")
    public ModelAndView addTask() {
        return new ModelAndView("createTask.html", "task", new Task());
    }

//This is a post method that will redirect to the /addTask page
    @RequestMapping(value="/addTask", method= RequestMethod.POST)
    public RedirectView addNewTask(Task task) {
        tasks.save(task);
        return new RedirectView("/allTasks");
    }

//This will direct to the /allTasks page, where the database will be queried for all tasks
    @RequestMapping("/allTasks")
    public ModelAndView allTasks(ModelMap modelMap){
        modelMap.addAttribute("tasks", tasks.findAll());
        return new ModelAndView("taskList.html", modelMap);
    }
}

