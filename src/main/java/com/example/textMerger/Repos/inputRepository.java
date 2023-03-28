package com.example.textMerger.Repos;

import com.example.textMerger.Entities.input;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface inputRepository
        extends MongoRepository<input,String> {
}
