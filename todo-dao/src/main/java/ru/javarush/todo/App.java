package ru.javarush.todo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.javarush.todo.config.AppConfig;
import ru.javarush.todo.dao.TaskDao;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        for (String str : applicationContext.getBeanDefinitionNames()) {
            System.out.println(str);
        }
    }
}
