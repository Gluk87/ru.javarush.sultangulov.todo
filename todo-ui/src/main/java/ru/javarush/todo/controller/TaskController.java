package ru.javarush.todo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javarush.todo.entity.Task;
import ru.javarush.todo.service.TaskService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public String tasks(Model model,
                            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        return "tasks";
    }

    @PostMapping("/{id}")
    public void edit(Model model,
                     @PathVariable Integer id,
                     @RequestBody TaskInfo info) {

    }

    @PostMapping("/")
    public void add(Model model,
                     @RequestBody TaskInfo info) {

    }

    @DeleteMapping("/{id}")
    public String delete(Model model,
                     @PathVariable Integer id) {
        return "tasks";
    }
}
