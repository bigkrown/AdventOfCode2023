import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

/*
 * Day1.java
 * Advent of Code 2023 Day 1
 * Author: Shola Adewale
 */

public class Day1 {

     private static Map<String, String> wordToDigit;

     public Day1() {
        //initialize the hashmap for part 2
        //this is the hashmap that will be used to convert the words to digits
        wordToDigit = new HashMap<>();
        wordToDigit.put("one", "1");
        wordToDigit.put("two", "2");
        wordToDigit.put("three", "3");
        wordToDigit.put("four", "4");
        wordToDigit.put("five", "5");
        wordToDigit.put("six", "6");
        wordToDigit.put("seven", "7");
        wordToDigit.put("eight", "8");
        wordToDigit.put("nine", "9");
     }
    public static void main(String[] args) {
    
        Day1 d1 = new Day1();
        //read file input line by line using scanner
        Scanner scanner = new Scanner(System.in);
        //read file input line by line using scanner
        try {
            File file = new File(args[0]);
            scanner = new Scanner(file);
            int sumup = 0;
            int sumup2 = 0;
            int i =1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //part 1
                 sumup+=(part1Solution(line));
                 sumup2+= d1.part1Solution(ConvertAlphabetToDigit(line));
                i++;
            }
            //part 1 answer
            System.out.println("Part 1:"+sumup);

            //part 2 answer
            System.out.println("Part 2:"+sumup2);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        scanner.close();
       
        
    }

    public static int part1Solution(String str) {
        int sum = 0;
        int first = -1, last = -1;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                if (first == -1) {
                    first = Character.getNumericValue(str.charAt(i));
                }
                last = Character.getNumericValue(str.charAt(i));
            }
        }

        sum += Integer.parseInt(Integer.toString(first)+Integer.toString(last));

        return sum;
        
    }


    //converts the first two numbers of a string to int
    public static String ConvertAlphabetToDigit(String input){
        //check for extra weird cases
        input = input.replace("oneight", "oneeight");
        input = input.replace("twone", "twoone");
        input = input.replace("eightone", "eightone");
        input = input.replace("eightwo", "eighttwo");
        input = input.replace("nine eight", "nineeight");
       
        for (Map.Entry<String, String> entry : wordToDigit.entrySet()) {
             input = input.replaceAll(entry.getKey(), entry.getValue());
        }
      
        return (input);
    }

}
