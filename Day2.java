import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

/*
 * Advent of Code 2023 Day 2
 * Author: Shola Adewale (bigkrown)
 * Date: 2023.12.2
 */

public class Day2 {

    public static void main(String[] args) {

        Day2 d2 = new Day2();
        //read file input line by line using scanner
       Scanner scanner = new Scanner(System.in);

        //read file input line by line using scanner
        try {
            File file = new File(args[0]);
            scanner = new Scanner(file);
            int sumup = 0;
            int sumup1 = 0;
            int games =1;
            int[] scores = new int[101];
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
          
                String[] sec1 = line.split(":");
                String[] sec2 = sec1[1].split(";");
                    int higestred = 0;
                    int higestgreen = 0;
                    int higestblue = 0;
                for(int i =0; i<sec2.length; i++){
                    String[] sec3 = sec2[i].split(",");
                    
                    for(int j =0; j<sec3.length; j++){
                        String[] sec4 = sec3[j].split(" ");
                       
                        if(sec4[2].equals("red")){
                            if(Integer.parseInt(sec4[1])>higestred){
                                higestred = Integer.parseInt(sec4[1]);
                            }
                        }
                        if(sec4[2].equals("green")){
                            if(Integer.parseInt(sec4[1])>higestgreen){
                                higestgreen = Integer.parseInt(sec4[1]);
                            }
                        }

                        if(sec4[2].equals("blue")){
                            if(Integer.parseInt(sec4[1])>higestblue){
                                higestblue = Integer.parseInt(sec4[1]);
                            }
                        }

                    }
                    
                }
                //part 1
                if(higestred<=12 && higestgreen<=13 && higestblue<=14){
                    scores[games] = games;
                    sumup = sumup+scores[games];
                    
                }

                //part 2
                sumup1 = sumup1+(higestred*higestgreen*higestblue);

                games++;
            }

            System.out.println("Part 1:"+sumup);
            System.out.println("Part 2:"+sumup1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
       
    }
    
}
