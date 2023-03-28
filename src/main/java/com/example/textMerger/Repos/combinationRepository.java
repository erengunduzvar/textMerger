package com.example.textMerger.Repos;

import com.example.textMerger.Entities.combination;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface combinationRepository
        extends MongoRepository<combination,String> {
}
