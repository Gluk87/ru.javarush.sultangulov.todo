package ru.javarush.todo.controller;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.todo.entity.Status;

@Getter
@Setter
public class TaskInfo {
    private String description;
    private Status status;
}
