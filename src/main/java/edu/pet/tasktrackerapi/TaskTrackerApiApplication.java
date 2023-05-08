package edu.pet.tasktrackerapi;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class TaskTrackerApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerApiApplication.class, args);


    }

}
