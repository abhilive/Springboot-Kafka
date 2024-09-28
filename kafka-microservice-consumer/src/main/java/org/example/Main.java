package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        System.out.println("Abhishek");
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
//        /* count number of chars in String */
//        String str = "Myself Abhishek";
//        IntStream charsInASCII = str.chars();
//        Stream<Character> strChars = charsInASCII.mapToObj(c -> (char) c);
//        Map<Character, Long> map = strChars.collect(Collectors.groupingBy(
//                Function.identity(), Collectors.counting()
//        ));
//        System.out.println(map);
//
//        /* Fail Fast and Fail Safe */
//        failFastFailSafe();
    }

    private static void failFastFailSafe() {
        Map<String, Integer> empAge = new ConcurrentHashMap<>(); // ConcurrentModificationException
        empAge.put("Emp1", 27);
        empAge.put("Emp2", 33);
        empAge.put("Emp3", 35);
        for(Integer s : empAge.values()) {
            empAge.put("Emp4", 39);
            System.out.println(s);
        }
        // Fail Safe - Allow modifications of collection while iterating over it
        // Fail Fast - Doesn't allow modifications of a collection while iterating over it
        //              If we try to modify they throw - ConcurrentModificationException
    }


}