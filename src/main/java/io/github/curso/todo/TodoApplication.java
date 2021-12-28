package io.github.curso.todo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import io.github.curso.todo.model.Todo;
import io.github.curso.todo.repository.TodoRepository;

@SpringBootApplication
@RestController
public class TodoApplication {

	@Autowired
	private TodoRepository todoRepository;
	
	@Bean
	public CommandLineRunner init() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Todo todo = new Todo();
				todo.setDescription("Estudar Sptring");
				todo.setCreatedDate(LocalDateTime.now());
				todoRepository.save(todo);
			}
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
