package com.example.textMerger.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class input {
    @Id
    String Id;
    String input;

    public input(String input) {
        this.input = input;
    }

}
