package com.example.textMerger;

import com.example.textMerger.Entities.combination;
import com.example.textMerger.Repos.combinationRepository;
import com.example.textMerger.Repos.inputRepository;
import com.example.textMerger.Entities.input;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TextMergerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextMergerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(inputRepository repository, combinationRepository combinationRepository)
	{
		return args -> {
			repository.deleteAll();
			combinationRepository.deleteAll();
		};
	}

}
