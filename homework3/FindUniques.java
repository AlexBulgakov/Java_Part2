package ru.geekbrains.alexbulgakov.java_part2.lection3.homework;

import java.util.*;

public class FindUniques {

    static HashSet<String> findUniques(String[] array) {
        HashSet<String> uniques = new HashSet<>();
        Collections.addAll(uniques, array);
        return uniques;
    }

    static void countWordInArray(String[] array) {
        HashMap<String, Integer> countWords = new HashMap<>();
        for (String s : array) {
            if (!countWords.containsKey(s)) countWords.put(s, 0);
            countWords.put(s, countWords.get(s) + 1);
        }
    }


}
