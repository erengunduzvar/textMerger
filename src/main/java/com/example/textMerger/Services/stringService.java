package com.example.textMerger.Services;

import org.springframework.stereotype.Service;
import com.example.textMerger.Repos.*;
import com.example.textMerger.Entities.*;

import java.util.*;

@Service
public class stringService {
    public stringService(combinationRepository combinationRepository, inputRepository inputRepository) {
        this.combinationRepository = combinationRepository;
        this.inputRepository = inputRepository;
    }

    private combinationRepository combinationRepository;
    private inputRepository inputRepository;


    public String startMerging(LinkedList<String> stringList){
        String longestAnswer = "";
        String realAnswer = null;
        List<String> pastCombs = new ArrayList<>();
        for (int i = 0; i < Math.pow(2,stringList.size()); i++) {
            String answer = this.mergeStringArr(stringList);
            if(answer != null && !pastCombs.contains(answer))
            {
                pastCombs.add(answer);
                combination combination = new combination();
                combination.setInputs(stringList);
                combination.setCombination(answer);
                combinationRepository.insert(combination);
             if(longestAnswer.isEmpty())
             {
                 for (String input:stringList) {
                     input input1 = new input(input);
                     inputRepository.insert(input1);
                 }
             }

                if(answer.length() > longestAnswer.length())
                {
                    longestAnswer = answer;
                }
            }

            Collections.shuffle(stringList);
        }
        if(longestAnswer.length() > 0)
            realAnswer = longestAnswer;
        return realAnswer;
    }
   private String findCommonPrefix(String str1,String str2)
    {
        String commonSuffix = "";

        if(str1.length()>str2.length())
        {
            for (int i = 0; i < str2.length(); i++) {
                if(str1.charAt(i) == str2.charAt(i))
                {
                    commonSuffix = commonSuffix + str1.charAt(i);
                }
            }
        }
        else
        {
            for (int i = 0; i < str1.length(); i++) {
                if(str1.charAt(i) == str2.charAt(i))
                {
                    commonSuffix = commonSuffix + str1.charAt(i);
                }
            }
        }



        return commonSuffix;
    }
    private String searchSuffixInOtherString(String mainString, String sideString, int prefix)
    {
        if(prefix == -1)
        {
            if(mainString.length() > sideString.length())
                prefix = sideString.length();
            else
                prefix = mainString.length();
        }
        for (int i = prefix; i > 0; i--) {
            String sidePrefix = sideString.substring(0,i);
            if(mainString.contains(sidePrefix))
            {
                return sidePrefix;
            }
        }

        return null;
    }
    private String mergeTwoStrings(String mainString,String sideString,String prefix)
    {
        String croppedMainString = mainString.substring(0,mainString.lastIndexOf(prefix));
        return (croppedMainString + sideString);
    }

    private String mergeStringArr(LinkedList<String> stringList)
    {
        Iterator<String> iterator = stringList.iterator();

        String first = iterator.next();
        while (iterator.hasNext())
        {
            String nextString = iterator.next();
            String prefix = this.searchSuffixInOtherString(first,nextString,-1);
            if(prefix != null)
            {
                first = this.mergeTwoStrings(first,nextString,prefix);
            }
            else
                return null;
        }
        return first;
    }
}

