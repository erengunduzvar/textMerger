package com.example.textMerger.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.textMerger.Repos.*;
import com.example.textMerger.Services.stringService;
import com.example.textMerger.Entities.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class textController {


    public textController(stringService stringService,combinationRepository combinationRepository,inputRepository inputRepository) {
        this.stringService = stringService;
        this.combinationRepository = combinationRepository;
        this.inputRepository = inputRepository;
    }

    stringService stringService;
    combinationRepository combinationRepository;
    inputRepository inputRepository;
    @GetMapping("/hello")
    public String hello(Model model)
    {
        model.addAttribute("message","Selam Dünya");
        return "helloworld";
    }

    @GetMapping("/styletest")
    public String styletest(Model model)
    {
        model.addAttribute("message","Selam Dünya");
        return "cssJs";
    }
    @PostMapping("/output")
    public String processInputForm(@RequestParam String resultText, Model model) {
        long start = System.currentTimeMillis();

        String[] stringArr = resultText.split("-");
        LinkedList<String> linkedList = new LinkedList<>();
        for (String str:stringArr) {
            linkedList.addLast(str);
        }
        String answer = stringService.startMerging(linkedList);

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        if (answer != null){
            answer = "Longest combination is: '"+answer+"'";
            String time = "Calculation time is: "+elapsedTime+" miliseconds";
            model.addAttribute("message",answer);
            model.addAttribute("time",time);
        }

        else
            model.addAttribute("message","There is no combination !");

        return "cssJs";
    }

}
