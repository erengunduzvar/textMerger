package com.example.textMerger.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class combination {
    @Id
    String Id;
    String combination;
    List<String> inputs;

    public combination(String combination, List<String> inputs) {
        this.combination = combination;
        this.inputs = inputs;
    }

    public combination() {
    }
}
